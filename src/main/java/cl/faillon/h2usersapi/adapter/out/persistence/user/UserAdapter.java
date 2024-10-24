package cl.faillon.h2usersapi.adapter.out.persistence.user;

import cl.faillon.h2usersapi.adapter.out.persistence.phone.PhoneEntity;
import cl.faillon.h2usersapi.application.port.out.*;
import cl.faillon.h2usersapi.common.dto.CreateUserRequest;
import cl.faillon.h2usersapi.common.dto.DeleteUserResponse;
import cl.faillon.h2usersapi.common.dto.UpdateUserRequest;
import cl.faillon.h2usersapi.common.dto.UserResponse;
import cl.faillon.h2usersapi.common.exception.user.EmailAlreadyExistException;
import cl.faillon.h2usersapi.common.exception.user.UserNotFoundException;
import cl.faillon.h2usersapi.common.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserAdapter implements CreateUserPort, DeleteUserPort, GetAllUsersPort,
        UpdateUserPort, GetUserPort {

    Logger logger = LoggerFactory.getLogger(UserAdapter.class);
    private final UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();
    private final JwtTokenUtil jwtTokenUtil;

    private Function<UserEntity, UserResponse> userMapper = UserResponse::new;

    @Override
    public UserResponse createUser(CreateUserRequest user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistException();
        }
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity.setToken(jwtTokenUtil.generateAccessToken(userEntity));
        userEntity.setModified(Date.from(Instant.now()));
        UserEntity savedUser = userRepository.save(userEntity);
        return modelMapper.map(savedUser, UserResponse.class);
    }

    @Override
    public DeleteUserResponse deleteUser(UUID userId) {
        userRepository.deleteById(userId);
        DeleteUserResponse response = DeleteUserResponse.builder()
                .userId(userId)
                .message("Eliminado con Exito").build();

        return response;
    }

    @Override
    @Cacheable("listAllUsers")
    public List<UserResponse> listAllUsers() {
        logger.info("Getting All Users");
        List<UserEntity> entityList = userRepository.findAll();

        //transformar de lista de entity a list de DTO
        List<UserResponse> userList = entityList.stream()
                .map(userMapper)
                .toList();

        return userList;
    }

    @Override
    public UserResponse updateUser(UUID userId, UpdateUserRequest userRequest) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException();
        }

        UserEntity existingUser = optionalUser.get();
        existingUser.setName(userRequest.getName());
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setPassword(userRequest.getPassword());
        Set<PhoneEntity> phones = userRequest.getPhones().stream().map(
                        (phoneDTO) -> modelMapper.map(phoneDTO, PhoneEntity.class))
                .collect(Collectors.toSet());
        phones.forEach((phone) -> {
            phone.setUserId(existingUser.getId());
        });
        existingUser.getPhones().clear();
        existingUser.getPhones().addAll(phones);

        UserEntity updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserResponse.class);
    }

    @Override
    @Cacheable("getUser")
    public UserResponse getUser(UUID userId) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        System.out.println(optionalUser);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException();
        }
        UserEntity existingUser = optionalUser.get();
        return modelMapper.map(existingUser, UserResponse.class);
    }
}

package cl.faillon.h2usersapi.application.service;

import cl.faillon.h2usersapi.application.port.in.*;
import cl.faillon.h2usersapi.application.port.out.*;
import cl.faillon.h2usersapi.common.dto.CreateUserRequest;
import cl.faillon.h2usersapi.common.dto.DeleteUserResponse;
import cl.faillon.h2usersapi.common.dto.UpdateUserRequest;
import cl.faillon.h2usersapi.common.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements GetAllUsersUseCase, GetUserUseCase, CreateUserUseCase,
        UpdateUserUseCase, DeleteUserUseCase {

    private final CreateUserPort createUserPort;
    private final DeleteUserPort deleteUserPort;
    private final GetAllUsersPort getAllUsersPort;
    private final UpdateUserPort updateUserPort;
    private final GetUserPort getUserPort;
    @Override
    public UserResponse createUser(CreateUserRequest request) {

        return createUserPort.createUser(request);
    }

    @Override
    public DeleteUserResponse deleteUser(UUID userId) {

        return deleteUserPort.deleteUser(userId);
    }

    @Override
    public List<UserResponse> getAllUsers() {

        return getAllUsersPort.listAllUsers();
    }

    @Override
    public UserResponse getUser(UUID userId) {

        return getUserPort.getUser(userId);
    }

    @Override
    public UserResponse updateUser(UUID userId, UpdateUserRequest request) {

        return updateUserPort.updateUser(userId, request);
    }
}

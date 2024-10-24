package cl.faillon.h2usersapi.adapter.in.web;

import cl.faillon.h2usersapi.application.port.in.*;
import cl.faillon.h2usersapi.common.dto.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
@Tag(name = "User Controller")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> getAllUsers() throws Exception {
        logger.info("Recibiendo Solicitud Obtencion todos los usuarios");
        List<UserResponse> users = getAllUsersUseCase.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @PostMapping("/")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        logger.info("Recibiendo Solicitud Creacion de Usuario");
        UserResponse createdUser = createUserUseCase.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@Valid @PathVariable("id") UUID userId) {
        logger.info("Recibiendo Solicitud Obtencion de Usuario con id " + userId);
        UserResponse user = getUserUseCase.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@Valid @PathVariable("id") UUID userId, @Valid @RequestBody UpdateUserRequest user) {
        logger.info("Recibiendo Solicitud Actualizacion de Usuario con id " + userId);
        UserResponse updatedUser = updateUserUseCase.updateUser(userId, user);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteUserResponse> deleteUser(@Valid @PathVariable("id") UUID userId) {
        logger.info("Recibiendo Solicitud Eliminacion de Usuario con id " + userId);
        DeleteUserResponse response = deleteUserUseCase.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

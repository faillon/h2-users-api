package cl.faillon.h2usersapi.application.port.in;

import cl.faillon.h2usersapi.common.dto.UpdateUserRequest;
import cl.faillon.h2usersapi.common.dto.UserResponse;

import java.util.UUID;

public interface UpdateUserUseCase {

    UserResponse updateUser(UUID userId, UpdateUserRequest request);
}

package cl.faillon.h2usersapi.application.port.out;

import cl.faillon.h2usersapi.common.dto.UpdateUserRequest;
import cl.faillon.h2usersapi.common.dto.UserResponse;

import java.util.UUID;

public interface UpdateUserPort {

    UserResponse updateUser(UUID userId, UpdateUserRequest user);
}

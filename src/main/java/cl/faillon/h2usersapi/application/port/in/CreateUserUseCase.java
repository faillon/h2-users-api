package cl.faillon.h2usersapi.application.port.in;

import cl.faillon.h2usersapi.common.dto.CreateUserRequest;
import cl.faillon.h2usersapi.common.dto.CreateUserResponse;
import cl.faillon.h2usersapi.common.dto.UserResponse;

public interface CreateUserUseCase {

    UserResponse createUser(CreateUserRequest request);
}

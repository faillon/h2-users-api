package cl.faillon.h2usersapi.application.port.out;

import cl.faillon.h2usersapi.common.dto.CreateUserRequest;
import cl.faillon.h2usersapi.common.dto.UserResponse;

public interface CreateUserPort {

    UserResponse createUser(CreateUserRequest user);
}

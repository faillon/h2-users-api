package cl.faillon.h2usersapi.application.port.in;

import cl.faillon.h2usersapi.common.dto.UserRequest;
import cl.faillon.h2usersapi.common.dto.UserResponse;

import java.util.List;

public interface GetAllUsersUseCase {

    List<UserResponse> getAllUsers();
}

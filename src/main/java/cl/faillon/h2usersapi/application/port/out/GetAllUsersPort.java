package cl.faillon.h2usersapi.application.port.out;

import cl.faillon.h2usersapi.adapter.out.persistence.user.UserEntity;
import cl.faillon.h2usersapi.common.dto.UserResponse;

import java.util.List;

public interface GetAllUsersPort {

    List<UserResponse> listAllUsers();
}

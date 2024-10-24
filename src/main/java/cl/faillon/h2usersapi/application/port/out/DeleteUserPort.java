package cl.faillon.h2usersapi.application.port.out;

import cl.faillon.h2usersapi.common.dto.DeleteUserResponse;

import java.util.UUID;

public interface DeleteUserPort {

    DeleteUserResponse deleteUser(UUID userId);
}

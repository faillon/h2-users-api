package cl.faillon.h2usersapi.application.port.in;

import cl.faillon.h2usersapi.common.dto.DeleteUserResponse;

import java.util.UUID;

public interface DeleteUserUseCase {

    DeleteUserResponse deleteUser(UUID userId);
}

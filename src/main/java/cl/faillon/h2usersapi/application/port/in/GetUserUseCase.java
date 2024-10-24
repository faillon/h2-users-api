package cl.faillon.h2usersapi.application.port.in;

import cl.faillon.h2usersapi.common.dto.UserResponse;
import java.util.UUID;

public interface GetUserUseCase {

    UserResponse getUser(UUID userId);
}

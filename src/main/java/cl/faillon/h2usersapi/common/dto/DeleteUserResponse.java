package cl.faillon.h2usersapi.common.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteUserResponse {

    UUID userId;
    String message;
}

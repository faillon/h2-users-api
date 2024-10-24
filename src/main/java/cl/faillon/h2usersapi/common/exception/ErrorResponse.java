package cl.faillon.h2usersapi.common.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ErrorResponse {
    private int statusCode;
    private String message;
}

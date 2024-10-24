package cl.faillon.h2usersapi.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ValidationErrorResponse {

    private int statusCode;
    private Map<String, String> errors;
}

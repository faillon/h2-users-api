package cl.faillon.h2usersapi.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidEmailValidator.class)
public @interface ValidEmail {

    String message() default "Email debe coincidir con el formato aaaaaaa@dominio.cl";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

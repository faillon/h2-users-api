package cl.faillon.h2usersapi.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidPasswordValidator.class)
public @interface ValidPassword {

    String message() default "Password debe tener al menos: 1 letra mayuscula, 1 letra minuscula, 1 caracter especial, 1 numero, 8 caracteres";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
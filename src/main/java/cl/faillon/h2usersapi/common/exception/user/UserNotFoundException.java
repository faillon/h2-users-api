package cl.faillon.h2usersapi.common.exception.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Usuario No Encontrado");
    }
}

package cl.faillon.h2usersapi.common.exception.user;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException() {
        super("El email ingresado ya existe");
    }
}

package finki.ukim.mk.library.model.exceptions;

public class PasswordsNotMatchingException extends RuntimeException{

    public PasswordsNotMatchingException() {
        super("Passwords do not match exception.");
    }
}

package finki.ukim.mk.library.model.exceptions;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException() {
        super("Username not found");
    }
}

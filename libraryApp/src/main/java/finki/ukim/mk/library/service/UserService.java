package finki.ukim.mk.library.service;

import finki.ukim.mk.library.model.Country;
import finki.ukim.mk.library.model.User;
import finki.ukim.mk.library.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String name, String surname, String password, Role role);
}

package finki.ukim.mk.library.service.impl;

import finki.ukim.mk.library.model.Country;
import finki.ukim.mk.library.model.User;
import finki.ukim.mk.library.model.enumerations.Role;
import finki.ukim.mk.library.model.exceptions.CountryNotFoundException;
import finki.ukim.mk.library.repository.CountryRepository;
import finki.ukim.mk.library.repository.UserRepository;
import finki.ukim.mk.library.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String name, String surname, String password, Role role) {
        User user = new User(username, name, surname, password, role);
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

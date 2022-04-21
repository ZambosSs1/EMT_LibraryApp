package finki.ukim.mk.library.model.dto;

import finki.ukim.mk.library.model.User;
import finki.ukim.mk.library.model.enumerations.Role;
import lombok.Data;

@Data
public class UserDetailsDto {

    private String username;
    private Role role;

    public static UserDetailsDto of(User user){
        UserDetailsDto details = new UserDetailsDto();
        details.username = user.getUsername();
        details.role = user.getRole();

        return details;
    }
}

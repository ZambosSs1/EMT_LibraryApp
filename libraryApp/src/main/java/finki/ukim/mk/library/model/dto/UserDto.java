package finki.ukim.mk.library.model.dto;

import finki.ukim.mk.library.model.Country;
import finki.ukim.mk.library.model.enumerations.Role;
import lombok.Data;

@Data
public class UserDto {

    private String name;

    private String surname;

    private String password;

    private Long country;

    private Role role;

    public UserDto(String name, String surname, String password, Long country, Role role) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.country = country;
        this.role = role;
    }
}

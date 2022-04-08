package finki.ukim.mk.library.model;

import finki.ukim.mk.library.model.enumerations.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String password;

    @OneToOne
    private Country country;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User() {}

    public User(String name, String surname, String password, Country country, Role role) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.country = country;
        this.role = role;
    }
}

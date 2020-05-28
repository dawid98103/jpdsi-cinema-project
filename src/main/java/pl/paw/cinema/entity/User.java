package pl.paw.cinema.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    @Length(min = 5, message = "*Nazwa użytkownika powinna zawierać min {min} znaków")
    @NotEmpty(message = "*Nazwa użytkownika nie może być pusta")
    private String userName;

    @Column(name = "email")
    @Email(message = "*Adres email niewłaściwy")
    @NotEmpty(message = "*Adres email nie może być pusty")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Hasło musi zawierać conajmniej {min} znaków")
    @NotEmpty(message = "*Hasło nie może być puste")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "active")
    private Boolean active;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations;

    @Transient
    private String confirmPassword;
}

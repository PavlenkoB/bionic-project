package ua.ho.godex.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@ToString
@EqualsAndHashCode
public class User implements AbstaractGenericDomainObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Обязательное поле")
    private String name;
    @NotBlank(message = "Обязательное поле")
    @Email(message = "Поле должно содержать правильный email")
    private String email;
    @NotBlank(message = "Обязательное поле")
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orderList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id")
    )
    private List<Product> ownProducts;


    public User() {
    }

    public User(Integer id, String name, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}

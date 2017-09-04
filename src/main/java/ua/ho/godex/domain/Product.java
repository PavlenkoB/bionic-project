package ua.ho.godex.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@ToString
@EqualsAndHashCode
public class Product implements AbstaractGenericDomainObj {
    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorys_id", nullable = false)
    private Category category;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_users",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersWhoHaveThisProduct;

    public Product() {
    }
}

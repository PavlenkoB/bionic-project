package ua.ho.godex.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @Column(name = "categorys_id")
    //todo write
    private Integer categoryId;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_users",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersWhoHaveThisProduct;

    public Product() {
    }

    public Product(String name, String description, Integer categoryId) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", usersWhoHaveThisProduct=" + usersWhoHaveThisProduct +
                '}';
    }
}

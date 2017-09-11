package ua.ho.godex.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "variants")
@Data
@ToString
@EqualsAndHashCode
public class Variant implements AbstaractGenericDomainObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @NotBlank(message = "Обязательное поле")
    private String name;
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id",nullable = false)
    private Attribute attribute;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_variants",
            joinColumns = @JoinColumn(name = "variants_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id")
    )
    private List<Product> productList;

    public Variant() {
    }

    public Variant(String name, Attribute attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "Variant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

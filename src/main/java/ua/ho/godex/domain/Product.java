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
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "count")
    private Integer count;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_variants",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "variants_id")
    )
    List<Variant> variants;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorys_id", nullable = false)
    private Category category;

    public Product() {
    }
}

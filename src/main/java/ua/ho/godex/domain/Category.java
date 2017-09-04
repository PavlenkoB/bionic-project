package ua.ho.godex.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorys")
@Data
@ToString
@EqualsAndHashCode
public class Category implements AbstaractGenericDomainObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "parent_cat_id")
    private Integer parentCatId;
    @Column(name = "name")
    @NotBlank(message = "Обязательное поле")
    private String name;
    @Column(name = "order")
    private Integer order;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Attribute> attributes;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> productList;

    @Transient
    private List<Category> children;

    public Category() {
        this.children = new ArrayList<>();
    }

    public Category getSelf() {
        return this;
    }
}

package ua.ho.godex.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorys")
@Data
public class Category implements AbstaractGenericDomainObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "parent_cat_id")
    private Integer parentCatId;
    @NotBlank(message = "Обязательное поле")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "categorys_atributes",
            joinColumns = @JoinColumn(name = "categorys_id"),
            inverseJoinColumns = @JoinColumn(name = "atributes_id")
    )
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        return result;
    }
}

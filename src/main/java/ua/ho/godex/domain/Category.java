package ua.ho.godex.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "parent_cat_id")
    private Integer parentCatId;
    @NotBlank(message = "Обязательное поле")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "categorys_atributes",
            joinColumns = @JoinColumn(name = "categorys_id"),
            inverseJoinColumns = @JoinColumn(name = "atributes_id")
    )
    private List<Attribute> attributes;

    public Category() {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentCatId() {
        return parentCatId;
    }

    public void setParentCatId(Integer parentCatId) {
        this.parentCatId = parentCatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

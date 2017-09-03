package ua.ho.godex.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "attributes")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Обязательное поле")
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "attribute")
    private List<Variant> variantList;

    public Attribute() {
    }

    public Attribute(String name) {
        this.name = name;
    }

    public Attribute(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Attribute(String name, String description) {
        this.name = name;
        this.description = description;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribute attribute = (Attribute) o;

        if (id != null ? !id.equals(attribute.id) : attribute.id != null) return false;
        return name.equals(attribute.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        return result;
    }

    public List<Variant> getVariantList() {
        return variantList;
    }

    public String getVariantsInString() {
        return String.join("|\n",
                this.variantList.stream().map(variant -> variant.toString()).collect(Collectors.toList())
        );
    }
}

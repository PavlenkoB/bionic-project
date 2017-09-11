package ua.ho.godex.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "attributes")
@Data
@EqualsAndHashCode
public class Attribute implements AbstaractGenericDomainObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @NotBlank(message = "Обязательное поле")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private FieldType fieldType;

    @OneToMany(mappedBy = "attribute", fetch = FetchType.LAZY)
    private List<Variant> variantList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorys_id", nullable = false)
    private Category category;

    public Attribute() {
        this.variantList = new ArrayList<>();
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

    public String getVariantsInString() {
        return this.variantList.stream().map(Variant::toString).reduce((s, s2) -> s + "\n" + s2).orElse("empty");
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", fieldType=" + fieldType +
                '}';
    }


}

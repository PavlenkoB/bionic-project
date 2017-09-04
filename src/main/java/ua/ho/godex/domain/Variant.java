package ua.ho.godex.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "variants")
@Data
@ToString
@EqualsAndHashCode
public class Variant implements AbstaractGenericDomainObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Обязательное поле")
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id",nullable = false)
    private Attribute attribute;

    public Variant() {
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

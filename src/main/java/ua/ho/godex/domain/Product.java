package ua.ho.godex.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

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
    @Column(name = "moderated")
    private Boolean moderated = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorys_id", nullable = false)
    private Category category;

    public Product() {
    }
}

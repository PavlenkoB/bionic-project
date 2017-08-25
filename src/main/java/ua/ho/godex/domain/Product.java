package ua.ho.godex.domain;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    //todo write
    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}

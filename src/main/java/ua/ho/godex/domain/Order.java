package ua.ho.godex.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 02.09.2017
 * Project: supStore
 */
@Entity
@Table(name = "orders")
@Data
@ToString
@EqualsAndHashCode
public class Order implements AbstaractGenericDomainObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "datetime")
    private LocalDateTime localDateTime;
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_orders",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id")
    )
    private List<Product> products;
}

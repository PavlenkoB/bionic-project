package ua.ho.godex.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Column(name = "datetime_open", columnDefinition = "DATETIME")
    private LocalDateTime localDateTimeOpen;
    @Column(name = "datetime_closed", columnDefinition = "DATETIME")
    private LocalDateTime localDateTimeClosed;
    @Column(name = "description")
    private String description;
    @Column(name = "sum")
    private BigDecimal totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_orders",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id")
    )
    private List<Product> products;

    public Order() {
        this.products = new ArrayList<>();
        this.totalAmount = new BigDecimal(0);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}

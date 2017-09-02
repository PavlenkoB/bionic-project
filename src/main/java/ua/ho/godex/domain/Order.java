package ua.ho.godex.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Creator: Pavlenko Bohdan
 * Date: 02.09.2017
 * Project: supStore
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "datetime")
    private LocalDateTime localDateTime;
}

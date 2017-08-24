package ua.ho.godex.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Обязательное поле")
    private String name;
    @NotNull(message = "Обязательное поле")
    @Min(value = 0, message = "Цена должна быть больше 0")
    private BigDecimal price;
    @NotNull(message = "Обязательное поле")
    @Min(value = 0, message = "Память должна быть больше 0")
    private Integer capacity;
    @NotBlank(message = "Обязательное поле")
    private String display;
    private String description;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, BigDecimal price, Integer capacity, String display, String description) {
        this.id = id;
        this.name = name;
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.capacity = capacity;
        this.display = display;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (capacity != null ? !capacity.equals(product.capacity) : product.capacity != null) return false;
        if (display != null ? !display.equals(product.display) : product.display != null) return false;
        return description != null ? description.equals(product.description) : product.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (display != null ? display.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", display='" + display + '\'' +
                ", description='" + description + '\'' +
                '}';
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String printInfo() {
        return String.format("%d. %s %d - %.2f", id, name, capacity, price);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

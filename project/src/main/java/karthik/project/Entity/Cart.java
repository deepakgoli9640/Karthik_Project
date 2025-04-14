package karthik.project.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="inventory_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long cart_id;

    @ManyToOne
    @JoinColumn(name="product_id",referencedColumnName="id",nullable = false)
    private Product product;

    @Column(nullable = false)
    private int cart_quantity;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
}
package karthik.project.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String name;
    private String barcode;
    private double price;
    private int quantity;

    @Column(name = "image_url")
    private String imageUrl;
    @Column(name="category")
    private String category;
    @Column(name="quality")
    private String quality;
    @Column(name="size")
    private String size;

}

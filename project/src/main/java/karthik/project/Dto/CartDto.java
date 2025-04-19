package karthik.project.Dto;
import lombok.Data;

@Data
public class CartDto {
    private Long cart_id;
    private Long product_id;
    private int cart_quantity;
    private String name;
    private double price;
}

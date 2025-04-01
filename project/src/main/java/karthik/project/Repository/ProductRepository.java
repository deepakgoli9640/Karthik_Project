package karthik.project.Repository;

import karthik.project.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByBarcode(String barcode);
    List<Product> findByNameContainingIgnoreCase(String name);

}

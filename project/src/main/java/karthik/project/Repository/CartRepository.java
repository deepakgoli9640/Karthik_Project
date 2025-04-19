package karthik.project.Repository;

import karthik.project.Entity.Cart;
import karthik.project.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByProduct(Product product);

}

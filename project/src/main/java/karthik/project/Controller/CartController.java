package karthik.project.Controller;
import karthik.project.Entity.Cart;
import karthik.project.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/cart")

public class CartController {
        @Autowired
        private  CartService cartService;
        @PostMapping("/add")
        public ResponseEntity<?> addToCart(@RequestBody Cart cart) {
            return ResponseEntity.ok(cartService.addToCart(cart));
        }
      @GetMapping("/")
        public ResponseEntity<?> getCart() {
            return ResponseEntity.ok(cartService.getAllItemsInCart());
        }

}

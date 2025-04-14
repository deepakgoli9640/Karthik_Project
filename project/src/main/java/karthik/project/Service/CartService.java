package karthik.project.Service;

import karthik.project.Entity.Cart;
import karthik.project.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllItemsInCart() {
        return cartRepository.findAll();
    }
    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }
}

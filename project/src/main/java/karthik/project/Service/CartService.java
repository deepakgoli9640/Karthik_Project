package karthik.project.Service;

import karthik.project.Dto.CartDto;
import karthik.project.Entity.Cart;
import karthik.project.Entity.Product;
import karthik.project.Repository.CartRepository;
import karthik.project.Repository.ProductRepository;
import karthik.project.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<CartDto> getAllItemsInCart() {

        return CartMapper.toDtoList(cartRepository.findAll());
    }

    public CartDto addToCart(CartDto cartDto) {
        Cart cart = new Cart();
        Product product = productRepository.findById(cartDto.getProduct_id())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Check if the product is already in the cart
        Cart existingCart = cartRepository.findByProduct(product);
        if (existingCart != null) {
            // Update the existing cart item
            existingCart.setCart_quantity(existingCart.getCart_quantity() + cartDto.getCart_quantity());
            Cart updatedCart = cartRepository.save(existingCart);
            return CartMapper.toDto(updatedCart);
        }
        else {
            cart.setProduct(product);
            cart.setName(cartDto.getName());
            cart.setCart_quantity(cartDto.getCart_quantity());
            cart.setPrice(cartDto.getPrice());
            Cart savedCart = cartRepository.save(cart);
            return CartMapper.toDto(savedCart);
        }
    }
    public void deleteCartItem(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartRepository.delete(cart);
    }
}
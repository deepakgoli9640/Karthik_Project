package karthik.project.mapper;


import karthik.project.Dto.CartDto;
import karthik.project.Entity.Cart;

import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {
    public static CartDto toDto(Cart cart) {
        CartDto dto = new CartDto();
        dto.setCart_id(cart.getCart_id());
        dto.setProduct_id(cart.getProduct().getId());
        dto.setName(cart.getName());
        dto.setCart_quantity(cart.getCart_quantity());
        dto.setPrice(cart.getPrice());
        return dto;
    }

    public static List<CartDto> toDtoList(List<Cart> carts) {
        return carts.stream().map(CartMapper::toDto).collect(Collectors.toList());
    }
}

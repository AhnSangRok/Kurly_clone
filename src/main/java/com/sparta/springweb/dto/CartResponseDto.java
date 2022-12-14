package com.sparta.springweb.dto;

import com.sparta.springweb.model.Cart;
import com.sparta.springweb.model.CartItem;
import lombok.Getter;

import java.util.List;

@Getter
public class CartResponseDto {

    private String username;
    private List<CartItem> posts;
    private int deliveryFee;
    private int totalPrice;

    //장바구니
    public CartResponseDto(Cart cart) {
        this.username = cart.getUsername();
        this.posts = cart.getPosts();
        this.deliveryFee = cart.getDeliveryFee();
        this.totalPrice = cart.getTotalPrice();
    }
}

package com.sparta.springweb.controller;


import com.sparta.springweb.dto.CartResponseDto;
import com.sparta.springweb.model.Cart;
import com.sparta.springweb.model.CartItem;
import com.sparta.springweb.model.Post;
import com.sparta.springweb.security.UserDetailsImpl;
import com.sparta.springweb.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    // 장바구니 물건 추가
    @PostMapping("/api/post/item/{postId}")
    public CartItem getItem(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.postItem(postId, userDetails);
        //페이지 리턴 response entity
    }

    // 장바구니 조회
    @GetMapping("/api/cart")
    public CartResponseDto getCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Cart cart = cartService.getCart(userDetails.getUser());
        CartResponseDto responseDto = new CartResponseDto(cart);
        return responseDto;
    }

    @GetMapping("/api/cart1")
    public List<CartItem> getCartt(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Cart cart = cartService.getCart(userDetails.getUser());
        return cart.getPosts();
    }

    // 장바구니 특정 물건 삭제
    @DeleteMapping("/api/cart/item/{cartItemId}")
    public Cart deleteItem(@PathVariable Long cartItemId,@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.deleteItem(cartItemId, userDetails.getUser());
    }
    // 장바구니 전체 삭제
    @DeleteMapping("/api/cart")
    public Cart deleteCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return cartService.deleteCart(userDetails.getUser());
    }
}

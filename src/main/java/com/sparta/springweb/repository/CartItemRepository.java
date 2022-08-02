package com.sparta.springweb.repository;

import com.sparta.springweb.model.Cart;
import com.sparta.springweb.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findCartItemsByCart(Cart cart);

    CartItem findByCartIdAndPostId(Long cartId, Long postId);

    void deleteAllByCart(Cart cart);
}

package com.sparta.springweb.repository;

import com.sparta.springweb.model.Cart;
import com.sparta.springweb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUser(User user);
}

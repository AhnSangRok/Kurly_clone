package com.sparta.springweb.service;

import com.sparta.springweb.model.Cart;
import com.sparta.springweb.model.CartItem;
import com.sparta.springweb.model.Post;
import com.sparta.springweb.model.User;
import com.sparta.springweb.repository.CartItemRepository;
import com.sparta.springweb.repository.CartRepository;
import com.sparta.springweb.repository.PostRepository;
import com.sparta.springweb.repository.UserRepository;
import com.sparta.springweb.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CartItemRepository cartItemRepository;

    public CartItem postItem(Long postId, UserDetailsImpl userDetails) {
        Cart cart = cartRepository.findByUser(userDetails.getUser());
        List<CartItem> cartItemList =new ArrayList<>();

        if (cart == null){
            cart = Cart.builder()
                    .user(userDetails.getUser())
                    .username(userDetails.getUsername())
                    .deliveryFee(0)
                    .totalPrice(0)
                    .posts(cartItemList)
                    .build();
            cartRepository.save(cart);
        }

        Post post = postRepository.findPostById(postId);

        CartItem cartItem = cartItemRepository.findByCartIdAndPostId(cart.getId(), postId);

        if (cartItem == null){
            cartItem = CartItem.builder()
                    .cart(cart)
                    .title(post.getTitle())
                    .imageUrl(post.getImageUrl())
                    .price(post.getPrice())
                    .build();
            cartItemRepository.save(cartItem);
        }else{
            //물건 추가 구매 기능
        }

        return cartItem;
    }

    // 장바구니 조회
    @Transactional
    public Cart getCart(User user) {
        Cart cart = cartRepository.findByUser(user);
        List<CartItem> cartItemList =new ArrayList<>();

        if (cart == null){
            cart = Cart.builder()
                    .user(user)
                    .username(user.getUsername())
                    .deliveryFee(0)
                    .totalPrice(0)
                    .posts(cartItemList)
                    .build();
            cartRepository.save(cart);
            return cart;
        }

        int totalPrice = 0;
        int deliveryFee = 3000;

        List<CartItem> cartItems = cartItemRepository.findCartItemsByCart(cart);
        for (CartItem cartItem : cartItems){
            cartItemList.add(cartItem);
            totalPrice += cartItem.getPrice();
        }

        if (totalPrice > 20000){
            deliveryFee = 0;
        }

        cart.setTotalPrice(totalPrice);
        cart.setDeliveryFee(deliveryFee);
        cart.setPosts(cartItemList);

        return cart;
    }

    //특정 물건 삭제
    public Cart deleteItem(Long cartItemId, User user) {
        Cart cart = cartRepository.findByUser(user);

        if (cart == null){
            throw new IllegalStateException("아이디가 없음");
        }
        List<CartItem> items =  cart.getPosts();
        for (int i = 0; i < items.size(); i++) {
            if (Objects.equals(items.get(i).getId(), cartItemId)){
                items.remove(i);
                break;
            }
        }
        cart.setPosts(items);

        cartItemRepository.deleteById(cartItemId);

        return cart;
    }

    public Cart deleteCart(User user) {
        Cart cart = cartRepository.findByUser(user);

        if (cart == null){
            throw new IllegalStateException("아이디가 없음");
        }

        List<CartItem> items =  cart.getPosts();

        for (CartItem item : items) {
            items.remove(item);
            cartItemRepository.deleteById(item.getId());
        }

        cart.setPosts(items);

        return cart;
    }
}

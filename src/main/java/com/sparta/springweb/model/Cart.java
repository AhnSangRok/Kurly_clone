package com.sparta.springweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column
    private int totalPrice;

    @Column
    private int deliveryFee;

    @OneToMany
    @JsonIgnore
    @Column
    private List<CartItem> posts = new ArrayList<>();

    @OneToOne
    private User user;
}

package com.sparta.springweb.dto;

import com.sparta.springweb.model.CartItem;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private String title;
    private int quantity;
    private int price;

}

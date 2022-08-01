package com.sparta.springweb.dto;


import com.sparta.springweb.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostResponseDto {

    private String title;
    private String image_url;
    private String salesUnit;
    private String weight;
    private int price;


    public PostResponseDto(Post post) {
        this.title= post.getTitle();
        this.image_url= post.getImage_url();
        this.salesUnit=post.getSalesUnit();
        this.weight= post.getWeight();
        this.price=post.getPrice();

    }
}

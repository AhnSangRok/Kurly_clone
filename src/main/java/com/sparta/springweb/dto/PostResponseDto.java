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
    private String salesUnit;
    private String weight;
    public String image;
    private int price;


    public PostResponseDto(Post post) {
        this.title= post.getTitle();
        this.salesUnit=post.getSalesUnit();
        this.weight= post.getWeight();
        this.price=post.getPrice();
        this.image= post.getFile().getFileUrl();

    }


}

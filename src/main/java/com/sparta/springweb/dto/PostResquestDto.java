package com.sparta.springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostResquestDto {
    private Long postId;
    private String title;
    private String image_url;
    private String salesUnit;
    private String weight;
    private int price;


}

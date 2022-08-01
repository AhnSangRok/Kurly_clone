package com.sparta.springweb.model;


import com.sparta.springweb.dto.PostResquestDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Post {
    @Id
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image_url;

    @Column(nullable = false)
    private String salesUnit;

    @Column(nullable = false)
    private String weight;

    @Column(nullable = false)
    private int price;


    public Post(PostResquestDto postResquestDto) {
        this.title = postResquestDto.getTitle();
        this.image_url = postResquestDto.getImage_url();
        this.salesUnit = postResquestDto.getSalesUnit();
        this.weight = postResquestDto.getWeight();
        this.price = postResquestDto.getPrice();
    }




    public void update(PostResquestDto postResquestDto) {
        this.title = postResquestDto.getTitle();
        this.image_url = postResquestDto.getImage_url();
        this.salesUnit = postResquestDto.getSalesUnit();
        this.weight = postResquestDto.getWeight();
        this.price = postResquestDto.getPrice();



    }

}

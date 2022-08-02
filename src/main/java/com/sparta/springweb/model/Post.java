package com.sparta.springweb.model;


import com.sparta.springweb.dto.PostRequestDto;
import com.sparta.springweb.model.Embedded.File;
import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POST_ID",nullable = false)
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String salesUnit;

    @Column(nullable = false)
    private String weight;

    @Column(nullable = false)
    private int price;

    @Embedded
    private File file;




    public Post(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.salesUnit = postRequestDto.getSalesUnit();
        this.weight = postRequestDto.getWeight();
        this.price = postRequestDto.getPrice();
    }

    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.salesUnit = postRequestDto.getSalesUnit();
        this.weight = postRequestDto.getWeight();
        this.price = postRequestDto.getPrice();
    }

    public void setFile(File file) {
        this.file = file;
    }
}



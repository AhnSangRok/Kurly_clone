package com.sparta.springweb.model;

import com.sparta.springweb.dto.PostDto;
import com.sparta.springweb.model.Embedded.File;

import javax.persistence.*;

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String salesUnit;

    @Column(nullable = false)
    private String weight;

    @Embedded
    private File file;

    public Post (PostDto postDto){
        this.title = postDto.getTitle();
        this.price = postDto.getPrice();
        this.salesUnit = postDto.getSalesUnit();
        this.weight = postDto.getWeight();
    }

    public void setFile(File file) {
        this.file = file;
    }
}

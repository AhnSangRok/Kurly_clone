package com.sparta.springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    public String title;
    public int Price;
    public String salesUnit;
    public String weight;
    public MultipartFile image;

}

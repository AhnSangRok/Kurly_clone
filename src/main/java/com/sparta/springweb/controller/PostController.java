package com.sparta.springweb.controller;



import com.sparta.springweb.dto.PostDto;
import com.sparta.springweb.service.PostService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    // 저장하기
    @PostMapping("/api/post")
    public String savePost (PostDto postDto)throws Exception {
        PostDto dto = postService.saveImage(postDto,postDto.getImage());
        return "아이템 저장이 성공했습니다.";
    }

    // post목록보기

}

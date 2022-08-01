package com.sparta.springweb.service;


import com.sparta.springweb.dto.PostResponseDto;
import com.sparta.springweb.dto.PostResquestDto;
import com.sparta.springweb.model.Post;
import com.sparta.springweb.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
//게시글 생성
    @Transactional
    public void savepost(PostResquestDto postresquestdto) {

        Post post = Post.builder()
                .title(postresquestdto.getTitle())
                .salesUnit(postresquestdto.getSalesUnit())
                .weight(postresquestdto.getWeight())
                .image_url(postresquestdto.getImage_url())
                .build();


        postRepository.save(post);
    }

//게시글 삭제
    @Transactional
    public void deleteposting(Long postId) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 게시글을 찾을 수 없습니다.")
        );
        postRepository.delete(post);
    }

//게시글 수정
    public void updatepost(Long postId, PostResquestDto postResquestDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 게시글을 찾을 수 없습니다.")
        );

        post.update(postResquestDto);
    }

    //상세페이지 조회
    public PostResponseDto detailposting(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 게시글을 찾을 수 없습니다."));
       return new PostResponseDto(post);
    }


//메인페이지 조회
    public List<PostResponseDto> mainposting() {
        List<Post> posts =postRepository.findAll();
        List<PostResponseDto> responseDtos= new ArrayList<>();
        for(Post post: posts){
            PostResponseDto postResponseDto =new PostResponseDto(post);
            responseDtos.add(postResponseDto);
        }
        return responseDtos;
    }

//insert into POST (ID, IMAGE_URL, PRICE, SALES_UNIT ,TITLE , WEIGHT) values (1, 'Suzuki', 1, '123' , '1234' , '1234' );
}







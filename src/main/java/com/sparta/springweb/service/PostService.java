package com.sparta.springweb.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.sparta.springweb.dto.FileDto;
import com.sparta.springweb.dto.PostDto;
import com.sparta.springweb.model.Embedded.File;
import com.sparta.springweb.model.Post;
import com.sparta.springweb.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Component
public class PostService {

    private final AmazonS3Client amazonS3Client;
    private final PostRepository postRepository;

    private String S3Bucket = "test-bucket-hong";


    // 이미지 저장하기
    public  PostDto saveImage(PostDto postDto, MultipartFile file) throws Exception{

        FileDto fileDto = createFile(file);
        File saveFile = new File(fileDto);
        Post post = new Post(postDto);
        post.setFile(saveFile);
        postRepository.save(post);
        return postDto;
    }

    //저장할 이미지 생성
    public FileDto createFile(MultipartFile file) throws Exception {
        String originalName= file.getOriginalFilename();
        long size = file.getSize();

        String originalFileExtension = StringUtils.getFilenameExtension("");

        ObjectMetadata objectMetaData = new ObjectMetadata();
        objectMetaData.setContentType(file.getContentType());
        objectMetaData.setContentLength(size);


        amazonS3Client.putObject(
                new PutObjectRequest(S3Bucket, originalName, file.getInputStream(), objectMetaData)
                        .withCannedAcl(CannedAccessControlList.PublicRead)
        );
        String fileName =
                UUID.randomUUID()
                        .toString()
                        .replaceAll("-", "") + "." + originalFileExtension;

        String fileUrl = amazonS3Client.getUrl(S3Bucket, originalName).toString();
        return new FileDto(fileUrl, originalName, fileName);

    }

    //목록 불러오기





}

package com.sparta.springweb.controller;

import com.sparta.springweb.dto.SignupRequestDto;
import com.sparta.springweb.exception.CustomException;
import com.sparta.springweb.security.UserDetailsImpl;
import com.sparta.springweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static com.sparta.springweb.exception.ErrorCode.ID_LENGTH_CODE;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public ResponseEntity registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
       return new ResponseEntity<>("회원 가입 완료", HttpStatus.OK); // Error는 보통 전부 Exceptionhandler로 처리해주는데 굳이 ResponseEntity를 리턴해서
                                                                        //상태코드를 보내는 이유?
    }



    // 로그아웃
//    @PostMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        return userService.logout(request);
//    }




}
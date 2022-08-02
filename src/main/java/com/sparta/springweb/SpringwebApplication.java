package com.sparta.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringwebApplication.class, args);
    }



//    @Bean
//    public CommandLineRunner demo(PostsRepository repository) {
//        return (args) -> {
//            repository.save(new Contents("항해99", "선원1", "어푸어푸"));
//        };
//    }
}

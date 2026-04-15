package com.app.restful.service;

import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PostServiceTests {

    @Autowired
    private PostService postService;

    @Test
    public void postList() {
        log.info("postList : {}", postService.getPostList());
    }

    @Test
    public void post() {
        log.info("post : {}", postService.getPost(2L));
    }

    @Test
    public void createPost() {
        PostCreateRequestDTO postCreateRequestDTO = new PostCreateRequestDTO();
        postCreateRequestDTO.setPostTitle("test");
        postCreateRequestDTO.setPostContent("test");
        postCreateRequestDTO.setMemberId(1L);
        postService.createPost(postCreateRequestDTO);
    }

    @Test
    public void updatePost() {
        PostUpdateRequestDTO postUpdateRequestDTO = new PostUpdateRequestDTO();
        postUpdateRequestDTO.setId(82L);
        postUpdateRequestDTO.setPostTitle("테스츄");
        postUpdateRequestDTO.setPostContent("테스츄");
        postService.updatePost(postUpdateRequestDTO);
    }

    @Test
    public void withdrawPost() {
        postService.withdrawPost(82L);
    }
}

package com.app.threetier.service;

import com.app.threetier.domain.vo.PostVO;
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
    void getPostTest() {
        log.info("post {}", postService.getPost(5L));
    }

    @Test
    void getPostUpdateTest() {
        PostVO postVO = new PostVO();
        postVO.setId(1L);
        postVO.setPostTitle("게시글 제목 변경!");
        postVO.setPostContent("게시글 내용 변경?");
        postService.getPostUpdate(postVO);
        log.info("post {}", postService.getPost(1L));
    }
}

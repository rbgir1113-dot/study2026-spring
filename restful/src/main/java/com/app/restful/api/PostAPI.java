package com.app.restful.api;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostAPI {

    private final PostService postService;

    public List<PostDTO> postList() {
        return postService.getPostList( );
    }
}

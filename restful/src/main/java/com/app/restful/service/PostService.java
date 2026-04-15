package com.app.restful.service;


import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostListRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.PostVO;

import java.util.List;

public interface PostService {
    public List<PostListRequestDTO> getPostList();
    public PostListRequestDTO getPost(Long id);
    public void createPost(PostCreateRequestDTO postCreateRequestDTO);
    public void updatePost(PostUpdateRequestDTO postUpdateRequestDTO);
    public void withdrawPost(Long id);

}

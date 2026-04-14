package com.app.restful.service;


import com.app.restful.domain.dto.PostDTO;

import java.util.List;

public interface PostService {
    public List<PostDTO> getPostList(PostDTO postDTO);
}

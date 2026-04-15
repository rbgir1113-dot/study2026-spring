package com.app.restful.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostListRequestDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long postReadCount;
    private String memberEmail;
    private String memberName;


    public static PostListRequestDTO from(PostDTO postDTO) {
        PostListRequestDTO postListRequestDTO = new PostListRequestDTO();
        postListRequestDTO.setId(postDTO.getId());
        postListRequestDTO.setPostTitle(postDTO.getPostTitle());
        postListRequestDTO.setPostContent(postDTO.getPostContent());
        postListRequestDTO.setPostReadCount(postDTO.getPostReadCount());
        postListRequestDTO.setMemberEmail(postDTO.getMemberEmail());
        postListRequestDTO.setMemberName(postDTO.getMemberName());
        return postListRequestDTO;
    }
}

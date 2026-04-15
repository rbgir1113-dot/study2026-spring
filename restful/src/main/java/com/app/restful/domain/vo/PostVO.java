package com.app.restful.domain.vo;

import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Long memberId;
    private Long postReadCount;


    public static PostVO from(PostCreateRequestDTO postCreateRequestDTO) {
        PostVO postVO = new PostVO();
        postVO.setPostTitle(postCreateRequestDTO.getPostTitle());
        postVO.setPostContent(postCreateRequestDTO.getPostContent());
        postVO.setMemberId(postCreateRequestDTO.getMemberId());
        return postVO;
    }

//    오버로딩
    public static PostVO from(PostUpdateRequestDTO postUpdateRequestDTO) {
        PostVO postVO = new PostVO();
        postVO.setId(postUpdateRequestDTO.getId());
        postVO.setPostTitle(postUpdateRequestDTO.getPostTitle());
        postVO.setPostContent(postUpdateRequestDTO.getPostContent());
        return postVO;
    }
}

package com.app.restful.service;

import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostListRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.exception.PostException;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;
    private final PostVO postVO;

    @Override
    public List<PostListRequestDTO> getPostList() {
        return postDAO.findAll().stream().map(PostListRequestDTO::from).toList();
    }

    @Override
    public PostListRequestDTO getPost(Long id) {
        return postDAO
                .findById(id)
                .map(PostListRequestDTO::from)
                .orElseThrow(() -> {return new PostException("회원이 없습니다.");});
    }

    @Override
    public void createPost(PostCreateRequestDTO postCreateRequestDTO) {
        postDAO.save(postVO.from(postCreateRequestDTO));
    }

    @Override
    public void updatePost(PostUpdateRequestDTO postUpdateRequestDTO) {
        postDAO.update(postVO.from(postUpdateRequestDTO));
    }

    @Override
    public void withdrawPost(Long id) {
        postDAO.withdraw(id);
    }


}

package com.app.restful.repository;

import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {

    private final PostMapper postMapper;

    public List<PostDTO> findAll() {
        return postMapper.selectAll();
    }

    public Optional<PostDTO> findById(Long id) {
        return Optional.ofNullable(postMapper.select(id));
    }

    public void save(PostVO postVO) {
        postMapper.insert(postVO);
    }

    public void update(PostVO postVO) {
        postMapper.update(postVO);
    }

    public void withdraw(Long id) {
        postMapper.delete(id);
    }

    public void withdrawByMemberId(Long id) {
        postMapper.deleteByMemberId(id);
    }


}

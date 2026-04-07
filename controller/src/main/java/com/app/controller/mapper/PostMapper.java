package com.app.controller.mapper;

import com.app.controller.domain.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {
    public List<PostDTO> selectAll();



}


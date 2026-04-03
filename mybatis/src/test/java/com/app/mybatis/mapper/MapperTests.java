package com.app.mybatis.mapper;

import com.app.mybatis.domain.dto.PostDTO;
import com.app.mybatis.domain.vo.MemberVO;
import com.app.mybatis.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Sequence;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class MapperTests {

    @Autowired
    private TimeMapper timeMapper;

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberVO memberVO;
    @Autowired
    private PostMapper postMapper;

    @Test
    public void mapperTests() {
        log.info(timeMapper.getTime());
    }

    @Test
    public void mapperTests2() {
        log.info(timeMapper.getTime2());
    }

    @Test
    public void mapperTests3() {
        log.info(memberMapper.selectAll().toString());
    }

    @Test
    public void mapperTest4() {
        memberMapper.select(2L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void insertTest() {
        MemberVO memberVO = new MemberVO();
//        memberVO.setMemberEmail("test789@gmail.com");
//        memberVO.setMemberPassword("test123!@#");
//        memberVO.setMemberName("장보고");

        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberPassword("test123!@#");
        memberVO.setMemberName("이순신");

        memberMapper.insert(memberVO);

    }

    @Test
    public void updateTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setId(2L);
        memberVO.setMemberEmail("test456@gmail.com");
        memberVO.setMemberPassword("test123!@#");
        memberVO.setMemberName("장길동");

        memberMapper.select(2L).map(MemberVO::toString).ifPresent(log::info);
        memberMapper.update(memberVO);
        memberMapper.select(2L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void deleteTest() {
        memberMapper.delete(2L);
    }

    @Test
    public void postInsertTest() {
        PostVO postVO = new PostVO();
        postVO.setPostTitle("개미는 뚠뚠 오늘도 뚠뚠");
        postVO.setPostContent("열심히 일을 하네 뚠뚠");
        postVO.setMemberId(3L);
        postVO.setPostReadCount(5L);
        postMapper.insert(postVO);
    }

    @Test
    public void postSelectAllTest() {
        postMapper.selectAll(1L).forEach(postVO -> log.info(postVO.toString()));
    }

    @Test
    public void postSelectTest() {
        postMapper.select(8L).map(PostDTO::toString).ifPresent(log::info);
    }




    @Test
    public void updatePostTest() {
        PostVO postVO = new PostVO();
        postVO.setId(8L);
        postVO.setPostTitle("개미는 뚠뚠 오늘도 뚠뚠");
        postVO.setPostContent("열심히 일을 하네 뚠뚠");
        postVO.setMemberId(4L);
        postVO.setPostReadCount(12L);

        postMapper.select(8L).map(PostDTO::toString).ifPresent(log::info);
        postMapper.update(postVO);
        postMapper.select(8L).map(PostDTO::toString).ifPresent(log::info);
    }

    @Test
    public void deletePostTest() {
        postMapper.delete(7L);
    }
}

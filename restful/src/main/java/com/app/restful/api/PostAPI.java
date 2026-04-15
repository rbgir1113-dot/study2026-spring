package com.app.restful.api;

import com.app.restful.domain.dto.PostCreateRequestDTO;
import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.dto.PostListRequestDTO;
import com.app.restful.domain.dto.PostUpdateRequestDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostAPI {

    private final PostService postService;
    private final PostVO postVO;
    private final PostUpdateRequestDTO postUpdateRequestDTO;

    @Operation(summary = "게시글 리스트 조회 서비스", description = "게시글 작성한 회원과 내용 제목 리스트로 전부 출력")
    @ApiResponse(responseCode = "201", description = "게시글 목록 조회 성공")
    @GetMapping("")
    public List<PostListRequestDTO> postList() {
        return postService.getPostList();
    }

    @Operation(summary = "게시글 단일 출력", description = "게시글 단일로 회원들에게 보여줌")
    @ApiResponse(responseCode = "201" , description = "게시글 단일 조회 성공")
    @GetMapping("/{id}")
    public PostListRequestDTO post(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @Operation(description = "게시글 작성 해주는 서비스", summary = "게시글 작성")
    @ApiResponse(responseCode = "201", description = "게시글 추가 완료")
    @PostMapping("/create")
    public void createPost(@RequestBody PostCreateRequestDTO postCreateRequestDTO) {
        postService.createPost(postCreateRequestDTO);
    }

    @Operation(summary = "게시글 수정" , description = "게시글을 수정해주는 서비스")
    @ApiResponse(responseCode = "207", description = "게시글 수정 완료")
    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDTO postUpdateRequestDTO) {
        postUpdateRequestDTO.setId(id);
        postService.updatePost(postUpdateRequestDTO);
    }

    @Operation(summary = "게시글 삭제", description = "게시글을 삭제해주는 서비스")
    @ApiResponse(responseCode = "207", description = "게시글 삭제 완료")
    @DeleteMapping("/{id}")
    public void withdrawPost(@PathVariable Long id) {
        postService.withdrawPost(id);
    }


}

package com.app.threetier.controller;

import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.mapper.PostMapper;
import com.app.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/posts/*")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("list")
    public void goToList(Model model) {
        model.addAttribute("posts", postService.getPosts());
    }

    @GetMapping("read")
    public void goToRead(Model model, Long id) {
        model.addAttribute("post", postService.getPost(id));
    }

    @GetMapping("update")
    public String goToUpdate(Long id , Model model) {
        model.addAttribute("post", postService.getPost(id));
        return "posts/update";
    }

    @PostMapping("update-ok")
    public RedirectView updateOk(PostVO postVO) {
        postService.updatePost(postVO);
        return new RedirectView("/posts/read?id=" + postVO.getId());
    }

//  delete는 주로 get, deleteMapping을 사용
    @GetMapping("delete-ok")
    public RedirectView delete(Long id) {
        postService.deletePost(id);
        return new RedirectView("/posts/list");
    }


}


package com.SimpleBoard.SimpleBoard.web;


import com.SimpleBoard.SimpleBoard.service.post.PostService;
import com.SimpleBoard.SimpleBoard.web.dto.PostCreatePostRequestDto;
import com.SimpleBoard.SimpleBoard.web.dto.PostFindResponseDto;
import com.SimpleBoard.SimpleBoard.web.dto.PostListsResponseDto;
import com.SimpleBoard.SimpleBoard.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @PostMapping
    public Long createPost(@RequestBody PostCreatePostRequestDto requestDto){
        return postService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public PostFindResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

    @GetMapping
    public List<PostListsResponseDto> findAll(){
        return postService.findAllDesc();
    }





}

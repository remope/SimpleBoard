package com.SimpleBoard.SimpleBoard.web;

import com.SimpleBoard.SimpleBoard.service.comment.CommentService;
import com.SimpleBoard.SimpleBoard.web.dto.GetCommentListsResponseDto;
import com.SimpleBoard.SimpleBoard.web.dto.PostCreateCommentRequestDto;
import com.SimpleBoard.SimpleBoard.web.dto.PutUpdateCommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Long createComment(@RequestBody PostCreateCommentRequestDto requestDto){
        return commentService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody PutUpdateCommentRequestDto requestDto){
        return commentService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public List<GetCommentListsResponseDto> findByPostId(@PathVariable Long id){
        return commentService.findByPostId(id);
    }




}

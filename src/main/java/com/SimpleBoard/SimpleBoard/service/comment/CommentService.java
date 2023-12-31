package com.SimpleBoard.SimpleBoard.service.comment;

import com.SimpleBoard.SimpleBoard.domain.comment.Comment;
import com.SimpleBoard.SimpleBoard.domain.comment.CommentRepository;
import com.SimpleBoard.SimpleBoard.web.dto.GetCommentListsResponseDto;
import com.SimpleBoard.SimpleBoard.web.dto.GetPostListsResponseDto;
import com.SimpleBoard.SimpleBoard.web.dto.PostCreateCommentRequestDto;
import com.SimpleBoard.SimpleBoard.web.dto.PutUpdateCommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;


    @Transactional
    public Long save(PostCreateCommentRequestDto requestDto){
        return commentRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, PutUpdateCommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );

        comment.update(requestDto);
        return comment.getId();
    }

    public List<GetCommentListsResponseDto> findByPostId(Long id) {
        return commentRepository.findByPostId(id).stream()
                .map(GetCommentListsResponseDto::new)
                .collect(Collectors.toList());
    }
}

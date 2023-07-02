package com.SimpleBoard.SimpleBoard.service.post;


import com.SimpleBoard.SimpleBoard.domain.post.Post;
import com.SimpleBoard.SimpleBoard.domain.post.PostRepository;
import com.SimpleBoard.SimpleBoard.web.dto.PostCreatePostRequestDto;
import com.SimpleBoard.SimpleBoard.web.dto.PostFindResponseDto;
import com.SimpleBoard.SimpleBoard.web.dto.PostListsResponseDto;
import com.SimpleBoard.SimpleBoard.web.dto.PutUpdatePostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PutUpdatePostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        post.update(requestDto);
        return post.getId();
    }

    @Transactional
    public Long save(PostCreatePostRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }


    public PostFindResponseDto findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 Post가 존재하지 않습니다. ID = " + id)
        );
        return new PostFindResponseDto(post);
    }

    @Transactional
    public List<PostListsResponseDto> findAllDesc(){
        return postRepository.findAllDesc().stream()
                .map(PostListsResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 Post가 존재하지 않습니다. ID = " + id)
        );
        postRepository.delete(post);
    }
}

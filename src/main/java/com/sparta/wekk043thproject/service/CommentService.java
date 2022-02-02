package com.sparta.wekk043thproject.service;

import com.sparta.wekk043thproject.dto.CommentRequestDto;
import com.sparta.wekk043thproject.model.Comment;
import com.sparta.wekk043thproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long update(Long id, CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글 내용을 채워주세요.")
        );
        comment.update(requestDto);
        return comment.getId();
        }
    }



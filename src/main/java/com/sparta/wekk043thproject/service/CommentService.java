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

    //댓글 수정하기
    //1. 댓글 조회하기
    public Comment getComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
        return comment;
    }
    //2. 댓글 수정하기
    public Comment updateComment(Long id, CommentRequestDto commentDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));

        comment.setCommentid(commentDto.getCommentid());
        comment.setComment(commentDto.getComment());
        commentRepository.save(comment);

        return comment;
    }
    @Transactional
    public Long update(Long id, CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("수정 할 댓글 내용을 채워주세요.")
        );
        comment.update(requestDto);
        return comment.getId();
        }
    }



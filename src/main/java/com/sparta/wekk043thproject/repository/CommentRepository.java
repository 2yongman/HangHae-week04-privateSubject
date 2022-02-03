package com.sparta.wekk043thproject.repository;

import com.sparta.wekk043thproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
     List<Comment> findAllByCommentidOrderByCreatedAtDesc(Long commentid);
    //findAllByOrderByModifiedAtDesc : 다 찾고 수정된 날짜 기준으로 정렬을 해줘.
}
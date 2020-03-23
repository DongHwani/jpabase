package com.dhk.jpabase.domain.comment.repository;

import com.dhk.jpabase.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

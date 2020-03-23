package com.dhk.jpabase.setup.domain;

import com.dhk.jpabase.domain.comment.entity.Comment;
import com.dhk.jpabase.domain.comment.repository.CommentRepository;
import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.setup.model.CommentBuilder;
import com.dhk.jpabase.setup.model.LectureBuilder;
import org.springframework.stereotype.Component;

@Component
public class CommentSetUp {

    private final CommentRepository commentRepository;
    private final MemberSetUp memberSetUp;

    public CommentSetUp(CommentRepository commentRepository, MemberSetUp memberSetUp){
        this.commentRepository = commentRepository;
        this.memberSetUp = memberSetUp;
    }

    public Comment save(Long lectureId){
        final Comment comment = CommentBuilder.build(memberSetUp.save(), lectureId);
        return commentRepository.save(comment);
    }


}

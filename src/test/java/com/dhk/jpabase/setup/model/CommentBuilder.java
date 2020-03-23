package com.dhk.jpabase.setup.model;

import com.dhk.jpabase.domain.comment.entity.Comment;
import com.dhk.jpabase.domain.comment.entity.CommentType;
import com.dhk.jpabase.domain.member.entity.Member;

public class CommentBuilder {

    public static Comment build(Member member,Long lectureId){
        return Comment.builder()
                .lectureId(lectureId)
                .commentType(CommentType.REVIEW)
                .content("좋은 강의에요!!")
                .questioner(member)
                .build();
    }

}

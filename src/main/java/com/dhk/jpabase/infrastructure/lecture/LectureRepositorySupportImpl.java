package com.dhk.jpabase.infrastructure.lecture;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.repository.LectureRepositorySupport;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.dhk.jpabase.domain.comment.entity.QComment.comment;
import static com.dhk.jpabase.domain.lecture.entity.QLecture.lecture;

@RequiredArgsConstructor
public class LectureRepositorySupportImpl implements LectureRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Lecture findByIdWithComments(Long lectureId) {
        return jpaQueryFactory
                        .selectFrom(lecture)
                        .where(lecture.lectureId.eq(lectureId))
                        .leftJoin(lecture.comments, comment)
                        .fetchJoin()
                        .fetchOne();
    }
}

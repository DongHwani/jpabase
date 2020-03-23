package com.dhk.jpabase.domain.lecture.repository;

import com.dhk.jpabase.domain.lecture.entity.Lecture;

public interface LectureRepositorySupport {
    Lecture findByIdWithComments(Long lectureId);

}

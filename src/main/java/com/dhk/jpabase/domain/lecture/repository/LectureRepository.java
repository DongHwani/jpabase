package com.dhk.jpabase.domain.lecture.repository;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}

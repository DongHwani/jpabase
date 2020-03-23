package com.dhk.jpabase.domain.lecture.repository;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.entity.LectureCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long>, LectureRepositorySupport {

    List<Lecture> findByCategory(LectureCategory category, Pageable pageable);
}

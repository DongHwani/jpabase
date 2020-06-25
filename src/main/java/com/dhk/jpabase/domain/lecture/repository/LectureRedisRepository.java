package com.dhk.jpabase.domain.lecture.repository;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import org.springframework.data.repository.CrudRepository;

public interface LectureRedisRepository extends CrudRepository<Lecture, Integer> {
}

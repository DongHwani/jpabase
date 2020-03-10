package com.dhk.jpabase.setup.domain;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.repository.LectureRepository;
import com.dhk.jpabase.setup.model.LectureBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LectureSetUp {

    private final LectureRepository lectureRepository;


}


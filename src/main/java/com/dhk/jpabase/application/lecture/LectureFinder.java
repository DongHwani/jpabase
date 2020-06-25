package com.dhk.jpabase.application.lecture;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LectureFinder {

    private final LectureRepository lectureRepository;

    public Lecture getLecture(Long lectureId){
        final Lecture lecture = lectureRepository.findById(lectureId)
                                    .orElseThrow(() -> new IllegalArgumentException());
        return lecture;
    }
}

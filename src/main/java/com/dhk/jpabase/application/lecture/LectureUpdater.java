package com.dhk.jpabase.application.lecture;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.entity.LectureLine;
import com.dhk.jpabase.domain.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LectureUpdater {

    private final LectureRepository lectureRepository;

    public Lecture updateLectureLines(final Long lectureId, List<LectureLine> updateLectureLines){
       Lecture lecture = lectureRepository.findById(lectureId)
                    .orElseThrow(() -> new IllegalArgumentException());

       lecture.updateLectureLines(updateLectureLines);
       return lecture;
    }
}

package com.dhk.jpabase.application.lecture;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.entity.LectureState;
import com.dhk.jpabase.domain.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LectureRegister {

    private final LectureRepository lectureRepository;

    public Lecture createLecture(Lecture lecture){
        if(lecture.getLectureState() == null){
            lecture.updateLectureState(LectureState.PREPARATION);
        }
        return lectureRepository.save(lecture);
    }
}

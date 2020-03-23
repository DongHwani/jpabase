package com.dhk.jpabase.setup.domain;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.repository.LectureRepository;
import com.dhk.jpabase.setup.model.LectureBuilder;
import org.springframework.stereotype.Component;

@Component
public class LectureSetUp {

    private final LectureRepository lectureRepository;
    private final MemberSetUp memberSetUp;

    public LectureSetUp(LectureRepository lectureRepository, MemberSetUp memberSetUp){
        this.lectureRepository = lectureRepository;
        this.memberSetUp = memberSetUp;
    }

    public Lecture save(){
        Lecture lecture = LectureBuilder.build(memberSetUp.save());
        return lectureRepository.save(lecture);
    }

    public Lecture saveLectureJava(){
        Lecture lecture = LectureBuilder.buildLectureJava(memberSetUp.save());
        return lectureRepository.save(lecture);
    }
}


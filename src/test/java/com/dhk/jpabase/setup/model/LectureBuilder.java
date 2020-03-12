package com.dhk.jpabase.setup.model;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.entity.LectureCategory;
import com.dhk.jpabase.domain.lecture.entity.LectureLine;
import com.dhk.jpabase.domain.lecture.entity.LectureState;
import com.dhk.jpabase.domain.member.entity.Member;
import io.github.benas.randombeans.api.EnhancedRandom;

import java.math.BigDecimal;
import java.util.ArrayList;

public class LectureBuilder {

    public static Lecture build(Member member) {
        ArrayList<LectureLine> lines = (ArrayList) EnhancedRandom.randomListOf(5, LectureLine.class);
        return Lecture.builder()
                .category(LectureCategory.C)
                .lectureClassName("JAVA를 잡자")
                .lectureInformation("정보")
                .price(new BigDecimal(15000))
                .instructor(member)
                .lectureState(LectureState.PREPARATION)
                .lectureLines(lines)
                .build();
    }

    public static Lecture buildLectureJava(Member member) {
        ArrayList<LectureLine> lines = (ArrayList) EnhancedRandom.randomListOf(5, LectureLine.class);
        return Lecture.builder()
                .category(LectureCategory.JAVA)
                .lectureClassName("JAVA를 잡자")
                .lectureInformation("정보")
                .price(new BigDecimal(15000))
                .instructor(member)
                .lectureState(LectureState.PREPARATION)
                .lectureLines(lines)
                .build();
    }
}

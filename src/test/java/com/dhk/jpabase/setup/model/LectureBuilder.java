package com.dhk.jpabase.setup.model;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.entity.LectureCategory;
import com.dhk.jpabase.domain.lecture.entity.LectureLine;
import com.dhk.jpabase.domain.lecture.entity.LectureState;
import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import com.dhk.jpabase.setup.domain.LectureSetUp;
import com.dhk.jpabase.setup.domain.MemberSetUp;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@RequiredArgsConstructor
public class LectureBuilder {

    private final MemberSetUp memberSetUp;

    public static Lecture build() {
        ArrayList<LectureLine> lines = (ArrayList) EnhancedRandom
                                            .randomListOf(5, LectureLine.class);
        return Lecture.builder()
                .category(LectureCategory.JAVA)
                .lectureClassName("JAVA 초보")
                .lectureInformation("정보")
                .lectureState(LectureState.PREPARATION)
                .lectureLines(lines)
                .build();
    }
}

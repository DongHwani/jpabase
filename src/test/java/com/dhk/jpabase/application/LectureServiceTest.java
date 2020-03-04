package com.dhk.jpabase.application;

import com.dhk.jpabase.application.lecture.LectureChanger;
import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.entity.LectureCategory;
import com.dhk.jpabase.domain.lecture.entity.LectureLine;
import com.dhk.jpabase.domain.lecture.repository.LectureRepository;
import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LectureServiceTest {

    @Autowired
    private LectureChanger lectureChanger;

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private MemberRepository memberRepository;

    private Lecture lecture;

    @Before
    public void setUp(){
        lecture = createLecture();
    }

    @Test
    public void LectureLinesUpdate() {
        //Given
        Lecture savedLecture = lectureRepository.save(lecture);

        List<LectureLine> updateLines = new ArrayList<>();
        updateLines.add(new LectureLine("제 1장 오리엔테이션", "내용"));
        updateLines.add(new LectureLine("제 2장 학습목표", "내용"));
        updateLines.add(new LectureLine("제 3장 객체", "내용"));

        //When
        lectureChanger.updateLectureLines(savedLecture.getLectureId(), updateLines);
        Optional<Lecture> optional = lectureRepository.findById(savedLecture.getLectureId());
        Lecture result = optional.get();

        //Then
        assertThat(result.getLectureLines(), hasSize(3));
    }

    private Lecture createLecture() {
        List<LectureLine> list = new ArrayList<>();
        list.add(new LectureLine("제1장 객체", "내용"));
        list.add(new LectureLine("제2장 타입", "내용"));

        Member member = createMember();

        Lecture lecture = Lecture.builder()
                .lectureInformation("이 강의는 유익한 강의이다.")
                .lectureClassName("열혈 JAVA")
                .category(LectureCategory.JAVA)
                .price(new BigDecimal(150000))
                .instructor(member)
                .lectureLines(list)
                .build();

        return lecture;
    }

    private Member createMember() {
        EnhancedRandom builder = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .stringLengthRange(3, 5)
                .collectionSizeRange(1, 3)
                .build();
        Member member = builder.nextObject(Member.class, "memberId");
        return memberRepository.save(member);
    }

}

package com.dhk.jpabase.domain.repository;

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
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LectureRepositoryTest {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveLecture(){
        //Given
        Set<LectureLine> set = new HashSet<>();
        set.add(new LectureLine("제1장 객체", "내용"));
        set.add(new LectureLine("제2장 타입", "내용"));

        Member member = memberSetting();

        Lecture lecture = Lecture.builder()
                .lectureInformation("이 강의는 유익한 강의이다.")
                .lectureClassName("열혈 JAVA")
                .category(LectureCategory.JAVA)
                .price(new BigDecimal(150000))
                .instructor(member)
                .lectureLines(set)
                .build();


        //When
        Lecture savedLecture = lectureRepository.save(lecture);

        //Them
        assertThat(savedLecture).isNotNull();
        assertThat(savedLecture.getLectureId()).isNotNull();
        assertThat(savedLecture.getInstructor()).isNotNull();
        assertThat(savedLecture.getCategory()).isEqualTo(lecture.getCategory());
        assertThat(savedLecture.getLectureInformation()).isEqualTo(lecture.getLectureInformation());
        assertThat(savedLecture.getLectureClassName()).isEqualTo(lecture.getLectureClassName());
        assertThat(savedLecture.getPrice()).isEqualTo(lecture.getPrice());
        assertThat(savedLecture.getCreatedAt()).isEqualTo(lecture.getCreatedAt());
        assertThat(savedLecture.getLectureLines().size()).isNotNull();
    }

    private Member memberSetting() {
        EnhancedRandom builder = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .stringLengthRange(3, 5)
                .collectionSizeRange(1, 3)
                .build();
        Member member = builder.nextObject(Member.class, "memberId");
        return memberRepository.save(member);
    }

}

//package com.dhk.jpabase.domain.lecture.repository;
//
//import com.dhk.jpabase.domain.lecture.entity.Lecture;
//import com.dhk.jpabase.domain.lecture.entity.LectureCategory;
//import com.dhk.jpabase.domain.lecture.entity.LectureLine;
//import com.dhk.jpabase.domain.lecture.repository.LectureRepository;
//import com.dhk.jpabase.domain.member.entity.Member;
//import com.dhk.jpabase.domain.member.repository.MemberRepository;
//import io.github.benas.randombeans.EnhancedRandomBuilder;
//import io.github.benas.randombeans.api.EnhancedRandom;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.transaction.Transactional;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.hamcrest.Matchers.hasSize;
//import static org.junit.Assert.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class LectureRepositoryTest {
//
//    @Autowired
//    private LectureRepository lectureRepository;
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    private Lecture lecture;
//
//    @Before
//    public void setUp(){
//       lecture = createLecture();
//    }
//
//
//    @Test
//    public void saveLecture(){
//        //Given & When
//        Lecture savedLecture = lectureRepository.save(lecture);
//
//        //Them
//        assertThat(savedLecture).isNotNull();
//        assertThat(savedLecture.getLectureId()).isNotNull();
//        assertThat(savedLecture.getInstructor()).isNotNull();
//        assertThat(savedLecture.getCategory()).isEqualTo(lecture.getCategory());
//        assertThat(savedLecture.getLectureInformation()).isEqualTo(lecture.getLectureInformation());
//        assertThat(savedLecture.getLectureClassName()).isEqualTo(lecture.getLectureClassName());
//        assertThat(savedLecture.getPrice()).isEqualTo(lecture.getPrice());
//        assertThat(savedLecture.getCreatedAt()).isEqualTo(lecture.getCreatedAt());
//        assertThat(savedLecture.getLectureLines().size()).isNotNull();
//    }
//
//
//    @Test
//    public void getLecture(){
//        //Given
//        Lecture savedLecture = lectureRepository.save(lecture);
//
//        //When
//        Optional<Lecture> optionalLecture = lectureRepository.findById(savedLecture.getLectureId());
//        Lecture result = optionalLecture.get();
//
//        //Then
//        assertThat(result.getLectureId()).isEqualTo(savedLecture.getLectureId());
//        assertThat(result.getLectureClassName()).isEqualTo(savedLecture.getLectureClassName());
//        assertThat(result.getPrice()).isEqualTo(savedLecture.getPrice());
//        assertThat(result.getLectureInformation()).isEqualTo(savedLecture.getLectureInformation());
//        assertThat(result.getInstructor().getMemberId()).isEqualTo(savedLecture.getInstructor().getMemberId());
//        assertThat(result.getLectureLines(), hasSize(2));
//    }
//
//    @Test
//    public void deleteLecture(){
//        //Given
//        Lecture savedLecture = lectureRepository.save(lecture);
//
//        //When & THen
//        lectureRepository.deleteById(savedLecture.getLectureId());
//
//        System.out.println(lectureRepository.count());
//        assertThat(lectureRepository.count()).isEqualTo(0);
//    }
//
//
//    private Lecture createLecture() {
//        List<LectureLine> list = new ArrayList<>();
//        list.add(new LectureLine("제1장 객체", "내용"));
//        list.add(new LectureLine("제2장 타입", "내용"));
//
//        Member member = createMember();
//
//        Lecture lecture = Lecture.builder()
//                .lectureInformation("이 강의는 유익한 강의이다.")
//                .lectureClassName("열혈 JAVA")
//                .category(LectureCategory.JAVA)
//                .price(new BigDecimal(150000))
//                .instructor(member)
//                .lectureLines(list)
//                .build();
//
//        return lecture;
//    }
//
//    private Member createMember() {
//        EnhancedRandom builder = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
//                .stringLengthRange(3, 5)
//                .collectionSizeRange(1, 3)
//                .build();
//        Member member = builder.nextObject(Member.class, "memberId");
//        return memberRepository.save(member);
//    }
//
//
//}

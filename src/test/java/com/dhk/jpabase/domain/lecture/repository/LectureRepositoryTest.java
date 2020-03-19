package com.dhk.jpabase.domain.lecture.repository;

import com.dhk.jpabase.Description;
import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.entity.LectureCategory;
import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.setup.domain.LectureSetUp;
import com.dhk.jpabase.setup.domain.MemberSetUp;
import com.dhk.jpabase.setup.model.LectureBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class LectureRepositoryTest {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private MemberSetUp memberSetUp;

    @Autowired
    private LectureSetUp lectureSetUp;

    @PersistenceContext
    private EntityManager entityManager;

    private Lecture lecture;



    @Before
    public void setUp() {
        Member member = memberSetUp.save();
        lecture = LectureBuilder.build(member);
    }

    @After
    public void cleanUp(){
        entityManager.clear();
    }

    @Test
    public void saveLecture() {
        //Given & When
        Lecture savedLecture = lectureRepository.save(lecture);

        //Them
        assertThat(savedLecture).isNotNull();
        assertThat(savedLecture.getLectureId()).isNotNull();
        assertThat(savedLecture.getInstructor()).isNotNull();
        assertThat(savedLecture.getLectureState()).isEqualTo(lecture.getLectureState());
        assertThat(savedLecture.getCategory()).isEqualTo(lecture.getCategory());
        assertThat(savedLecture.getLectureInformation()).isEqualTo(lecture.getLectureInformation());
        assertThat(savedLecture.getLectureClassName()).isEqualTo(lecture.getLectureClassName());
        assertThat(savedLecture.getPrice()).isEqualTo(lecture.getPrice());
        assertThat(savedLecture.getCreatedAt()).isEqualTo(lecture.getCreatedAt());
        assertThat(savedLecture.getLectureLines().size()).isNotNull();
    }


    @Test
    public void getLecture() {
        //Given
        Lecture savedLecture = lectureRepository.save(lecture);

        //When
        Optional<Lecture> optionalLecture = lectureRepository.findById(savedLecture.getLectureId());
        Lecture result = optionalLecture.get();

        //Then
        assertThat(result.getLectureId()).isEqualTo(savedLecture.getLectureId());
        assertThat(result.getLectureClassName()).isEqualTo(savedLecture.getLectureClassName());
        assertThat(result.getPrice()).isEqualTo(savedLecture.getPrice());
        assertThat(result.getLectureInformation()).isEqualTo(savedLecture.getLectureInformation());
        assertThat(result.getInstructor().getMemberId()).isEqualTo(savedLecture.getInstructor().getMemberId());
        assertThat(result.getLectureLines(), hasSize(5));
    }

    @Test
    public void deleteLecture() {
        //Given
        Lecture savedLecture = lectureRepository.save(lecture);

        //When & THen
        lectureRepository.deleteById(savedLecture.getLectureId());
        assertThat(lectureRepository.count()).isEqualTo(0);
    }

    @Test
    public void getListLecture() {
        //Given
        IntStream.range(0, 10).forEach((i) -> lectureSetUp.save());

        //When
        List<Lecture> list = lectureRepository.findAll();

        //Then
        assertThat(list, hasSize(10));
    }

    @Test
    @Description("전체 강의목록의 첫번째 페이지 10개 항목 조회 테스트")
    public void get10PagedLecture() {
        //Given
        IntStream.range(0, 15).forEach((i) -> lectureSetUp.save());
        Pageable pageable = PageRequest.of(0, 10);

        //When
        Page<Lecture> lecturePage = lectureRepository.findAll(pageable);

        //Then
        assertThat(lecturePage.getContent(), hasSize(10)); //조회 요청한 페이지 컨텐츠가 10개인지
    }

    @Test
    @Description("카테고리 JAVA로 전체 페이지 조회 테스트")
    public void getJavaLectureList() {
        //Given
        IntStream.range(0, 10).forEach((i) -> lectureSetUp.save());
        IntStream.range(0, 3).forEach((i) -> lectureSetUp.saveLectureJava());

        //When
        Pageable pageable = PageRequest.of(0, 10);
        List<Lecture> list = lectureRepository.findByCategory(LectureCategory.JAVA, pageable);

        //Then
        assertThat(list, hasSize(3));
    }

}

package com.dhk.jpabase.application.lecture;

import com.dhk.jpabase.application.MockTest;
import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.repository.LectureRepository;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class LectureRegisterTest extends MockTest {

    @InjectMocks
    private LectureRegister lectureRegister;

    @Mock
    private LectureRepository lectureRepository;

    private Lecture lecture;

    @Before
    public void setUp(){
        lecture = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(Lecture.class);
    }

    @Test
    public void createLecture(){
        //Given
        given(lectureRepository.save(lecture)).willReturn(lecture);

        //When
        Lecture createdLecture = lectureRegister.createLecture(lecture);

        //Then
        verify(lectureRepository, atLeastOnce()).save(lecture);
        assertThat(createdLecture).isNotNull();
        assertThat(createdLecture.getLectureId()).isEqualTo(lecture.getLectureId());
        assertThat(createdLecture.getInstructor()).isEqualTo(lecture.getInstructor());
        assertThat(createdLecture.getLectureLines()).isEqualTo(lecture.getLectureLines());
    }
}

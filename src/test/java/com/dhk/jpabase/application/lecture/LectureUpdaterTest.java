package com.dhk.jpabase.application.lecture;

import com.dhk.jpabase.Description;
import com.dhk.jpabase.application.MockTest;
import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.repository.LectureRepository;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

public class LectureUpdaterTest extends MockTest {

    @InjectMocks
    private LectureUpdater lectureUpdater;

    @Mock
    private LectureRepository lectureRepository;

    private Lecture lecture = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
            .collectionSizeRange(5, 10)
            .build().nextObject(Lecture.class);

    @Test
    @Transactional
    public void LectureUpdate(){
        //Given
        Lecture updateLecture = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(Lecture.class);


        //When
        Lecture result = lectureUpdater.updateLecture(lecture.getLectureId(), lecture);

        //Then
        assertThat(result).isNotNull();

    }

    @Test
    public void LectureLinesUpdate() {
        //Given
        Lecture updatedLecture = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build().nextObject(Lecture.class);
        given(lectureRepository.findById(anyLong())).willReturn(Optional.ofNullable(updatedLecture));

        //When
        Lecture result = lectureUpdater.updateLectureLines(lecture.getLectureId(), lecture.getLectureLines());

        //Then
        verify(lectureRepository, atLeastOnce()).findById(lecture.getLectureId());
        assertThat(result.getLectureLines().size()).isEqualTo(updatedLecture.getLectureLines().size());
    }


}

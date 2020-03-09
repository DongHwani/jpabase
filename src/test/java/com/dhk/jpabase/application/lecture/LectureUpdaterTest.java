package com.dhk.jpabase.application.lecture;

import com.dhk.jpabase.application.MockTest;
import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.entity.LectureLine;
import com.dhk.jpabase.domain.lecture.repository.LectureRepository;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinition;
import io.github.benas.randombeans.FieldDefinitionBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.api.EnhancedRandomParameters;
import io.github.benas.randombeans.api.Randomizer;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

public class LectureUpdaterTest extends MockTest {

    @InjectMocks
    private LectureUpdater lectureUpdater;

    @Mock
    private LectureRepository lectureRepository;

    private Lecture lecture = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(Lecture.class);

    @Test
    public void LectureLinesUpdate() {
        //Given
        Lecture updatedLecture = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build().nextObject(Lecture.class);
        given(lectureRepository.findById(anyLong())).willReturn(Optional.ofNullable(updatedLecture));

        //When
        Lecture result = lectureUpdater.updateLectureLines(lecture.getLectureId(), lecture.getLectureLines());

        //Then
        verify(lectureRepository, atLeastOnce()).findById(lecture.getLectureId());
    }


}

package com.dhk.jpabase.application.lecture;

import com.dhk.jpabase.Description;
import com.dhk.jpabase.application.MockTest;
import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.repository.LectureRepository;
import com.dhk.jpabase.setup.domain.LectureSetUp;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private LectureSetUp lecture;

    @Test
    @Transactional
    public void LectureUpdate(){
        //Given
        Lecture updateLecture = lecture.save();

        //When
        Lecture result = lectureUpdater.updateLecture(updateLecture.getLectureId(), updateLecture);

        //Then
        assertThat(result).isNotNull();

    }

    @Test
    public void LectureLinesUpdate() {
        //Given
        Lecture notUpdatedLecture = lecture.save();
        given(lectureRepository.findById(anyLong())).willReturn(Optional.ofNullable(notUpdatedLecture));

        //When
        Lecture result = lectureUpdater.updateLectureLines(notUpdatedLecture.getLectureId(), notUpdatedLecture.getLectureLines());

        //Then
        verify(lectureRepository, atLeastOnce()).findById(notUpdatedLecture.getLectureId());
        assertThat(result.getLectureLines().size()).isEqualTo(notUpdatedLecture.getLectureLines().size());
    }


}

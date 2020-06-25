package com.dhk.jpabase.application.lecture;

import com.dhk.jpabase.Description;
import com.dhk.jpabase.domain.lecture.entity.Lecture;
import com.dhk.jpabase.domain.lecture.entity.LectureState;
import com.dhk.jpabase.setup.domain.LectureSetUp;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class LectureUpdaterTest {

    @Autowired
    private LectureUpdater lectureUpdater;

    @Autowired
    private LectureSetUp lectureSetUp;

    @Test
    @Description("Lecture 업데이트 시에 LectureState가 DRAFT일 경우 예외 발생 테스트")
    public void LectureUpdateConditionDRAFT(){
        //Given
        Lecture lecture = lectureSetUp.save();
        lecture.updateLectureState(LectureState.DRAFT);

        //When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                lectureUpdater.updateLecture(lecture.getLectureId(), lecture));
    }

    @Test
    public void LectureLinesUpdate() {
        //Given
        Lecture notUpdatedLecture = lectureSetUp.save();
        Lecture updateLecture = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(Lecture.class, "lectureId");

        //When
        Lecture result = lectureUpdater.updateLectureLines(notUpdatedLecture.getLectureId(), updateLecture.getLectureLines());

        //Then
        assertThat(result.getLectureLines().size()).isEqualTo(updateLecture.getLectureLines().size());
    }

    @Test
    @Description("강의목록이 0개 일 경우, Exception 예외 테스트")
    public void LectureLinesNotExsist(){
        //Given
        Lecture lecture = lectureSetUp.saveLectureWithoutLectureLines();

        //When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                lectureUpdater.updateLectureLines(lecture.getLectureId(), lecture.getLectureLines()));
    }


}

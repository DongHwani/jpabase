package com.dhk.jpabase.domain.lecture.entity;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.support.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(schema = "jpa", name = "lectures")
public class Lecture extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Member instructor;

    private String lectureClassName;
    private String lectureInformation;

    @Enumerated(EnumType.STRING)
    private LectureCategory category;
    private BigDecimal price;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "lectureLines", joinColumns = @JoinColumn(name = "lectureId"))
    private List<LectureLine> lectureLines;

    @Enumerated(EnumType.STRING)
    private LectureState lectureState;


    public void updateLectureContents(Lecture lecture) {
        if (lectureState == LectureState.DRAFT) {
            throw new IllegalArgumentException();
        }
        this.lectureClassName = lecture.getLectureClassName();
        this.lectureInformation = lecture.getLectureInformation();
        this.category = lecture.getCategory();
        this.price = lecture.getPrice();
        this.lectureState = lecture.getLectureState();
    }

    public void updateLectureLines(List<LectureLine> newLectureLines) {
        if (newLectureLines == null || newLectureLines.size() <= 0) {
            throw new IllegalArgumentException();
        }
        this.lectureLines = newLectureLines;
    }

}

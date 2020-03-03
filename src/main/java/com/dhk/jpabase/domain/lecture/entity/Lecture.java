package com.dhk.jpabase.domain.lecture.entity;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.support.BaseTime;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder @Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access =AccessLevel.PROTECTED)
@Table(schema = "jpa", name = "lectures")
public class Lecture extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Member instructor;

    private String lectureClassName;
    private String lectureInformation;

    @Enumerated(EnumType.STRING)
    private LectureCategory category;
    private BigDecimal price;

    @ElementCollection
    @CollectionTable(name = "lectureLines", joinColumns = @JoinColumn(name="lectureId"))
    private Set<LectureLine> lectureLines = new HashSet<>();

}

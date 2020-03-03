package com.dhk.jpabase.domain.lecture.entity;

import lombok.*;

import javax.persistence.Embeddable;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class LectureLine {

    private String lectureTitle;
    private String lectureContents;

}

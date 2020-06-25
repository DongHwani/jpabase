package com.dhk.jpabase.interfaces.lecture;

import com.dhk.jpabase.application.lecture.LectureFinder;
import com.dhk.jpabase.domain.lecture.entity.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LectureController {


    @Autowired
    private LectureFinder lectureFinder;

    @GetMapping("/lecture/{lectureId}")
    @CachePut(key = "viewCount", value = "1")
    public ResponseEntity getLecture(@PathVariable Long lectureId){
        Lecture lecture = lectureFinder.getLecture(lectureId);

        return new ResponseEntity<>(lecture, HttpStatus.OK);
    }
}

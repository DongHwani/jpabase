package com.dhk.jpabase.interfaces;

import com.dhk.jpabase.domain.lecture.entity.Lecture;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LectureRedisCacheTest {

    @Autowired
    private MockMvc mockMvc;


    private Lecture lecture;

    @Before
    public void setUp(){
        lecture = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(Lecture.class, "lectureState");
    }

    @Test
    public void LectureViewCountRedisTest(){
        //Given
        System.out.println(lecture);


    }

}

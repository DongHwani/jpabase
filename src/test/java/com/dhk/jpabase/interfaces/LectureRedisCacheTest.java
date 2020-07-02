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

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

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
    public void LectureViewCountRedisTest() throws Exception{
        //Given
        mockMvc.perform(get("/lecture/{lectureId}", 3))
                .andDo(print())
                ;

    }

}

package com.dhk.jpabase.application;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberFinderTest {

    @Autowired
    private MemberFinder memberFinder;

    @Test
    public void findByMemberEmail(){



    }

}

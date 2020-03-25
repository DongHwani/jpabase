package com.dhk.jpabase.application.member;


import com.dhk.jpabase.Description;
import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import com.dhk.jpabase.setup.domain.MemberSetUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberFinderServiceTest {

    @Autowired
    private MemberFinder memberFinder;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberSetUp memberSetUp;




    @Test
    public void findByMemberEmail() {
        //Given
        Member savedMember = memberSetUp.save();

        //When
        Member result = memberFinder.findByMemberEmail(savedMember.getMemberEmail());

        //Then
        assertThat(savedMember.getMemberId()).isEqualTo(result.getMemberId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByMemberEmail_notFound() {
        //Given & When
        Member savedMember = memberSetUp.save();
        memberFinder.findByMemberEmail(savedMember.getMemberEmail() + "0");

    }

    @Test
    @Description("주소 도시명에 따른 모든 회원을 조회하는 테스트")
    public void findOutLiveInCity() {
        //Given
        String city = "서울";
        IntStream.range(0, 15).forEach((i) -> memberSetUp.save());

        //When
        List<Member> memberList = memberFinder.findByAddressCity(city);

        //When
        assertThat(memberList, hasSize(0));
    }

}

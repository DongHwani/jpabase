package com.dhk.jpabase.application.member;


import com.dhk.jpabase.Description;
import com.dhk.jpabase.domain.member.entity.Account;
import com.dhk.jpabase.domain.member.entity.Address;
import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.Before;
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
    private Member member;

    @Before
    public void setUp() {
        EnhancedRandom builder = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .stringLengthRange(3, 5)
                .collectionSizeRange(1, 3)
                .build();
        member = builder.nextObject(Member.class, "memberId");
    }


    @Test
    public void findByMemberEmail() {
        //Given
        Member savedMember = memberRepository.save(member);

        //When
        Member result = memberFinder.findByMemberEmail(savedMember.getMemberEmail());

        //Then
        assertThat(member.getMemberId()).isEqualTo(result.getMemberId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByMemberEmail_notFound() {
        //Given & When
        Member savedMember = memberRepository.save(member);
        memberFinder.findByMemberEmail(savedMember.getMemberEmail() + "0");

    }

    @Test
    @Description("주소 도시명에 따른 모든 회원을 조회하는 테스트")
    public void findOutLiveInCity() {
        //Given
        String city = "서울";
        IntStream.range(0, 15).forEach(this::createListMember);
        memberRepository.save(member);

        //When
        List<Member> memberList = memberFinder.findByAddressCity(city);

        //When
        assertThat(memberList, hasSize(0));
    }

    private void createListMember(int i) {
        Account account = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(Account.class);
        Address address = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(Address.class);

        Member member = Member.builder()
                .memberEmail("email@email.com" + i)
                .nickName("nick" + i)
                .password("pass" + i)
                .phoneNumber("0100112020" + i)
                .address(address)
                .account(account)
                .build();

        this.memberRepository.save(member);
    }
}

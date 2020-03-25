package com.dhk.jpabase.domain.member.repository;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.setup.domain.MemberSetUp;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberSetUp memberSetUp;

    @Test
    public void saveMember() {
        //Given
        Member member = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(Member.class, "memberId");

        //When
        Member savedMember = memberRepository.save(member);

        assertThat(savedMember).isNotNull();
        assertThat(savedMember.getAccount()).isNotNull();
        assertThat(savedMember.getAddress()).isNotNull();
        assertThat(savedMember.getMemberEmail()).isEqualTo(member.getMemberEmail());
        assertThat(savedMember.getNickName()).isEqualTo(member.getNickName());

    }

    @Test
    public void findByEmailMember() {

        //Given
        Member memberSaved = memberSetUp.save();

        //When
        Optional<Member> optionalMember = memberRepository.findByMemberEmail(memberSaved.getMemberEmail());
        Member result = optionalMember.get();

        //Then
        assertThat(result.getNickName()).isEqualTo(memberSaved.getNickName());
        assertThat(result.getMemberEmail()).isEqualTo(memberSaved.getMemberEmail());
        assertThat(result.getMemberId()).isEqualTo(memberSaved.getMemberId());
        assertThat(result.getCreatedAt()).isNotNull();
        assertThat(result.getModifiedAt()).isNotNull();
    }

    @Test
    public void deleteMember() {
        //Given
        Member memberSaved = memberSetUp.save();

        //When
        memberRepository.deleteById(memberSaved.getMemberId());

        //Then
        assertThat(memberRepository.count()).isEqualTo(0);
    }

    @Test
    public void getMemberWithAddress() {
        //Given
        IntStream.range(0, 5).forEach((i) -> memberSetUp.saveCitySeoul(i));

        String city = "서울";

        //When
        List<Member> result = memberRepository.findByAddressCityEquals(city);


        //Then
        assertThat(result, hasSize(5));
    }

}

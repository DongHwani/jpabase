package com.dhk.jpabase.domain.member.repository;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void saveMember() {
        //Given
        EnhancedRandom builder = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .stringLengthRange(3, 5)
                .collectionSizeRange(1, 3)
                .build();

        Member member = builder.nextObject(Member.class, "memberId");

        //When
        Member savedMember = memberRepository.save(member);

        assertThat(savedMember).isNotNull();
        assertThat(savedMember.getAccount()).isNotNull();
        assertThat(savedMember.getAddress()).isNotNull();
        assertThat(savedMember.getMemberEmail()).isEqualTo(member.getMemberEmail());
        assertThat(savedMember.getNickName()).isEqualTo(member.getNickName());

    }

    @Test
    public void findByEmailMember(){

        //Given
        EnhancedRandom builder = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .stringLengthRange(3, 5)
                .collectionSizeRange(1, 3)
                .build();

        Member member = builder.nextObject(Member.class, "memberId");
        Member memberSaved = memberRepository.save(member);

        //When
        Optional<Member> optionalMember = memberRepository.findByMemberEmail(memberSaved.getMemberEmail());
        Member result = optionalMember.get();

        //Then
        assertThat(result.getNickName()).isEqualTo(member.getNickName());
        assertThat(result.getMemberEmail()).isEqualTo(member.getMemberEmail());
        assertThat(result.getMemberId()).isEqualTo(member.getMemberId());
        assertThat(result.getCreatedAt()).isNotNull();
        assertThat(result.getModifiedAt()).isNotNull();
    }

}

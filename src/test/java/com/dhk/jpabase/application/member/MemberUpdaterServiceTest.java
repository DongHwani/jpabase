package com.dhk.jpabase.application.member;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import com.dhk.jpabase.setup.domain.MemberSetUp;
import com.dhk.jpabase.setup.model.MemberBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberUpdaterServiceTest  {

    @Autowired
    private MemberUpdater memberUpdater;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberSetUp memberSetUp;

    @Test
    public void MemberInformationUpdate(){
        //Given
        Member member = memberSetUp.save();
        Member updateMember = MemberBuilder.build();

        //When
        Member result = memberUpdater.updateInformation(member.getMemberId(), updateMember);

        //Then
        assertThat(result.getNickName()).isEqualTo(updateMember.getNickName());
        assertThat(result.getMemberEmail()).isEqualTo(updateMember.getMemberEmail());
        assertThat(result.getPhoneNumber()).isEqualTo(updateMember.getPhoneNumber());

    }

    @Test
    public void changePassword(){
        //Given
        String changePassword = "newPassword";

        Member member = memberSetUp.save();

        //When
        memberUpdater.changePassword(member.getMemberId(), changePassword);
        Optional<Member> optional = memberRepository.findById(member.getMemberId());
        Member result = optional.get();

        //Then
        assertThat(result.getPassword()).isEqualTo(changePassword);

    }

}

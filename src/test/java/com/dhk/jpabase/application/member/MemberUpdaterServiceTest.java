package com.dhk.jpabase.application.member;

import com.dhk.jpabase.application.MockTest;
import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class MemberUpdaterServiceTest extends MockTest {

    @InjectMocks
    private MemberUpdater memberUpdater;

    @Mock
    private MemberRepository memberRepository;

    private Member member;

    @Before
    public void setUp(){
       this.member = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build().nextObject(Member.class);
    }

    @Test
    public void MemberInformationUpdate(){
        //Given
        Member updateMember = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build()
                              .nextObject(Member.class);
        given(memberRepository.findById(anyLong())).willReturn(Optional.ofNullable(updateMember));

        //When
        Member result = memberUpdater.updateInformation(member.getMemberId(), member);

        //Then
        verify(memberRepository, atLeastOnce()).findById(member.getMemberId());

        assertThat(result.getNickName()).isEqualTo(updateMember.getNickName());
        assertThat(result.getMemberEmail()).isEqualTo(updateMember.getMemberEmail());
        assertThat(result.getPhoneNumber()).isEqualTo(updateMember.getPhoneNumber());

    }

    @Test
    public void changePassword(){
        //Given
        String changePassword = "newPassword";
        given(memberRepository.findById(anyLong())).willReturn(Optional.ofNullable(member));

        //When
        memberUpdater.changePassword(member.getMemberId(), changePassword);
        Optional<Member> optional = memberRepository.findById(member.getMemberId());
        Member result = optional.get();

        //Then
        verify(memberRepository, atLeastOnce()).findById(member.getMemberId());
        assertThat(result.getPassword()).isEqualTo(changePassword);

    }

}

package com.dhk.jpabase.application.member;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberChangerInformation implements MemberChanger {

    private final MemberRepository memberRepository;

    @Override
    public void changePassword(Long memberId, String newPassword) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException());

        member.changePassword(newPassword);
    }

    @Override
    public void updateInformation(Long memberId, Member newMember) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException());

        member.updateInformation(newMember);
    }
}

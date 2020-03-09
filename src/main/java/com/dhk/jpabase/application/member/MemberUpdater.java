package com.dhk.jpabase.application.member;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberUpdater implements MemberProfile {

    private final MemberRepository memberRepository;

    @Override
    public Member updateInformation(final Long memberId, final Member updateMember) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException());

        member.updateInformation(updateMember);
        return member;
    }

    @Override
    public void changePassword(Long memberId, String newPassword) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException());

        member.changePassword(newPassword);
    }


}

package com.dhk.jpabase.application;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberFinder {

    @Autowired
    private MemberRepository memberRepository;

    public Member findByMemberEmail(final String memberEmail) {
        final Member member = memberRepository.findByMemberEmail(memberEmail)
                                    .orElseThrow(IllegalArgumentException::new);
        return member;
    }
}

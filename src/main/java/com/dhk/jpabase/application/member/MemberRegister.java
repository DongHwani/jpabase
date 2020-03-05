package com.dhk.jpabase.application.member;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberRegister {

    private final MemberRepository memberRepository;

    public Member singUp(Member member) {
         return memberRepository.save(member);
    }
}

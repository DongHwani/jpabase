package com.dhk.jpabase.setup.domain;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import com.dhk.jpabase.setup.model.MemberBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberSetUp {

    private final MemberRepository memberRepository;

    public Member save() {

        final Member member = MemberBuilder.build();

        return memberRepository.save(member);
    }
}

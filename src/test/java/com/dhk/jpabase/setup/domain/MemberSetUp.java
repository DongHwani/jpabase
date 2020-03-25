package com.dhk.jpabase.setup.domain;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import com.dhk.jpabase.setup.model.MemberBuilder;
import org.springframework.stereotype.Component;

@Component
public class MemberSetUp {

    private final MemberRepository memberRepository;

    public MemberSetUp(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Member save() {
        final Member member = MemberBuilder.build();
        return memberRepository.save(member);
    }

    public Member saveCitySeoul(int i){
        final Member member = MemberBuilder.buildCitySeoul(i);
        return memberRepository.save(member);
    }
}

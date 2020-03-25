package com.dhk.jpabase.application.member;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberFinder {

    private final MemberRepository memberRepository;

    public Member findByMemberEmail(final String memberEmail) {
        final Member member = memberRepository.findByMemberEmail(memberEmail)
                                    .orElseThrow(IllegalArgumentException::new);
        return member;
    }

    public List<Member> findByAddressCity(final String city) {
        return memberRepository.findByAddressCityEquals(city);
    }
}

package com.dhk.jpabase.infrastructure.member;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.member.repository.MemberRepositorySupport;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dhk.jpabase.domain.member.entity.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberFinderSupport implements MemberRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Member> findByAddressCity(final String city) {
        return jpaQueryFactory
                        .selectFrom(member)
                        .where(member.address.city.eq(city))
                        .fetch();

    }
}

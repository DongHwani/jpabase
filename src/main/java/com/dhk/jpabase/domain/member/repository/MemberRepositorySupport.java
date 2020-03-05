package com.dhk.jpabase.domain.member.repository;

import com.dhk.jpabase.domain.member.entity.Member;

import java.util.List;

public interface MemberRepositorySupport {

    List<Member> findByAddressCity(final String city);

}

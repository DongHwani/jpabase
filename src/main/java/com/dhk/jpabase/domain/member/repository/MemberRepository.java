package com.dhk.jpabase.domain.member.repository;

import com.dhk.jpabase.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositorySupport {

    Optional<Member> findByMemberEmail(final String memberEmail);



}

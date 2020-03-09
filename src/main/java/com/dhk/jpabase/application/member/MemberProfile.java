package com.dhk.jpabase.application.member;

import com.dhk.jpabase.domain.member.entity.Member;

public interface MemberProfile {

    void changePassword(Long memberId, String newPassword);

    Member updateInformation(Long memberId, Member updateMember);
}

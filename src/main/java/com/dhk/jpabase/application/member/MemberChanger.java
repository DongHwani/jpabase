package com.dhk.jpabase.application.member;

import com.dhk.jpabase.domain.member.entity.Member;

public interface MemberChanger {


    void changePassword(final Long memberId, final String newPassword);

    void updateInformation(final Long memberId, final Member newMember);
}

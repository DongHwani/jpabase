package com.dhk.jpabase.setup.model;

import com.dhk.jpabase.domain.member.entity.Member;
import io.github.benas.randombeans.EnhancedRandomBuilder;

public class MemberBuilder {

    public static Member build() {
        return EnhancedRandomBuilder
                    .aNewEnhancedRandom()
                    .nextObject(Member.class, "memberId");
    }
}

package com.dhk.jpabase.setup.model;

import com.dhk.jpabase.domain.member.entity.Account;
import com.dhk.jpabase.domain.member.entity.Address;
import com.dhk.jpabase.domain.member.entity.Member;
import io.github.benas.randombeans.EnhancedRandomBuilder;

public class MemberBuilder {

    public static Member build() {
        return EnhancedRandomBuilder
                    .aNewEnhancedRandom()
                    .nextObject(Member.class, "memberId");
    }

    public static Member buildCitySeoul(int i) {
        Account account = EnhancedRandomBuilder.aNewEnhancedRandom().nextObject(Account.class);
        Address address = Address.builder()
                .city("서울")
                .street("St")
                .zipCode("zip")
                .build();
        return Member.builder()
                .address(address)
                .password("pass")
                .phoneNumber("0102222")
                .nickName("nick")
                .memberEmail("email"+i)
                .account(account)
                .build();
    }
}

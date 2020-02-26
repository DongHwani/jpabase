package com.dhk.jpabase.domain.member.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Builder @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {

    private String street;
    private String city;
    private String zipCode;

}

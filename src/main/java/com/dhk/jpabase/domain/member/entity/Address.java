package com.dhk.jpabase.domain.member.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String street;
    private String city;
    private String zipCode;

}

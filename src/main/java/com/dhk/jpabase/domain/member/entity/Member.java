package com.dhk.jpabase.domain.member.entity;

import com.dhk.jpabase.domain.support.BaseTime;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(schema = "jpa", name = "members")
public class Member extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String memberEmail;

    private String password;

    @Embedded
    private Address address;

    private String phoneNumber;

    private String nickName;


    @Embedded
    private Account account;

    public void updateInformation(Member member){
        this.memberEmail = member.getMemberEmail();
        this.nickName = member.getNickName();
        this.address = member.getAddress();
        this.phoneNumber = member.getPhoneNumber();
    }

    public void changePassword(final String newPassword){
        this.password = newPassword;
    }

}

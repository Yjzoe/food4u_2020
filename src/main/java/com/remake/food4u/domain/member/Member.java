package com.remake.food4u.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    private String id;
    private String pwd;
    private String name;
    private String addr;
    private int gender;
    private String phone;
    private String birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Member(String id, String pwd, String name, String addr, int gender, String phone, String birthDate, Role role) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.addr = addr;
        this.gender = gender;
        this.phone = phone;
        this.birthDate = birthDate;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}

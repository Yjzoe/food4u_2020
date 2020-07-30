package com.remake.food4u.domain.orders;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Deliveries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String deli_no;
    private String o_no;
    private String name;
    private String phone;
    private String addr;
    private boolean status;

    @Builder
    public Deliveries(boolean status, String deli_no, String o_no, String name, String phone,String addr) {
        this.status = status;
        this.deli_no = deli_no;
        this.o_no = o_no;
        this.name = name;
        this.phone = phone;
        this.addr = addr;
    }

    public void update(boolean status, String name, String phone, String addr) {
        this.status = status;
        this.name = name;
        this.phone = phone;
        this.addr = addr;
    }
}

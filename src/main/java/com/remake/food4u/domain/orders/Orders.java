package com.remake.food4u.domain.orders;

import com.remake.food4u.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Orders extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private int g_no;
    private int qty;
    private String id;
    private String addr;
    private String deli_status;
    private int paid;
    private int price;

    @Builder
    public Orders(int g_no, int qty, String id, String addr, String deli_status, int paid, int price) {
        this.g_no = g_no;
        this.qty = qty;
        this.id = id;
        this.addr = addr;
        this.deli_status = deli_status;
        this.paid = paid;
        this.price = price;
    }
}

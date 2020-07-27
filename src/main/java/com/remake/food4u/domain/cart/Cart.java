package com.remake.food4u.domain.cart;

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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private int g_no;
    private String id;
    private int qty;

    @Builder
    public Cart(int g_no, String id, int qty) {
        this.g_no = g_no;
        this.id = id;
        this.qty = qty;
    }
}

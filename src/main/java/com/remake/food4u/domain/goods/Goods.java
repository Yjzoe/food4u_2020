package com.remake.food4u.domain.goods;

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
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String name;
    private int price;
    private String type;
    private String fname;
    private int stock;

    @Builder
    public Goods(String name, int price, String type, String fname, int stock) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.fname = fname;
        this.stock = stock;
    }
}

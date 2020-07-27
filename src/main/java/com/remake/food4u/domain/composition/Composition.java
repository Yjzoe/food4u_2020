package com.remake.food4u.domain.composition;

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
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private int g_no;
    private String foodName;

    @Builder
    public Composition(int g_no, String foodName) {
        this.g_no = g_no;
        this.foodName = foodName;
    }
}

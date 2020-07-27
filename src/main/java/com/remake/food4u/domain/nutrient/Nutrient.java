package com.remake.food4u.domain.nutrient;

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
public class Nutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int no;
    private int g_no;
    private String n_name;
    private Double qty;

    @Builder
    public Nutrient(int g_no, String n_name, Double qty) {
        this.g_no = g_no;
        this.n_name = n_name;
        this.qty = qty;
    }
}

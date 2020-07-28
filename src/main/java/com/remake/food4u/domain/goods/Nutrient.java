package com.remake.food4u.domain.goods;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Nutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long no;

    @ManyToOne(fetch = FetchType.EAGER)
    private Goods goods;

    private String n_name;
    private Double qty;

    @Builder
    public Nutrient(Long g_no, String n_name, Double qty) {
        this.n_name = n_name;
        this.qty = qty;
    }
}

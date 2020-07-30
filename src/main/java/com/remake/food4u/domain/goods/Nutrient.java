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
    @JoinColumn
    private Goods goods;
    private String n_name;
    private Double qty;

    @Builder
    public Nutrient(Goods goods, String n_name, Double qty) {
        this.goods = goods;
        this.n_name = n_name;
        this.qty = qty;
    }

    public void setGoods(Goods goods) {
        if (this.goods != null) {
            this.goods.removeNutrient(this);
        }
        this.goods = goods;
        goods.addNutrients(this);
    }
}

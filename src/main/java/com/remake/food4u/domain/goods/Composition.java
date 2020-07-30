package com.remake.food4u.domain.goods;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Goods goods;
    private String foodName;

    @Builder
    public Composition(int g_no, String foodName) {
        this.foodName = foodName;
    }

    public void update(String foodName) {
        this.foodName = foodName;
    }

    public void setGoods(Goods goods) {
        if (this.goods != null) {
            this.goods.removeComposition(this);
        }
        this.goods = goods;
        goods.addComposition(this);
    }
}

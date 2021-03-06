package com.remake.food4u.web.dto;

import com.remake.food4u.domain.goods.Goods;
import com.remake.food4u.domain.goods.Nutrient;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class NutrientResponseDto {
    private Long no;
    private Goods goods;
    private String n_name;
    private Double qty;

    public NutrientResponseDto(Nutrient entity) {
        this.no = entity.getNo();
        this.goods = entity.getGoods();
        this.n_name = entity.getN_name();
        this.qty = entity.getQty();
    }
}

package com.remake.food4u.web.dto;

import com.remake.food4u.domain.goods.Composition;
import com.remake.food4u.domain.goods.Goods;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CompositionResponseDto {
    private Long no;
    private Goods goods;
    private String foodName;

    public CompositionResponseDto(Composition entity) {
        this.no = entity.getNo();
        this.goods = entity.getGoods();
        this.foodName = entity.getFoodName();
    }
}

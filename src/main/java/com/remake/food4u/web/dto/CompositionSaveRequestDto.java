package com.remake.food4u.web.dto;

import com.remake.food4u.domain.goods.Composition;
import com.remake.food4u.domain.goods.Goods;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompositionSaveRequestDto {
    private Goods goods;
    private String foodName;

    @Builder
    public CompositionSaveRequestDto(Goods goods, String foodName) {
        this.goods = goods;
        this.foodName = foodName;
    }

    public Composition toEntity() {
        return Composition.builder()
                .goods(goods)
                .foodName(foodName)
                .build();
    }
}
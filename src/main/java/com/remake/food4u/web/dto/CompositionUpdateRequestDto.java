package com.remake.food4u.web.dto;

import com.remake.food4u.domain.goods.Composition;
import com.remake.food4u.domain.goods.Goods;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompositionUpdateRequestDto {
    private String foodName;

    @Builder
    public CompositionUpdateRequestDto(String foodName) {
        this.foodName = foodName;
    }

    public Composition toEntity() {
        return Composition.builder()
                .foodName(foodName)
                .build();
    }
}

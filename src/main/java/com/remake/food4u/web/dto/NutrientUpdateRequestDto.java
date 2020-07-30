package com.remake.food4u.web.dto;

import com.remake.food4u.domain.goods.Nutrient;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NutrientUpdateRequestDto {
    private String n_name;
    private Double qty;

    @Builder
    public NutrientUpdateRequestDto(String n_name, Double qty) {
        this.n_name = n_name;
        this.qty = qty;
    }

    public Nutrient toEntity() {
        return Nutrient.builder()
                .n_name(n_name)
                .qty(qty)
                .build();
    }
}

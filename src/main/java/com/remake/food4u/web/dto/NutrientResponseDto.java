package com.remake.food4u.web.dto;

import com.remake.food4u.domain.goods.Goods;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class NutrientResponseDto {
    private Long no;
    private Goods goods;
    private String n_name;
    private Double qty;
}

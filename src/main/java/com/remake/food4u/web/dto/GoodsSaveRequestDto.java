package com.remake.food4u.web.dto;

import com.remake.food4u.domain.goods.Composition;
import com.remake.food4u.domain.goods.Goods;
import com.remake.food4u.domain.goods.Nutrient;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class GoodsSaveRequestDto {
    private String name;
    private int price;
    private String type;
    private String fname;
    private int stock;
    private List<Nutrient> nutrients = new ArrayList<Nutrient>();
    private List<Composition> compositions = new ArrayList<Composition>();

    @Builder
    public GoodsSaveRequestDto(String name, int price, String type, String fname, int stock,
                                     List<Nutrient>nutrients, List<Composition>compositions) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.fname = fname;
        this.stock = stock;
        this.nutrients = nutrients;
        this.compositions = compositions;
    }

    public Goods toEntity() {
        return Goods.builder()
                .name(name)
                .price(price)
                .type(type)
                .fname(fname)
                .stock(stock)
                .nutrients(nutrients)
                .compositions(compositions)
                .build();
    }
}

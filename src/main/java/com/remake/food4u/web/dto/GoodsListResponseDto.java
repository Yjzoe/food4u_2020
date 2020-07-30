//package com.remake.food4u.web.dto;
//
//import com.remake.food4u.domain.goods.Composition;
//import com.remake.food4u.domain.goods.Goods;
//import com.remake.food4u.domain.goods.Nutrient;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GoodsListResponseDto {
//    private Long g_no;
//    private String name;
//    private int price;
//    private String type;
//    private String fname;
//    private int stock;
//    private List<Nutrient> nutrients = new ArrayList<Nutrient>();
//    private List<Composition> compositions = new ArrayList<Composition>();
//
//    public GoodsListResponseDto(Goods entity) {
//        this.g_no = entity.getG_no();
//        this.name = entity.getName();
//        this.price = entity.getPrice();
//        this.type = entity.getType();
//        this.fname = entity.getType();
//        this.stock = entity.getStock();
//        this.nutrients = entity.getNutrients();
//        this.compositions = entity.getCompositions();
//    }
//}

package com.remake.food4u.domain.searchfood;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class SearchFood {
    @Id
    private String foodname;
    private String serving;
    private String kcal;
    private String carbohydrate;
    private String protein;
    private String fat;
    private String sugar;
    private String natrium;
    private String cholesterol;
    private String fatty_acid;
    private String transfatty_acid;
    private String totalCount;

    @Builder
    public SearchFood(String foodName, String serving, String kcal, String carbohydrate, String protein, String fat,
                      String sugar, String natrium, String cholesterol, String fatty_acid, String transfatty_acid,String totalCount) {
        this.foodname = foodName;
        this.serving = serving;
        this.kcal = kcal;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.sugar = sugar;
        this.natrium = natrium;
        this.cholesterol = cholesterol;
        this.fatty_acid = fatty_acid;
        this.transfatty_acid = transfatty_acid;
        this.totalCount = totalCount;
    }
}

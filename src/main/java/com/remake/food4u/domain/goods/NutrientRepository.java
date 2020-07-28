package com.remake.food4u.domain.goods;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NutrientRepository extends JpaRepository<Nutrient, Long> {
    List<Nutrient> findByGoods(Goods goods);
}

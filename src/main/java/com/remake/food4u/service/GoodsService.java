package com.remake.food4u.service;

import com.remake.food4u.domain.goods.*;
import com.remake.food4u.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GoodsService {
    private final GoodsRepository goodsRepo;
    private final NutrientRepository nutrientRepo;
    private final CompositionRepository compositionRepo;

    @Transactional
    public Long save(GoodsSaveRequestDto requestDto) {
        Long g_no = goodsRepo.save(requestDto.toEntity()).getG_no();
        Goods goods = goodsRepo.findById(g_no).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        goods.addNutrients((Nutrient) requestDto.getNutrients());
        goods.addComposition((Composition) requestDto.getCompositions());
        return g_no;
    }

    @Transactional
    public Long update(Long g_no, GoodsUpdateRequestDto requestDto) {
        Goods goods = goodsRepo.findById(g_no).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        goods.update(requestDto.getName(), requestDto.getPrice(), requestDto.getType(), requestDto.getFname(), requestDto.getStock(), requestDto.getNutrients(), requestDto.getCompositions());
        return g_no;
    }

    public GoodsResponseDto findById(Long g_no) {
        Goods goods = goodsRepo.findById(g_no)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        return new GoodsResponseDto(goods);
    }

    public List<Goods> findAll() {
        List<Goods> goodsList = goodsRepo.findAll();
        return goodsList;
    }

    @Transactional
    public void delete(Long g_no) {
        Goods goods = goodsRepo.findById(g_no).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        goodsRepo.delete(goods);
    }
//
//    @Transactional
//    public Long addNutrient(NutrientSaveRequestDto requestDto) {
//        return nutrientRepo.save(requestDto.toEntity()).getNo();
//    }
//
//    @Transactional
//    public void deleteNutrient(Long no) {
//        Goods goods =
//        Nutrient nutrient = nutrientRepo.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 정보가 없습니다."));
//
//    }
}

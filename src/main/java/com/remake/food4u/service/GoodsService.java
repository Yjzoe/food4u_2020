//package com.remake.food4u.service;
//
//import com.remake.food4u.domain.goods.Goods;
//import com.remake.food4u.domain.goods.GoodsRepository;
//import com.remake.food4u.web.dto.GoodsResponseDto;
//import com.remake.food4u.web.dto.GoodsSaveRequestDto;
//import com.remake.food4u.web.dto.GoodsUpdateRequestDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@RequiredArgsConstructor
//@Service
//public class GoodsService {
//    private final GoodsRepository repo;
//
//    @Transactional
//    public Long save(GoodsSaveRequestDto requestDto) {
//        return repo.save(requestDto.toEntity()).getG_no();
//    }
//
//    @Transactional
//    public Long update(Long g_no, GoodsUpdateRequestDto requestDto) {
//        Goods goods = repo.findById(g_no).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
//        goods.update(requestDto.getName(), requestDto.getPrice(), requestDto.getType(), requestDto.getFname(), requestDto.getStock(), requestDto.getNutrients(), requestDto.getCompositions());
//        return g_no;
//    }
//
//    public GoodsResponseDto findById(Long g_no) {
//        Goods goods = repo.findById(g_no)
//                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
//        return new GoodsResponseDto(goods);
//    }
//
//    @Transactional
//    public void delete(Long g_no) {
//        Goods goods = repo.findById(g_no).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
//        repo.delete(goods);
//    }
//}

package com.remake.food4u.web;

import com.remake.food4u.config.auth.LoginUser;
import com.remake.food4u.config.auth.dto.SessionUser;
import com.remake.food4u.service.*;
import com.remake.food4u.web.dto.GoodsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GoodsApiController {

    private final BoardService boardService;
    private final CartService cartService;
    private final GoodsService goodsService;
    private final OrdersService ordersService;
    private final ReviewsService reviewsService;

    //manager
    @PostMapping("/manager/insertGoods")
    public Long insertGood(@RequestBody GoodsSaveRequestDto requestDto) {
        return goodsService.save(requestDto);
    }

    @PostMapping(value="/manager/insertNutrient")
    @ResponseBody
    public void insertNutrient(String g_no,String n_name,String qty)
    {
//        Long no = goodsService.
//        int re = dao.insertNutrient(g_no,n_name,qty);
    }
}

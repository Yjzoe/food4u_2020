package com.remake.food4u.web;

import com.remake.food4u.config.auth.LoginUser;
import com.remake.food4u.config.auth.dto.SessionUser;
import com.remake.food4u.service.*;
import com.remake.food4u.web.dto.GoodsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}

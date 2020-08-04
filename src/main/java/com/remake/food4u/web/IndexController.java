package com.remake.food4u.web;

import com.remake.food4u.config.auth.LoginUser;
import com.remake.food4u.config.auth.dto.SessionUser;
import com.remake.food4u.service.*;
import com.remake.food4u.web.dto.GoodsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;
    private final BoardService boardService;
    private final CartService cartService;
    private final GoodsService goodsService;
    private final OrdersService ordersService;
    private final ReviewsService reviewsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    //manager

    @GetMapping("/manager/list")
    public String adminList(Model model, @LoginUser SessionUser user) {
        model.addAttribute("Goods",goodsService.findAll());
        model.addAttribute("Orders",ordersService.findAll());
        return "/manager/list";
    }

    @GetMapping("/manager/GoodsList")
    public String goodsList(Model model, @LoginUser SessionUser user) {
        model.addAttribute("Goods",goodsService.findAll());
        return "/manager/GoodsList";
    }

    @GetMapping("/manager/insertGoods")
    public String insertGoods() {
        return "/manager/insertGoods";
    }

    @PostMapping("/manager/insertGoods")
    public Long insertGood(@RequestBody GoodsSaveRequestDto requestDto) {
        return goodsService.save(requestDto);
    }

    @GetMapping("/manager/OrdersList")
    public String orderList(Model model, @LoginUser SessionUser user) {
        model.addAttribute("Orders", ordersService.findAll());
        return "/manager/OrdersList";
    }

}

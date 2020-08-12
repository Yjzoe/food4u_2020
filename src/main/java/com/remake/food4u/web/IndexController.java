package com.remake.food4u.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.remake.food4u.config.auth.LoginUser;
import com.remake.food4u.config.auth.dto.SessionUser;
import com.remake.food4u.domain.searchfood.Search;
import com.remake.food4u.domain.searchfood.SearchFood;
import com.remake.food4u.service.*;
import com.remake.food4u.web.dto.GoodsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

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

    @GetMapping("/manager/OrdersList")
    public String orderList(Model model, @LoginUser SessionUser user) {
        model.addAttribute("Orders", ordersService.findAll());
        return "/manager/OrdersList";
    }

    @GetMapping(value = "/manager/SearchFood",produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String searchFood(@RequestParam(value="foodname", defaultValue="계란")String foodname, @RequestParam(value="pageNum", defaultValue="1") String pageNum) throws IOException
    {
        String re = "";
        ArrayList<SearchFood> list = null;
        try {
            list = Search.addList(foodname, pageNum);
            ObjectMapper om = new ObjectMapper();
            re = om.writeValueAsString(list);
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return re;
    }
    @GetMapping(value="/manager/insertNutrient")
    public void insertNutrient1(String n_name,String qty){}
}

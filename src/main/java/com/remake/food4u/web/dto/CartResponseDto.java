package com.remake.food4u.web.dto;

import com.remake.food4u.domain.cart.Cart;

public class CartResponseDto {
    private Long no;
    private int g_no;
    private String id;
    private int qty;

    public CartResponseDto(Cart entity) {
        this.no = entity.getNo();
        this.g_no = entity.getG_no();
        this.id = entity.getId();
        this.qty = entity.getQty();
    }
}

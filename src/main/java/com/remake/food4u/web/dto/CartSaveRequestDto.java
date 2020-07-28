package com.remake.food4u.web.dto;

import com.remake.food4u.domain.cart.Cart;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartSaveRequestDto {
    private Long no;
    private int g_no;
    private String id;
    private int qty;

    @Builder
    public CartSaveRequestDto(int g_no, String id, int qty) {
        this.g_no = g_no;
        this.id = id;
        this.qty = qty;
    }

    public Cart toEntity() {
        return Cart.builder()
                .g_no(g_no)
                .id(id)
                .qty(qty)
                .build();
    }
}

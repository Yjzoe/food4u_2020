package com.remake.food4u.web.dto;

import com.remake.food4u.domain.cart.Cart;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartUpdateRequestDto {
    private int g_no;
    private int qty;

    @Builder
    public CartUpdateRequestDto(int g_no, int qty) {
        this.g_no = g_no;
        this.qty = qty;
    }

    public Cart toEntity() {
        return Cart.builder()
                .g_no(g_no)
                .qty(qty)
                .build();
    }
}

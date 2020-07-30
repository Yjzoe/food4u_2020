package com.remake.food4u.web.dto;

import com.remake.food4u.domain.orders.Deliveries;
import com.remake.food4u.domain.orders.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrdersSaveRequestDto {
    private Long g_no;
    private int qty;
    private String id;
    private Deliveries delivery;
    private int paid;
    private int price;

    @Builder
    public OrdersSaveRequestDto(Long g_no, int qty, String id, Deliveries delivery, int paid, int price) {
        this.g_no = g_no;
        this.qty = qty;
        this.id = id;
        this.delivery = delivery;
        this.paid = paid;
        this.price = price;
    }

    public Orders toEntity() {
        return Orders.builder()
                .g_no(g_no)
                .qty(qty)
                .id(id)
                .delivery(delivery)
                .paid(paid)
                .price(price)
                .build();
    }
}

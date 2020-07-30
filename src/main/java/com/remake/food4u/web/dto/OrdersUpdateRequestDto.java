package com.remake.food4u.web.dto;

import com.remake.food4u.domain.orders.Deliveries;
import com.remake.food4u.domain.orders.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrdersUpdateRequestDto {
    private int qty;
    private Deliveries delivery;
    private int paid;

    @Builder
    public OrdersUpdateRequestDto(int qty, String addr, Deliveries delivery, int paid) {
        this.qty = qty;
        this.delivery = delivery;
        this.paid = paid;
    }

    public Orders toEntity() {
        return Orders.builder()
                .qty(qty)
                .delivery(delivery)
                .paid(paid)
                .build();
    }
}

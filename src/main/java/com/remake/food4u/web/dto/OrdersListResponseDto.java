package com.remake.food4u.web.dto;

import com.remake.food4u.domain.orders.Deliveries;
import com.remake.food4u.domain.orders.Orders;

public class OrdersListResponseDto {
    private String no;
    private Long g_no;
    private int qty;
    private Deliveries delivery;
    private int paid;
    private int price;

    public OrdersListResponseDto(Orders entity) {
        this.no = entity.getNo();
        this.g_no = entity.getG_no();
        this.qty = entity.getQty();
        this.delivery = entity.getDelivery();
        this.paid = entity.getPaid();
        this.price = entity.getPrice();
    }
}

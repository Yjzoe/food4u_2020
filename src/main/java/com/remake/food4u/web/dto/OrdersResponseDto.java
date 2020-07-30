package com.remake.food4u.web.dto;

import com.remake.food4u.domain.orders.Deliveries;
import com.remake.food4u.domain.orders.Orders;

public class OrdersResponseDto {
    private String no;
    private Long g_no;
    private int qty;
    private String id;
    private Deliveries delivery;
    private int paid;
    private int price;

    public OrdersResponseDto(Orders entity) {
        this.no = entity.getNo();
        this.g_no = entity.getG_no();
        this.qty = entity.getQty();
        this.id = entity.getId();
        this.delivery = entity.getDelivery();
        this.paid = entity.getPaid();
        this.price = entity.getPrice();
    }
}

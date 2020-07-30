package com.remake.food4u.domain.orders;

import com.remake.food4u.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Orders extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String no;
    private Long g_no;
    private int qty;
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="delivery")
    private Deliveries delivery;
    private int paid;
    private int price;


    @Builder
    public Orders(Long g_no, int qty, String id, Deliveries delivery, int paid, int price) {
        this.g_no = g_no;
        this.qty = qty;
        this.id = id;
        this.delivery = delivery;
        this.paid = paid;
        this.price = price;
    }

    public void update(int qty, Deliveries delivery, int paid) {
        this.qty = qty;
        this.delivery = delivery;
        this.paid = paid;
    }
}

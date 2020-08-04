package com.remake.food4u.service;

import com.remake.food4u.domain.orders.Orders;
import com.remake.food4u.domain.orders.OrdersRepository;
import com.remake.food4u.web.dto.OrdersResponseDto;
import com.remake.food4u.web.dto.OrdersSaveRequestDto;
import com.remake.food4u.web.dto.OrdersUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrdersService {
    private final OrdersRepository repo;

    @Transactional
    public String save(OrdersSaveRequestDto requestDto) {
        return repo.save(requestDto.toEntity()).getNo();
    }

    @Transactional
    public Long update(Long no, OrdersUpdateRequestDto requestDto) {
        Orders order = repo.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다."));
        order.update(requestDto.getQty(), requestDto.getDelivery(), requestDto.getPaid());
        return no;
    }

    public OrdersResponseDto findByNo(Long no) {
        Orders order = repo.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다."));
        return new OrdersResponseDto(order);
    }

    public List<Orders> findAll() {
        List<Orders> ordersList = repo.findAll();
        return ordersList;
    }

    @Transactional
    public void delete(Long no) {
        Orders order = repo.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다."));
        repo.delete(order);
    }
}

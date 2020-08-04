package com.remake.food4u.service;

import com.remake.food4u.domain.cart.Cart;
import com.remake.food4u.domain.cart.CartRepository;
import com.remake.food4u.domain.goods.Goods;
import com.remake.food4u.web.dto.CartResponseDto;
import com.remake.food4u.web.dto.CartSaveRequestDto;
import com.remake.food4u.web.dto.CartUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {
    private final CartRepository repo;

    @Transactional
    public Long save(CartSaveRequestDto requestDto) {
        return repo.save(requestDto.toEntity()).getNo();
    }

    @Transactional
    public Long update(Long no, CartUpdateRequestDto requestDto) {
        Cart cart = repo.findById(no).orElseThrow(() -> new IllegalArgumentException("장바구니에 상품이 존재하지 않습니다."));
        cart.update(requestDto.getG_no(), requestDto.getQty());
        return no;
    }

    public CartResponseDto findByNo(Long no) {
        Cart cart = repo.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("장바구니에 상품이 존재하지 않습니다."));
        return new CartResponseDto(cart);
    }

    public List<Cart> findById(String id,Pageable pageable) {
        List<Cart> cartList = repo.findById(id);
        return cartList;
    }

    @Transactional
    public void delete(Long no) {
        Cart cart = repo.findById(no).orElseThrow(() -> new IllegalArgumentException("장바구니에 상품이 존재하지 않습니다."));
        repo.delete(cart);
    }
}

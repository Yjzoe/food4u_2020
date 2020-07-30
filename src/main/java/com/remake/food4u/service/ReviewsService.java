package com.remake.food4u.service;

import com.remake.food4u.domain.cart.Cart;
import com.remake.food4u.domain.cart.CartRepository;
import com.remake.food4u.domain.reviews.Reviews;
import com.remake.food4u.domain.reviews.ReviewsRepository;
import com.remake.food4u.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewsService {
    private final ReviewsRepository repo;

    @Transactional
    public Long save(ReviewsSaveRequestDto requestDto) {
        return repo.save(requestDto.toEntity()).getNo();
    }

    @Transactional
    public Long update(Long no, ReviewsUpdateRequestDto requestDto) {
        Reviews review = repo.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 존재하지 않습니다."));
        review.update(requestDto.getTitle(),requestDto.getContent(),requestDto.getPhoto());
        return no;
    }

    public ReviewsResponseDto findByNo(Long no) {
        Reviews review = repo.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 존재하지 않습니다."));
        return new ReviewsResponseDto(review);
    }

    @Transactional
    public void delete(Long no) {
        Reviews review = repo.findById(no).orElseThrow(() -> new IllegalArgumentException("해당 리뷰가 존재하지 않습니다."));
        repo.delete(review);
    }
}

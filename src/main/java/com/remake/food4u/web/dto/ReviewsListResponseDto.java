package com.remake.food4u.web.dto;

import com.remake.food4u.domain.reviews.Reviews;

public class ReviewsListResponseDto {
    private String title;
    private String content;
    private String photo;

    public ReviewsListResponseDto(Reviews entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.photo = entity.getPhoto();
    }
}

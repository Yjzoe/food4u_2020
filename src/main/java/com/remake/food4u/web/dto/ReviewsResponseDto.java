package com.remake.food4u.web.dto;

import com.remake.food4u.domain.reviews.Reviews;

public class ReviewsResponseDto {
    private Long no;
    private Long g_no;
    private String o_no;
    private String title;
    private String content;
    private String photo;

    public ReviewsResponseDto(Reviews entity) {
        this.no = entity.getNo();
        this.g_no = entity.getG_no();
        this.o_no = entity.getO_no();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.photo = entity.getPhoto();
    }
}

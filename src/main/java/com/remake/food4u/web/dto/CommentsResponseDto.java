package com.remake.food4u.web.dto;

import com.remake.food4u.domain.comments.Comments;

public class CommentsResponseDto {
    private Long no;
    private Long r_no;
    private String id;
    private String comment;

    public CommentsResponseDto(Comments entity) {
        this.no = entity.getNo();
        this.r_no = entity.getR_no();
        this.id = entity.getId();
        this.comment = entity.getComment();
    }
}

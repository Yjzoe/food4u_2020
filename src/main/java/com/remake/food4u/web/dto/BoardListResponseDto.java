package com.remake.food4u.web.dto;

import com.remake.food4u.domain.board.Board;

import java.time.LocalDateTime;

public class BoardListResponseDto {

    private Long no;
    private String title;
    private LocalDateTime createDate;
    private String writer;
    private int b_ref;
    private int b_level;
    private int b_step;
    private int hit;
    private int type;

    public BoardListResponseDto(Board entity) {
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.b_ref = entity.getB_ref();
        this.b_level = entity.getB_level();
        this.b_step = entity.getB_step();
        this.hit = entity.getHit();
        this.type = entity.getType();
    }
}

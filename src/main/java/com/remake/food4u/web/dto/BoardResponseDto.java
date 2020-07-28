package com.remake.food4u.web.dto;

import com.remake.food4u.domain.board.Board;

public class BoardResponseDto {

    private Long no;
    private String title;
    private String writer;
    private String content;
    private String fname;
    private int b_ref;
    private int b_level;
    private int b_step;
    private int hit;
    private int type;

    public BoardResponseDto(Board entity) {
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.content = entity.getContent();
        this.fname = entity.getFname();
        this.b_ref = entity.getB_ref();
        this.b_level = entity.getB_level();
        this.b_step = entity.getB_step();
        this.hit = entity.getHit();
        this.type = entity.getType();
    }
}

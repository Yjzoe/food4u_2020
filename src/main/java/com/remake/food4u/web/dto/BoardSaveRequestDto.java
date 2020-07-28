package com.remake.food4u.web.dto;

import com.remake.food4u.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String title;
    private String writer;
    private String content;
    private String fname;
    private int b_ref;
    private int b_level;
    private int b_step;
    private int hit;
    private int type;

    @Builder
    public BoardSaveRequestDto(int type, String title, String writer, String content, String fname, int b_ref, int b_level, int b_step, int hit) {
        this.type = type;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.fname = fname;
        this.b_ref = b_ref;
        this.b_level = b_level;
        this.b_step = b_step;
        this.hit = hit;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .writer(writer)
                .type(type)
                .fname(fname)
                .content(content)
                .b_ref(b_ref)
                .b_level(b_level)
                .b_step(b_step)
                .hit(hit)
                .build();
    }
}

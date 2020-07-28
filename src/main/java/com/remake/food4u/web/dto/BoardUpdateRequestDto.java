package com.remake.food4u.web.dto;

import com.remake.food4u.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String title;
    private String content;
    private String fname;

    @Builder
    public BoardUpdateRequestDto(String title, String content, String fname) {
        this.title = title;
        this.content = content;
        this.fname = fname;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .fname(fname)
                .content(content)
                .build();
    }
}

package com.remake.food4u.domain.board;

import com.remake.food4u.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String title;
    private String writer;
    private String content;
    private String fname;
    private int b_ref;
    private int b_level;
    private int b_step;
    private int hit;

    @Builder
    public Board(String title, String writer, String content, String fname, int b_ref, int b_level, int b_step, int hit) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.fname = fname;
        this.b_ref = b_ref;
        this.b_level = b_level;
        this.b_step = b_step;
        this.hit = hit;
    }

    //faq + QnA
    public void faq(String title, String writer, String content, String fname) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.fname = fname;
    }
}

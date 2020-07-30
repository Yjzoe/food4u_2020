package com.remake.food4u.domain.reviews;

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
public class Reviews extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private Long g_no;
    private String o_no;
    private String title;
    private String content;
    private String photo;

    @Builder
    public Reviews(Long g_no, String o_no, String title, String content, String photo) {
        this.g_no = g_no;
        this.o_no = o_no;
        this.title = title;
        this.content = content;
        this.photo = photo;
    }

    public void update(String title, String content, String photo) {
        this.title = title;
        this.content = content;
        this.photo = photo;
    }
}

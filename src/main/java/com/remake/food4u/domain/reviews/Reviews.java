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
    private int g_no;
    private String id;
    private int o_no;
    private int point;
    private String title;
    private String content;
    private String photo;

    @Builder
    public Reviews(int g_no, String id, int o_no, int point, String title, String content, String photo) {
        this.g_no = g_no;
        this.id = id;
        this.o_no = o_no;
        this.point = point;
        this.title = title;
        this.content = content;
        this.photo = photo;
    }
}

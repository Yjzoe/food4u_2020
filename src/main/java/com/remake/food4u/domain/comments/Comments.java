package com.remake.food4u.domain.comments;

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
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private Long r_no;
    private String id;
    private String comment;

    @Builder
    public Comments(Long r_no, String id, String comment) {
        this.r_no = r_no;
        this.id = id;
        this.comment = comment;
    }

    public void update(String comment) {
        this.comment = comment;
    }
}

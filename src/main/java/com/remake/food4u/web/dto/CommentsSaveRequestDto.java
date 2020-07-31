package com.remake.food4u.web.dto;

import com.remake.food4u.domain.comments.Comments;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {
    private Long r_no;
    private String id;
    private String comment;

    @Builder
    public CommentsSaveRequestDto(Long r_no, String id, String comment) {
        this.r_no = r_no;
        this.id = id;
        this.comment = comment;
    }

    public Comments toEntity() {
        return Comments.builder()
                .r_no(r_no)
                .id(id)
                .comment(comment)
                .build();
    }
}
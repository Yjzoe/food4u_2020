package com.remake.food4u.web.dto;

import com.remake.food4u.domain.comments.Comments;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsUpdateRequestDto {
    private String comment;

    @Builder
    public CommentsUpdateRequestDto(String comment) {
        this.comment = comment;
    }

    public Comments toEntity() {
        return Comments.builder()
                .comment(comment)
                .build();
    }
}

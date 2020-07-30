package com.remake.food4u.web.dto;

import com.remake.food4u.domain.reviews.Reviews;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewsUpdateRequestDto {
    private String title;
    private String content;
    private String photo;

    @Builder
    public ReviewsUpdateRequestDto(String title, String content, String photo) {
        this.title = title;
        this.content = content;
        this.photo = photo;
    }

    public Reviews toEntity() {
        return Reviews.builder()
                .title(title)
                .content(content)
                .photo(photo)
                .build();
    }
}

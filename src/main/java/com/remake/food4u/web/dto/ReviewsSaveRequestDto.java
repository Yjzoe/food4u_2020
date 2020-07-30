package com.remake.food4u.web.dto;

import com.remake.food4u.domain.reviews.Reviews;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewsSaveRequestDto {
    private Long g_no;
    private String o_no;
    private String title;
    private String content;
    private String photo;

    @Builder
    public ReviewsSaveRequestDto(Long g_no, String o_no, String title, String content, String photo) {
        this.g_no = g_no;
        this.o_no = o_no;
        this.title = title;
        this.content = content;
        this.photo = photo;
    }

    public Reviews toEntity() {
        return Reviews.builder()
                .g_no(g_no)
                .o_no(o_no)
                .title(title)
                .content(content)
                .photo(photo)
                .build();
    }
}

package org.prgrms.myboard.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.prgrms.myboard.domain.Post;

public record PostCreateRequestDto(
    @NotBlank(message = "제목이 비어있으면 안됩니다.")
    String title,
    @NotBlank(message = "내용이 비어있으면 안됩니다.")
    String content,
    @NotNull(message = "유저Id가 null이면 안됩니다.")
    @Min(value = 1, message = "Id는 음수일 수 없습니다.")
    Long userId
) {
    public Post toPost() {
        return new Post(title, content);
    }
}
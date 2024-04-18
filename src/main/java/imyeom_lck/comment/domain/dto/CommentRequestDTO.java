package imyeom_lck.comment.domain.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommentRequestDTO {
    private Long memberId;
    private Long parentId;
    private String content;
    private LocalDateTime commentCreateTime;
}

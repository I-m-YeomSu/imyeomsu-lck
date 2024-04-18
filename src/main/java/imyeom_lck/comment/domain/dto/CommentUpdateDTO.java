package imyeom_lck.comment.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentUpdateDTO {
    private Long memberId;
    private Long commentId;
    private String content;
}
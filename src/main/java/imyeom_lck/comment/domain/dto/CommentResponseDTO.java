package imyeom_lck.comment.domain.dto;

import imyeom_lck.comment.domain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDTO {

    private Long commentId;
    private String memberName;
    private LocalDateTime commentCreateTime;
    private String content;
    @Builder.Default
    private List<CommentResponseDTO> childrenComment = new ArrayList<>();


    //Entity -> DTO 변환
    public static CommentResponseDTO fromEntity(Comment comment){

        return CommentResponseDTO.builder()
                .commentId(comment.getCommentId())
                .memberName(comment.getMember().getName())
                .commentCreateTime(comment.getCommentCreateTime())
                .content(comment.getContent())
                .build();


    }


    //대댓글 Entity -> dto 변환
    public static CommentResponseDTO childFromEntity(Comment comment){
        CommentResponseDTO dto = CommentResponseDTO.builder()
                .memberName(comment.getMember().getName())
                .commentCreateTime(comment.getCommentCreateTime())
                .content(comment.getContent())
                .build();

        for(Comment child : comment.getChildrenComment()){
            dto.addChildComment(childFromEntity(child));
        }

        return dto;
    }

    // Entity -> DTO 변환 - 대댓글
    private void addChildComment(CommentResponseDTO childCommentDto) {
        this.childrenComment.add(childCommentDto);
    }

}

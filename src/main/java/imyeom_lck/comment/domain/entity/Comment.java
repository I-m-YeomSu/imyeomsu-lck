package imyeom_lck.comment.domain.entity;

import imyeom_lck.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


    @Column(nullable = false)
    @CreationTimestamp
    @Builder.Default
    private LocalDate commentDate = LocalDate.now();


    @Column(nullable = false)
    @CreationTimestamp
    @Builder.Default
    private LocalDateTime commentCreateTime = LocalDateTime.now();

    @Column(nullable = false, length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    //부모 댓글 삭제 되면, 자식 댓글도 삭제
    @Builder.Default
    @OneToMany(mappedBy = "parentComment",orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<Comment> childrenComment = new ArrayList<>();


//    @PrePersist
//    public void setCommentDateFromCreateTime() {
//        this.commentDate = this.commentCreateTime.toLocalDate();
//    }

}

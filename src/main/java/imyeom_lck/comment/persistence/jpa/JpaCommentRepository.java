package imyeom_lck.comment.persistence.jpa;

;
import imyeom_lck.comment.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JpaCommentRepository extends JpaRepository<Comment, Long> {
    //날짜에 따른 댓글 조회
    @Query("SELECT c FROM Comment c WHERE c.commentDate = :date")
    List<Comment> findByCommentDate(@Param("date") LocalDate date);

    //대댓글 조회
    @Query("SELECT c FROM Comment c WHERE c.parentComment.commentId = :parentId")
    List<Comment> findByParentId(@Param("parentId") Long parentId);

    Comment findByCommentId(Long commentId);



    //Optional<Comment> findCommentByIdWithParent(Long id);

    //댓글 수정 시, 멤버 id 확인 후, 댓글 id 확인 후에 수정해야 하는데,,,,,,,,,,,,,





}

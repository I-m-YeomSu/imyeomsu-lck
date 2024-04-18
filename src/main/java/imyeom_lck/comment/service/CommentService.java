package imyeom_lck.comment.service;

import imyeom_lck.comment.domain.dto.CommentRequestDTO;
import imyeom_lck.comment.domain.dto.CommentResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface CommentService {

    //날짜 별 댓글 조회하기
    List<CommentResponseDTO> findByCommentDate(LocalDate commentDate);
    //대댓글 조회하기
    List<CommentResponseDTO> findByParentId(Long parentId);
    //댓글 작성하기
    CommentResponseDTO createComment(CommentRequestDTO commentRequestDTO);
    //대댓글 작성하기
    CommentResponseDTO createChildComment(CommentRequestDTO commentRequestDTO);
    //댓글 수정하기
    CommentResponseDTO updateComment(CommentRequestDTO commentRequestDTO);
}

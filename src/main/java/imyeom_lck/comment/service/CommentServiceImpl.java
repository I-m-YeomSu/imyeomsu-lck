package imyeom_lck.comment.service;

import imyeom_lck.comment.domain.dto.CommentRequestDTO;
import imyeom_lck.comment.domain.dto.CommentResponseDTO;
import imyeom_lck.comment.domain.entity.Comment;
import imyeom_lck.comment.persistence.jpa.JpaCommentRepository;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import imyeomsu.lck.common_utils.code.ErrorCode;
import imyeomsu.lck.common_utils.exception.ClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final JpaCommentRepository jpacommentRepository;
    private final JpaMemberRepository jpaMemberRepository;


    @Override
    public List<CommentResponseDTO> findByCommentDate(LocalDate commentDate) {
        List<Comment> comments = jpacommentRepository.findByCommentDate(commentDate);
        if (comments.isEmpty()) {
            throw new ClientException(ErrorCode.NOT_FOUND,"해당 날짜에 댓글이 없습니다.");
        }

        List<CommentResponseDTO> commentResponseDTOs = new ArrayList<>();

        for (Comment comment : comments) {
            commentResponseDTOs.add(CommentResponseDTO.fromEntity(comment));
        }

        return commentResponseDTOs;
    }

    @Override
    public List<CommentResponseDTO> findByParentId(Long parentId) {
        List<Comment> comments = jpacommentRepository.findByParentId(parentId);
        if(comments.isEmpty()){
            throw new ClientException(ErrorCode.NOT_FOUND, "부모 댓글이 없습니다.");
        }

        List<CommentResponseDTO> commentResponseDTOs = new ArrayList<>();

        for(Comment comment : comments){
            commentResponseDTOs.add(CommentResponseDTO.childFromEntity(comment));
        }

        return commentResponseDTOs;
    }


    @Override
    public CommentResponseDTO createComment(CommentRequestDTO commentRequestDTO) {
        Member member = jpaMemberRepository.findByMemberId(commentRequestDTO.getMemberId());
        if (member == null){
            throw new ClientException(ErrorCode.NOT_FOUND,"해당 ID의 회원을 찾을 수 없습니다.");
        }

        Comment comment = Comment.builder()
                .member(member)
                .content(commentRequestDTO.getContent())
                .build();

        jpacommentRepository.save(comment);

        // entity -> request Dto로 변환해서  메서드 반환 시 반환해주기
        return CommentResponseDTO.fromEntity(comment);

    }

    //답글 달기 버튼 누르면 그 댓글의 id를 부모 id로 보내준다고 가정
    @Override
    public CommentResponseDTO createChildComment(CommentRequestDTO commentRequestDTO) {
        Member member = jpaMemberRepository.findByMemberId(commentRequestDTO.getMemberId());
        Comment parentComment = jpacommentRepository.findByCommentId(commentRequestDTO.getParentId());
        if (member == null) {
            throw new ClientException(ErrorCode.NOT_FOUND,"해당 ID의 회원을 찾을 수 없습니다.");
        }
        if (parentComment == null){
            throw new ClientException(ErrorCode.NOT_FOUND,"답글을 달 댓글이 없습니다.");
        }

        Comment childComment = Comment.builder()
                .member(member)
                .parentComment(parentComment)
                .content(commentRequestDTO.getContent())
                .build();

        parentComment.getChildrenComment().add(childComment);

        jpacommentRepository.save(childComment);

        return CommentResponseDTO.fromEntity(childComment);
    }

    @Override
    public CommentResponseDTO updateComment(CommentRequestDTO commentRequestDTO) {

        return null;
    }
}

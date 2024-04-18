package imyeom_lck.comment.controller;

import imyeom_lck.comment.domain.dto.CommentRequestDTO;
import imyeom_lck.comment.domain.dto.CommentResponseDTO;
import imyeom_lck.comment.service.CommentService;
import imyeomsu.lck.common_utils.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestCommentController {
    private final CommentService commentService;

    //날짜 별 댓글 조회
//    @GetMapping(value = "/comment/{date}")
//    public ResponseEntity<ResponseDto<List<CommentResponseDTO>>> findByCommentDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate commentDate){
//        List<CommentResponseDTO> commentResponseDTOs = commentService.findByCommentDate(commentDate);
//
//        return ResponseEntity.ok(ResponseDto.<List<CommentResponseDTO>>builder()
//                .data(commentResponseDTOs)
//                .status(HttpStatus.OK)
//                .success(true)
//                .build());
//    }

    //대댓글 조회
//    @GetMapping(value = "/comment/child/{parentId}")
//    public ResponseEntity<ResponseDto<List<CommentResponseDTO>>> findByParentId(@PathVariable("parentId") Long parentId){
//        List<CommentResponseDTO> commentResponseDTOS = commentService.findByParentId(parentId);
//
//        return ResponseEntity.ok(ResponseDto.<List<CommentResponseDTO>>builder()
//                .data(commentResponseDTOS)
//                .status(HttpStatus.OK)
//                .success(true)
//                .build());
//    }

    //댓글 작성
//    @PostMapping(value="/comment")
//    public ResponseEntity<ResponseDto<CommentResponseDTO>> createComment(@RequestBody CommentRequestDTO commentRequestDTO){
//        CommentResponseDTO commentResponseDTO = commentService.createComment(commentRequestDTO);
//        return ResponseEntity.ok(ResponseDto.<CommentResponseDTO>builder()
//                .data(commentResponseDTO)
//                .status(HttpStatus.OK)
//                .success(true)
//                .build());
//    }
//
//    //대댓글 작성
//    @PostMapping(value = "/comment/child")
//    public ResponseEntity<ResponseDto<CommentResponseDTO>> createChildComment(@RequestBody CommentRequestDTO commentRequestDTO){
//        CommentResponseDTO commentResponseDTO = commentService.createChildComment(commentRequestDTO);
//        return ResponseEntity.ok(ResponseDto.<CommentResponseDTO>builder()
//                .data(commentResponseDTO)
//                .status(HttpStatus.OK)
//                .success(true)
//                .build());
//    }


}

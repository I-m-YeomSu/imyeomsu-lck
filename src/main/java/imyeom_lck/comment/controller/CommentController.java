package imyeom_lck.comment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import imyeom_lck.comment.domain.dto.CommentRequestDTO;
import imyeom_lck.comment.domain.dto.CommentResponseDTO;
import imyeom_lck.comment.service.CommentService;
import imyeomsu.lck.common_utils.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 별 답글 조회
//    @GetMapping(value = "/child/{parentId}")
//    public String findByParentId(@PathVariable("parentId") Long parentId, Model model) throws JsonProcessingException{
//        List<CommentResponseDTO> commentResponseDTOS = commentService.findByParentId(parentId);
//        model.addAttribute("childComments", commentResponseDTOS);
//        return "comment";
//
//    }

    // 대댓글 조회
    @GetMapping(value = "/child/{parentId}")
    public ResponseEntity<List<CommentResponseDTO>> findByParentId(@PathVariable("parentId") Long parentId) {
        List<CommentResponseDTO> childComments = commentService.findByParentId(parentId);
        return ResponseEntity.ok(childComments);
    }


    //날짜 별 댓글 조회
    @GetMapping(value = "/{date}")
    public String findByCommentDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        LocalDate commentDate, Model model) throws JsonProcessingException {

        List<CommentResponseDTO> commentResponseDTOS = commentService.findByCommentDate(commentDate);
        model.addAttribute("comments", commentResponseDTOS);
        return "comment";
    }

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
    @PostMapping
    public ResponseEntity<ResponseDto<CommentResponseDTO>> createComment(CommentRequestDTO commentRequestDTO) {
        CommentResponseDTO commentResponseDTO = commentService.createComment(commentRequestDTO);
        return ResponseEntity.ok(ResponseDto.<CommentResponseDTO>builder()
                .data(commentResponseDTO)
                .status(HttpStatus.OK)
                .success(true)
                .build());
    }





}

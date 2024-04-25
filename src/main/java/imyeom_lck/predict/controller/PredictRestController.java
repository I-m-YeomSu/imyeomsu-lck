package imyeom_lck.predict.controller;


import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.predict.domain.dto.PredictDTO;
import imyeom_lck.predict.domain.dto.PredictRequestDTO;
import imyeom_lck.predict.service.inter.PredictService;
import imyeomsu.lck.common_utils.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value="/api/predict")
public class PredictRestController {

    private final PredictService predictService;

    @PostMapping(value="/vote")
    public ResponseDto<PredictDTO> vote(@RequestBody PredictRequestDTO predictRequestDTO) throws InterruptedException {

        PredictDTO predictDTO = predictService.vote(predictRequestDTO);
        // flag true 면 홈, flase 면 어웨이
        log.info("test:{} {} {}", predictRequestDTO.getPredictId(), predictRequestDTO.getMemberId(),predictRequestDTO.isFlag());

        return ResponseDto.<PredictDTO>builder()
                .data(predictDTO)
                .status(HttpStatus.OK)
                .success(true)

                .build();
    }




}

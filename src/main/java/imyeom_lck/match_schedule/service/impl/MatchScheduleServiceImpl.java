// package imyeom_lck.match_schedule.service.impl;
//
//
// import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
// import imyeom_lck.match_schedule.domain.dto.NextMatchResponseDTO;
// import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
// import imyeom_lck.match_schedule.persistence.jpa.JpaMatchScheduleRepository;
// import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
// import imyeom_lck.member.domain.entity.Member;
// import imyeomsu.lck.common_utils.code.ErrorCode;
// import imyeomsu.lck.common_utils.exception.ClientException;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
//
// import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
//
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
//
// @Service
// @RequiredArgsConstructor
// public class MatchScheduleServiceImpl implements MatchScheduleService {
//
//     private final JpaMatchScheduleRepository matchRepository;
//
//     public List<MatchesResponseDTO> getAllMatches() {
//
//         List<MatchesResponseDTO> matchesResponseDTOS = new ArrayList<>();
//         List<MatchSchedule> matchSchedules = matchRepository.findAll();
//
//         for(MatchSchedule matchSchedule : matchSchedules) {
//             matchesResponseDTOS.add(new MatchesResponseDTO(
//                     matchSchedule.getHomeTeam(),
//                     matchSchedule.getAwayTeam(),
//                     matchSchedule.getMatchDate().toString(),
//                     matchSchedule.isMatchResult(),
//                     matchSchedule.isShowdown())
//             );
//         }
//
//         return matchesResponseDTOS;
//     }
//
//     public NextMatchResponseDTO getNextMatch() {
//
//         LocalDateTime nowDateTime =  LocalDateTime.now();
//
//         MatchSchedule matchSchedule = matchRepository.findAllByMatchDateGreaterThanOrderByMatchDateAsc(nowDateTime)
//                 .orElseThrow(() -> new ClientException(ErrorCode.NOT_FOUND, "다음 경기를 찾을 수 없습니다."));
//
//         return new NextMatchResponseDTO(
//                 matchSchedule.getHomeTeam(),
//                 matchSchedule.getAwayTeam(),
//                 matchSchedule.getMatchDate().toString(),
//                 matchSchedule.isShowdown()
//         );
//     }
// }

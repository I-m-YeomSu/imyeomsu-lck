package imyeom_lck.match_schedule.service.impl;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.persistence.querydsl.QueryMatchScheduleRepository;
import imyeom_lck.match_schedule.service.inter.QueryMatchScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryMatchScheduleServiceImpl implements QueryMatchScheduleService {

    private final QueryMatchScheduleRepository queryMatchScheduleRepository;

    @Override
    public List<MatchesResponseDTO> getAllMatchScheduleByMonth(String month, Pageable pageable) {

        List<MatchesResponseDTO> dtos = new ArrayList<>();
        for (MatchSchedule matchSchedule : queryMatchScheduleRepository.findMatchScheduleByMonth(month, pageable)) {
            dtos.add(MatchesResponseDTO.fromEntity(matchSchedule));
        }

        return dtos;
    }
}

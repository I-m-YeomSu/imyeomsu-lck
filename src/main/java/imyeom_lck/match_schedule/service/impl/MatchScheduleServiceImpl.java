package imyeom_lck.match_schedule.service.impl;


import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchScheduleServiceImpl implements MatchScheduleService {
    @Override
    public List<MatchesResponseDTO> getAllMatches() {
        return null;
    }
}

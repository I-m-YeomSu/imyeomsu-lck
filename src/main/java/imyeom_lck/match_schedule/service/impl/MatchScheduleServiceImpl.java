package imyeom_lck.match_schedule.service.impl;


import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import io.lettuce.core.XReadArgs;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MatchScheduleServiceImpl implements MatchScheduleService {
    @Override
    public List<MatchesResponseDTO> getAllMatches() {
        return null;
    }
}

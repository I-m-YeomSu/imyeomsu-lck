package imyeom_lck.match_schedule.service.impl;


import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.persistence.querydsl.QueryMatchScheduleRepository;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import io.lettuce.core.XReadArgs;
import lombok.RequiredArgsConstructor;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatchScheduleServiceImpl implements MatchScheduleService {
    private final RedisTemplate<String, String> redisTemplate;


    @Override
    public List<MatchesResponseDTO> getAllMatches() {


        return null;
    }
}

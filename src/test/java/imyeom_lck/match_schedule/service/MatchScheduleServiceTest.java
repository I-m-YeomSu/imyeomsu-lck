package imyeom_lck.match_schedule.service;


import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.dummy.DummyMatchSchedule;
import imyeom_lck.match_schedule.persistence.jpa.JpaMatchScheduleRepository;
import imyeom_lck.match_schedule.service.impl.MatchScheduleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;

@ExtendWith(MockitoExtension.class)
public class MatchScheduleServiceTest {

    @InjectMocks
    private MatchScheduleServiceImpl matchScheduleService;

    @Mock
    private JpaMatchScheduleRepository matchScheduleRepository;

    private MatchSchedule matchSchedule1;
    private MatchSchedule matchSchedule2;
    private MatchSchedule matchSchedule3;

    @BeforeEach
    void setUp(){
        matchSchedule1 = DummyMatchSchedule.createDummyMatchSchedule("homeTeamName1","awayTeamName1", "4월 11일 (목)", "12:00");
        matchSchedule2 = DummyMatchSchedule.createDummyMatchSchedule("homeTeamName2","awayTeamName2", "4월 12일 (목)", "12:00");
        matchSchedule3 = DummyMatchSchedule.createDummyMatchSchedule("homeTeamName3","awayTeamName3", "4월 13일 (목)", "12:00");

    }

    @Test
    void getAllMatches() throws JsonProcessingException {

        // given
        List<MatchSchedule> matchSchedules = List.of(matchSchedule1, matchSchedule2, matchSchedule3);
        when(matchScheduleRepository.findAll()).thenReturn(matchSchedules);

        // when
        List <MatchesResponseDTO> responseDTOs = matchScheduleService.getAllMatchesByRedis();

        // then
        assertNotNull(responseDTOs);
        assertEquals(3, responseDTOs.size());

        // 각 MatchesResponseDTO 객체를 확인
        for (int i = 0; i < 3; i++) {
            MatchesResponseDTO responseDTO = responseDTOs.get(i);
            MatchSchedule matchSchedule = matchSchedules.get(i);

            assertEquals(matchSchedule.getMatchTime(), responseDTO.getMatchTime());
            assertEquals(matchSchedule.getMatchDate(), responseDTO.getMatchDate());
            assertEquals(matchSchedule.getMatchState(), responseDTO.getMatchState());
        }

        // findAll 메서드가 한 번 호출되었는지 확인
        verify(matchScheduleRepository).findAll();
    }



}

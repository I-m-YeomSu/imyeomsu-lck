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
        matchSchedule1 = DummyMatchSchedule.createDummyMatchSchedule(123L,456L, LocalDateTime.now(), true, false);
        matchSchedule2 = DummyMatchSchedule.createDummyMatchSchedule(456L,123L, LocalDateTime.now(), false, false);
        matchSchedule3 = DummyMatchSchedule.createDummyMatchSchedule(789L,787L, LocalDateTime.now(), true, false);
    }


    @Test
    void getAllMatches() {
        // given
        List<MatchSchedule> matchSchedules = List.of(matchSchedule1, matchSchedule2, matchSchedule3);
        when(matchScheduleRepository.findAll()).thenReturn(matchSchedules);

        // when
        List <MatchesResponseDTO> responseDTOs = matchScheduleService.getAllMatches();

        // then
        assertNotNull(responseDTOs);
        assertEquals(3, responseDTOs.size());

        // 각 MatchesResponseDTO 객체를 확인
        for (int i = 0; i < 3; i++) {
            MatchesResponseDTO responseDTO = responseDTOs.get(i);
            MatchSchedule matchSchedule = matchSchedules.get(i);

            assertEquals(matchSchedule.getHomeTeam(), responseDTO.getHomeTeam());
            assertEquals(matchSchedule.getAwayTeam(), responseDTO.getAwayTeam());
            assertEquals(matchSchedule.getMatchDate().toString(), responseDTO.getMatchDate());
            assertEquals(matchSchedule.isMatchResult(), responseDTO.isMatchResult());
            assertEquals(matchSchedule.isShowdown(), responseDTO.isShowdown());
        }

        // findAll 메서드가 한 번 호출되었는지 확인
        verify(matchScheduleRepository).findAll();
    }



}

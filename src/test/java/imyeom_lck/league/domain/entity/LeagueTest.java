package imyeom_lck.league.domain.entity;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.dummy.DummyMatchSchedule;
import imyeom_lck.team.domain.entity.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LeagueTest {

    private League league;
    private Team team;
    private MatchSchedule matchSchedule;

    private LocalDateTime startDate = LocalDateTime.now();
    private LocalDateTime endDate = LocalDateTime.now().plusDays(7);

    @BeforeEach
    void setUp() {

        team = Team.builder().build();
        matchSchedule = DummyMatchSchedule.createDummyMatchSchedule("homeTeamName1","awayTeamName1", "4월 11일 (목)", "12:00");

        league = League.builder()
            .leagueId(1L)
            .team(team)
            .matchSchedule(matchSchedule)
            .startDate(LocalDateTime.now())
            .endDate(LocalDateTime.now().plusDays(7))
            .build();
    }

    @Test
    void getLeagueId() {

        assertThat(league.getLeagueId()).isEqualTo(1L);

    }

    @Test
    void getTeam() {
        assertThat(league.getTeam()).isEqualTo(team);

    }

    @Test
    void getMatchSchedule() {
        assertThat(league.getMatchSchedule()).isEqualTo(matchSchedule);

    }

    @Test
    void getStartDate() {
        assertThat(league.getStartDate().getMonthValue()).isEqualTo(startDate.getMonthValue());
        assertThat(league.getStartDate().getDayOfWeek()).isEqualTo(startDate.getDayOfWeek());

    }

    @Test
    void getEndDate() {
        assertThat(league.getEndDate().getMonthValue()).isEqualTo(endDate.getMonthValue());
        assertThat(league.getEndDate().getDayOfWeek()).isEqualTo(endDate.getDayOfWeek());

    }


}
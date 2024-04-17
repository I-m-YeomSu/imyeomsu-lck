package imyeom_lck.league.repository;

import imyeom_lck.league.domain.entity.League;
import imyeom_lck.league.dummy.DummyLeague;
import imyeom_lck.league.dummy.DummyMatchSchedule;
import imyeom_lck.league.dummy.DummyTeam;
import imyeom_lck.league.persistence.jpa.LeagueRepository;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.team.domain.entity.Team;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LeagueRepositoryTest {

//    @Autowired
//    private EntityManager entityManager;
//
//    @Autowired
//    private LeagueRepository leagueRepository;
//
//    private League league1;
//    private League league2;
//
//    private Team team1;
//    private Team team2;
//
//    private MatchSchedule matchSchedule1;
//    private MatchSchedule matchSchedule2;
//
//    @BeforeEach
//    public void setUp(){
//        team1 = DummyTeam.dummy(1L, "team1");
//        team2 = DummyTeam.dummy(2L, "team2");
//
//        matchSchedule1 = DummyMatchSchedule.dummy(1L, "title1");
//        matchSchedule2 = DummyMatchSchedule.dummy(2L, "title2");
//
//        league1 = DummyLeague.dummy(team1, matchSchedule1);
//        league2 = DummyLeague.dummy(team2, matchSchedule2);
//
//        leagueRepository.save(league1);
//        leagueRepository.save(league2);
//    }
//
//    @DisplayName("리그 저장 테스트")
//    @Test
//    public void testSaveLeague(){
//        //given
//        entityManager.persist(league1);
//
//        //when
//        leagueRepository.save(league1);
//
//        //then
//        assertNotNull(league1.getLeagueId());
//    }

}

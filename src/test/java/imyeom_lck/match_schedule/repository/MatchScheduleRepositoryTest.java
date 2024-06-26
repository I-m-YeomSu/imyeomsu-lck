package imyeom_lck.match_schedule.repository;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.dummy.DummyMatchSchedule;
import imyeom_lck.match_schedule.persistence.jpa.JpaMatchScheduleRepository;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.dummy.DummyMember;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MatchScheduleRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private JpaMatchScheduleRepository matchScheduleRepository;

    private MatchSchedule matchSchedule1;
    private MatchSchedule matchSchedule2;
    private MatchSchedule matchSchedule3;

    @BeforeEach
    public void setUp(){

        matchSchedule1 = DummyMatchSchedule.createDummyMatchSchedule("homeTeamName1","awayTeamName1", "4월 11일 (목)", "12:00");
        matchSchedule2 = DummyMatchSchedule.createDummyMatchSchedule("homeTeamName2","awayTeamName2", "4월 12일 (목)", "12:00");
        matchSchedule3 = DummyMatchSchedule.createDummyMatchSchedule("homeTeamName3","awayTeamName3", "4월 13일 (목)", "12:00");


    }



    @DisplayName("모든 경기 일정 조회")
    @Test
    public void testGetAllMatchSchedules() {
        // given
        entityManager.persist(matchSchedule1);
        entityManager.persist(matchSchedule2);
        entityManager.persist(matchSchedule3);


        // when
        List<MatchSchedule> matchScheduleList = matchScheduleRepository.findAll();

        // then
        assertEquals(3, matchScheduleList.size());


    }

}

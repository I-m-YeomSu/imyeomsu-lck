package imyeom_lck.match_schedule.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class MatchesResponseDTOTest {

    private MatchesResponseDTO matchesResponseDTO1;

    @BeforeEach
    void setup(){
        matchesResponseDTO1 = MatchesResponseDTO.builder()
                .matchDate("04-03")
                .matchTime("12:30")
                .matchState("matchstate1")
                .matchTitle("matchtitle1")
                .homeTeamScore("1")
                .awayTeamScore("1")
                .homeTeamName("home1")
                .homeTeamLogo("homelogo1")
                .awayTeamName("away1")
                .awayTeamLogo("awaylogo1")
                .build();

    }

    @Test
    void getMatchDate(){
        assertThat(matchesResponseDTO1.getMatchDate()).isEqualTo("04-03");
    }

    @Test
    void getMatchTime(){
        assertThat(matchesResponseDTO1.getMatchTime()).isEqualTo("12:30");
    }

    @Test
    void getMatchState(){
        assertThat(matchesResponseDTO1.getMatchState()).isEqualTo("matchstate1");
    }

    @Test
    void getMatchTitle(){
        assertThat(matchesResponseDTO1.getMatchTitle()).isEqualTo("matchtitle1");
    }

    @Test
    void getHomeTeamScore(){
        assertThat(matchesResponseDTO1.getHomeTeamScore()).isEqualTo("1");
    }

    @Test
    void getAwayTeamScore(){
        assertThat(matchesResponseDTO1.getAwayTeamScore()).isEqualTo("1");
    }

    @Test
    void getHomeTeamName(){
        assertThat(matchesResponseDTO1.getHomeTeamName()).isEqualTo("home1");
    }

    @Test
    void getHomeTeamLogo(){
        assertThat(matchesResponseDTO1.getHomeTeamLogo()).isEqualTo("homelogo1");
    }

    @Test
    void getAwayTeamName(){
        assertThat(matchesResponseDTO1.getAwayTeamName()).isEqualTo("away1");
    }

    @Test
    void getAwayTeamLogo(){
        assertThat(matchesResponseDTO1.getAwayTeamLogo()).isEqualTo("awaylogo1");
    }
}

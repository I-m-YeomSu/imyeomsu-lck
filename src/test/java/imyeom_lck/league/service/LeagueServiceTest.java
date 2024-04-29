package imyeom_lck.league.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.rank.domain.dto.RankDTO;
import imyeom_lck.league.dummy.DummyRankDTO;
import imyeom_lck.league.service.impl.LeagueServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LeagueServiceTest {

    @InjectMocks
    private LeagueServiceImpl leagueService;

    @Mock
    private RedisTemplate<String, String> matchRankingRedisTemplate;

    @Mock
    private ObjectMapper objectMapper;

    private RankDTO rankDTO1;
    private RankDTO rankDTO2;
    private Set<String> keys = new HashSet<>();;
    private List<RankDTO> rankList = new ArrayList<>();

    @BeforeEach
    void setUp(){
        keys.add("1");
        keys.add("2");

        rankDTO1 = DummyRankDTO.dummy("team1", "logo1", 111);
        rankDTO2 = DummyRankDTO.dummy("team2", "logo2", 222);

        rankList.add(rankDTO1);
        rankList.add(rankDTO2);

    }

    // 이건 보류
//    @DisplayName("getrank : 랭킹 받아오는 메소드")
//    @Test
//    void getRank() throws JsonProcessingException {
//        // given
//        when(matchRankingRedisTemplate.keys("*")).thenReturn(keys);
//        when(matchRankingRedisTemplate.opsForValue().get(anyString())).thenReturn("test");
//
//        // when
//        List<RankDTO> resultRankDTO = leagueService.getrank();
//
//
//        // then
//        assertNotNull(resultRankDTO); // 회원 정보가 null이 아닌지 확인
//    }

}

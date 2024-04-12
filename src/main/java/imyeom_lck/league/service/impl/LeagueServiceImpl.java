package imyeom_lck.league.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.league.domain.dto.NewsDTO;
import imyeom_lck.league.domain.dto.RankDTO;
import imyeom_lck.league.service.inter.LeagueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class LeagueServiceImpl implements LeagueService {

    private final RedisTemplate<String, String> matchRankingRedisTemplate;
    private final RedisTemplate<String, String> newsRedisTemplate;
    private final ObjectMapper objectMapper;

    public LeagueServiceImpl(@Qualifier("matchRankingRedisTemplate") RedisTemplate<String, String> matchRankingRedisTemplate,
                             @Qualifier("newsRedisTemplate") RedisTemplate<String, String> newsRedisTemplate,
                             ObjectMapper objectMapper) {
        this.matchRankingRedisTemplate = matchRankingRedisTemplate;
        this.newsRedisTemplate = newsRedisTemplate;
        this.objectMapper = objectMapper;
    }

    public List<RankDTO> redistest(){
        Set<String> keys = matchRankingRedisTemplate.keys("*");
        List<RankDTO> rankList = new ArrayList<>();
        for (String key : keys) {
            Object keys2 = matchRankingRedisTemplate.opsForValue().get(key);
            String json = keys2.toString();
            json = json.substring(1, json.length() - 1);
            String[] pairs = json.split(",");

            List<String> slist = new ArrayList<>();

            for(String s : pairs){
                String[] kv = s.split("=");
                slist.add(kv[1]);
            }

            RankDTO rank = RankDTO.builder()
                    .logo(slist.get(0))
                    .TeamName(slist.get(1))
                    .win(Integer.parseInt(slist.get(2)))
                    .lose(Integer.parseInt(slist.get(3)))
                    .difference(Integer.parseInt(slist.get(4)))
                    .winrate(slist.get(5))
                    .kda(slist.get(6))
                    .killcount(Integer.parseInt(slist.get(7)))
                    .deathcount(Integer.parseInt(slist.get(8)))
                    .assistcount(Integer.parseInt(slist.get(9)))
                    .build();

            rankList.add(rank);
        }
        return rankList;
    }
    public List<RankDTO> ranksort(List<RankDTO> rankList){

        Collections.sort(rankList, new Comparator<RankDTO>() {
            @Override
            public int compare(RankDTO r1, RankDTO r2) {
                if (r1.getWin() != r2.getWin()) {
                    return r2.getWin() - r1.getWin(); // 승수가 큰 순서대로 정렬
                } else {
                    return r2.getDifference() - r1.getDifference(); // 승수가 같으면 차이가 큰 순서대로 정렬
                }
            }
        });

        return rankList;
    }

    @Override
    public List<NewsDTO> getnews() throws JsonProcessingException {
        Set<String> keys = newsRedisTemplate.keys("*");

        for (String key : keys) {
            Object keys2 = newsRedisTemplate.opsForValue().get(key);

            String s = objectMapper.writeValueAsString(keys2);
            log.info("JSON@@@@@@@@@@@@@@@@@@@@ {}",s);

            NewsDTO newsDTO = objectMapper.readValue(s, NewsDTO.class);

            log.info("news DTO{} ", newsDTO.getContent());
            log.info("news DTO{} ", newsDTO.getTitle());
            log.info("news DTO{} ", newsDTO.getDate());
            log.info("news DTO{} ", newsDTO.getThumbnail());



            log.info("key!!!!!!!!!!!!!!!!!!!!!!!!!!!!! {} ",key);
        }

        return null;
    }

//    public List<NewsDTO> getnews(){
//        Set<String> keys = newsRedisTemplate.keys("*");
//        List<NewsDTO> newsList = new ArrayList<>();
//        for (String key : keys) {
//            Object keys2 = newsRedisTemplate.opsForValue().get(key);
//            String json = keys2.toString();
//            json = json.substring(1, json.length() - 1);
//
//            String title = parseValue(json, "title");
//            String content = parseValue(json, "content");
//            String thumbnail = parseValue(json, "thumbnail");
//            String date = parseValue(json, "date");
//
//            Pattern pattern = Pattern.compile(key + "=([^,]+)");
//            Matcher matcher = pattern.matcher(data);
//
//            if (matcher.find()) {
//                return matcher.group(1);
//            }
//
////            log.info("----------------:{}",json);
//
//
////            String[] pairs = json.split("=");
////            List<String> slist = new ArrayList<>();
////
////            for(String s : pairs){
////                String[] kv = s.split("=");
////                log.info("----------------:{}",kv[0]);
////                slist.add(kv[1]);
////            }
//
////            NewsDTO news = NewsDTO.builder()
////                    .logo(slist.get(0))
////                    .TeamName(slist.get(1))
////                    .win(Integer.parseInt(slist.get(2)))
////                    .lose(Integer.parseInt(slist.get(3)))
////                    .difference(Integer.parseInt(slist.get(4)))
////                    .winrate(slist.get(5))
////                    .kda(slist.get(6))
////                    .killcount(Integer.parseInt(slist.get(7)))
////                    .deathcount(Integer.parseInt(slist.get(8)))
////                    .assistcount(Integer.parseInt(slist.get(9)))
////                    .build();
////
////            newsList.add(news);
//        }
//        return newsList;
//    }


}

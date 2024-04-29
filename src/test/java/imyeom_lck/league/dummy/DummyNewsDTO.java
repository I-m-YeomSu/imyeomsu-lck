package imyeom_lck.league.dummy;

import imyeom_lck.league.domain.dto.NewsDTO;

public class DummyNewsDTO {
    public static NewsDTO dummy(String title, String content){
        return NewsDTO.builder()
                .title(title)
                .content(content)
                .build();
    }
}

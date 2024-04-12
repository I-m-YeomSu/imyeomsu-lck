package imyeom_lck.league.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NewsDTO {
    private String title;
    private String content;
    private String thumbnail;
    private String date;
}

package imyeom_lck.league.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO{

    private String title;
    private String content;
    private String thumbnail;
    private String date;

}

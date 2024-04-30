package imyeom_lck.news.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsDTO{

    private String title;
    private String content;
    private String thumbnail;
    private LocalDate date;
    private int index;

}

package imyeom_lck.match_schedule.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMatchSchedule is a Querydsl query type for MatchSchedule
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMatchSchedule extends EntityPathBase<MatchSchedule> {

    private static final long serialVersionUID = 1275630217L;

    public static final QMatchSchedule matchSchedule = new QMatchSchedule("matchSchedule");

    public final NumberPath<Long> awayTeam = createNumber("awayTeam", Long.class);

    public final NumberPath<Long> homeTeam = createNumber("homeTeam", Long.class);

    public final BooleanPath isShowdown = createBoolean("isShowdown");

    public final DateTimePath<java.time.LocalDateTime> matchDate = createDateTime("matchDate", java.time.LocalDateTime.class);

    public final BooleanPath matchResult = createBoolean("matchResult");

    public final NumberPath<Long> matchScheduleId = createNumber("matchScheduleId", Long.class);

    public QMatchSchedule(String variable) {
        super(MatchSchedule.class, forVariable(variable));
    }

    public QMatchSchedule(Path<? extends MatchSchedule> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMatchSchedule(PathMetadata metadata) {
        super(MatchSchedule.class, metadata);
    }

}


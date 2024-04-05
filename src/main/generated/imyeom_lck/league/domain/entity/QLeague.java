package imyeom_lck.league.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLeague is a Querydsl query type for League
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLeague extends EntityPathBase<League> {

    private static final long serialVersionUID = -1266142940L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLeague league = new QLeague("league");

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> leagueId = createNumber("leagueId", Long.class);

    public final imyeom_lck.match_schedule.domain.entity.QMatchSchedule matchSchedule;

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public final imyeom_lck.team.domain.entity.QTeam team;

    public QLeague(String variable) {
        this(League.class, forVariable(variable), INITS);
    }

    public QLeague(Path<? extends League> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLeague(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLeague(PathMetadata metadata, PathInits inits) {
        this(League.class, metadata, inits);
    }

    public QLeague(Class<? extends League> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.matchSchedule = inits.isInitialized("matchSchedule") ? new imyeom_lck.match_schedule.domain.entity.QMatchSchedule(forProperty("matchSchedule")) : null;
        this.team = inits.isInitialized("team") ? new imyeom_lck.team.domain.entity.QTeam(forProperty("team")) : null;
    }

}


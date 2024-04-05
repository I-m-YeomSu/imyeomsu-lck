package imyeom_lck.team.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeamPlayer is a Querydsl query type for TeamPlayer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeamPlayer extends EntityPathBase<TeamPlayer> {

    private static final long serialVersionUID = -1821248283L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTeamPlayer teamPlayer = new QTeamPlayer("teamPlayer");

    public final imyeom_lck.player.domain.entity.QPlayer player;

    public final QTeam team;

    public final NumberPath<Long> teamPlayerId = createNumber("teamPlayerId", Long.class);

    public QTeamPlayer(String variable) {
        this(TeamPlayer.class, forVariable(variable), INITS);
    }

    public QTeamPlayer(Path<? extends TeamPlayer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTeamPlayer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTeamPlayer(PathMetadata metadata, PathInits inits) {
        this(TeamPlayer.class, metadata, inits);
    }

    public QTeamPlayer(Class<? extends TeamPlayer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.player = inits.isInitialized("player") ? new imyeom_lck.player.domain.entity.QPlayer(forProperty("player")) : null;
        this.team = inits.isInitialized("team") ? new QTeam(forProperty("team")) : null;
    }

}


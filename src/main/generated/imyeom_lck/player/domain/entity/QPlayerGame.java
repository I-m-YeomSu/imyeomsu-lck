package imyeom_lck.player.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlayerGame is a Querydsl query type for PlayerGame
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlayerGame extends EntityPathBase<PlayerGame> {

    private static final long serialVersionUID = 734650998L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlayerGame playerGame = new QPlayerGame("playerGame");

    public final QPlayer player;

    public final NumberPath<Long> playerGameId = createNumber("playerGameId", Long.class);

    public QPlayerGame(String variable) {
        this(PlayerGame.class, forVariable(variable), INITS);
    }

    public QPlayerGame(Path<? extends PlayerGame> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlayerGame(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlayerGame(PathMetadata metadata, PathInits inits) {
        this(PlayerGame.class, metadata, inits);
    }

    public QPlayerGame(Class<? extends PlayerGame> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.player = inits.isInitialized("player") ? new QPlayer(forProperty("player")) : null;
    }

}


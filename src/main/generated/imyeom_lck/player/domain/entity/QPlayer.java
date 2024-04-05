package imyeom_lck.player.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlayer is a Querydsl query type for Player
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlayer extends EntityPathBase<Player> {

    private static final long serialVersionUID = -1748962204L;

    public static final QPlayer player = new QPlayer("player");

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Long> playerId = createNumber("playerId", Long.class);

    public final StringPath playerName = createString("playerName");

    public final NumberPath<Long> pogPoint = createNumber("pogPoint", Long.class);

    public final NumberPath<Long> position = createNumber("position", Long.class);

    public final StringPath stat = createString("stat");

    public QPlayer(String variable) {
        super(Player.class, forVariable(variable));
    }

    public QPlayer(Path<? extends Player> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlayer(PathMetadata metadata) {
        super(Player.class, metadata);
    }

}


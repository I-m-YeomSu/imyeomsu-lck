package imyeom_lck.team.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTeam is a Querydsl query type for Team
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeam extends EntityPathBase<Team> {

    private static final long serialVersionUID = -1541429020L;

    public static final QTeam team1 = new QTeam("team1");

    public final StringPath logo = createString("logo");

    public final NumberPath<Long> team = createNumber("team", Long.class);

    public final StringPath teamName = createString("teamName");

    public final NumberPath<Integer> teamRanking = createNumber("teamRanking", Integer.class);

    public final NumberPath<Integer> winningGame = createNumber("winningGame", Integer.class);

    public final NumberPath<Integer> winningPoint = createNumber("winningPoint", Integer.class);

    public QTeam(String variable) {
        super(Team.class, forVariable(variable));
    }

    public QTeam(Path<? extends Team> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeam(PathMetadata metadata) {
        super(Team.class, metadata);
    }

}


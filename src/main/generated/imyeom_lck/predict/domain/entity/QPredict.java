package imyeom_lck.predict.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPredict is a Querydsl query type for Predict
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPredict extends EntityPathBase<Predict> {

    private static final long serialVersionUID = 607152952L;

    public static final QPredict predict = new QPredict("predict");

    public final NumberPath<Long> awayTeamVote = createNumber("awayTeamVote", Long.class);

    public final NumberPath<Long> homeTeamVote = createNumber("homeTeamVote", Long.class);

    public final DateTimePath<java.time.LocalDateTime> matchDate = createDateTime("matchDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> predictId = createNumber("predictId", Long.class);

    public QPredict(String variable) {
        super(Predict.class, forVariable(variable));
    }

    public QPredict(Path<? extends Predict> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPredict(PathMetadata metadata) {
        super(Predict.class, metadata);
    }

}


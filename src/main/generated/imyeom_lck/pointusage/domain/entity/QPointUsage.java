package imyeom_lck.pointusage.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPointUsage is a Querydsl query type for PointUsage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPointUsage extends EntityPathBase<PointUsage> {

    private static final long serialVersionUID = -478060988L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPointUsage pointUsage = new QPointUsage("pointUsage");

    public final imyeom_lck.member.domain.entity.QMember member;

    public final StringPath pointHistory = createString("pointHistory");

    public final NumberPath<Long> pointUsageId = createNumber("pointUsageId", Long.class);

    public final NumberPath<Long> usageClassification = createNumber("usageClassification", Long.class);

    public final DateTimePath<java.time.LocalDateTime> usageDate = createDateTime("usageDate", java.time.LocalDateTime.class);

    public QPointUsage(String variable) {
        this(PointUsage.class, forVariable(variable), INITS);
    }

    public QPointUsage(Path<? extends PointUsage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPointUsage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPointUsage(PathMetadata metadata, PathInits inits) {
        this(PointUsage.class, metadata, inits);
    }

    public QPointUsage(Class<? extends PointUsage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new imyeom_lck.member.domain.entity.QMember(forProperty("member")) : null;
    }

}


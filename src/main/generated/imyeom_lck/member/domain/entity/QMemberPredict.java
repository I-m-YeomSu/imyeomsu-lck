package imyeom_lck.member.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberPredict is a Querydsl query type for MemberPredict
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberPredict extends EntityPathBase<MemberPredict> {

    private static final long serialVersionUID = 318869045L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberPredict memberPredict = new QMemberPredict("memberPredict");

    public final QMember member;

    public final NumberPath<Long> memberPredictId = createNumber("memberPredictId", Long.class);

    public final imyeom_lck.predict.domain.entity.QPredict predict;

    public QMemberPredict(String variable) {
        this(MemberPredict.class, forVariable(variable), INITS);
    }

    public QMemberPredict(Path<? extends MemberPredict> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberPredict(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberPredict(PathMetadata metadata, PathInits inits) {
        this(MemberPredict.class, metadata, inits);
    }

    public QMemberPredict(Class<? extends MemberPredict> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.predict = inits.isInitialized("predict") ? new imyeom_lck.predict.domain.entity.QPredict(forProperty("predict")) : null;
    }

}


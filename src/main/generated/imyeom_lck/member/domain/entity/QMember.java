package imyeom_lck.member.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1736454660L;

    public static final QMember member = new QMember("member1");

    public final StringPath cheeringTeam = createString("cheeringTeam");

    public final BooleanPath connectionStatus = createBoolean("connectionStatus");

    public final NumberPath<Long> financeId = createNumber("financeId", Long.class);

    public final BooleanPath isAlert = createBoolean("isAlert");

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final StringPath loginId = createString("loginId");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<imyeom_lck.pointusage.domain.entity.PointUsage, imyeom_lck.pointusage.domain.entity.QPointUsage> pointUsages = this.<imyeom_lck.pointusage.domain.entity.PointUsage, imyeom_lck.pointusage.domain.entity.QPointUsage>createList("pointUsages", imyeom_lck.pointusage.domain.entity.PointUsage.class, imyeom_lck.pointusage.domain.entity.QPointUsage.class, PathInits.DIRECT2);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}


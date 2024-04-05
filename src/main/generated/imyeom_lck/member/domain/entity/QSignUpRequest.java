package imyeom_lck.member.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSignUpRequest is a Querydsl query type for SignUpRequest
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSignUpRequest extends EntityPathBase<SignUpRequest> {

    private static final long serialVersionUID = -13345907L;

    public static final QSignUpRequest signUpRequest = new QSignUpRequest("signUpRequest");

    public final StringPath loginId = createString("loginId");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public QSignUpRequest(String variable) {
        super(SignUpRequest.class, forVariable(variable));
    }

    public QSignUpRequest(Path<? extends SignUpRequest> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSignUpRequest(PathMetadata metadata) {
        super(SignUpRequest.class, metadata);
    }

}


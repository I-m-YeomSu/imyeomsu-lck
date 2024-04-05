package imyeom_lck.merchandise.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMerchandise is a Querydsl query type for Merchandise
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMerchandise extends EntityPathBase<Merchandise> {

    private static final long serialVersionUID = -528535924L;

    public static final QMerchandise merchandise = new QMerchandise("merchandise");

    public final NumberPath<Long> classification = createNumber("classification", Long.class);

    public final StringPath image = createString("image");

    public final NumberPath<Long> merchandiseId = createNumber("merchandiseId", Long.class);

    public final StringPath merchandiseName = createString("merchandiseName");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final NumberPath<Long> stockQuantity = createNumber("stockQuantity", Long.class);

    public QMerchandise(String variable) {
        super(Merchandise.class, forVariable(variable));
    }

    public QMerchandise(Path<? extends Merchandise> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMerchandise(PathMetadata metadata) {
        super(Merchandise.class, metadata);
    }

}


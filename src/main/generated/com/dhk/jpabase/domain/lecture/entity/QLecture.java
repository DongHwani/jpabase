package com.dhk.jpabase.domain.lecture.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLecture is a Querydsl query type for Lecture
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLecture extends EntityPathBase<Lecture> {

    private static final long serialVersionUID = -1930904713L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLecture lecture = new QLecture("lecture");

    public final com.dhk.jpabase.domain.support.QBaseTime _super = new com.dhk.jpabase.domain.support.QBaseTime(this);

    public final EnumPath<LectureCategory> category = createEnum("category", LectureCategory.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.dhk.jpabase.domain.member.entity.QMember instructor;

    public final StringPath lectureClassName = createString("lectureClassName");

    public final NumberPath<Long> lectureId = createNumber("lectureId", Long.class);

    public final StringPath lectureInformation = createString("lectureInformation");

    public final ListPath<LectureLine, QLectureLine> lectureLines = this.<LectureLine, QLectureLine>createList("lectureLines", LectureLine.class, QLectureLine.class, PathInits.DIRECT2);

    public final EnumPath<LectureState> lectureState = createEnum("lectureState", LectureState.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public QLecture(String variable) {
        this(Lecture.class, forVariable(variable), INITS);
    }

    public QLecture(Path<? extends Lecture> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLecture(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLecture(PathMetadata metadata, PathInits inits) {
        this(Lecture.class, metadata, inits);
    }

    public QLecture(Class<? extends Lecture> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.instructor = inits.isInitialized("instructor") ? new com.dhk.jpabase.domain.member.entity.QMember(forProperty("instructor"), inits.get("instructor")) : null;
    }

}


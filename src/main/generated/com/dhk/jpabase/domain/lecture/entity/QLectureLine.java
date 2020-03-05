package com.dhk.jpabase.domain.lecture.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLectureLine is a Querydsl query type for LectureLine
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QLectureLine extends BeanPath<LectureLine> {

    private static final long serialVersionUID = 717507595L;

    public static final QLectureLine lectureLine = new QLectureLine("lectureLine");

    public final StringPath lectureContents = createString("lectureContents");

    public final StringPath lectureTitle = createString("lectureTitle");

    public QLectureLine(String variable) {
        super(LectureLine.class, forVariable(variable));
    }

    public QLectureLine(Path<? extends LectureLine> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLectureLine(PathMetadata metadata) {
        super(LectureLine.class, metadata);
    }

}


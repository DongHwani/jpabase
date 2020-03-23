package com.dhk.jpabase.domain.comment.entity;

import com.dhk.jpabase.domain.member.entity.Member;
import com.dhk.jpabase.domain.support.BaseTime;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(schema = "jpa", name = "comments")
public class Comment extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name="memberId")
    private Member questioner;

    @JoinColumn(name = "lectureId")
    private Long lectureId;

    private String content;

    @Enumerated(EnumType.STRING)
    private CommentType commentType;

}

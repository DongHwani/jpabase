CREATE TABLE `jpa`.`comments` (

  `commentId`         BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '댓글 번호',
  `memberId`          BIGINT(20)    NOT NULL                COMMENT '회원 번호',
  `lectureId`         BIGINT(20)    NOT NULL                COMMENT '강의 번호',
  `content`           TINYTEXT      NOT NULL                COMMENT '댓글 내용',
  `commentType`       VARCHAR(50)   NOT NULL                COMMENT '댓글 타입',

  `createdAt`             DATETIME(6)   NOT NULL            COMMENT '댓글 생성 일시',
  `modifiedAt`            DATETIME(6)   NOT NULL            COMMENT '댓글 수정 일시',

  PRIMARY KEY (`commentId`),
  FOREIGN KEY (`memberId`) REFERENCES members (`memberId`),
  FOREIGN KEY (`lectureId`) REFERENCES lectures (`lectureId`),
  UNIQUE INDEX `commentId_UNIQUE` (`commentId` ASC));

CREATE TABLE `jpa`.`lectureLines` (

  `lectureLineId`         BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '회차 강의 번호',
  `lectureTitle`          VARCHAR(100)  NOT NULL                COMMENT '회차 강의 제목',
  `lectureContents`       TINYTEXT      NOT NULL                COMMENT '회차 강의 내용',

  `lectureId`             BIGINT(20)    NOT NULL                COMMENT '클래스 번호',

  PRIMARY KEY (`lectureLineId`),
  FOREIGN KEY (`lectureId`) REFERENCES lectures (`lectureId`),
  UNIQUE INDEX `lectureId_UNIQUE` (`lectureLineId` ASC));


CREATE TABLE `jpa`.`lectures` (

  `lectureId`             BIGINT(20)    NOT NULL AUTO_INCREMENT COMMENT '강의 번호',
  `instructorId`          BIGINT(20)    NOT NULL                COMMENT '강사 번호',
  `lectureClassName`      VARCHAR(100)  NOT NULL                COMMENT '강의명',
  `lectureInformation`    TINYTEXT      NOT NULL                COMMENT '강의 정보',
  `lectureState`          VARCHAR(30)   NOT NULL                COMMENT '강의 상태',

  `category`              VARCHAR(50)   NOT NULL                COMMENT '회원 연락가능 전화번호',
  `price`                 DECIMAL(8)    NOT NULL                COMMENT '강의 가격',

  `createdAt`             DATETIME(6)   NOT NULL                COMMENT '강의 개설 일시',
  `modifiedAt`            DATETIME(6)   NOT NULL                COMMENT '강의 수정 일시',

  PRIMARY KEY (`lectureId`),
  FOREIGN KEY (`instructorId`) REFERENCES members (`memberId`),
  UNIQUE INDEX `lectureId_UNIQUE` (`lectureId` ASC));


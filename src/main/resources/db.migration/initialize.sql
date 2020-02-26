USE mysql;

CREATE DATABASE jpa DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

CREATE USER 'dhk'@'%' IDENTIFIED BY 'dhk';
CREATE USER 'dhk'@'localhost' IDENTIFIED BY 'dhk';

-- DB 별 권한 부여
GRANT ALL PRIVILEGES ON jpa.* TO 'dhk'@'localhost';
GRANT ALL PRIVILEGES ON jpa.* TO 'dhk'@'%';

-- 마무리.
FLUSH PRIVILEGES;
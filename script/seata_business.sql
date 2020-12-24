CREATE DATABASE seata_storage;
USE seata_storage;
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT,
    `commodity_code` varchar(255) DEFAULT NULL,
    `count`          int(11)      DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`commodity_code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE DATABASE seata_order;
USE seata_order;
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT,
    `user_id`        varchar(255) DEFAULT NULL,
    `commodity_code` varchar(255) DEFAULT NULL,
    `count`          int(11)      DEFAULT 0,
    `money`          int(11)      DEFAULT 0,
    `status`         int(1)       DEFAULT 0,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE DATABASE seata_account;
USE seata_account;
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `user_id` varchar(255) DEFAULT NULL,
    `money`   int(11)      DEFAULT 0,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
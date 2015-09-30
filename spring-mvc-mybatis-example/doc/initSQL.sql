
CREATE TABLE `contacts_cstm` (
  `id_c` VARCHAR(36) NOT NULL DEFAULT 'NULL',
  `total_points_c` INT(10) DEFAULT NULL COMMENT '总积分',
  `upgrade_points_c` INT(10) DEFAULT NULL COMMENT '升级积分',
  `available_points_c` INT(10) DEFAULT NULL COMMENT '可用积分',
  `level_level_c` VARCHAR(8) DEFAULT NULL COMMENT '1，普通；2，vip；3，钻石',
  `level_name_c` VARCHAR(255) DEFAULT NULL COMMENT '1，普通；2，vip；3，钻石',
  `points_expired_time_c` TIMESTAMP NULL DEFAULT NULL COMMENT '等级过期时间',
  `points_status_c` CHAR(1) DEFAULT NULL,
  `points_description_c` VARCHAR(255) DEFAULT NULL,
  `is_permanent_c` CHAR(1) DEFAULT NULL COMMENT '是否永久钻石会员 Y:是 N：否',
  `points_date_entered_c` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `points_date_modified_c` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id_c`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='积分表';


CREATE TABLE `t_user` (
  `id` INT(11) NOT NULL,
  `username` VARCHAR(45) DEFAULT NULL,
  `password` VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;



INSERT INTO `t_user` (`id`, `username`, `password`) VALUES('1','jack','123');
INSERT INTO `t_user` (`id`, `username`, `password`) VALUES('2','jack123','123456');
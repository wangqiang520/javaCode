drop table t_user;
CREATE TABLE `t_user` (
  `id` int NOT NULL,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_login` varchar(255) DEFAULT NULL COMMENT '登录用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `sex` char(2) DEFAULT NULL COMMENT '性别1:男，2:女',
  `idCard` VARCHAR(18) DEFAULT null COMMENT '身份证',
  `email` VARCHAR(25) DEFAULT null COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `telephone` int DEFAULT NULL COMMENT '电话',
  `creater` int DEFAULT NULL COMMENT '创建人',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `updater` int DEFAULT NULL COMMENT '修改人',
  `update_time` bigint DEFAULT NULL COMMENT '修改时间',
  `status` char(1) default 1 COMMENT '状态1:正常，0：注销',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table t_loginLog;
CREATE TABLE `t_user` (
  `id` int NOT NULL,
  `user_id` int NOT NULL COMMENT '用户id',
  `login_address` varchar(255) DEFAULT NULL COMMENT '登录IP地址',
  `login_time` bigint DEFAULT NULL COMMENT '登录时间',
  `logout_time` bigint DEFAULT NULL COMMENT '注销时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


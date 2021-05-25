##对比数据落地

CREATE TABLE `t_ruban_conpare_datas` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `dim_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '维度id',
  `dim_rank` varchar(32) DEFAULT NULL COMMENT '排序',
  `datas` varchar(11) DEFAULT NULL COMMENT '数据',
  `del_flag` tinyint unsigned DEFAULT '0' COMMENT '删除标志位 0 未删除 1删除',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


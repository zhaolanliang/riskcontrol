##任务清洗的对比维度

CREATE TABLE `t_ruban_compare_dimensions` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `task_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `task_name` varchar(32) DEFAULT NULL COMMENT '任务名称',
  `dim_rank` varchar(32) DEFAULT NULL COMMENT '排序',
  `diff_time` bigint(11) DEFAULT NULL COMMENT '间隔时间(毫秒)',
  `del_flag` tinyint unsigned DEFAULT '0' COMMENT '删除标志位 0 未删除 1删除',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
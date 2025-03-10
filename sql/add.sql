
-----插入数据--
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (11, '条数', 'dic_num', '0', 'admin', '2025-03-08 00:47:23', '', NULL, '条数');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (30, 0, '1条', '1', 'dic_num', NULL, 'default', 'N', '0', 'admin', '2025-03-08 00:48:02', '', NULL, NULL);
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (31, 0, '2条', '2', 'dic_num', NULL, 'default', 'N', '0', 'admin', '2025-03-08 00:48:14', '', NULL, NULL);
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (32, 0, '4条', '4', 'dic_num', NULL, 'default', 'N', '0', 'admin', '2025-03-08 00:48:45', 'admin', '2025-03-08 01:02:15', NULL);



----创建表sql
---- 操作记录表
REATE TABLE `opt_history` (
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `id` int(11) NOT NULL COMMENT '主键',
  `real_url` tinytext COMMENT '原图',
  `mat_url` tinytext COMMENT '物料图',
  `mk_url` tinytext COMMENT '合成合集',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(255) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户历史操作记录图';


ALTER TABLE `sys_user`
DROP COLUMN `score`,
ADD COLUMN `score` varchar(255) NULL COMMENT '积分' AFTER `remark`


CREATE TABLE `user_score`  (
  `user_id` int NOT NULL COMMENT '用户id',
  `date_time` datetime NULL COMMENT '日期',
  `score` varchar(255) NULL COMMENT '积分',
  `addFlag` varchar(255) NULL COMMENT '删除-0  新增-1 ',
  `note` varchar(255) NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) COMMENT = '积分详情图'
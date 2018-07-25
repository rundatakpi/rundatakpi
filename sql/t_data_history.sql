/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : datakpi

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-25 09:41:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_data_history`
-- ----------------------------
DROP TABLE IF EXISTS `t_data_history`;
CREATE TABLE `t_data_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `data_type` varchar(100) DEFAULT NULL COMMENT '数据类型，格转数据/预处理数据/入库日志数据/对象化数据',
  `field_name` varchar(100) DEFAULT NULL COMMENT '字段名称，输入数据条数/输入数据字段填充率',
  `data` varchar(100) DEFAULT NULL COMMENT '数据',
  `data_time` date DEFAULT NULL COMMENT '数据的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_data_history
-- ----------------------------

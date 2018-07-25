/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : datakpi

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-25 09:41:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_input_log_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_input_log_info`;
CREATE TABLE `t_input_log_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ds_code` varchar(100) DEFAULT NULL COMMENT '数据源编码',
  `ds_description` varchar(300) DEFAULT NULL COMMENT '数据源描述',
  `b_protocol_code` varchar(100) DEFAULT NULL COMMENT '大协议编号',
  `b_protocol_description` varchar(300) DEFAULT NULL COMMENT '大协议描述',
  `input_num` int(11) DEFAULT NULL COMMENT '入库条数',
  `input_rate` varchar(100) DEFAULT NULL COMMENT '入库率',
  `field_num` int(11) DEFAULT NULL COMMENT '字段数',
  `data_accuracy` varchar(100) DEFAULT NULL COMMENT '数据准确性',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_input_log_info
-- ----------------------------

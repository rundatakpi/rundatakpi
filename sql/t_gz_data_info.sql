/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : datakpi

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-25 09:41:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_gz_data_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_gz_data_info`;
CREATE TABLE `t_gz_data_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ds_code` varchar(50) NOT NULL COMMENT '数据源编码',
  `ds_description` varchar(200) NOT NULL COMMENT '数据源描述',
  `b_protocol_code` varchar(50) NOT NULL COMMENT '大协议编码',
  `b_protocol_description` varchar(200) NOT NULL COMMENT '大协议描述',
  `s_protocol_code` varchar(50) NOT NULL COMMENT '小协议编码',
  `s_protocol_description` varchar(200) NOT NULL COMMENT '小协议描述',
  `action` varchar(50) NOT NULL COMMENT '动作描述',
  `input_data_num` int(11) NOT NULL COMMENT '输入数据条数',
  `input_data_speed` varchar(100) NOT NULL COMMENT '输入数据速度',
  `input_field_filled_rate` varchar(100) NOT NULL COMMENT '输入数据字段填充率',
  `input_group_filled_rate` varchar(100) NOT NULL COMMENT '输入数据依赖字段组填充率',
  `input_data_availability` varchar(100) NOT NULL COMMENT '输入数据字段可用率',
  `input_group_availability` varchar(100) NOT NULL COMMENT '输入数据依赖字段组可用率',
  `input_data_accuracy` varchar(100) NOT NULL COMMENT '输入数据准确率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gz_data_info
-- ----------------------------

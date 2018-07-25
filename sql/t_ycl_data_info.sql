/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : datakpi

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-25 09:42:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_ycl_data_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_ycl_data_info`;
CREATE TABLE `t_ycl_data_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ds_code` varchar(100) DEFAULT NULL COMMENT '数据源编号',
  `ds_description` varchar(300) DEFAULT NULL COMMENT '数据源描述',
  `b_protocol_code` varchar(100) DEFAULT NULL COMMENT '大协议编号',
  `b_protocol_description` varchar(300) DEFAULT NULL COMMENT '大协议描述',
  `s_protocol_code` varchar(100) DEFAULT NULL COMMENT '小协议编码',
  `s_protocol_description` varchar(300) DEFAULT NULL COMMENT '小协议描述',
  `action_type` varchar(10) DEFAULT NULL COMMENT '动作描述',
  `input_data_num` int(11) DEFAULT NULL COMMENT '输入数据条数',
  `input_field_rate` varchar(100) DEFAULT NULL COMMENT '输入数据填充率',
  `input_group_rate` varchar(100) DEFAULT NULL COMMENT '输入数据依赖字段组填充率',
  `input_field_avaliability` varchar(100) DEFAULT NULL COMMENT '输入数据字段可用率',
  `input_group_avalability` varchar(100) DEFAULT NULL COMMENT '输入数据依赖字段组可用率',
  `input_data_accuracy` varchar(100) DEFAULT NULL COMMENT '输入数据准确率',
  `output_data_num` int(11) DEFAULT NULL COMMENT '输出数据条数',
  `output_data_speed` varchar(100) DEFAULT NULL COMMENT '输出数据速率',
  `output_field_rate` varchar(100) DEFAULT NULL COMMENT '输出数据字段填充率',
  `output_group_rate` varchar(100) DEFAULT NULL COMMENT '输出数据依赖字段组填充率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ycl_data_info
-- ----------------------------

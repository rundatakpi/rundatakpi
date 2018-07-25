/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : datakpi

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-25 09:40:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_data_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_data_detail`;
CREATE TABLE `t_data_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `source_description` varchar(200) DEFAULT NULL COMMENT '来源描述',
  `rz_number` varchar(50) DEFAULT NULL COMMENT '认证号码',
  `rz_type` varchar(50) DEFAULT NULL COMMENT '认证类型',
  `sender` varchar(50) DEFAULT NULL COMMENT '发送者名称',
  `receiver` varchar(50) DEFAULT NULL COMMENT '接收者名称',
  `base_station` varchar(100) DEFAULT NULL COMMENT '基站',
  `relate_id` bigint(20) DEFAULT NULL COMMENT '关联的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_data_detail
-- ----------------------------

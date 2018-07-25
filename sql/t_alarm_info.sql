/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : datakpi

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-25 09:40:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_alarm_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_alarm_info`;
CREATE TABLE `t_alarm_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `alarm_time` datetime NOT NULL COMMENT '告警时间',
  `alarm_level` varchar(10) NOT NULL COMMENT '告警级别',
  `alarm_content` varchar(500) DEFAULT '' COMMENT '告警内容',
  `process_status` varchar(10) NOT NULL COMMENT '告警状态，1告警中，2处理中，3已处理',
  `is_deleted` varchar(10) NOT NULL DEFAULT 'N' COMMENT '是否删除，N未删除，Y已删除',
  `relate_id` bigint(20) NOT NULL COMMENT '关联id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_alarm_info
-- ----------------------------

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : datakpi

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-25 09:41:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_input_log_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_input_log_detail`;
CREATE TABLE `t_input_log_detail` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `s_protocol_code` varchar(100) NOT NULL COMMENT '小协议编号',
  `s_protocol_description` varchar(200) NOT NULL COMMENT '小协议描述',
  `action_type` varchar(50) DEFAULT NULL COMMENT '动作描述',
  `data_num` int(11) DEFAULT NULL COMMENT '数据条数',
  `rzhm_filled_rate` varchar(100) DEFAULT NULL COMMENT '认证号码填充率',
  `rzhm_accuracy` varchar(100) DEFAULT NULL COMMENT '认证号码准确性',
  `rzlx_filled_rate` varchar(100) DEFAULT NULL COMMENT '认证类型填充率',
  `rzlx_accuracy` varchar(100) DEFAULT NULL COMMENT '认证类型准确率',
  `rzlx_matching` varchar(100) DEFAULT NULL COMMENT '认证类型代码符合度',
  `sender_filled_rate` varchar(100) DEFAULT NULL COMMENT '发送者名称填充率',
  `sender_accuracy` varchar(100) DEFAULT NULL COMMENT '发送者名称准确率',
  `receiver_filled_rate` varchar(100) DEFAULT NULL COMMENT '接收者名称填充率',
  `receiver_accuracy` varchar(100) DEFAULT NULL COMMENT '接收者名称准确率',
  `jz_filled_rate` varchar(100) DEFAULT NULL COMMENT '基站填充率',
  `jz_accuracy` varchar(100) DEFAULT NULL COMMENT '基站准确性',
  `relate_id` bigint(20) DEFAULT NULL COMMENT '关联大协议的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_input_log_detail
-- ----------------------------

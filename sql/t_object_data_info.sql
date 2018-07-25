/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : datakpi

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-07-25 09:41:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_object_data_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_object_data_info`;
CREATE TABLE `t_object_data_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `feature_string` varchar(200) DEFAULT NULL COMMENT '特征串',
  `ds_code` varchar(100) DEFAULT NULL COMMENT '数据源编码',
  `ds_description` varchar(300) DEFAULT NULL COMMENT '数据源中文描述',
  `feature_string_total` int(11) DEFAULT NULL COMMENT '特征串总量（对）',
  `accuracy` varchar(255) DEFAULT NULL COMMENT '准确率',
  `weekly_extraction` int(11) DEFAULT NULL COMMENT '近7天提取量',
  `net_extract_relations` int(11) DEFAULT NULL COMMENT '净提取关系个数',
  `net_extract_relation_rate` varchar(100) DEFAULT NULL COMMENT '净提取关系比率',
  `phone_relations` int(11) DEFAULT NULL COMMENT '手机号关联数量',
  `phone_relation_rate` varchar(100) DEFAULT NULL COMMENT '手机号关联数量占比',
  `idcard_relations` int(11) DEFAULT NULL COMMENT '身份证关联数量',
  `idcard_relation_rate` varchar(100) DEFAULT NULL COMMENT '身份证关联数量占比',
  `adsl_relations` int(11) DEFAULT NULL COMMENT 'adsl关联数量',
  `adsl_relation_rate` varchar(100) DEFAULT NULL COMMENT 'adsl关联数量占比',
  `imei_relatons` int(11) DEFAULT NULL COMMENT 'imei关联数量',
  `imei_relation_rate` varchar(100) DEFAULT NULL COMMENT 'imei关联数量占比',
  `imsi_relations` int(11) DEFAULT NULL COMMENT 'imsi关联数量',
  `imsi_relation_rate` varchar(100) DEFAULT NULL COMMENT 'imsi关联数量占比',
  `mac_relations` int(11) DEFAULT NULL COMMENT 'mac关联数量',
  `mac_relation_rate` varchar(100) DEFAULT NULL COMMENT 'mac关联数量占比',
  `field1` varchar(100) DEFAULT NULL COMMENT '属性字段1(元素编码)，填充率',
  `field2` varchar(100) DEFAULT NULL COMMENT '属性字段2(元素编码)，填充率',
  `field3` varchar(100) DEFAULT NULL COMMENT '属性字段3(元素编码)，填充率',
  `field4` varchar(100) DEFAULT NULL COMMENT '属性字段4(元素编码)，填充率',
  `feild5` varchar(100) DEFAULT NULL COMMENT '属性字段5(元素编码)，填充率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_object_data_info
-- ----------------------------

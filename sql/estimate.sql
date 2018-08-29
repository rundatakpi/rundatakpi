/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : datakpi

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2018-08-29 10:36:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_input_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_input_log`;
CREATE TABLE `t_input_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dataSet` varchar(100) DEFAULT '' COMMENT '数据集',
  `dsCode` varchar(100) DEFAULT '' COMMENT '数据源编码',
  `dsDesc` varchar(300) DEFAULT '' COMMENT '数据源描述',
  `bProtocolCode` varchar(100) DEFAULT '' COMMENT '大协议编号',
  `bProtocolDesc` varchar(300) DEFAULT '' COMMENT '大协议描述',
  `totalNum` int(11) DEFAULT '0' COMMENT '总条数',
  `inputNum` int(11) DEFAULT '0' COMMENT '入库条数',
  `inputRate` varchar(50) DEFAULT '' COMMENT '入库率',
  `fieldNum` int(11) DEFAULT '0' COMMENT '字段数',
  `accurateNum` int(11) DEFAULT '0' COMMENT '数据准确条数',
  `accuracy` varchar(50) DEFAULT '' COMMENT '数据准确率',
  `createDate` date DEFAULT NULL COMMENT '数据生成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_input_log
-- ----------------------------
INSERT INTO `t_input_log` VALUES ('9', '', '111', '固网', 'WA_SOURCE_0001', '网页访问(HTTP)', '200', '76', '0.76', '70', '100', '0.99', '2018-08-29');
INSERT INTO `t_input_log` VALUES ('10', '', '111', '固网', 'WA_SOURCE_0001', '网页访问(HTTP)', '290', '87', '0.87', '60', '80', '0.87', '2018-08-28');
INSERT INTO `t_input_log` VALUES ('11', '', '111', '固网', 'WA_SOURCE_0001', '网页访问(HTTP)', '220', '56', '0.54', '80', '74', '0.64', '2018-08-27');
INSERT INTO `t_input_log` VALUES ('12', '', '111', '固网', 'WA_SOURCE_0001', '网页访问(HTTP)', '260', '45', '0.55', '80', '75', '0.55', '2018-08-26');
INSERT INTO `t_input_log` VALUES ('13', '', '111', '固网', 'WA_SOURCE_0001', '网页访问(HTTP)', '250', '43', '0.98', '69', '77', '0.93', '2018-08-25');
INSERT INTO `t_input_log` VALUES ('14', '', '111', '固网', 'WA_SOURCE_0001', '网页访问(HTTP)', '280', '45', '0.79', '67', '78', '0.71', '2018-08-24');

-- ----------------------------
-- Table structure for `t_input_log_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_input_log_detail`;
CREATE TABLE `t_input_log_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dsCode` varchar(50) DEFAULT '' COMMENT '数据源编号',
  `bProtocolCode` varchar(50) DEFAULT NULL COMMENT '大协议编码',
  `sProtocolCode` varchar(50) DEFAULT '' COMMENT '小协议编号',
  `actionType` varchar(50) DEFAULT '' COMMENT '小协议动作类型',
  `dataNum` bigint(20) DEFAULT '0' COMMENT '小协议数据条数',
  `fieldCode` varchar(50) DEFAULT '' COMMENT '字段编码',
  `fieldDesc` varchar(100) DEFAULT '' COMMENT '字段描述',
  `fillNum` bigint(20) DEFAULT '0' COMMENT '填充条数',
  `accurateNum` bigint(20) DEFAULT '0' COMMENT '准确条数',
  `codeMatchNum` bigint(20) DEFAULT '0' COMMENT '代码符合条数',
  `createDate` date DEFAULT NULL COMMENT '数据生成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_input_log_detail
-- ----------------------------
INSERT INTO `t_input_log_detail` VALUES ('10', '111', 'WA_SOURCE_0001', '1000001', '02', '100', '220040B', '归一化认证账号', '80', '100', '43', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('11', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'Z002005', 'todo', '70', '60', '76', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('12', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'B050005', '发送方名称', '70', '90', '87', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('13', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'Z002007', '日志标识', '60', '80', '69', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('14', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'C020005', '操作系统版本', '70', '90', '81', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('15', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'Z002001', '数据唯一标识', '80', '90', '76', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('16', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'Z002000', '大协议名', '70', '80', '56', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('25', '111', 'WA_SOURCE_0001', '1000001', '02', '200', '220040B', '归一化认证账号', '120', '143', '176', '2018-08-28');
INSERT INTO `t_input_log_detail` VALUES ('26', '111', 'WA_SOURCE_0001', '1000001', '02', '200', 'Z002005', 'todo', '150', '123', '125', '2018-08-28');
INSERT INTO `t_input_log_detail` VALUES ('27', '111', 'WA_SOURCE_0001', '1000001', '02', '200', 'B050005', '发送方名称', '160', '138', '153', '2018-08-28');
INSERT INTO `t_input_log_detail` VALUES ('28', '111', 'WA_SOURCE_0001', '1000001', '02', '200', 'Z002007', '日志标识', '110', '152', '161', '2018-08-28');
INSERT INTO `t_input_log_detail` VALUES ('29', '111', 'WA_SOURCE_0001', '1000001', '02', '200', 'C020005', '操作系统版本', '123', '139', '132', '2018-08-28');
INSERT INTO `t_input_log_detail` VALUES ('30', '111', 'WA_SOURCE_0001', '1000001', '02', '200', 'Z002001', '数据唯一标识', '109', '129', '154', '2018-08-28');
INSERT INTO `t_input_log_detail` VALUES ('31', '111', 'WA_SOURCE_0001', '1000001', '02', '200', 'Z002000', '大协议名', '112', '109', '134', '2018-08-28');
INSERT INTO `t_input_log_detail` VALUES ('32', '111', 'WA_SOURCE_0001', '1000001', '02', '300', '220040B', '归一化认证账号', '234', '109', '0', '2018-08-27');
INSERT INTO `t_input_log_detail` VALUES ('33', '111', 'WA_SOURCE_0001', '1000001', '02', '300', 'Z002005', 'todo', '214', '188', '0', '2018-08-27');
INSERT INTO `t_input_log_detail` VALUES ('34', '111', 'WA_SOURCE_0001', '1000001', '02', '300', 'B050005', '发送方名称', '187', '145', '0', '2018-08-27');
INSERT INTO `t_input_log_detail` VALUES ('35', '111', 'WA_SOURCE_0001', '1000001', '02', '300', 'Z002007', '日志标识', '156', '231', '0', '2018-08-27');
INSERT INTO `t_input_log_detail` VALUES ('36', '111', 'WA_SOURCE_0001', '1000001', '02', '300', 'C020005', '操作系统版本', '273', '214', '0', '2018-08-27');
INSERT INTO `t_input_log_detail` VALUES ('37', '111', 'WA_SOURCE_0001', '1000001', '02', '300', 'Z002001', '数据唯一标识', '241', '256', '0', '2018-08-27');
INSERT INTO `t_input_log_detail` VALUES ('38', '111', 'WA_SOURCE_0001', '1000001', '02', '300', 'Z002000', '大协议名', '290', '276', '0', '2018-08-27');
INSERT INTO `t_input_log_detail` VALUES ('39', '111', 'WA_SOURCE_0001', '1000001', '02', '400', '220040B', '归一化认证账号', '215', '331', '145', '2018-08-26');
INSERT INTO `t_input_log_detail` VALUES ('40', '111', 'WA_SOURCE_0001', '1000001', '02', '400', 'Z002005', 'todo', '278', '245', '231', '2018-08-26');
INSERT INTO `t_input_log_detail` VALUES ('41', '111', 'WA_SOURCE_0001', '1000001', '02', '400', 'B050005', '发送方名称', '345', '276', '278', '2018-08-26');
INSERT INTO `t_input_log_detail` VALUES ('42', '111', 'WA_SOURCE_0001', '1000001', '02', '400', 'Z002007', '日志标识', '398', '254', '143', '2018-08-26');
INSERT INTO `t_input_log_detail` VALUES ('43', '111', 'WA_SOURCE_0001', '1000001', '02', '400', 'C020005', '操作系统版本', '365', '345', '234', '2018-08-26');
INSERT INTO `t_input_log_detail` VALUES ('44', '111', 'WA_SOURCE_0001', '1000001', '02', '400', 'Z002001', '数据唯一标识', '312', '324', '325', '2018-08-26');
INSERT INTO `t_input_log_detail` VALUES ('45', '111', 'WA_SOURCE_0001', '1000001', '02', '400', 'Z002000', '大协议名', '278', '336', '332', '2018-08-26');
INSERT INTO `t_input_log_detail` VALUES ('46', '111', 'WA_SOURCE_0001', '1000001', '02', '500', '220040B', '归一化认证账号', '254', '438', '314', '2018-08-25');
INSERT INTO `t_input_log_detail` VALUES ('47', '111', 'WA_SOURCE_0001', '1000001', '02', '500', 'Z002005', 'todo', '443', '455', '378', '2018-08-25');
INSERT INTO `t_input_log_detail` VALUES ('48', '111', 'WA_SOURCE_0001', '1000001', '02', '500', 'B050005', '发送方名称', '478', '379', '455', '2018-08-25');
INSERT INTO `t_input_log_detail` VALUES ('49', '111', 'WA_SOURCE_0001', '1000001', '02', '500', 'Z002007', '日志标识', '421', '421', '491', '2018-08-25');
INSERT INTO `t_input_log_detail` VALUES ('50', '111', 'WA_SOURCE_0001', '1000001', '02', '500', 'C020005', '操作系统版本', '398', '381', '431', '2018-08-25');
INSERT INTO `t_input_log_detail` VALUES ('51', '111', 'WA_SOURCE_0001', '1000001', '02', '500', 'Z002001', '数据唯一标识', '367', '399', '387', '2018-08-25');
INSERT INTO `t_input_log_detail` VALUES ('52', '111', 'WA_SOURCE_0001', '1000001', '02', '500', 'Z002000', '大协议名', '456', '412', '434', '2018-08-25');
INSERT INTO `t_input_log_detail` VALUES ('53', '111', 'WA_SOURCE_0001', '1000002', '01', '100', '220040B', '归一化认证账号', '0', '0', '0', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('54', '111', 'WA_SOURCE_0001', '1000002', '01', '100', 'Z002005', 'todo', '0', '0', '0', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('55', '111', 'WA_SOURCE_0001', '1000002', '01', '100', 'B050005', '发送方名称', '0', '0', '0', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('56', '111', 'WA_SOURCE_0001', '1000002', '01', '100', 'Z002007', '日志标识', '0', '0', '0', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('57', '111', 'WA_SOURCE_0001', '1000002', '01', '100', 'C020005', '操作系统版本', '0', '0', '0', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('58', '111', 'WA_SOURCE_0001', '1000002', '01', '100', 'Z002001', '数据唯一标识', '0', '0', '0', '2018-08-29');
INSERT INTO `t_input_log_detail` VALUES ('59', '111', 'WA_SOURCE_0001', '1000002', '01', '100', 'Z002000', '大协议名', '0', '0', '0', '2018-08-29');

-- ----------------------------
-- Table structure for `t_input_log_detail_total`
-- ----------------------------
DROP TABLE IF EXISTS `t_input_log_detail_total`;
CREATE TABLE `t_input_log_detail_total` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dsCode` varchar(50) DEFAULT '' COMMENT '数据源编号',
  `bProtocolCode` varchar(50) DEFAULT NULL COMMENT '大协议编码',
  `sProtocolCode` varchar(50) DEFAULT '' COMMENT '小协议编号',
  `actionType` varchar(50) DEFAULT '' COMMENT '小协议动作类型',
  `dataNum` bigint(20) DEFAULT '0' COMMENT '小协议数据条数',
  `fieldCode` varchar(50) DEFAULT '' COMMENT '字段编码',
  `fieldDesc` varchar(100) DEFAULT '' COMMENT '字段描述',
  `fillNum` bigint(20) DEFAULT '0' COMMENT '填充条数',
  `accurateNum` bigint(20) DEFAULT '0' COMMENT '准确条数',
  `codeMatchNum` bigint(20) DEFAULT '0' COMMENT '代码符合条数',
  `createDate` date DEFAULT NULL COMMENT '数据生成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_input_log_detail_total
-- ----------------------------
INSERT INTO `t_input_log_detail_total` VALUES ('10', '111', 'WA_SOURCE_0001', '1000001', '02', '100', '220040B', '归一化认证账号', '80', '100', '43', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('11', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'Z002005', 'todo', '70', '60', '76', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('12', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'B050005', '发送方名称', '70', '90', '87', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('13', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'Z002007', '日志标识', '60', '80', '69', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('14', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'C020005', '操作系统版本', '70', '90', '81', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('15', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'Z002001', '数据唯一标识', '80', '90', '76', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('16', '111', 'WA_SOURCE_0001', '1000001', '02', '100', 'Z002000', '大协议名', '70', '80', '56', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('25', '111', 'WA_SOURCE_0001', '1000002', '01', '200', '220040B', '归一化认证账号', '120', '143', '176', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('26', '111', 'WA_SOURCE_0001', '1000002', '01', '200', 'Z002005', 'todo', '150', '123', '125', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('27', '111', 'WA_SOURCE_0001', '1000002', '01', '200', 'B050005', '发送方名称', '160', '138', '153', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('28', '111', 'WA_SOURCE_0001', '1000002', '01', '200', 'Z002007', '日志标识', '110', '152', '161', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('29', '111', 'WA_SOURCE_0001', '1000002', '01', '200', 'C020005', '操作系统版本', '123', '139', '132', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('30', '111', 'WA_SOURCE_0001', '1000002', '01', '200', 'Z002001', '数据唯一标识', '109', '129', '154', '2018-08-29');
INSERT INTO `t_input_log_detail_total` VALUES ('31', '111', 'WA_SOURCE_0001', '1000002', '01', '200', 'Z002000', '大协议名', '112', '109', '134', '2018-08-29');

-- ----------------------------
-- Table structure for `t_input_log_total`
-- ----------------------------
DROP TABLE IF EXISTS `t_input_log_total`;
CREATE TABLE `t_input_log_total` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dataSet` varchar(100) DEFAULT '' COMMENT '数据集',
  `dsCode` varchar(100) DEFAULT '' COMMENT '数据源编码',
  `dsDesc` varchar(300) DEFAULT '' COMMENT '数据源描述',
  `bProtocolCode` varchar(100) DEFAULT '' COMMENT '大协议编号',
  `bProtocolDesc` varchar(300) DEFAULT '' COMMENT '大协议描述',
  `totalNum` int(11) DEFAULT '0' COMMENT '总条数',
  `inputNum` int(11) DEFAULT '0' COMMENT '入库条数',
  `inputRate` varchar(50) DEFAULT '' COMMENT '入库率',
  `fieldNum` int(11) DEFAULT '0' COMMENT '字段数',
  `accurateNum` int(11) DEFAULT '0' COMMENT '数据准确条数',
  `accuracy` varchar(50) DEFAULT '' COMMENT '数据准确率',
  `createDate` date DEFAULT NULL COMMENT '数据生成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_input_log_total
-- ----------------------------
INSERT INTO `t_input_log_total` VALUES ('9', '', '111', '固网', 'WA_SOURCE_0001', '网页访问(HTTP)', '100', '76', '0.76', '70', '100', '0.99', '2018-08-29');
INSERT INTO `t_input_log_total` VALUES ('10', '', '111', '固网', 'WA_SOURCE_0002', '电子邮件(EMAIL)', '190', '87', '0.87', '60', '80', '0.87', '2018-08-29');
INSERT INTO `t_input_log_total` VALUES ('11', '', '111', '固网', 'WA_SOURCE_0005', '即时通信(IM)', '120', '56', '0.54', '80', '74', '0.64', '2018-08-29');
INSERT INTO `t_input_log_total` VALUES ('12', '', '124', '无线', 'WA_SOURCE_0001', '网页访问(HTTP)', '160', '45', '0.55', '80', '75', '0.55', '2018-08-29');
INSERT INTO `t_input_log_total` VALUES ('13', '', '124', '无线', 'WA_SOURCE_0002', '电子邮件(EMAIL)', '150', '43', '0.98', '69', '77', '0.93', '2018-08-29');
INSERT INTO `t_input_log_total` VALUES ('14', '', '124', '无线', 'WA_SOURCE_0005', '即时通信(IM)', '180', '45', '0.79', '67', '78', '0.71', '2018-08-29');

-- ----------------------------
-- Table structure for `t_obj_quality`
-- ----------------------------
DROP TABLE IF EXISTS `t_obj_quality`;
CREATE TABLE `t_obj_quality` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dsCode` varchar(100) DEFAULT '' COMMENT '数据源编码',
  `aspectCode` varchar(100) DEFAULT '' COMMENT '特征串编码',
  `aspectNum` bigint(11) DEFAULT '0' COMMENT '特征串数量',
  `errorNum` bigint(11) DEFAULT '0' COMMENT '错误总条数',
  `netExtractNum` bigint(11) DEFAULT '0' COMMENT '净提取关系总个数',
  `phoneReNum` bigint(11) DEFAULT '0' COMMENT '手机号关联数量',
  `idCardReNum` bigint(11) DEFAULT '0' COMMENT '身份证关联数量',
  `adslReNum` bigint(11) DEFAULT '0' COMMENT 'ADSL关联总量',
  `imeiReNum` bigint(11) DEFAULT '0' COMMENT 'IMEI关联总量',
  `imsiReNum` bigint(11) DEFAULT '0' COMMENT 'IMSI关联总量',
  `macReNum` bigint(11) DEFAULT '0' COMMENT 'MAC关联总量',
  `createDate` date DEFAULT NULL COMMENT '数据产生日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_obj_quality
-- ----------------------------
INSERT INTO `t_obj_quality` VALUES ('1', '111', 'A3D1143', '1000', '1000', '1000', '1000', '1000', '1000', '1000', '1000', '1000', '2018-08-29');
INSERT INTO `t_obj_quality` VALUES ('2', '111', 'A3D1143', '900', '900', '900', '900', '900', '900', '900', '900', '900', '2018-08-28');
INSERT INTO `t_obj_quality` VALUES ('3', '111', 'A3D1143', '800', '800', '800', '800', '800', '800', '800', '800', '800', '2018-08-27');
INSERT INTO `t_obj_quality` VALUES ('4', '111', 'A3D1143', '700', '700', '2700', '700', '700', '700', '700', '700', '700', '2018-08-26');
INSERT INTO `t_obj_quality` VALUES ('179', '111', 'A3D1143', '600', '600', '600', '600', '600', '600', '600', '600', '600', '2018-08-25');

-- ----------------------------
-- Table structure for `t_obj_quality_more`
-- ----------------------------
DROP TABLE IF EXISTS `t_obj_quality_more`;
CREATE TABLE `t_obj_quality_more` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `srcId` bigint(20) DEFAULT NULL COMMENT '源id',
  `name` varchar(255) DEFAULT '' COMMENT '字段名',
  `count` bigint(20) DEFAULT '0' COMMENT '字段值',
  `createDate` date DEFAULT NULL COMMENT '数据生成日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_obj_quality_more
-- ----------------------------

-- ----------------------------
-- Table structure for `t_obj_quality_more_total`
-- ----------------------------
DROP TABLE IF EXISTS `t_obj_quality_more_total`;
CREATE TABLE `t_obj_quality_more_total` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `srcId` bigint(20) DEFAULT NULL COMMENT '源id',
  `fieldCode` varchar(255) DEFAULT '' COMMENT '字段名',
  `count` bigint(20) DEFAULT '0' COMMENT '字段值',
  `createDate` date DEFAULT NULL COMMENT '数据生成日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_obj_quality_more_total
-- ----------------------------
INSERT INTO `t_obj_quality_more_total` VALUES ('6', '1', 'Z002095', '12', '2018-08-29');
INSERT INTO `t_obj_quality_more_total` VALUES ('7', '1', 'H010034', '43', '2018-08-29');
INSERT INTO `t_obj_quality_more_total` VALUES ('8', '1', 'Z0021CB', '34', '2018-08-29');
INSERT INTO `t_obj_quality_more_total` VALUES ('9', '2', 'Z002095', '35', '2018-08-29');
INSERT INTO `t_obj_quality_more_total` VALUES ('10', '2', 'H010034', '45', '2018-08-29');
INSERT INTO `t_obj_quality_more_total` VALUES ('11', '2', 'Z0021CB', '45', '2018-08-29');
INSERT INTO `t_obj_quality_more_total` VALUES ('13', '3', 'Z002095', '76', '2018-08-29');
INSERT INTO `t_obj_quality_more_total` VALUES ('14', '3', 'H010034', '54', '2018-08-29');
INSERT INTO `t_obj_quality_more_total` VALUES ('15', '3', 'Z0021CB', '56', '2018-08-29');
INSERT INTO `t_obj_quality_more_total` VALUES ('16', '4', 'Z002095', '43', '2018-08-29');
INSERT INTO `t_obj_quality_more_total` VALUES ('17', '4', 'H010034', '23', '2018-08-29');
INSERT INTO `t_obj_quality_more_total` VALUES ('18', '4', 'Z0021CB', '43', '2018-08-29');

-- ----------------------------
-- Table structure for `t_obj_quality_total`
-- ----------------------------
DROP TABLE IF EXISTS `t_obj_quality_total`;
CREATE TABLE `t_obj_quality_total` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dsCode` varchar(100) DEFAULT '' COMMENT '数据源编码',
  `aspectCode` varchar(100) DEFAULT '' COMMENT '特征串编码',
  `aspectNum` bigint(11) DEFAULT '0' COMMENT '特征串数量',
  `errorNum` bigint(11) DEFAULT '0' COMMENT '错误总条数',
  `netExtractNum` bigint(11) DEFAULT '0' COMMENT '净提取关系总个数',
  `phoneReNum` bigint(11) DEFAULT '0' COMMENT '手机号关联数量',
  `idCardReNum` bigint(11) DEFAULT '0' COMMENT '身份证关联数量',
  `adslReNum` bigint(11) DEFAULT '0' COMMENT 'ADSL关联总量',
  `imeiReNum` bigint(11) DEFAULT '0' COMMENT 'IMEI关联总量',
  `imsiReNum` bigint(11) DEFAULT '0' COMMENT 'IMSI关联总量',
  `macReNum` bigint(11) DEFAULT '0' COMMENT 'MAC关联总量',
  `createDate` date DEFAULT NULL COMMENT '数据产生日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_obj_quality_total
-- ----------------------------
INSERT INTO `t_obj_quality_total` VALUES ('1', '111', 'A3D1143', '213', '34', '0', '0', '0', '0', '0', '0', '0', '2018-08-29');
INSERT INTO `t_obj_quality_total` VALUES ('2', '111', 'A3D1000', '1213', '54', '0', '0', '0', '0', '0', '0', '0', '2018-08-29');
INSERT INTO `t_obj_quality_total` VALUES ('3', '111', 'A3D1142', '1062', '12', '0', '0', '0', '0', '0', '0', '0', '2018-08-29');
INSERT INTO `t_obj_quality_total` VALUES ('4', '111', 'A3D0474', '823', '54', '2', '0', '0', '0', '0', '0', '0', '2018-08-29');

-- ----------------------------
-- Table structure for `t_trans`
-- ----------------------------
DROP TABLE IF EXISTS `t_trans`;
CREATE TABLE `t_trans` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `dsCode` varchar(50) DEFAULT '' COMMENT '数据源编号',
  `dsDesc` varchar(300) DEFAULT '' COMMENT '数据源描述',
  `bProtocolCode` varchar(50) DEFAULT '' COMMENT '大协议编码',
  `bProtocolDesc` varchar(50) DEFAULT '' COMMENT '大协议描述',
  `sProtocolCode` varchar(50) DEFAULT '' COMMENT '小协议编码',
  `sProtocolDesc` varchar(50) DEFAULT '' COMMENT '小协议描述',
  `actionType` varchar(20) DEFAULT '' COMMENT '动作类型',
  `inputNum` bigint(20) DEFAULT '0' COMMENT '输入数据条数',
  `inputSpeed` bigint(20) DEFAULT '0' COMMENT '输入数据速度',
  `inputFieldNum` bigint(20) DEFAULT '0' COMMENT '输入数据字段填充条数',
  `inputFieldRate` varchar(50) DEFAULT '' COMMENT '输入数据字段填充率',
  `inputGroupNum` bigint(20) DEFAULT '0' COMMENT '输入数据依赖字段组填充条数',
  `inputGroupRate` varchar(50) DEFAULT '' COMMENT '输入数据依赖字段组填充率',
  `inputFieldAvailNum` bigint(20) DEFAULT '0' COMMENT '输入数据字段可用条数',
  `inputFieldAvailRate` varchar(50) DEFAULT '' COMMENT '输入数据字段可用率',
  `inputGroupAvailNum` bigint(20) DEFAULT '0' COMMENT '输入数据依赖字段组可用条数',
  `inputGroupAvailRate` varchar(50) DEFAULT '' COMMENT '输入数据依赖字段组可用率',
  `inputAccurateNum` bigint(20) DEFAULT '0' COMMENT '输入数据准确条数',
  `inputAccuracy` varchar(50) DEFAULT '' COMMENT '输入数据准确率',
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_trans
-- ----------------------------
INSERT INTO `t_trans` VALUES ('17', '111', '固网', 'bp_0001', '大协议测试1', 'sp_0001', '小协议测试1', '01', '2000', '600', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '2018-08-29');
INSERT INTO `t_trans` VALUES ('23', '111', '固网', 'bp_0001', '大协议测试1', 'sp_0001', '小协议测试1', '01', '2000', '600', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '2018-08-28');
INSERT INTO `t_trans` VALUES ('24', '111', '固网', 'bp_0001', '大协议测试1', 'sp_0001', '小协议测试1', '01', '2000', '600', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '2018-08-27');
INSERT INTO `t_trans` VALUES ('25', '111', '固网', 'bp_0001', '大协议测试1', 'sp_0001', '小协议测试1', '01', '2000', '600', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '2018-08-26');
INSERT INTO `t_trans` VALUES ('26', '111', '固网', 'bp_0001', '大协议测试1', 'sp_0001', '小协议测试1', '01', '2000', '600', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '2018-08-25');

-- ----------------------------
-- Table structure for `t_trans_total`
-- ----------------------------
DROP TABLE IF EXISTS `t_trans_total`;
CREATE TABLE `t_trans_total` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `dsCode` varchar(50) DEFAULT '' COMMENT '数据源编号',
  `dsDesc` varchar(300) DEFAULT '' COMMENT '数据源描述',
  `bProtocolCode` varchar(50) DEFAULT '' COMMENT '大协议编码',
  `bProtocolDesc` varchar(50) DEFAULT '' COMMENT '大协议描述',
  `sProtocolCode` varchar(50) DEFAULT '' COMMENT '小协议编码',
  `sProtocolDesc` varchar(50) DEFAULT '' COMMENT '小协议描述',
  `actionType` varchar(20) DEFAULT '' COMMENT '动作类型',
  `inputNum` bigint(20) DEFAULT '0' COMMENT '输入数据条数',
  `inputSpeed` bigint(20) DEFAULT '0' COMMENT '输入数据速度',
  `inputFieldNum` bigint(20) DEFAULT '0' COMMENT '输入数据字段填充条数',
  `inputFieldRate` varchar(50) DEFAULT '' COMMENT '输入数据字段填充率',
  `inputGroupNum` bigint(20) DEFAULT '0' COMMENT '输入数据依赖字段组填充条数',
  `inputGroupRate` varchar(50) DEFAULT '' COMMENT '输入数据依赖字段组填充率',
  `inputFieldAvailNum` bigint(20) DEFAULT '0' COMMENT '输入数据字段可用条数',
  `inputFieldAvailRate` varchar(50) DEFAULT '' COMMENT '输入数据字段可用率',
  `inputGroupAvailNum` bigint(20) DEFAULT '0' COMMENT '输入数据依赖字段组可用条数',
  `inputGroupAvailRate` varchar(50) DEFAULT '' COMMENT '输入数据依赖字段组可用率',
  `inputAccurateNum` bigint(20) DEFAULT '0' COMMENT '输入数据准确条数',
  `inputAccuracy` varchar(50) DEFAULT '' COMMENT '输入数据准确率',
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_trans_total
-- ----------------------------
INSERT INTO `t_trans_total` VALUES ('17', '111', '固网', 'bp_0001', '大协议测试1', 'sp_0001', '小协议测试1', '01', '10000', '600', '1000', '0.1', '1000', '0.1', '1000', '0.1', '1000', '0.1', '1000', '0.1', '2018-08-29');
INSERT INTO `t_trans_total` VALUES ('18', '120', '网吧', 'bp_0002', '大协议测试2', 'sp_0002', '小协议测试2', '02', '10000', '600', '2000', '0.2', '2000', '0.2', '2000', '0.2', '2000', '0.2', '2000', '0.2', '2018-08-29');
INSERT INTO `t_trans_total` VALUES ('19', '119', 'IDC', 'bp_0003', '大协议测试3', 'sp_0003', '小协议测试3', '03', '10000', '600', '3000', '0.3', '3000', '0.3', '3000', '0.3', '3000', '0.3', '3000', '0.3', '2018-08-29');
INSERT INTO `t_trans_total` VALUES ('20', '124', '无线', 'bp_0004', '大协议测试4', 'sp_0004', '小协议测试4', '04', '10000', '600', '4000', '0.4', '4000', '0.4', '4000', '0.4', '4000', '0.4', '4000', '0.4', '2018-08-29');
INSERT INTO `t_trans_total` VALUES ('21', '125', '小区', 'bp_0005', '大协议测试5', 'sp_0005', '小协议测试5', '05', '10000', '600', '5000', '0.5', '5000', '0.5', '5000', '0.5', '5000', '0.5', '5000', '0.5', '2018-08-29');
INSERT INTO `t_trans_total` VALUES ('22', '139', 'WIFI', 'bp_0006', '大协议测试6', 'sp_0006', '小协议测试6', '06', '10000', '600', '6000', '0.6', '6000', '0.6', '6000', '0.6', '6000', '0.6', '6000', '0.6', '2018-08-29');
INSERT INTO `t_trans_total` VALUES ('23', '111', '固网', 'bp_0001', '大协议测试1', 'sp_0001', '小协议测试1', '02', '1000', '60', '100', '0.1', '100', '0.1', '100', '0.1', '100', '0.1', '100', '0.1', '2018-08-29');

-- ----------------------------
-- Table structure for `t_ycl`
-- ----------------------------
DROP TABLE IF EXISTS `t_ycl`;
CREATE TABLE `t_ycl` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `dsCode` varchar(50) DEFAULT '' COMMENT '数据源编号',
  `dsDesc` varchar(300) DEFAULT '' COMMENT '数据源描述',
  `bProtocolCode` varchar(50) DEFAULT '' COMMENT '大协议编码',
  `bProtocolDesc` varchar(50) DEFAULT '' COMMENT '大协议描述',
  `sProtocolCode` varchar(50) DEFAULT '' COMMENT '小协议编码',
  `sProtocolDesc` varchar(50) DEFAULT '' COMMENT '小协议描述',
  `actionType` varchar(50) DEFAULT '' COMMENT '动作类型',
  `inputNum` bigint(20) DEFAULT '0' COMMENT '输入数据条数',
  `inputFeildNum` bigint(20) DEFAULT '0' COMMENT '输入数据字段填充条数',
  `inputFieldRate` varchar(50) DEFAULT '' COMMENT '输入数据字段填充率',
  `inputGroupNum` bigint(20) DEFAULT '0' COMMENT '输入数据依赖字段组填充条数',
  `inputGroupRate` varchar(50) DEFAULT '' COMMENT '输入数据依赖字段组填充率',
  `inputFieldAvailNum` bigint(20) DEFAULT '0' COMMENT '输入数据字段可用条数',
  `inputFieldAvailRate` varchar(20) DEFAULT '' COMMENT '输入数据字段可用率',
  `inputGroupAvailNum` bigint(20) DEFAULT '0' COMMENT '输入数据依赖字段组可用条数',
  `inputGroupAvailRate` varchar(50) DEFAULT '' COMMENT '输入数据依赖字段组可用率',
  `inputAccurateNum` bigint(20) DEFAULT '0' COMMENT '输入数据准确条数',
  `inputAccuracy` varchar(50) DEFAULT '' COMMENT '输入数据准确率',
  `outputNum` bigint(20) DEFAULT '0' COMMENT '输出数据条数',
  `outputSpeed` varchar(50) DEFAULT '' COMMENT '输出数据速率',
  `outputFieldNum` bigint(20) DEFAULT '0' COMMENT '输出字段填充条数',
  `outputFieldRate` varchar(50) DEFAULT '' COMMENT '输出数据字段填充率',
  `outputGroupNum` bigint(20) DEFAULT '0' COMMENT '输出数据依赖字段组填充条数',
  `outputGroupRate` varchar(50) DEFAULT '' COMMENT '输出数据依赖字段组填充率',
  `createDate` date DEFAULT NULL COMMENT '数据产生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ycl
-- ----------------------------
INSERT INTO `t_ycl` VALUES ('1', '111', '固网', 'bc0001', '大协议测试1', 'sc0001', '小协议测试1', '01', '2000', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '600', '200', '0.1', '200', '0.1', '2018-08-29');
INSERT INTO `t_ycl` VALUES ('9', '111', '固网', 'bc0001', '大协议测试1', 'sc0001', '小协议测试1', '01', '2000', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '600', '200', '0.1', '200', '0.1', '2018-08-28');
INSERT INTO `t_ycl` VALUES ('10', '111', '固网', 'bc0001', '大协议测试1', 'sc0001', '小协议测试1', '01', '2000', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '600', '200', '0.1', '200', '0.1', '2018-08-27');
INSERT INTO `t_ycl` VALUES ('11', '111', '固网', 'bc0001', '大协议测试1', 'sc0001', '小协议测试1', '01', '2000', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '600', '200', '0.1', '200', '0.1', '2018-08-26');
INSERT INTO `t_ycl` VALUES ('12', '111', '固网', 'bc0001', '大协议测试1', 'sc0001', '小协议测试1', '01', '2000', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '0.1', '200', '600', '200', '0.1', '200', '0.1', '2018-08-25');

-- ----------------------------
-- Table structure for `t_ycl_example`
-- ----------------------------
DROP TABLE IF EXISTS `t_ycl_example`;
CREATE TABLE `t_ycl_example` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `dsCode` varchar(50) DEFAULT '' COMMENT '数据源编码',
  `bProtocolCode` varchar(300) DEFAULT '' COMMENT '大协议编码',
  `sourceDesc` varchar(50) DEFAULT '' COMMENT '来源描述',
  `authentNumber` varchar(50) DEFAULT '' COMMENT '认证号码',
  `authenType` varchar(50) DEFAULT '' COMMENT '认证类型',
  `senderName` varchar(50) DEFAULT '' COMMENT '发送者名称',
  `receiverName` varchar(50) DEFAULT '' COMMENT '接受者名称',
  `baseStation` varchar(50) DEFAULT '' COMMENT '基站',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ycl_example
-- ----------------------------
INSERT INTO `t_ycl_example` VALUES ('1', '111', 'bc0001', '0', '5456798441', '12', 'sdadsad', 'fsdfdsff', '1233');
INSERT INTO `t_ycl_example` VALUES ('2', '111', 'bc0001', '0', '34243234', '12', 'dfsfsdffg', 'ewrewr', '1234');
INSERT INTO `t_ycl_example` VALUES ('3', '111', 'bc0001', '0', '3243432', '12', 'ffdsfgffg', 'qwewee', '1343');
INSERT INTO `t_ycl_example` VALUES ('4', '111', 'bc0001', '0', '324434343', '12', 'dfsdfddf', 'dfsfdsfs', '1245');
INSERT INTO `t_ycl_example` VALUES ('5', '111', 'bc0001', '0', '42354354', '12', 'fgsfgsfdg', 'dfsdfsf', '1432');
INSERT INTO `t_ycl_example` VALUES ('6', '111', 'bc0001', '1', '343545453', '12', 'fsdfsfgsff', 'dreafdf', '3245');
INSERT INTO `t_ycl_example` VALUES ('7', '111', 'bc0001', '1', '432434345', '12', 'gfsdgr', 'fsddfdf', '3452');
INSERT INTO `t_ycl_example` VALUES ('12', '111', 'bc0001', '1', '242343454', '12', 'fdsffdsffsd', 'dsfadds', '3243');
INSERT INTO `t_ycl_example` VALUES ('13', '111', 'bc0001', '1', '342342354', '12', 'afdsff', 'fdsfsffds', '2343');
INSERT INTO `t_ycl_example` VALUES ('14', '111', 'bc0001', '1', '324324344', '12', 'fadsfsdfds', 'sasfdasf', '2344');

-- ----------------------------
-- Table structure for `t_ycl_total`
-- ----------------------------
DROP TABLE IF EXISTS `t_ycl_total`;
CREATE TABLE `t_ycl_total` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `dsCode` varchar(50) DEFAULT '' COMMENT '数据源编号',
  `dsDesc` varchar(300) DEFAULT '' COMMENT '数据源描述',
  `bProtocolCode` varchar(50) DEFAULT '' COMMENT '大协议编码',
  `bProtocolDesc` varchar(50) DEFAULT '' COMMENT '大协议描述',
  `sProtocolCode` varchar(50) DEFAULT '' COMMENT '小协议编码',
  `sProtocolDesc` varchar(50) DEFAULT '' COMMENT '小协议描述',
  `actionType` varchar(50) DEFAULT '' COMMENT '动作类型',
  `inputNum` bigint(20) DEFAULT '0' COMMENT '输入数据条数',
  `inputFeildNum` bigint(20) DEFAULT '0' COMMENT '输入数据字段填充条数',
  `inputFieldRate` varchar(50) DEFAULT '' COMMENT '输入数据字段填充率',
  `inputGroupNum` bigint(20) DEFAULT '0' COMMENT '输入数据依赖字段组填充条数',
  `inputGroupRate` varchar(50) DEFAULT '' COMMENT '输入数据依赖字段组填充率',
  `inputFieldAvailNum` bigint(20) DEFAULT '0' COMMENT '输入数据字段可用条数',
  `inputFieldAvailRate` varchar(20) DEFAULT '' COMMENT '输入数据字段可用率',
  `inputGroupAvailNum` bigint(20) DEFAULT '0' COMMENT '输入数据依赖字段组可用条数',
  `inputGroupAvailRate` varchar(50) DEFAULT '' COMMENT '输入数据依赖字段组可用率',
  `inputAccurateNum` bigint(20) DEFAULT '0' COMMENT '输入数据准确条数',
  `inputAccuracy` varchar(50) DEFAULT '' COMMENT '输入数据准确率',
  `outputNum` bigint(20) DEFAULT '0' COMMENT '输出数据条数',
  `outputSpeed` varchar(50) DEFAULT '' COMMENT '输出数据速率',
  `outputFieldNum` bigint(20) DEFAULT '0' COMMENT '输出字段填充条数',
  `outputFieldRate` varchar(50) DEFAULT '' COMMENT '输出数据字段填充率',
  `outputGroupNum` bigint(20) DEFAULT '0' COMMENT '输出数据依赖字段组填充条数',
  `outputGroupRate` varchar(50) DEFAULT '' COMMENT '输出数据依赖字段组填充率',
  `createDate` date DEFAULT NULL COMMENT '数据产生时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ycl_total
-- ----------------------------
INSERT INTO `t_ycl_total` VALUES ('1', '111', '固网', 'bc0001', '大协议测试1', 'sc0001', '小协议测试1', '01', '10000', '1000', '0.1', '1000', '0.1', '1000', '0.1', '1000', '0.1', '1000', '0.1', '10000', '600', '1000', '0.1', '1000', '0.1', '2018-08-29');
INSERT INTO `t_ycl_total` VALUES ('2', '114', '4G', 'bc0002', '大协议测试2', 'sc0002', '小协议测试2', '02', '10000', '2000', '0.2', '2000', '0.2', '2000', '0.2', '2000', '0.2', '2000', '0.2', '10000', '600', '2000', '0.2', '2000', '0.2', '2018-08-29');
INSERT INTO `t_ycl_total` VALUES ('3', '119', 'IDC', 'bc0003', '大协议测试3', 'sc0003', '小协议测试3', '03', '10000', '3000', '0.3', '3000', '0.3', '3000', '0.3', '3000', '0.3', '3000', '0.3', '10000', '600', '3000', '0.3', '3000', '0.3', '2018-08-29');
INSERT INTO `t_ycl_total` VALUES ('4', '120', '网吧', 'bc0004', '大协议测试4', 'sc0004', '小协议测试4', '04', '10000', '4000', '0.4', '4000', '0.4', '4000', '0.4', '4000', '0.4', '4000', '0.4', '10000', '600', '4000', '0.4', '4000', '0.4', '2018-08-29');
INSERT INTO `t_ycl_total` VALUES ('5', '124', '无线', 'bc0005', '大协议测试5', 'sc0005', '小协议测试5', '05', '10000', '5000', '0.5', '5000', '0.5', '5000', '0.5', '5000', '0.5', '5000', '0.5', '10000', '600', '5000', '0.5', '5000', '0.5', '2018-08-29');
INSERT INTO `t_ycl_total` VALUES ('6', '125', '小区', 'bc0006', '大协议测试6', 'sc0006', '小协议测试6', '06', '10000', '6000', '0.6', '6000', '0.6', '6000', '0.6', '6000', '0.6', '6000', '0.6', '10000', '600', '6000', '0.6', '6000', '0.6', '2018-08-29');

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : datakpi

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-29 10:20:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accessmonitor
-- ----------------------------
DROP TABLE IF EXISTS `accessmonitor`;
CREATE TABLE `accessmonitor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdate` date DEFAULT NULL COMMENT '创建时间',
  `input` bigint(20) DEFAULT NULL COMMENT '输入',
  `datasource` varchar(255) DEFAULT NULL COMMENT '数据源',
  `bprotocol` varchar(255) DEFAULT NULL COMMENT '大协议',
  `sprotocol` varchar(255) DEFAULT NULL COMMENT '小协议',
  `action` varchar(255) DEFAULT NULL COMMENT '动作',
  `discard` bigint(20) DEFAULT NULL,
  `discardreason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accessmonitor
-- ----------------------------
INSERT INTO `accessmonitor` VALUES ('1', '2018-08-08', '1888', '固网', '即时通讯', '陌陌', '动作', '333', '原因1');
INSERT INTO `accessmonitor` VALUES ('2', '2018-08-12', '1777', '大情报', '及时通讯', '微信', 'a', '444', '原因2');
INSERT INTO `accessmonitor` VALUES ('3', '2018-08-13', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('4', '2018-08-14', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('5', '2018-08-15', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('6', '2018-08-16', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('7', '2018-08-17', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('8', '2018-08-18', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('9', '2018-08-19', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('10', '2018-08-20', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('11', '2018-08-21', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('12', '2018-08-22', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('13', '2018-08-05', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('14', '2018-08-04', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('15', '2018-08-03', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('16', '2018-08-02', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');
INSERT INTO `accessmonitor` VALUES ('17', '2018-08-01', '3452', '微信', '及时通讯', 'QQ', 'a', '222', '原因3');

-- ----------------------------
-- Table structure for appqueryrecord
-- ----------------------------
DROP TABLE IF EXISTS `appqueryrecord`;
CREATE TABLE `appqueryrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `capturetime` datetime DEFAULT NULL COMMENT '调用时间',
  `sqlstr` varchar(4000) DEFAULT NULL COMMENT '调用语句',
  `protocol` varchar(255) DEFAULT NULL,
  `system_id` varchar(255) DEFAULT NULL COMMENT '调用系统ID（应用）',
  `status` bigint(2) DEFAULT NULL COMMENT '状态 0成功 1失败',
  `error_desc` varchar(255) DEFAULT NULL COMMENT '错误描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=gbk COMMENT='服务监测';

-- ----------------------------
-- Records of appqueryrecord
-- ----------------------------
INSERT INTO `appqueryrecord` VALUES ('1', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('2', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('3', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('4', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('5', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('6', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('7', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('8', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('9', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('10', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('11', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('12', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('13', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('14', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('15', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('16', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('17', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('18', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('19', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('20', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('21', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('22', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('23', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('24', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('25', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('26', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('27', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('28', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('29', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('30', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('31', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('32', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('33', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('34', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('35', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('36', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('37', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('38', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('39', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('40', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('41', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('42', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('43', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('44', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('45', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('46', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('47', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('48', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('49', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('50', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('51', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('52', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('53', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('54', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('55', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('56', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('57', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('58', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('59', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('60', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('61', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('62', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('63', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('64', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('65', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('66', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('67', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('68', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('69', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('70', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('71', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('72', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('73', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('74', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('75', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('76', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('77', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('78', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('79', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('80', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('81', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('82', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('83', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('84', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('85', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('86', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('87', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('88', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('89', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('90', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('91', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('92', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('93', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('94', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('95', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('96', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('97', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('98', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('99', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('100', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('101', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('102', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('103', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('104', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('105', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('106', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('107', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('108', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('109', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('110', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('111', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('112', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('113', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('114', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('115', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('116', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('117', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('118', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('119', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('120', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('121', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('122', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('123', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('124', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('125', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('126', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('127', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('128', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('129', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('130', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('131', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('132', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('133', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('134', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('135', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('136', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('137', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('138', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('139', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('140', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('141', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('142', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('143', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('144', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('145', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('146', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('147', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('148', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('149', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('150', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('151', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('152', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('153', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('154', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('155', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('156', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('157', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('158', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('159', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('160', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');
INSERT INTO `appqueryrecord` VALUES ('161', '2018-08-22 09:56:18', 'select * from hhh', 'p', '锐搜', '1', '调用异常');

-- ----------------------------
-- Table structure for backlog
-- ----------------------------
DROP TABLE IF EXISTS `backlog`;
CREATE TABLE `backlog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `machinebacklognum` bigint(20) DEFAULT NULL COMMENT '接口机积压数量',
  `machinebacklogsize` double DEFAULT NULL COMMENT '接口机积压大小',
  `kafkabacklognum` bigint(20) DEFAULT NULL COMMENT 'kafka积压数量',
  `kafkabacklogsize` double DEFAULT NULL COMMENT 'kafka积压大小',
  `createdate` date DEFAULT NULL COMMENT '采集时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='积压监测';

-- ----------------------------
-- Records of backlog
-- ----------------------------
INSERT INTO `backlog` VALUES ('1', '111', '222', '333', '222', '2018-08-06');
INSERT INTO `backlog` VALUES ('2', '123', '123', '223', '351', '2018-08-07');
INSERT INTO `backlog` VALUES ('3', '462', '176', '452', '289', '2018-08-08');
INSERT INTO `backlog` VALUES ('4', '475', '234', '135', '279', '2018-08-09');
INSERT INTO `backlog` VALUES ('5', '321', '579', '254', '170', '2018-08-10');
INSERT INTO `backlog` VALUES ('6', '178', '234', '378', '199', '2018-08-11');
INSERT INTO `backlog` VALUES ('7', '157', '342', '234', '768', '2018-08-12');
INSERT INTO `backlog` VALUES ('8', '789', '2342', '4234', '2355', '2018-08-13');
INSERT INTO `backlog` VALUES ('9', '457', '2344', '6573', '2234', '2018-08-14');
INSERT INTO `backlog` VALUES ('10', '234', '4332', '2223', '1235', '2018-08-15');

-- ----------------------------
-- Table structure for datastoremonitor
-- ----------------------------
DROP TABLE IF EXISTS `datastoremonitor`;
CREATE TABLE `datastoremonitor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datatype` int(2) DEFAULT NULL COMMENT '数据类型(1:资源库，2:对象库)',
  `store` bigint(20) DEFAULT NULL COMMENT '数据存储大小',
  `sourcename` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='数据存储检测';

-- ----------------------------
-- Records of datastoremonitor
-- ----------------------------
INSERT INTO `datastoremonitor` VALUES ('1', '1', '121', '虚拟身份库', '2018-08-01');
INSERT INTO `datastoremonitor` VALUES ('2', '1', '243', '终端硬件特征库', '2018-08-02');
INSERT INTO `datastoremonitor` VALUES ('3', '1', '651', '检查备案库', '2018-08-03');
INSERT INTO `datastoremonitor` VALUES ('4', '1', '932', '接入日志认证库', '2018-08-04');
INSERT INTO `datastoremonitor` VALUES ('5', '1', '121', '海量全文库', '2018-08-05');
INSERT INTO `datastoremonitor` VALUES ('6', '1', '243', '网络账号信息库', '2018-08-06');
INSERT INTO `datastoremonitor` VALUES ('7', '1', '651', '虚拟身份关联库', '2018-08-07');
INSERT INTO `datastoremonitor` VALUES ('8', '1', '932', '网名档案库', '2018-08-08');
INSERT INTO `datastoremonitor` VALUES ('9', '1', '121', '虚拟身份库', '2018-08-09');
INSERT INTO `datastoremonitor` VALUES ('10', '1', '243', '终端硬件特征库', '2018-08-10');
INSERT INTO `datastoremonitor` VALUES ('12', '1', '651', '检查备案库', '2018-08-11');
INSERT INTO `datastoremonitor` VALUES ('13', '1', '932', '接入日志认证库', '2018-08-12');
INSERT INTO `datastoremonitor` VALUES ('14', '1', '121', '海量全文库', '2018-08-13');
INSERT INTO `datastoremonitor` VALUES ('15', '1', '243', '网络账号信息库', '2018-08-14');
INSERT INTO `datastoremonitor` VALUES ('16', '1', '651', '虚拟身份关联库', '2018-08-15');
INSERT INTO `datastoremonitor` VALUES ('17', '1', '932', '网名档案库', '2018-08-16');
INSERT INTO `datastoremonitor` VALUES ('18', '2', '156', '手机号', '2018-08-01');
INSERT INTO `datastoremonitor` VALUES ('19', '2', '231', '手机号', '2018-08-01');
INSERT INTO `datastoremonitor` VALUES ('20', '2', '145', 'qq号', '2018-08-02');
INSERT INTO `datastoremonitor` VALUES ('21', '2', '167', '证件号', '2018-08-03');
INSERT INTO `datastoremonitor` VALUES ('22', '2', '376', '邮箱', '2018-08-04');
INSERT INTO `datastoremonitor` VALUES ('23', '2', '782', '虚拟账号', '2018-08-05');
INSERT INTO `datastoremonitor` VALUES ('24', '2', '476', '宽带账号', '2018-08-06');
INSERT INTO `datastoremonitor` VALUES ('25', '2', '319', 'MAC', '2018-08-07');
INSERT INTO `datastoremonitor` VALUES ('26', '2', '190', 'IMEI', '2018-08-08');
INSERT INTO `datastoremonitor` VALUES ('27', '2', '231', '手机号', '2018-08-02');
INSERT INTO `datastoremonitor` VALUES ('28', '2', '145', 'qq号', '2018-08-03');
INSERT INTO `datastoremonitor` VALUES ('29', '2', '167', '证件号', '2018-08-04');
INSERT INTO `datastoremonitor` VALUES ('30', '2', '376', '邮箱', '2018-08-05');
INSERT INTO `datastoremonitor` VALUES ('31', '2', '782', '虚拟账号', '2018-08-06');
INSERT INTO `datastoremonitor` VALUES ('32', '2', '476', '宽带账号', '2018-08-07');
INSERT INTO `datastoremonitor` VALUES ('33', '2', '319', 'MAC', '2018-08-15');
INSERT INTO `datastoremonitor` VALUES ('34', '2', '190', 'IMEI', '2018-08-15');

-- ----------------------------
-- Table structure for jobmonitor
-- ----------------------------
DROP TABLE IF EXISTS `jobmonitor`;
CREATE TABLE `jobmonitor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `TIMEKEY` varchar(10) DEFAULT NULL COMMENT '日期',
  `JOB_STATUS` varchar(2) DEFAULT NULL COMMENT '任务状态',
  `JOB_NAME` varchar(100) DEFAULT NULL COMMENT '任务名称',
  `START_TIME` varchar(20) DEFAULT NULL COMMENT '开始时间',
  `END_TIME` varchar(20) DEFAULT NULL COMMENT '结束时间',
  `INPUT_TIME` varchar(10) DEFAULT NULL COMMENT '入库时间',
  `HOSTIP` varchar(20) DEFAULT NULL COMMENT '服务器地址',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='任务监测';

-- ----------------------------
-- Records of jobmonitor
-- ----------------------------
INSERT INTO `jobmonitor` VALUES ('1', '2018-08-01', '3', 'test', '2018-08-01', '2018-08-01', '2018-08-01', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('2', '2018-08-01', '3', 'test', '2018-08-01', '2018-08-01', '2018-08-02', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('3', '2018-08-01', '3', 'test', '2018-08-01', '2018-08-01', '2018-08-03', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('4', '2018-08-01', '3', 'test', '2018-08-01', '2018-08-01', '2018-08-04', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('5', '2018-08-01', '3', 'test', '2018-08-01', '2018-08-01', '2018-08-05', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('6', '2018-08-01', '3', 'test', '2018-08-01', '2018-08-01', '2018-08-06', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('7', '2018-08-01', '3', 'test', '2018-08-01', '2018-08-01', '2018-08-07', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('8', '2018-08-01', '3', 'test', '2018-08-01', '2018-08-01', '2018-08-01', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('9', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-02', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('10', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-03', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('11', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-04', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('12', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-05', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('13', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-06', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('14', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-07', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('15', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-08', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('16', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-09', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('17', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-10', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('18', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-11', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('19', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-12', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('20', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-13', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('21', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-14', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('22', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-15', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('23', '2018-08-01', '2', 'test', '2018-08-01', '2018-08-01', '2018-08-16', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('24', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-01', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('25', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-02', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('26', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-03', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('27', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-04', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('28', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-05', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('29', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-06', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('30', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-07', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('31', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-01', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('32', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-02', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('33', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-03', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('34', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-04', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('35', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-05', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('36', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-06', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('37', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-07', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('38', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-08', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('39', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-09', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('40', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-10', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('41', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-11', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('42', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-12', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('43', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-13', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('44', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-14', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('45', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-15', '192.168.0.1');
INSERT INTO `jobmonitor` VALUES ('46', '2018-08-01', '4', 'test', '2018-08-01', '2018-08-01', '2018-08-16', '192.168.0.1');

-- ----------------------------
-- Table structure for preprocessmonitor
-- ----------------------------
DROP TABLE IF EXISTS `preprocessmonitor`;
CREATE TABLE `preprocessmonitor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datasource` varchar(255) DEFAULT NULL COMMENT '数据源',
  `datatype` int(4) DEFAULT NULL COMMENT '2001:输入 2002：上报输出 2003：下发输出 2005：磁盘输出 2009：采样输出 2012：thrift输出 2006：丢弃数据 2044：总输入 2045：填充校验',
  `datanum` bigint(20) DEFAULT NULL COMMENT '输入量',
  `createtime` date DEFAULT NULL,
  `protocol` varchar(255) DEFAULT NULL COMMENT '协议',
  `protocolId` varchar(255) DEFAULT NULL COMMENT '协议id',
  `actionType` varchar(255) DEFAULT NULL COMMENT '动作类型',
  `collectplace` varchar(255) DEFAULT NULL COMMENT '采集地',
  `errortype` int(2) DEFAULT NULL COMMENT '错误类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='预处理监测';

-- ----------------------------
-- Records of preprocessmonitor
-- ----------------------------
INSERT INTO `preprocessmonitor` VALUES ('1', '4g', '2004', '888', '2018-08-18', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('2', '4g', '2004', '666', '2018-08-19', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('3', '4g', '2004', '677', '2018-08-20', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('4', '4g', '2004', '888', '2018-08-11', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('5', '4g', '2004', '134', '2018-08-12', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('6', '4g', '2001', '888', '2018-08-13', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('7', '4g', '2001', '888', '2018-08-14', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('8', '4g', '2001', '3256', '2018-08-15', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('9', '4g', '2001', '888', '2018-08-16', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('10', '4g', '2001', '1634', '2018-08-17', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('11', '4g', '2002', '888', '2018-08-11', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('12', '4g', '2002', '4578', '2018-08-12', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('13', '4g', '2002', '123', '2018-08-13', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('14', '4g', '2002', '888', '2018-08-14', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('15', '4g', '2002', '346', '2018-08-15', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('16', '4g', '2002', '888', '2018-08-16', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('17', '4g', '2002', '967', '2018-08-17', 's', 'ss', 'a', '杭州', '1');
INSERT INTO `preprocessmonitor` VALUES ('18', '4g', '2004', '246', '2018-08-18', 's', 'ss', 'a', '杭州', '4');
INSERT INTO `preprocessmonitor` VALUES ('19', '4g', '2004', '888', '2018-08-19', 's', 'ss', 'a', '杭州', '3');
INSERT INTO `preprocessmonitor` VALUES ('20', '4g', '2004', '679', '2018-08-20', 's', 'ss', 'a', '杭州', '2');

-- ----------------------------
-- Table structure for restoremonitor
-- ----------------------------
DROP TABLE IF EXISTS `restoremonitor`;
CREATE TABLE `restoremonitor` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `createtime` date DEFAULT NULL COMMENT '入库时间',
  `restoreinput` bigint(20) DEFAULT NULL COMMENT '协议还原输入数据量',
  `restoreoutputbcp` bigint(20) DEFAULT NULL COMMENT '协议还原输出数据量(bcp)',
  `restoreoutputzip` bigint(20) DEFAULT NULL COMMENT '协议还原输出数据量(bcp)',
  `restorediscard` bigint(255) DEFAULT NULL COMMENT '协议还原丢弃数据量',
  `datasource` varchar(255) DEFAULT NULL COMMENT '数据源',
  `bprotocol` varchar(255) DEFAULT NULL COMMENT '大协议',
  `sprotocol` varchar(255) DEFAULT NULL COMMENT '小协议',
  `action` varchar(255) DEFAULT NULL COMMENT '动作类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='还原监测';

-- ----------------------------
-- Records of restoremonitor
-- ----------------------------
INSERT INTO `restoremonitor` VALUES ('1', '2018-08-20', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('2', '2018-08-21', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('3', '2018-08-22', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('4', '2018-08-23', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('5', '2018-08-24', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('6', '2018-08-25', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('7', '2018-08-26', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('8', '2018-08-27', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('9', '2018-08-28', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('10', '2018-08-29', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('11', '2018-08-01', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('12', '2018-08-02', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('13', '2018-08-03', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('14', '2018-08-04', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('15', '2018-08-05', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('16', '2018-08-06', '123', '100', '10', '13', 'd', 'b', 's', 'a');
INSERT INTO `restoremonitor` VALUES ('17', '2018-08-07', '123', '100', '10', '13', 'd', 'b', 's', 'a');

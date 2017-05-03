/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50146
Source Host           : localhost:3306
Source Database       : tbms

Target Server Type    : MYSQL
Target Server Version : 50146
File Encoding         : 65001

Date: 2017-05-02 20:44:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `accountId` int(10) NOT NULL AUTO_INCREMENT COMMENT '账号Id',
  `recommenderAccountId` int(10) DEFAULT NULL COMMENT '推荐人Id',
  `loginUserName` varchar(30) NOT NULL COMMENT '登录名',
  `loginPassword` varchar(30) NOT NULL COMMENT '登录密码',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `pauseDate` datetime DEFAULT NULL COMMENT '暂停时间',
  `closeDate` datetime DEFAULT NULL COMMENT '关闭时间',
  `realName` varchar(20) NOT NULL COMMENT '真实姓名',
  `idcardNo` char(18) NOT NULL COMMENT '身份证号',
  `birthDate` datetime DEFAULT NULL COMMENT '出生时间',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `occupation` varchar(50) DEFAULT NULL COMMENT '职业',
  `telephone` varchar(15) NOT NULL COMMENT '电话号码',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `mailAddress` varchar(200) DEFAULT NULL COMMENT '通信地址',
  `zipCode` char(6) DEFAULT NULL COMMENT '邮编号码',
  `qq` varchar(15) DEFAULT NULL COMMENT 'qq号码',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `lastLoginIp` varchar(15) DEFAULT NULL COMMENT '最后登录IP',
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=1027 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1005', null, 'taiji001', '256528', '0', '2008-03-15 00:00:00', null, null, 'zhangsanfeng', '123456789012345671', '1943-02-25 00:00:00', '0', '1', '13669351234', 'test@163.com', 'test', '333333', '55555555', null, null);
INSERT INTO `account` VALUES ('1010', null, 'xl18z60', '190613', '1', '2009-01-10 00:00:00', null, null, 'guojing', '123456789012345672', '1969-03-19 00:00:00', null, null, '13338924567', null, null, null, null, null, null);
INSERT INTO `account` VALUES ('1011', '1010', 'dgbf70', '270429', '1', '2009-03-01 00:00:00', null, null, 'huangrong', '123456789012345673', '1971-08-27 00:00:00', null, null, '13637811357', null, null, null, null, null, null);
INSERT INTO `account` VALUES ('1015', '1005', 'mjjzh64', '041115', '1', '2010-03-12 00:00:00', null, null, 'zhangwuji', '123456789012345674', '1989-06-04 00:00:00', null, null, '13572952468', null, null, null, null, null, null);
INSERT INTO `account` VALUES ('1018', '1011', 'jmdxj00', '010322', '1', '2011-01-01 00:00:00', null, null, 'guofurong', '123456789012345675', '1996-01-01 00:00:00', null, null, '18617832562', null, null, null, null, null, null);
INSERT INTO `account` VALUES ('1019', '1011', 'ljxj90', '310346', '1', '2012-02-01 00:00:00', null, null, 'luwushuang', '123456789012345676', '1993-07-31 00:00:00', null, null, '13186454984', null, null, null, null, null, null);
INSERT INTO `account` VALUES ('1020', null, 'kxhxd20', '012115', '1', '2012-02-20 00:00:00', null, null, 'weixiaobao', '123456789012345677', '2000-10-01 00:00:00', null, null, '13953410078', null, null, null, null, null, null);
INSERT INTO `account` VALUES ('1021', null, 'kxhxd21', '012116', '1', '2012-02-20 00:00:00', null, null, 'zhangsan', '123456789012345678', '2000-10-02 00:00:00', null, null, '13953410079', null, null, null, null, null, null);
INSERT INTO `account` VALUES ('1022', null, 'kxhxd22', '012117', '1', '2012-02-20 00:00:00', null, null, 'lisi', '123456789012345670', '2000-10-03 00:00:00', null, null, '13953410080', null, null, null, null, null, null);
INSERT INTO `account` VALUES ('1023', null, 'kxhxd23', '012118', '1', '2012-02-20 00:00:00', null, null, 'wangwu', '123456789012345611', '2000-10-04 00:00:00', null, null, '13953410081', null, null, null, null, null, null);
INSERT INTO `account` VALUES ('1024', null, 'kxhxd24', '012119', '1', '2012-02-20 00:00:00', null, null, 'zhouliu', '123456789012345612', '2000-10-05 00:00:00', null, null, '13953410082', null, null, null, null, null, null);
INSERT INTO `account` VALUES ('1025', null, 'kxhxd25', '012120', '1', '2012-02-20 00:00:00', null, null, 'maqi', '12345678901234567', '2000-10-06 00:00:00', null, null, '13953410083', null, null, null, null, null, null);
INSERT INTO `account` VALUES ('1026', null, 'test', '', '2', '2017-04-06 09:50:46', null, '2017-04-06 10:13:52', 'mytest', '111111111111111111', '1111-11-11 00:00:00', '1', '', '11111111111', '', '', '', '', null, null);

-- ----------------------------
-- Table structure for `admininfo`
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `adminId` int(10) NOT NULL AUTO_INCREMENT COMMENT '管理员Id',
  `adminCode` varchar(30) NOT NULL COMMENT '管理员账号',
  `password` varchar(30) NOT NULL COMMENT '管理员密码',
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `telephone` varchar(15) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `enrollDate` datetime NOT NULL COMMENT '登记时间',
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=6001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES ('2000', 'admin', '111', 'ADMIN', '123456789', 'admin@tarena.com.cn', '2016-02-18 00:00:00');
INSERT INTO `admininfo` VALUES ('3000', 'zhangfei', 'admin', 'ZhangFei', '123456789', 'zhangfei@tarena.com.cn', '2016-02-18 00:00:00');
INSERT INTO `admininfo` VALUES ('4000', 'liubei', 'admin', 'LiuBei', '123456789', 'liubei@tarena.com.cn', '2016-02-18 00:00:00');
INSERT INTO `admininfo` VALUES ('5000', 'caocao', '123', 'CaoCao', '123456789', 'caocao@tarena.com.cn', '2016-02-18 00:00:00');
INSERT INTO `admininfo` VALUES ('6000', 'aaa', '123', 'AAA', '123456789', 'aaa@tarena.com.cn', '2016-02-18 00:00:00');

-- ----------------------------
-- Table structure for `adminrole`
-- ----------------------------
DROP TABLE IF EXISTS `adminrole`;
CREATE TABLE `adminrole` (
  `adminId` int(10) NOT NULL COMMENT '管理员Id',
  `roleId` int(10) NOT NULL COMMENT '角色Id',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminrole
-- ----------------------------
INSERT INTO `adminrole` VALUES ('2000', '100', '1');
INSERT INTO `adminrole` VALUES ('3000', '200', '2');
INSERT INTO `adminrole` VALUES ('4000', '300', '3');
INSERT INTO `adminrole` VALUES ('5000', '100', '4');
INSERT INTO `adminrole` VALUES ('5000', '200', '5');
INSERT INTO `adminrole` VALUES ('5000', '300', '6');

-- ----------------------------
-- Table structure for `cost`
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost` (
  `costId` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `baseDuration` decimal(11,0) DEFAULT NULL,
  `baseCost` decimal(7,2) DEFAULT NULL,
  `unitCost` decimal(7,4) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `descr` varchar(100) DEFAULT NULL,
  `creatTime` datetime DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `costType` char(1) DEFAULT NULL,
  PRIMARY KEY (`costId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cost
-- ----------------------------
INSERT INTO `cost` VALUES ('1', '5.9元套餐', '20', '5.90', '0.4000', '0', '5.9元20小时/月,超出部分0.4元/时', null, null, null);
INSERT INTO `cost` VALUES ('2', '6.9元套餐', '40', '6.90', '0.3000', '0', '6.9元40小时/月,超出部分0.3元/时', null, null, null);
INSERT INTO `cost` VALUES ('3', '8.5元套餐', '100', '8.50', '0.2000', '0', '8.5元100小时/月,超出部分0.2元/时', null, null, null);
INSERT INTO `cost` VALUES ('4', '10.5元套餐', '200', '10.50', '0.1000', '0', '10.5元200小时/月,超出部分0.1元/时', null, null, null);
INSERT INTO `cost` VALUES ('5', '计时收费', null, null, '0.5000', '0', '0.5元/时,不使用不收费', null, null, null);
INSERT INTO `cost` VALUES ('6', '包月', null, '20.00', null, '0', '每月20元,不限制使用时间', null, null, null);
INSERT INTO `cost` VALUES ('7', 'mm', '10', '5.00', null, '0', '', null, null, null);
INSERT INTO `cost` VALUES ('8', 'nn', '10', '7.00', null, '0', '', null, null, null);
INSERT INTO `cost` VALUES ('9', 'qq', '10', '4.00', null, '0', '', null, null, null);

-- ----------------------------
-- Table structure for `moduleinfo`
-- ----------------------------
DROP TABLE IF EXISTS `moduleinfo`;
CREATE TABLE `moduleinfo` (
  `moduleId` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`moduleId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of moduleinfo
-- ----------------------------
INSERT INTO `moduleinfo` VALUES ('1', '角色管理');
INSERT INTO `moduleinfo` VALUES ('2', '管理员');
INSERT INTO `moduleinfo` VALUES ('3', '资费管理');
INSERT INTO `moduleinfo` VALUES ('4', '账务账号');
INSERT INTO `moduleinfo` VALUES ('5', '业务账号');
INSERT INTO `moduleinfo` VALUES ('6', '账单管理');
INSERT INTO `moduleinfo` VALUES ('7', '报表');

-- ----------------------------
-- Table structure for `roleinfo`
-- ----------------------------
DROP TABLE IF EXISTS `roleinfo`;
CREATE TABLE `roleinfo` (
  `roleId` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色Id',
  `name` varchar(50) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roleinfo
-- ----------------------------
INSERT INTO `roleinfo` VALUES ('100', '管理员');
INSERT INTO `roleinfo` VALUES ('200', '营业员');
INSERT INTO `roleinfo` VALUES ('300', '经理');
INSERT INTO `roleinfo` VALUES ('400', 'aaa');
INSERT INTO `roleinfo` VALUES ('500', 'bbb');

-- ----------------------------
-- Table structure for `rolemodule`
-- ----------------------------
DROP TABLE IF EXISTS `rolemodule`;
CREATE TABLE `rolemodule` (
  `roleId` int(10) NOT NULL COMMENT '角色Id',
  `moduleId` int(10) NOT NULL COMMENT '模块Id',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rolemodule
-- ----------------------------
INSERT INTO `rolemodule` VALUES ('100', '1', '1');
INSERT INTO `rolemodule` VALUES ('100', '2', '2');
INSERT INTO `rolemodule` VALUES ('100', '4', '3');
INSERT INTO `rolemodule` VALUES ('100', '5', '4');
INSERT INTO `rolemodule` VALUES ('100', '6', '5');
INSERT INTO `rolemodule` VALUES ('100', '7', '6');
INSERT INTO `rolemodule` VALUES ('200', '3', '7');
INSERT INTO `rolemodule` VALUES ('200', '4', '8');
INSERT INTO `rolemodule` VALUES ('200', '5', '9');
INSERT INTO `rolemodule` VALUES ('200', '6', '10');
INSERT INTO `rolemodule` VALUES ('300', '7', '11');
INSERT INTO `rolemodule` VALUES ('500', '4', '12');
INSERT INTO `rolemodule` VALUES ('500', '5', '13');
INSERT INTO `rolemodule` VALUES ('100', '3', '14');

-- ----------------------------
-- Table structure for `service`
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `serviceId` int(10) NOT NULL COMMENT '服务Id',
  `accountId` int(10) NOT NULL COMMENT '账号Id',
  `hostIp` varchar(15) NOT NULL,
  `serverUserName` varchar(8) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status` char(1) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `pauseDate` datetime DEFAULT NULL,
  `closeDate` datetime DEFAULT NULL,
  `costId` int(10) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2017 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service
-- ----------------------------
INSERT INTO `service` VALUES ('2001', '1010', '192.168.0.26', 'guojing', 'guo1234', '1', '2016-02-18 00:00:00', '2017-04-06 22:26:12', null, '4', '2009');
INSERT INTO `service` VALUES ('2002', '1011', '192.168.0.26', 'huangr', 'huang234', '0', '2016-02-18 00:00:00', null, null, '1', '2010');
INSERT INTO `service` VALUES ('2003', '1011', '192.168.0.20', 'huangr', 'huang234', '0', '2016-02-18 00:00:00', null, null, '3', '2011');
INSERT INTO `service` VALUES ('2004', '1011', '192.168.0.23', 'huangr', 'huang234', '0', '2016-02-18 00:00:00', null, null, '6', '2012');
INSERT INTO `service` VALUES ('2005', '1019', '192.168.0.26', 'luwsh', 'luwu2345', '0', '2016-02-18 00:00:00', null, null, '4', '2013');
INSERT INTO `service` VALUES ('2006', '1019', '192.168.0.20', 'luwsh', 'luwu2345', '0', '2016-02-18 00:00:00', null, null, '5', '2014');
INSERT INTO `service` VALUES ('2007', '1020', '192.168.0.20', 'weixb', 'wei12345', '1', '2016-02-18 00:00:00', null, '2017-04-06 23:07:52', '6', '2015');
INSERT INTO `service` VALUES ('2008', '1010', '192.168.0.20', 'guojing', 'guo09876', '1', '2016-02-18 00:00:00', '2017-04-06 22:27:23', null, '6', '2016');

-- ----------------------------
-- Table structure for `serviceupdatebak`
-- ----------------------------
DROP TABLE IF EXISTS `serviceupdatebak`;
CREATE TABLE `serviceupdatebak` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `serviceId` int(10) NOT NULL,
  `costId` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of serviceupdatebak
-- ----------------------------
INSERT INTO `serviceupdatebak` VALUES ('3', '2001', '4');
INSERT INTO `serviceupdatebak` VALUES ('4', '2001', '4');

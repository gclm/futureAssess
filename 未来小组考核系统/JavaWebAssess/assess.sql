/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : assess

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-03-12 14:47:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `id` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL,
  `applyidentity` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES ('', '', '');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `id` varchar(50) NOT NULL,
  `information` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('', '');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `userpass` varchar(100) NOT NULL,
  `usernick` varchar(100) NOT NULL,
  `useridentity` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `grade` varchar(50) NOT NULL,
  `direction` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `email` varchar(225) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('18b69ec2-c733-47e3-a886-86ae4a682471', '201615651234', '123456789', '阿双方都是', null, '12', '男', '456', 'javaweb', '13071755409', '12@qq.com');
INSERT INTO `person` VALUES ('636cf410-be41-4a18-b4f8-f0b64de9c8d7', '20161564314', 'feng159', '谢亚飞', '管理员', '20', 'man', '信工中外163', 'javaweb', '15837337963', '1719982754@qq.com');
INSERT INTO `person` VALUES ('99609b6f-7367-4f0a-b5bd-67f53a15c334', '20161534214', '123456', '12', '考官', '12', 'man', '123', 'front end', '13071755109', '123@qq.com');
INSERT INTO `person` VALUES ('ec046c03-96e8-43fd-b692-c7b0cbdf28a6', '20161534314', '12345678', 'wer', null, '12', '男', 'asedesa', 'javaweb', '13071755209', '1@qq.com');

-- ----------------------------
-- Table structure for results
-- ----------------------------
DROP TABLE IF EXISTS `results`;
CREATE TABLE `results` (
  `username` varchar(100) NOT NULL,
  `NO1` int(20) DEFAULT NULL,
  `NO2` int(20) DEFAULT NULL,
  `NO3` int(20) DEFAULT NULL,
  `NO4` int(20) DEFAULT NULL,
  `NO5` int(20) DEFAULT NULL,
  `NO6` int(20) DEFAULT NULL,
  `NO7` int(20) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of results
-- ----------------------------
INSERT INTO `results` VALUES ('201615651234', '1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Event structure for users
-- ----------------------------
DROP EVENT IF EXISTS `users`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` EVENT `users` ON SCHEDULE AT '2017-03-05 10:28:02' ON COMPLETION NOT PRESERVE ENABLE DO create database day14_user;
;;
DELIMITER ;

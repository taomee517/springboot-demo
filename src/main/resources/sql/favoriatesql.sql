/*
Navicat MySQL Data Transfer

Source Server         : 192.168.6.160
Source Server Version : 50722
Source Host           : 192.168.6.160:3306
Source Database       : db_terminal

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-04-15 17:21:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for favoriatesql
-- ----------------------------
DROP TABLE IF EXISTS `favoriatesql`;
CREATE TABLE `favoriatesql` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `database_name` varchar(64) NOT NULL,
  `adddate` datetime NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `sql_text` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favoriatesql
-- ----------------------------

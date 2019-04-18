/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-04-17 17:26:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log4j
-- ----------------------------
DROP TABLE IF EXISTS `log4j`;
CREATE TABLE `log4j` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_name` varchar(64) DEFAULT NULL COMMENT '项目名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `level` varchar(10) DEFAULT NULL COMMENT '日志级别',
  `category` varchar(255) DEFAULT NULL,
  `file_name` varchar(64) DEFAULT NULL COMMENT '类文件',
  `thread_name` varchar(64) DEFAULT NULL COMMENT '线程',
  `line` varchar(64) DEFAULT NULL COMMENT '日志所在行号',
  `all_category` varchar(255) DEFAULT NULL COMMENT '层级',
  `message` text COMMENT '日志内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

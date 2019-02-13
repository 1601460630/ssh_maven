/*
Navicat MySQL Data Transfer

Source Server         : jyx
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : ssh_crm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-02-13 17:28:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for guest
-- ----------------------------
DROP TABLE IF EXISTS `guest`;
CREATE TABLE `guest` (
  `guest_id` int(20) NOT NULL AUTO_INCREMENT,
  `guest_gender` char(1) DEFAULT NULL COMMENT '性别',
  `guest_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `guest_mobile` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `guest_email` varchar(255) DEFAULT NULL COMMENT '电子邮件',
  `guest_qq` varchar(255) DEFAULT NULL COMMENT 'QQ',
  `guest_time` date DEFAULT NULL COMMENT '拜访时间',
  `guest_lkm_id` int(20) DEFAULT NULL COMMENT '拜访联系人',
  PRIMARY KEY (`guest_id`),
  KEY `FK5aogq4vxmi9e7bfqjr86c8l4s` (`guest_lkm_id`),
  CONSTRAINT `FK5aogq4vxmi9e7bfqjr86c8l4s` FOREIGN KEY (`guest_lkm_id`) REFERENCES `cst_linkman` (`lkm_id`),
  CONSTRAINT `guest_ibfk_1` FOREIGN KEY (`guest_lkm_id`) REFERENCES `cst_linkman` (`lkm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*
Navicat MySQL Data Transfer

Source Server         : 99
Source Server Version : 50720
Source Host           : 139.196.194.172:3306
Source Database       : electric_bicycle_pro_dev

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-04-03 19:26:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_customer_address_info
-- 用户订单地址表
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_address_info`;
CREATE TABLE `t_customer_address_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` char(64) NOT NULL DEFAULT '' COMMENT '用户id',
  `customer_name` char(10) NOT NULL DEFAULT '' COMMENT '顾客姓名',
  `customer_phone` char(11) NOT NULL DEFAULT '' COMMENT '顾客手机号',
  `customer_place_provice` char(5) NOT NULL DEFAULT '' COMMENT '顾客所在省',
  `customer_place_city` char(10) NOT NULL DEFAULT '' COMMENT '顾客所在市',
  `customer_place_area` char(10) NOT NULL DEFAULT '' COMMENT '顾客所在区',
  `customer_detailed_address` varchar(30) NOT NULL DEFAULT '' COMMENT '顾客详细地址',
  `del_flag` smallint(1) NOT NULL DEFAULT '0' COMMENT '删除标识 0 未删除 1已删除',
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

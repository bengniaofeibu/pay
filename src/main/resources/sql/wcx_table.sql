/*
Navicat MySQL Data Transfer

Source Server         : 99
Source Server Version : 50720
Source Host           : 139.196.194.172:3306
Source Database       : electric_bicycle_pro_dev

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-24 15:15:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_wcx_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_wcx_user_info`;
CREATE TABLE `t_wcx_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一号',
  `open_id` varchar(64) NOT NULL DEFAULT '' COMMENT '微出行平台用户ID',
  `user_id` varchar(64) NOT NULL DEFAULT '' COMMENT '车商平台用户ID',
  `user_name` varchar(64) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `user_mobile` varchar(64) NOT NULL DEFAULT '' COMMENT '用户手机号',
  `userid_hash` varchar(64) NOT NULL DEFAULT '' COMMENT '用户身份证号',
  `regist_flag` int(4) NOT NULL DEFAULT '1' COMMENT '注册标识：1：未注册 ，2 ：已在微出行平台注册 3 ：已在车商侧注册 ',
  `deposit_flag` int(4) NOT NULL DEFAULT '0' COMMENT '押金标识 1：表示该用户未交押金  2 ：表示该用户在微出行平台已交押金  3 ：表示该用户在车商已交押金   4 ：表示该用户免押金状态中(微出行限时免押)  5 ：表示该用户在车商已退押金  6 ：表示该用户使用按次免押券',
  `deposit_fee` bigint(8) NOT NULL DEFAULT '0' COMMENT '押金费用 （单位分）',
  `add_time` datetime DEFAULT NULL COMMENT '数据添加时间',
  `update_time` datetime DEFAULT NULL COMMIT '数据更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_open_id` (`open_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;



ALTER TABLE `t_electric_fance_info`
DROP INDEX `i_area_name`,
ADD INDEX `i_area_name` (`area_name`) USING BTREE ;

ALTER TABLE `t_feedback_info`
ADD COLUMN `platform`  int(2) NULL COMMENT '反馈来源(1.赳赳单车 2.微出行)' AFTER `is_bike_faulted`,
ADD COLUMN `trans_id`  varchar(64) NULL COMMENT '骑行id' AFTER `platform`,
ADD COLUMN `bike_lat`  varchar(10) NULL COMMENT '车辆纬度(WGS-84 坐标系)，不含地图纠偏数据' AFTER `trans_id`,
ADD COLUMN `bike_lng`  varchar(10) NULL COMMENT '车辆经度(WGS-84 坐标系)，不含地图纠偏数据' AFTER `bike_lat`,
ADD COLUMN `open_id`  varchar(64) NULL COMMENT '微出行用户id' AFTER `bike_lng`;




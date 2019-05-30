/*
Navicat MySQL Data Transfer

Source Server         : chen
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : fcs

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-30 19:42:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `fasinformation`
-- ----------------------------
DROP TABLE IF EXISTS `fasinformation`;
CREATE TABLE `fasinformation` (
  `information_id` varchar(50) NOT NULL,
  `information_topic` varchar(50) NOT NULL,
  `information_author` varchar(50) NOT NULL,
  `information_content` varchar(2000) NOT NULL,
  `information_fabulous` int(11) NOT NULL,
  `information_ reltime` varchar(50) NOT NULL,
  `information_status` int(11) NOT NULL DEFAULT '0',
  `information_img` varchar(100) NOT NULL,
  PRIMARY KEY (`information_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fasinformation
-- ----------------------------
INSERT INTO `fasinformation` VALUES ('1', '易烊千玺', 'chen', 'XXXXXdhsiughfijdghfdjkhgfjkhskfjhk', '100', '2018-10-12', '0', '111');
INSERT INTO `fasinformation` VALUES ('2', '哈哈', 'chen', 'WWWWdsdsfdefw', '500', '2019-5-30', '0', '222');
INSERT INTO `fasinformation` VALUES ('3', '组织', 'cheh', 'AAAfwerfgregreg', '40', '2019-5-30', '0', '3');
INSERT INTO `fasinformation` VALUES ('4', '有点帅的法式风格怎么穿？学学这位漂亮的时尚博主Alexandra Ricci吧！', '海报时尚网', '推荐一位美美的巴黎女孩Alexandra Ricci，是一位平面模特及时尚博主。她跟许多法国女孩一样，喜欢复古又带点甜美感的服装；却不是那种典型的甜姐儿，她也爱穿狩猎外套、卡其裤等帅气的行头，让人想到安妮·霍尔！', '100', '2019-5-28', '0', 'http://localhost:8080/FCS/image/information/f01.jpg');

-- ----------------------------
-- Table structure for `fastype`
-- ----------------------------
DROP TABLE IF EXISTS `fastype`;
CREATE TABLE `fastype` (
  `type_id` int(11) NOT NULL,
  `type_number` int(11) NOT NULL,
  `type_supcategpry` varchar(50) DEFAULT NULL,
  `type_name` varchar(50) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fastype
-- ----------------------------
INSERT INTO `fastype` VALUES ('1', '1', null, '女装');
INSERT INTO `fastype` VALUES ('2', '2', null, '男装');
INSERT INTO `fastype` VALUES ('3', '3', null, '童装');
INSERT INTO `fastype` VALUES ('4', '4', null, '内衣');
INSERT INTO `fastype` VALUES ('5', '5', null, '休闲');
INSERT INTO `fastype` VALUES ('6', '6', null, '牛仔');
INSERT INTO `fastype` VALUES ('7', '7', null, '家纺');
INSERT INTO `fastype` VALUES ('8', '8', null, '配饰');
INSERT INTO `fastype` VALUES ('9', '9', null, '婚纱');
INSERT INTO `fastype` VALUES ('10', '10', null, '箱包');
INSERT INTO `fastype` VALUES ('11', '11', null, '皮草');
INSERT INTO `fastype` VALUES ('12', '12', null, '陈列');

-- ----------------------------
-- Table structure for `fasuseraccount`
-- ----------------------------
DROP TABLE IF EXISTS `fasuseraccount`;
CREATE TABLE `fasuseraccount` (
  `user_id` varchar(50) NOT NULL,
  `user_account` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_type` int(1) NOT NULL COMMENT '设计师：1，普通用户：2 ',
  `user_regtime` varchar(50) NOT NULL,
  `user_status` int(11) NOT NULL DEFAULT '0' COMMENT '用户状态 启用：0 停用：1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fasuseraccount
-- ----------------------------
INSERT INTO `fasuseraccount` VALUES ('3f78a91a814111e9969e54e1adbba677', '李四', '202cb962ac59075b964b07152d234b70', '1', '2019-05-28 20:06:43', '0');
INSERT INTO `fasuseraccount` VALUES ('4d6c61b8814111e9969e54e1adbba677', '李四', '202cb962ac59075b964b07152d234b70', '1', '2019-05-28 20:07:07', '0');
INSERT INTO `fasuseraccount` VALUES ('af7775d6814111e9969e54e1adbba677', '李四', '202cb962ac59075b964b07152d234b70', '0', '2019-05-28 20:09:51', '0');
INSERT INTO `fasuseraccount` VALUES ('d06e4cc5814211e9969e54e1adbba677', '李四', '202cb962ac59075b964b07152d234b70', '0', '2019-05-28 20:17:56', '0');

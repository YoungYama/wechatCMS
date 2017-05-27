/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : wechatcms

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2017-05-27 17:14:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `sys_user_id` varchar(50) NOT NULL COMMENT '用户ID',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `head_img` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `wx_public_account_id` varchar(50) DEFAULT NULL COMMENT '关联的公众号ID',
  `user_role` int(1) DEFAULT NULL COMMENT '用户角色：0：系统管理员;1：系统用户',
  `register_time` varchar(20) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`sys_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('bd9cce54-03e7-485f-baed-9c528f348a7f-1495864619145', '1495864619145', '00112222344455666666777888999bbbbddeeeff', null, '18718995465', null, '52669710-29c2-4a19-bd18-2849c4f3e660-1495870631677', '1', '2017-05-27 13:56:59');

-- ----------------------------
-- Table structure for wx_menu
-- ----------------------------
DROP TABLE IF EXISTS `wx_menu`;
CREATE TABLE `wx_menu` (
  `wx_menu_id` varchar(50) NOT NULL COMMENT '菜单ID',
  `wx_public_account_id` varchar(50) DEFAULT NULL COMMENT '所属公众号ID',
  `media_id` varchar(255) DEFAULT NULL COMMENT 'media_id类型和view_limited类型必须，调用新增永久素材接口返回的合法media_id',
  `but_type` varchar(20) DEFAULT '' COMMENT '菜单的响应动作类型【click：点击推事件，view：跳转URL，scancode_push：扫码推事件，scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框，pic_sysphoto：弹出系统拍照发图，pic_photo_or_album：弹出拍照或者相册发图，pic_weixin：弹出微信相册发图器，location_select：弹出地理位置选择器，media_id：下发消息（除文本消息），view_limited：跳转图文消息URL】',
  `but_name` varchar(40) DEFAULT NULL COMMENT '菜单标题，不超过16个字节，子菜单不超过40个字节',
  `but_key` varchar(128) DEFAULT NULL COMMENT 'click等点击类型必须，菜单KEY值，用于消息接口推送，不超过128字节',
  `but_url` tinytext COMMENT 'view类型必须，网页链接，用户点击菜单可打开链接，不超过1024字节',
  `but_sort` int(11) DEFAULT NULL COMMENT '菜单排序',
  `parent_id` varchar(50) DEFAULT NULL COMMENT '菜单级别，一级菜单值为0，二级菜单值为其父级菜单的ID',
  `wx_menu_group_id` int(11) DEFAULT NULL COMMENT '组别',
  PRIMARY KEY (`wx_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_menu
-- ----------------------------

-- ----------------------------
-- Table structure for wx_menu_group
-- ----------------------------
DROP TABLE IF EXISTS `wx_menu_group`;
CREATE TABLE `wx_menu_group` (
  `wx_menu_group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单组ID',
  `group_name` varchar(255) DEFAULT NULL COMMENT '菜单组名称',
  `wx_public_account_id` varchar(50) DEFAULT NULL COMMENT '所属公众号ID',
  `is_enable` int(1) DEFAULT NULL COMMENT '是否启用，1：启用，0：禁用',
  PRIMARY KEY (`wx_menu_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_menu_group
-- ----------------------------
INSERT INTO `wx_menu_group` VALUES ('1', '第一组菜单', '6784a1e7-425a-47e9-8b70-4363416bb00f-1483702770212', '1');

-- ----------------------------
-- Table structure for wx_public_account
-- ----------------------------
DROP TABLE IF EXISTS `wx_public_account`;
CREATE TABLE `wx_public_account` (
  `wx_public_account_id` varchar(50) NOT NULL COMMENT '公众号ID',
  `url` varchar(255) DEFAULT NULL COMMENT '服务器地址（URL）',
  `token` varchar(255) DEFAULT NULL COMMENT 'Token可由开发者可以任意填写，用作生成签名（该Token会和接口URL中包含的Token进行比对，从而验证安全性）',
  `encoding_aes_key` varchar(255) DEFAULT NULL COMMENT 'EncodingAESKey由开发者手动填写或随机生成，将用作消息体加解密密钥',
  `grant_type` varchar(20) DEFAULT 'client_credential' COMMENT '获取access_token填写client_credential',
  `app_id` varchar(255) DEFAULT NULL COMMENT '第三方用户唯一凭证',
  `app_secret` varchar(255) DEFAULT NULL COMMENT '第三方用户唯一凭证密钥',
  `access_token` varchar(255) DEFAULT NULL COMMENT 'access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。开发者需要进行妥善保存。access_token的存储至少要保留512个字符空间。access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。',
  `last_modify_time` bigint(20) DEFAULT NULL COMMENT 'access_token最新更新时间',
  PRIMARY KEY (`wx_public_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_public_account
-- ----------------------------
INSERT INTO `wx_public_account` VALUES ('52669710-29c2-4a19-bd18-2849c4f3e660-1495870631677', '33', null, null, null, null, null, null, null);

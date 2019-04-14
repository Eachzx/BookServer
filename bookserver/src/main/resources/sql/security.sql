/*
 Navicat Premium Data Transfer

 Source Server         : 120.79.141.204
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 120.79.141.204:3306
 Source Schema         : security

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 13/04/2019 17:23:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for child_menu
-- ----------------------------
DROP TABLE IF EXISTS `child_menu`;
CREATE TABLE `child_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `child_menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `child_menu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `parent_menu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKnib5b4baudg9y6hbbpk6ies6r`(`parent_menu_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of child_menu
-- ----------------------------
INSERT INTO `child_menu` VALUES (1, 'child_menu_1_1', '1-1', 1);
INSERT INTO `child_menu` VALUES (2, 'child_menu_1_2', '1-2', 1);
INSERT INTO `child_menu` VALUES (3, 'child_menu_2_1', '2-1', 2);
INSERT INTO `child_menu` VALUES (4, 'child_menu_2_2', '2-2', 2);
INSERT INTO `child_menu` VALUES (5, 'child_menu_3_1', '3-1', 3);

-- ----------------------------
-- Table structure for parent_menu
-- ----------------------------
DROP TABLE IF EXISTS `parent_menu`;
CREATE TABLE `parent_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `parent_menu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of parent_menu
-- ----------------------------
INSERT INTO `parent_menu` VALUES (1, 'parent_menu_1', '1');
INSERT INTO `parent_menu` VALUES (2, 'parent_menu_2', '2');
INSERT INTO `parent_menu` VALUES (3, 'parent_menu_3', '3');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `permission_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 'p_1', '1');
INSERT INTO `permission` VALUES (2, 'p_2', '2');
INSERT INTO `permission` VALUES (3, 'p_3', '3');

-- ----------------------------
-- Table structure for permission_parent_menu
-- ----------------------------
DROP TABLE IF EXISTS `permission_parent_menu`;
CREATE TABLE `permission_parent_menu`  (
  `permission_id` int(11) NOT NULL,
  `parent_menu_id` int(11) NOT NULL,
  INDEX `FKpmqmm53carre39al9bp5en59n`(`parent_menu_id`) USING BTREE,
  INDEX `FKpdk4qwfcwhtxb2gra7d0aoy7f`(`permission_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of permission_parent_menu
-- ----------------------------
INSERT INTO `permission_parent_menu` VALUES (1, 1);
INSERT INTO `permission_parent_menu` VALUES (2, 2);
INSERT INTO `permission_parent_menu` VALUES (3, 3);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `role_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', 'admin');
INSERT INTO `role` VALUES (2, '普通用户角色1', 'role1');
INSERT INTO `role` VALUES (3, '普通用户角色2', 'role2');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  INDEX `FKf8yllw1ecvwqy3ehyxawqa1qp`(`permission_id`) USING BTREE,
  INDEX `FKa6jx8n8xkesmjmv6jqug6bg68`(`role_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1);
INSERT INTO `role_permission` VALUES (1, 2);
INSERT INTO `role_permission` VALUES (1, 3);
INSERT INTO `role_permission` VALUES (2, 1);
INSERT INTO `role_permission` VALUES (3, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '123456', 'user1', 'NO1');
INSERT INTO `user` VALUES (2, '123456', 'user2', 'NO2');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  INDEX `FKa68196081fvovjhkek5m97n3y`(`role_id`) USING BTREE,
  INDEX `FK859n2jvi8ivhui0rl0esws6o`(`user_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (1, 2);
INSERT INTO `user_role` VALUES (1, 3);

SET FOREIGN_KEY_CHECKS = 1;

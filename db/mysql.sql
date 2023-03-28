/*
 Navicat Premium Data Transfer

 Source Server         : balckflagisme
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : blackflag_cms

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 28/03/2023 18:46:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for community_thought
-- ----------------------------
DROP TABLE IF EXISTS `community_thought`;
CREATE TABLE `community_thought`  (
  `id` bigint NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '想法',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of community_thought
-- ----------------------------
INSERT INTO `community_thought` VALUES (1640664922666831873, 'string', 'string');
INSERT INTO `community_thought` VALUES (1640664994452344833, '1', '1');
INSERT INTO `community_thought` VALUES (1640665018951274497, '2', '2');

SET FOREIGN_KEY_CHECKS = 1;

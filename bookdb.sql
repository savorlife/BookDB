/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50096
 Source Host           : localhost:3306
 Source Schema         : bookdb

 Target Server Type    : MySQL
 Target Server Version : 50096
 File Encoding         : 65001

 Date: 25/04/2020 16:31:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adminpass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(255) NULL DEFAULT 0 COMMENT '1：超级管理员 0普通管理员',
  PRIMARY KEY USING BTREE (`a_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', 1);
INSERT INTO `admin` VALUES (4, '190HG0004', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `admin` VALUES (7, '190HG0007', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `admin` VALUES (8, '190HG0008', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `admin` VALUES (9, '190HG0009', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `admin` VALUES (10, '190HG0010', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `admin` VALUES (11, '190HG0011', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `admin` VALUES (12, '190HG0012', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `admin` VALUES (17, '190HG0014', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `admin` VALUES (20, '190HG0015', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `admin` VALUES (21, '190HG0016', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `admin` VALUES (22, '190HG0017', 'e10adc3949ba59abbe56e057f20f883e', 0);
INSERT INTO `admin` VALUES (39, '111', '111', 1);
INSERT INTO `admin` VALUES (43, '11111', '111111', 0);
INSERT INTO `admin` VALUES (44, '122333', '222222', 0);
INSERT INTO `admin` VALUES (45, '12414324', '111111', 0);
INSERT INTO `admin` VALUES (46, 'wqr111', '111111', 0);
INSERT INTO `admin` VALUES (47, '222', '222', 0);
INSERT INTO `admin` VALUES (49, '11111', '111111', 0);
INSERT INTO `admin` VALUES (56, '111223', '111111', 0);
INSERT INTO `admin` VALUES (59, '111111', '111111', 0);
INSERT INTO `admin` VALUES (60, '131423', '111111', 0);
INSERT INTO `admin` VALUES (61, '111112', '111112', 0);

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `bookname` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图书名称',
  `booktype` int(11) NOT NULL COMMENT '图书类别',
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '作者',
  `publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '出版社',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '定价',
  `kucun` int(255) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY USING BTREE (`id`),
  INDEX `t_id` USING BTREE(`booktype`),
  CONSTRAINT `t_id` FOREIGN KEY (`booktype`) REFERENCES `type` (`typeID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'InnoDB free: 11264 kB; (`booktype`) REFER `bookdb/type`(`typeID`)' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '人生（2020精装版）', 2, '路遥 ', '北京十月文艺出版社', 51.00, 432);
INSERT INTO `book` VALUES (2, '心理学统治生活(套装共10册)', 2, '爱丽丝·米勒', ' 中国友谊出版公司', 117.00, 3565);
INSERT INTO `book` VALUES (3, '\r\n君主论', 6, '马基雅维利', '北京联合出版公司', 12.99, 66);
INSERT INTO `book` VALUES (4, 'Java编程思想', 3, '[美] Bruce Eckel', '机械工业出版社', 73.90, 1);
INSERT INTO `book` VALUES (5, 'Java核心技术', 3, '[美],凯·,S.,霍斯特曼', '机械工业出版社', 96.00, 2);
INSERT INTO `book` VALUES (6, '计算机科学导论（原书第3版）', 3, '（美）佛罗赞', '机械工业出版社', 54.00, 3);
INSERT INTO `book` VALUES (7, '计算机网络：自顶向下方法(原书第7版)', 3, '詹姆斯·F.库罗斯', '机械工业出版社', 62.00, 4);
INSERT INTO `book` VALUES (8, '毛泽东选集（全四卷）', 1, '毛泽东', '人民出版社', 88.00, 66);
INSERT INTO `book` VALUES (9, '毛泽东文集（大32开全八册）', 1, '毛泽东', '人民出版社', 168.00, 21);
INSERT INTO `book` VALUES (10, '计算机科学导论（原书第3版）', 3, '（美）佛罗赞', '机械工业出版社', 54.00, 3);
INSERT INTO `book` VALUES (11, '\r\n君主论', 6, '马基雅维利', '北京联合出版公司', 12.99, 66);
INSERT INTO `book` VALUES (12, 'Java编程思想', 3, '[美] Bruce Eckel', '机械工业出版社', 73.90, 1);

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '借阅编号',
  `book_id` int(11) NULL DEFAULT NULL COMMENT '图书编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '借阅人编号',
  `borrow_date` datetime NULL DEFAULT NULL COMMENT '借阅时间',
  `back_date` datetime NULL DEFAULT NULL COMMENT '还书时间',
  `or_back` int(255) NULL DEFAULT NULL COMMENT '是否归还 1归还，0未归还',
  PRIMARY KEY USING BTREE (`id`),
  INDEX `bookid` USING BTREE(`book_id`),
  INDEX `user_id` USING BTREE(`user_id`),
  CONSTRAINT `bookid` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `borrow_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`u_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'InnoDB free: 11264 kB; (`book_id`) REFER `bookdb/book`(`id`); (`user_id`) REFER ' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (1, 1, 18080222, '2020-04-02 19:20:50', '2020-04-04 19:20:56', 1);
INSERT INTO `borrow` VALUES (2, 3, 18080224, '2020-03-31 19:22:15', '2020-04-05 19:22:22', 1);
INSERT INTO `borrow` VALUES (3, 3, 18080224, '2020-02-24 19:22:43', '2020-04-05 19:27:12', 1);
INSERT INTO `borrow` VALUES (4, 5, 18080222, '2020-04-01 19:27:34', '2020-04-02 19:27:42', 1);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `typeID` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`typeID`)
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '马列主义毛邓思想');
INSERT INTO `type` VALUES (2, '哲学');
INSERT INTO `type` VALUES (3, '计算机');
INSERT INTO `type` VALUES (4, '社会科学总论');
INSERT INTO `type` VALUES (5, '政治、法律');
INSERT INTO `type` VALUES (6, '军事');
INSERT INTO `type` VALUES (7, '经济');
INSERT INTO `type` VALUES (8, '文化、科学、教育、体育');
INSERT INTO `type` VALUES (9, '语言、文字');
INSERT INTO `type` VALUES (10, '文学');
INSERT INTO `type` VALUES (11, '艺术');
INSERT INTO `type` VALUES (12, '历史、地理');
INSERT INTO `type` VALUES (13, '自然科学总论');
INSERT INTO `type` VALUES (14, '数理科学和化学');
INSERT INTO `type` VALUES (15, '天文学、地球科学');
INSERT INTO `type` VALUES (16, '生物科学');
INSERT INTO `type` VALUES (17, '医药、卫生');
INSERT INTO `type` VALUES (18, '农业科学');
INSERT INTO `type` VALUES (19, '工业技术');
INSERT INTO `type` VALUES (20, '交通运输');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` int(255) NOT NULL AUTO_INCREMENT,
  `u_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userpass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `u_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `u_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `max` int(255) NOT NULL DEFAULT 0 COMMENT '最多借书数',
  PRIMARY KEY USING BTREE (`u_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 180802232 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (18080222, '17743882735', 'e10adc3949ba59abbe56e057f20f883e', '李四', '男', '河北省邢台市', '177438827345@qq.com', 3);
INSERT INTO `user` VALUES (18080223, '13253140530', 'e10adc3949ba59abbe56e057f20f883e', '小分', '男', 'null', '', 3);
INSERT INTO `user` VALUES (18080224, '18230132735', 'e10adc3949ba59abbe56e057f20f883e', '赵柳惠', '男', '河北省石家庄', '18230132735@qq.com', 3);
INSERT INTO `user` VALUES (18080225, '18236991236', 'e10adc3949ba59abbe56e057f20f883e', '赵不惠', '', NULL, '', 3);
INSERT INTO `user` VALUES (18080226, '13253170530', 'e10adc3949ba59abbe56e057f20f883e', '王五', '男', '河北省石家庄', '13253170530@qq.com', 3);
INSERT INTO `user` VALUES (18080227, '15132222222', 'e10adc3949ba59abbe56e057f20f883e', 'null', '男', 'null', '', 3);
INSERT INTO `user` VALUES (18080228, '15122222222', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, NULL, 3);
INSERT INTO `user` VALUES (18080229, '15122222223', '111111', '成功', '男', '', '', 3);
INSERT INTO `user` VALUES (180802231, '17749883652', 'e10adc3949ba59abbe56e057f20f883e', '张三', '男', '河北省张家口市', '1107879982@qq.com', 3);

SET FOREIGN_KEY_CHECKS = 1;

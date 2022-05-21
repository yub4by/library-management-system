/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2017-10-29 22:15:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `bookId` int(30) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(100) DEFAULT NULL,
  `bookAuther` varchar(100) DEFAULT NULL,
  `loca` varchar(100) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `borrowerId` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', 'JAVA', 'auther1', 'pl', '借出', '1');
INSERT INTO `books` VALUES ('2', 'C#', 'auther2', 'pl', '借出', '2');
INSERT INTO `books` VALUES ('3', 'Andorid', 'auther3', 'os', '借出', '3');
INSERT INTO `books` VALUES ('4', 'ios', 'auther4', 'os', '可借', '');
INSERT INTO `books` VALUES ('5', 'LittlePrince', 'Antoine', 'novel', '可借', '');
INSERT INTO `books` VALUES ('6', 'HarryPotter', 'JKRowling', 'novel', '可借', null);
INSERT INTO `books` VALUES ('7', 'JAVA', 'auther7', 'pl', '维护', null);
INSERT INTO `books` VALUES ('8', 'C#', 'auther8', 'pl', '维护', null);
INSERT INTO `books` VALUES ('9', 'ios', 'auther9', 'os', '维护', null);
INSERT INTO `books` VALUES ('10', 'Andorid', 'auther10', 'os', '维护', null);
INSERT INTO `books` VALUES ('11', 'LittlePrince', 'Antoine', 'novel', '维护', null);
INSERT INTO `books` VALUES ('12', 'HarryPotter', 'JKRowling', 'novel', '维护', null);
INSERT INTO `books` VALUES ('13', '西游记', '吴承恩', '中国四大名著', '可借', null);
INSERT INTO `books` VALUES ('14', '红楼梦', '曹雪芹', '中国四大名著', '可借', null);
INSERT INTO `books` VALUES ('15', '三国演义', '罗贯中', '中国四大名著', '可借', null);
INSERT INTO `books` VALUES ('16', '水浒传', '施耐庵', '中国四大名著', '可借', null);
INSERT INTO `books` VALUES ('17', '他们最幸福', '大冰', '情感励志', '可借', null);
INSERT INTO `books` VALUES ('18', '阿弥陀佛么么哒', '大冰', '情感励志', '可借', null);
INSERT INTO `books` VALUES ('19', '乖摸摸头', '大冰', '情感励志', '可借', null);
INSERT INTO `books` VALUES ('20', '好吗好的', '大冰', '情感励志', '可借', null);
INSERT INTO `books` VALUES ('21', '我不', '大冰', '情感励志', '可借', null);
INSERT INTO `books` VALUES ('22', '悟空传', '今何在', '小说', '可借', null);
INSERT INTO `books` VALUES ('23', '白鹿原', '陈忠实', '小说', '可借', null);
INSERT INTO `books` VALUES ('24', '考研英语词组背多分', '新东方', '教辅', '维护', null);
INSERT INTO `books` VALUES ('25', '考研政治核心考点权威解读', '新东方', '教辅', '维护', null);

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `ID` int(30) NOT NULL AUTO_INCREMENT,
  `userId` int(30) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `bookId` int(30) NOT NULL,
  `bookName` varchar(255) NOT NULL,
  `lendTime` datetime DEFAULT NULL,
  `replaceTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('6', '1', 'zhangsan', '1', 'JAVA', '2017-10-23 00:00:00', '2017-11-02 00:00:00');
INSERT INTO `borrow` VALUES ('7', '2', 'lisi', '2', 'C#', '2017-10-24 00:00:00', '2017-11-03 00:00:00');
INSERT INTO `borrow` VALUES ('8', '3', 'wangwu', '3', 'Andorid', '2017-10-25 00:00:00', '2017-11-04 00:00:00');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `bookId` int(30) DEFAULT NULL,
  `userId` int(30) DEFAULT NULL,
  `lendTime` datetime DEFAULT NULL,
  `returnTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '1', '1', '2017-10-23 00:00:00', '2017-11-02 00:00:00');
INSERT INTO `test` VALUES ('2', '2', '2', '2017-10-24 00:00:00', '2017-11-03 00:00:00');
INSERT INTO `test` VALUES ('3', '3', '3', '2017-10-25 00:00:00', '2017-11-04 00:00:00');
INSERT INTO `test` VALUES ('4', '5', '15', '2017-10-27 00:00:00', '2017-11-06 00:00:00');
INSERT INTO `test` VALUES ('5', '4', '15', '2017-10-29 00:00:00', '2017-11-08 00:00:00');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` int(30) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `note` int(30) DEFAULT '0',
  `role` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'zhangsan', '123', '1', '读者');
INSERT INTO `users` VALUES ('2', 'lisi', '456', '2', '读者');
INSERT INTO `users` VALUES ('3', 'wangwu', '789', '3', '读者');
INSERT INTO `users` VALUES ('4', 'admin', 'admin', '0', '管理员');
INSERT INTO `users` VALUES ('5', 'root', 'root', '0', '管理员');
INSERT INTO `users` VALUES ('6', 'user6', '666', '0', '读者');
INSERT INTO `users` VALUES ('7', 'user7', '777', '0', '读者');
INSERT INTO `users` VALUES ('8', 'user8', '888', '0', '读者');
INSERT INTO `users` VALUES ('9', 'user9', '999', '0', '读者');
INSERT INTO `users` VALUES ('15', 'java1234', '1234', '0', '读者');

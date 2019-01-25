/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50536
Source Host           : 127.0.0.1:3306
Source Database       : refreshshop

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2019-01-25 01:54:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES ('2', 'admin', 'admin');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '水果基地');
INSERT INTO `category` VALUES ('2', '安全频道');
INSERT INTO `category` VALUES ('3', '商城卡');
INSERT INTO `category` VALUES ('4', '定制套餐');
INSERT INTO `category` VALUES ('5', '节气养生');
INSERT INTO `category` VALUES ('6', '便民服务');

-- ----------------------------
-- Table structure for categorysecond
-- ----------------------------
DROP TABLE IF EXISTS `categorysecond`;
CREATE TABLE `categorysecond` (
  `csid` int(11) NOT NULL AUTO_INCREMENT,
  `csname` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`csid`),
  KEY `FK936FCAF21DB1FD15` (`cid`),
  CONSTRAINT `FK936FCAF21DB1FD15` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorysecond
-- ----------------------------
INSERT INTO `categorysecond` VALUES ('1', '西瓜', '1');
INSERT INTO `categorysecond` VALUES ('2', '樱桃', '1');
INSERT INTO `categorysecond` VALUES ('37', '百香果', '1');
INSERT INTO `categorysecond` VALUES ('38', '菠萝', '1');
INSERT INTO `categorysecond` VALUES ('39', '草莓', '1');
INSERT INTO `categorysecond` VALUES ('40', '橙子', '1');
INSERT INTO `categorysecond` VALUES ('41', '脆枣', '1');
INSERT INTO `categorysecond` VALUES ('42', '哈密瓜', '1');
INSERT INTO `categorysecond` VALUES ('43', '金橘', '1');
INSERT INTO `categorysecond` VALUES ('44', '榴莲', '1');
INSERT INTO `categorysecond` VALUES ('45', '毛桃', '1');
INSERT INTO `categorysecond` VALUES ('46', '牛油果', '1');
INSERT INTO `categorysecond` VALUES ('47', '柠檬', '1');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `subtotal` double(11,0) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `FKE8B2AB6166C01961` (`oid`),
  KEY `FKE8B2AB6171DB7AE4` (`pid`),
  KEY `FKE8B2AB6140ACF87A` (`oid`),
  CONSTRAINT `FKE8B2AB6140ACF87A` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`),
  CONSTRAINT `FKE8B2AB6171DB7AE4` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('18', '1', '18', '53', '9023');
INSERT INTO `orderitem` VALUES ('19', '1', '4', '21', '9024');
INSERT INTO `orderitem` VALUES ('20', '1', '3', '51', '9025');
INSERT INTO `orderitem` VALUES ('21', '1', '15', '35', '9026');
INSERT INTO `orderitem` VALUES ('22', '1', '10', '1', '9026');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `addr` varchar(50) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FKC3DF62E5AA3D9C7` (`uid`),
  CONSTRAINT `FKC3DF62E5AA3D9C7` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=9027 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('9013', '25', '2018-11-16 00:00:00', '2', 'qwe', '15640444444', '123', '10');
INSERT INTO `orders` VALUES ('9014', '20', '2018-11-16 00:00:00', '2', 'qwe', '15640444444', '123', '10');
INSERT INTO `orders` VALUES ('9015', '10', '2018-11-16 00:00:00', '2', 'qwe', '15640444444', '123', '10');
INSERT INTO `orders` VALUES ('9016', '10', '2018-11-16 00:00:00', '1', null, null, null, '10');
INSERT INTO `orders` VALUES ('9017', '14', '2018-11-16 00:00:00', '1', null, null, null, '10');
INSERT INTO `orders` VALUES ('9018', '17', '2018-11-16 00:00:00', '1', null, null, null, '10');
INSERT INTO `orders` VALUES ('9019', '18', '2018-11-16 00:00:00', '1', null, null, null, '10');
INSERT INTO `orders` VALUES ('9020', '4', '2018-11-16 00:00:00', '1', null, null, null, '10');
INSERT INTO `orders` VALUES ('9021', '18', '2018-11-16 00:00:00', '1', null, null, null, '10');
INSERT INTO `orders` VALUES ('9022', '18', '2018-11-16 00:00:00', '1', null, null, null, '10');
INSERT INTO `orders` VALUES ('9023', '18', '2018-11-16 00:00:00', '3', 'qwe', '15640444444', '123', '10');
INSERT INTO `orders` VALUES ('9024', '4', '2018-11-17 00:00:00', '3', 'qwe', '15640444444', '123', '10');
INSERT INTO `orders` VALUES ('9025', '3', '2018-11-18 00:00:00', '3', 'sxk', '15612341234', '辽宁省大连市', '7');
INSERT INTO `orders` VALUES ('9026', '25', '2018-11-19 00:00:00', '3', 'sxk', '15726607618', '辽宁省大连市', '7');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `is_hot` int(11) DEFAULT NULL,
  `pdate` datetime DEFAULT NULL,
  `csid` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FKED8DCCEFB9B74E02` (`csid`),
  CONSTRAINT `FKED8DCCEFB9B74E02` FOREIGN KEY (`csid`) REFERENCES `categorysecond` (`csid`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '百香果', '15', '10', 'products/baixiangguo.jpg', '限量一斤', '1', '2014-11-02 20:18:00', '37');
INSERT INTO `product` VALUES ('21', '菠萝', '5', '4', 'products/boluo.jpg', '限量一斤', '1', '2014-11-03 20:18:00', '38');
INSERT INTO `product` VALUES ('35', '草莓', '20', '15', 'products/caomei.jpg', '限量一斤', '1', '2014-11-03 20:18:00', '39');
INSERT INTO `product` VALUES ('41', '橙子', '5', '3', 'products/chengzi.jpg', '限量一斤', '1', '2014-11-03 20:18:00', '40');
INSERT INTO `product` VALUES ('42', '脆枣', '12', '10', 'products/cuizao.jpg', '限量一斤', '1', '2014-11-03 20:18:00', '41');
INSERT INTO `product` VALUES ('44', '哈密瓜', '4', '3', 'products/hamigua.jpg', '限量一斤', '1', '2014-11-03 20:18:00', '42');
INSERT INTO `product` VALUES ('47', '金橘', '2', '1', 'products/jinju.jpg', '限量一斤', '1', '2014-11-03 20:18:00', '43');
INSERT INTO `product` VALUES ('51', '西瓜', '5', '3', 'products/xigua.jpg', '限量一斤', '1', '2014-12-07 20:18:00', '1');
INSERT INTO `product` VALUES ('53', '榴莲', '20', '18', 'products/liulian.jpg', '限量一斤', '1', '2014-11-03 20:18:00', '44');
INSERT INTO `product` VALUES ('57', '毛桃', '4', '3', 'products/maotao.jpg', '限量一斤', '1', '2018-11-19 00:00:00', '45');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('7', 'sxk', '123', 'sxk', 'aaa@shop.com', '15726607618', '辽宁省大连市', null, null);
INSERT INTO `user` VALUES ('10', '123', '123', 'qwe', '353201814@qq.com', '15640444444', '123', null, null);

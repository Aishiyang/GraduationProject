/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50536
Source Host           : 127.0.0.1:3306
Source Database       : refreshshop

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-11-13 02:39:55
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '定制套餐');
INSERT INTO `category` VALUES ('2', '安全频道');
INSERT INTO `category` VALUES ('3', '商城卡');
INSERT INTO `category` VALUES ('4', '水果基地');
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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorysecond
-- ----------------------------
INSERT INTO `categorysecond` VALUES ('1', '潮流女装', '1');
INSERT INTO `categorysecond` VALUES ('2', '初冬羽绒', '1');
INSERT INTO `categorysecond` VALUES ('3', '毛呢大衣', '1');
INSERT INTO `categorysecond` VALUES ('4', '温暖毛衣', '1');
INSERT INTO `categorysecond` VALUES ('5', '精选男装', '1');
INSERT INTO `categorysecond` VALUES ('6', '冬季外套', '1');
INSERT INTO `categorysecond` VALUES ('7', '羽绒服', '1');
INSERT INTO `categorysecond` VALUES ('9', '女鞋', '2');
INSERT INTO `categorysecond` VALUES ('10', '短靴', '2');
INSERT INTO `categorysecond` VALUES ('11', '男鞋', '2');
INSERT INTO `categorysecond` VALUES ('12', '女包', '2');
INSERT INTO `categorysecond` VALUES ('13', '男包', '2');
INSERT INTO `categorysecond` VALUES ('14', '服饰配件', '2');
INSERT INTO `categorysecond` VALUES ('15', '运动鞋', '3');
INSERT INTO `categorysecond` VALUES ('16', '运动服', '3');
INSERT INTO `categorysecond` VALUES ('17', '户外运动', '3');
INSERT INTO `categorysecond` VALUES ('18', '健身装备', '3');
INSERT INTO `categorysecond` VALUES ('19', '骑行装备', '3');
INSERT INTO `categorysecond` VALUES ('21', '时尚饰品', '4');
INSERT INTO `categorysecond` VALUES ('22', '品质手表', '4');
INSERT INTO `categorysecond` VALUES ('23', '眼镜配饰', '4');
INSERT INTO `categorysecond` VALUES ('24', '手机', '5');
INSERT INTO `categorysecond` VALUES ('25', '平板', '5');
INSERT INTO `categorysecond` VALUES ('26', '电脑', '5');
INSERT INTO `categorysecond` VALUES ('27', '相机', '5');
INSERT INTO `categorysecond` VALUES ('28', '大家电', '6');
INSERT INTO `categorysecond` VALUES ('29', '厨房电器', '6');
INSERT INTO `categorysecond` VALUES ('30', '生活电器', '6');
INSERT INTO `categorysecond` VALUES ('31', '个户电器', '6');
INSERT INTO `categorysecond` VALUES ('32', '办公耗材', '6');
INSERT INTO `categorysecond` VALUES ('33', '美容护肤', '7');
INSERT INTO `categorysecond` VALUES ('34', '强效保养', '7');
INSERT INTO `categorysecond` VALUES ('35', '超值彩妆', '7');
INSERT INTO `categorysecond` VALUES ('36', '换季保养', '7');
INSERT INTO `categorysecond` VALUES ('40', '组合柜222', '10');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `FKE8B2AB6166C01961` (`oid`),
  KEY `FKE8B2AB6171DB7AE4` (`pid`),
  KEY `FKE8B2AB6140ACF87A` (`oid`),
  CONSTRAINT `FKE8B2AB6140ACF87A` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`),
  CONSTRAINT `FKE8B2AB6171DB7AE4` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('2', '1', '198', '73', '2000');
INSERT INTO `orderitem` VALUES ('3', '1', '172', '2', '2000');
INSERT INTO `orderitem` VALUES ('4', '1', '358', '51', '3000');
INSERT INTO `orderitem` VALUES ('5', '1', '590', '7', '4000');
INSERT INTO `orderitem` VALUES ('6', '1', '172', '2', '5000');
INSERT INTO `orderitem` VALUES ('7', '1', '228', '1', '5000');
INSERT INTO `orderitem` VALUES ('8', '1', '119', '5', '5000');
INSERT INTO `orderitem` VALUES ('9', '1', '125', '75', '6000');
INSERT INTO `orderitem` VALUES ('10', '1', '83', '72', '7000');
INSERT INTO `orderitem` VALUES ('11', '1', '358', '51', '8000');
INSERT INTO `orderitem` VALUES ('12', '1', '83', '68', '9000');
INSERT INTO `orderitem` VALUES ('13', '1', '83', '66', '9001');
INSERT INTO `orderitem` VALUES ('14', '1', '172', '2', '9001');
INSERT INTO `orderitem` VALUES ('15', '1', '228', '1', '9002');
INSERT INTO `orderitem` VALUES ('16', '1', '5099', '79', '9003');

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
) ENGINE=InnoDB AUTO_INCREMENT=9004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('2000', '370', '2015-02-11 10:04:23', '1', null, null, null, '7');
INSERT INTO `orders` VALUES ('3000', '358', '2015-02-11 10:46:41', '1', null, null, null, '7');
INSERT INTO `orders` VALUES ('4000', '590', '2015-02-11 10:46:47', '1', null, null, null, '7');
INSERT INTO `orders` VALUES ('5000', '519', '2015-02-11 10:47:01', '1', null, null, null, '7');
INSERT INTO `orders` VALUES ('6000', '125', '2015-02-11 10:47:07', '1', null, null, null, '7');
INSERT INTO `orders` VALUES ('7000', '83', '2015-02-11 10:47:15', '1', '姜涛', '15726607618', '北京市西三旗中腾建华3楼', '7');
INSERT INTO `orders` VALUES ('8000', '358', '2015-02-11 11:17:22', '2', '姜涛', '15726607618', '北京市西三旗中腾建华3楼', '7');
INSERT INTO `orders` VALUES ('9000', '83', '2015-02-11 11:23:26', '2', '姜涛', '15726607618', '北京市西三旗中腾建华3楼', '7');
INSERT INTO `orders` VALUES ('9001', '255', '2015-02-23 21:31:19', '1', null, null, null, '7');
INSERT INTO `orders` VALUES ('9002', '228', '2015-02-27 09:07:55', '1', null, null, null, '7');
INSERT INTO `orders` VALUES ('9003', '5099', '2015-02-27 15:35:53', '4', '姜涛', '15726607618', '北京市西三旗中腾建华3楼', '7');

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
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '韩版连帽加厚毛衣女外套', '558', '228', 'products/baixiangguo.jpg', '双11限量200件，拍完下架，加车享优惠，早下手早发货。。秋冬个性中长款毛衣，美丽和温度同在！限量供应，拒绝撞衫！迫于纱线和人工在不断上涨的双重压力下，产品涨价在即！少量现货出售中，手快有，手慢等哦，赶紧抢哦，绝对高大上。', '1', '2014-11-02 20:18:00', '1');
INSERT INTO `product` VALUES ('21', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/boluo.jpg', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '1', '2014-11-03 20:18:00', '3');
INSERT INTO `product` VALUES ('35', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/caomei.jpg', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '1', '2014-11-03 20:18:00', '4');
INSERT INTO `product` VALUES ('41', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/chengzi.jpg', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '1', '2014-11-03 20:18:00', '4');
INSERT INTO `product` VALUES ('42', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/cuizao.jpg', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-11-03 20:18:00', '5');
INSERT INTO `product` VALUES ('44', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/hamigua.jpg', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-11-03 20:18:00', '5');
INSERT INTO `product` VALUES ('47', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/jinju.jpg', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-11-03 20:18:00', '5');
INSERT INTO `product` VALUES ('51', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/li.jpg', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-12-07 20:18:00', '5');
INSERT INTO `product` VALUES ('53', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/liulian.jpg', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '1', '2014-11-03 20:18:00', '6');
INSERT INTO `product` VALUES ('57', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/maotao.jpg', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '1', '2014-12-07 22:18:00', '6');

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
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('7', 'sxk', '123', 'sxk', 'aaa@shop.com', '15726607618', '辽宁省大连市', '1', null);
INSERT INTO `user` VALUES ('8', 'lsy', '123', 'lsy', 'bbb@shop.com', '18726607618', '辽宁省大连市', '1', '');

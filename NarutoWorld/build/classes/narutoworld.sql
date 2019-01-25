/*
Navicat MySQL Data Transfer

Source Server         : zxw
Source Server Version : 50130
Source Host           : localhost:3306
Source Database       : narutoworld

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2018-06-29 19:03:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` int(64) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) DEFAULT NULL,
  `adminLoginName` varchar(100) DEFAULT NULL,
  `adminPassword` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for characterinfo
-- ----------------------------
DROP TABLE IF EXISTS `characterinfo`;
CREATE TABLE `characterinfo` (
  `characterinfoId` int(64) NOT NULL AUTO_INCREMENT,
  `characterinfoNum` varchar(11) DEFAULT NULL,
  `characterinfoName` varchar(255) DEFAULT NULL,
  `characterinfoDesc` varchar(1000) DEFAULT NULL,
  `characterinfoActivated` int(11) DEFAULT NULL,
  PRIMARY KEY (`characterinfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of characterinfo
-- ----------------------------
INSERT INTO `characterinfo` VALUES ('1', '001', '漩涡鸣人', '火之国木叶隐村的忍者，四代目火影波风水门和漩涡玖辛奈之子，六道仙人次子阿修罗转世。刚出生时父母为保护村子而牺牲，并将强大的尾兽“九尾”封印于鸣人体内。成为孤儿的鸣人在孤独中长大，但在唯一认同他的老师海野伊鲁卡以及三代目火影鼓励下有了要成为火影的梦想，让所有人都认同他的存在。成为忍者后，同旗木卡卡西、宇智波佐助和春野樱组成第七班进行各种任务。为实现梦想，和守护伙伴们的羁绊，鸣人不断修炼，作为木叶“三忍”之一自来也的弟子，在追求梦想的过程中不断突破自我，贯彻了自身的忍道，获得人们的认可。', '1');
INSERT INTO `characterinfo` VALUES ('2', '002', '宇智波佐助', '火之国木叶隐村宇智波一族的天才忍者，六道仙人长子因陀罗的转世。年幼时目睹宇智波一族被哥哥宇智波鼬全灭，从而走上复仇之路。在终末之谷与漩涡鸣人展开激战，将鸣人打败后叛离木叶并追随大蛇丸。三年后，佐助将大蛇丸吸收到异空间，并成功向鼬复仇，但在此之后却得知了宇智波鼬的灭族真相，于是决定摧毁木叶。后来，佐助与秽土转生的鼬重逢，想法再次发生了变化，为了进一步了解忍者、家族、哥哥的过去，佐助与秽土转生的历代火影进行交谈，在听完他们的回答后决定继承鼬的意志守护木叶，并希望成为火影改变现有的忍界体制。', '1');
INSERT INTO `characterinfo` VALUES ('3', '003', '春野樱', '新一代医疗忍者，五代目火影纲手的弟子，与漩涡鸣人、宇智波佐助隶属于旗木卡卡西领导的第七班。 原本个性柔弱任性，在木叶忍者学校以忍术理论知识见长。在佐助离开木叶村后，拜第五代火影纲手为师，学成优秀的体术怪力和医疗忍术。第四次忍界大战中作为忍者联军第三部队以及医疗后勤部队的一员。具有良好的查克拉控制能力与清晰的脑力，擅长体术怪力与医疗忍术以及解除幻术（拥有幻术天赋，早期设定是幻术型忍者）。经过自己艰苦卓绝的努力奋斗，最终成长为一个贯彻自己座右铭“勇气”的优秀忍者。', '1');
INSERT INTO `characterinfo` VALUES ('4', '004', '我爱罗', '我爱罗，日本漫画《火影忍者》及其衍生作品中的角色。风之国·砂隐村的第五代风影。小时候由于体内封印着一尾守鹤而被村人害怕，又因为至亲之人的背叛而导致性格变得冷酷无情、喜好杀戮，但在和漩涡鸣人一战后，由于鸣人的影响而逐渐摆脱心魔。之后我爱罗成为第五代风影，领导并守护着砂隐村，但一度被“晓”抽去了一尾守鹤而死亡，最后被千代牺牲性命复活。第四次忍界大战中，我爱罗担任忍界联军队长与第四部队统领。战争结束后，我爱罗仍继续担任风影的职位，还和鸣人及木叶村等人维持着友好的关系。', '0');

-- ----------------------------
-- Table structure for homenews
-- ----------------------------
DROP TABLE IF EXISTS `homenews`;
CREATE TABLE `homenews` (
  `homenewsId` varchar(64) NOT NULL,
  `homenewsLink` varchar(255) DEFAULT NULL,
  `homenewsPhoto` varchar(255) DEFAULT NULL,
  `homenewsActivated` int(11) DEFAULT NULL,
  PRIMARY KEY (`homenewsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homenews
-- ----------------------------
INSERT INTO `homenews` VALUES ('1', 'https://baike.baidu.com/item/%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85/3206592?fr=aladdin', '/img/upload/a.png', '1');
INSERT INTO `homenews` VALUES ('2', 'https://baike.baidu.com/item/%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85/3206592?fr=aladdin', '/img/upload/b.png', '0');

-- ----------------------------
-- Table structure for links
-- ----------------------------
DROP TABLE IF EXISTS `links`;
CREATE TABLE `links` (
  `linksId` int(64) NOT NULL AUTO_INCREMENT,
  `linksDesc` varchar(255) DEFAULT NULL,
  `linksLink` varchar(255) DEFAULT NULL,
  `linksDate` varchar(100) DEFAULT NULL,
  `linksUpdate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`linksId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of links
-- ----------------------------
INSERT INTO `links` VALUES ('1', '火影忍者', 'https://baike.baidu.com/item/%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85/8702?fr=aladdin#4_6', '百度百科', '2018-06-28 01:04:35');
INSERT INTO `links` VALUES ('2', '火影忍者地理', 'https://baike.baidu.com/item/%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%9C%B0%E7%90%86', '百度百科', '2018-06-28 01:04:35');
INSERT INTO `links` VALUES ('3', '火影忍者TV版全集在线观看', 'http://list.youku.com/show/id_zcc001f06962411de83b1.html?tpa=dW5pb25faWQ9MTAzNzUzXzEwMDAwMV8wMV8wMQ&refer=baiduald1705', '优酷', '2018-06-28 01:04:35');
INSERT INTO `links` VALUES ('4', '火影忍者中文网', 'http://www.narutom.com/', '官网', '2018-06-28 01:04:35');
INSERT INTO `links` VALUES ('5', '火影忍者疾风传东京电视台', 'http://www.tv-tokyo.co.jp/anime/naruto/index2.html', '官网', '2018-06-28 01:04:35');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `newsId` int(64) NOT NULL AUTO_INCREMENT,
  `newsDesc` varchar(255) DEFAULT NULL,
  `newsLink` varchar(255) DEFAULT NULL,
  `newsDate` varchar(100) DEFAULT NULL,
  `newsUpdate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`newsId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', 'アニメ『...ーズ最後の主題歌コンピ登場！！', 'http://www.tv-tokyo.co.jp/anime/naruto/news/news11/index.html#203635', '2018-06-28 ', '2018-06-28 01:04:35');
INSERT INTO `news` VALUES ('2', 'zxw「あにてれ」で配信開始！', 'http://www.tv-tokyo.co.jp/anime/naruto/news/news11/index.html#200579', '2018-06-28 ', '2018-06-28 01:04:35');
INSERT INTO `news` VALUES ('3', 'BORUTO-... GENERATIONS本サイト公開！', 'http://www.tv-tokyo.co.jp/anime/naruto/news/news11/index.html#198988', '2018-06-28 ', '2018-06-28 01:04:35');
INSERT INTO `news` VALUES ('4', '2月16日（木）の放送で豪華プレゼントを実施！ ', 'http://www.tv-tokyo.co.jp/anime/naruto/news/news11/index.html#198568', '2018-06-28 ', '2018-06-28 01:04:35');
INSERT INTO `news` VALUES ('5', 'ストーリーとPVを公開しました！', 'http://www.tv-tokyo.co.jp/anime/naruto/news/news11/index.html#198348', '2018-06-28 ', '2018-06-28 01:04:35');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `level` varchar(100) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `registdate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '张兴伟', '123', '男', '影', '雷之国', '2018-06-28 01:08:03');
INSERT INTO `user` VALUES ('3', '123', '123', '男', '下忍', '水之国', '2018-06-28 01:11:29');
INSERT INTO `user` VALUES ('4', '阿斯顿', 'qwe', '男', '中忍', '土之国', '2018-06-28 01:11:57');
INSERT INTO `user` VALUES ('5', '请问请问', 'asd', '男', '见习下忍', '风之国', '2018-06-28 01:13:34');
INSERT INTO `user` VALUES ('6', '托业', 'rty', '男', '中忍', '雷之国', '2018-06-28 01:38:28');
INSERT INTO `user` VALUES ('8', '123请问', '123', '男', '见习下忍', '水之国', '2018-06-28 17:23:57');
INSERT INTO `user` VALUES ('9', '123123123', '123', '男', '中忍', '火之国', '2018-06-28 17:28:10');
INSERT INTO `user` VALUES ('10', '2我', '123', '男', '下忍', '火之国', '2018-06-28 17:36:35');

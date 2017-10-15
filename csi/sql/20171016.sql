-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: csi
-- ------------------------------------------------------
-- Server version	5.6.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_admin_user`
--

DROP TABLE IF EXISTS `tbl_admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_admin_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_admin_user`
--

LOCK TABLES `tbl_admin_user` WRITE;
/*!40000 ALTER TABLE `tbl_admin_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_admin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_card_crime_item_clue`
--

DROP TABLE IF EXISTS `tbl_card_crime_item_clue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_card_crime_item_clue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_no` int(10) DEFAULT NULL COMMENT '编号',
  `item_type` char(1) DEFAULT NULL COMMENT '1.作案工具 2.作案线索',
  `item_name` varchar(45) DEFAULT NULL COMMENT '名称',
  `pic` varchar(200) DEFAULT '0' COMMENT '图片位置',
  `status` int(10) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=311 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_card_crime_item_clue`
--

LOCK TABLES `tbl_card_crime_item_clue` WRITE;
/*!40000 ALTER TABLE `tbl_card_crime_item_clue` DISABLE KEYS */;
INSERT INTO `tbl_card_crime_item_clue` VALUES (1,400,'4','纵火','/images/findings/finding_00',0,'','2017-10-13 13:53:33'),(2,401,'4','圈套','/images/findings/finding_01',0,'','2017-10-13 13:53:33'),(3,402,'4','竹尖','/images/findings/finding_02',0,'','2017-10-13 13:53:33'),(4,403,'4','机械','/images/findings/finding_03',0,'','2017-10-13 13:53:33'),(5,404,'4','铁丝','/images/findings/finding_04',0,'','2017-10-13 13:53:33'),(6,405,'4','药粉','/images/findings/finding_05',0,'','2017-10-13 13:53:33'),(7,406,'4','砖块','/images/findings/finding_06',0,'','2017-10-13 13:53:33'),(8,407,'4','石头','/images/findings/finding_07',0,'','2017-10-13 13:53:33'),(9,408,'4','溺水','/images/findings/finding_08',0,'','2017-10-13 13:53:33'),(10,409,'4','胶布','/images/findings/finding_09',0,'','2017-10-13 13:53:33'),(11,410,'4','斧头','/images/findings/finding_10',0,'','2017-10-13 13:53:33'),(12,411,'4','陷害','/images/findings/finding_11',0,'','2017-10-13 13:53:33'),(13,412,'4','毒品','/images/findings/finding_12',0,'','2017-10-13 13:53:33'),(14,413,'4','砒霜','/images/findings/finding_13',0,'','2017-10-13 13:53:33'),(15,414,'4','煤气','/images/findings/finding_14',0,'','2017-10-13 13:53:33'),(16,415,'4','饥荒','/images/findings/finding_15',0,'','2017-10-13 13:53:33'),(17,416,'4','疯狗','/images/findings/finding_16',0,'','2017-10-13 13:53:33'),(18,417,'4','病毒','/images/findings/finding_17',0,'','2017-10-13 13:53:33'),(19,418,'4','电闸','/images/findings/finding_18',0,'','2017-10-13 13:53:33'),(20,419,'4','电锯','/images/findings/finding_19',0,'','2017-10-13 13:53:33'),(21,420,'4','游戏','/images/findings/finding_20',0,'','2017-10-13 13:53:33'),(22,421,'4','注射','/images/findings/finding_21',0,'','2017-10-13 13:53:33'),(23,422,'4','炸药','/images/findings/finding_22',0,'','2017-10-13 13:53:33'),(24,423,'4','阴谋','/images/findings/finding_23',0,'','2017-10-13 13:53:33'),(25,424,'4','菜刀','/images/findings/finding_24',0,'','2017-10-13 13:53:33'),(26,425,'4','毒蛇','/images/findings/finding_25',0,'','2017-10-13 13:53:33'),(27,426,'4','铁铲','/images/findings/finding_26',0,'','2017-10-13 13:53:33'),(28,427,'4','奖杯','/images/findings/finding_27',0,'','2017-10-13 13:53:33'),(29,428,'4','电流','/images/findings/finding_28',0,'','2017-10-13 13:53:33'),(30,429,'4','刀片','/images/findings/finding_29',0,'','2017-10-13 13:53:33'),(31,430,'4','刀叉','/images/findings/finding_30',0,'','2017-10-13 13:53:33'),(32,431,'4','徒手','/images/findings/finding_31',0,'','2017-10-13 13:53:33'),(33,432,'4','大麻','/images/findings/finding_32',0,'','2017-10-13 13:53:33'),(34,433,'4','暴行','/images/findings/finding_33',0,'','2017-10-13 13:53:33'),(35,434,'4','毒针','/images/findings/finding_34',0,'','2017-10-13 13:53:33'),(36,435,'4','事故','/images/findings/finding_35',0,'','2017-10-13 13:53:33'),(37,436,'4','酒精','/images/findings/finding_36',0,'','2017-10-13 13:53:33'),(38,437,'4','火药','/images/findings/finding_37',0,'','2017-10-13 13:53:33'),(39,438,'4','玻璃','/images/findings/finding_38',0,'','2017-10-13 13:53:33'),(40,439,'4','盆栽','/images/findings/finding_39',0,'','2017-10-13 13:53:33'),(41,440,'4','奸杀','/images/findings/finding_40',0,'','2017-10-13 13:53:33'),(42,441,'4','拳击','/images/findings/finding_41',0,'','2017-10-13 13:53:33'),(43,442,'4','药剂','/images/findings/finding_42',0,'','2017-10-13 13:53:33'),(44,443,'4','火机','/images/findings/finding_43',0,'','2017-10-13 13:53:33'),(45,444,'4','扳手','/images/findings/finding_44',0,'','2017-10-13 13:53:33'),(46,445,'4','推拉','/images/findings/finding_45',0,'','2017-10-13 13:53:33'),(47,446,'4','切割','/images/findings/finding_46',0,'','2017-10-13 13:53:33'),(48,447,'4','火柴','/images/findings/finding_47',0,'','2017-10-13 13:53:33'),(49,448,'4','铁钩','/images/findings/finding_48',0,'','2017-10-13 13:53:33'),(50,449,'4','烛台','/images/findings/finding_49',0,'','2017-10-13 13:53:33'),(51,450,'4','棍棒','/images/findings/finding_50',0,'','2017-10-13 13:53:33'),(52,451,'4','放血','/images/findings/finding_51',0,'','2017-10-13 13:53:33'),(53,452,'4','毒蝎','/images/findings/finding_52',0,'','2017-10-13 13:53:33'),(54,453,'4','狙击','/images/findings/finding_53',0,'','2017-10-13 13:53:33'),(55,454,'4','硫酸','/images/findings/finding_54',0,'','2017-10-13 13:53:33'),(56,455,'4','手术','/images/findings/finding_55',0,'','2017-10-13 13:53:33'),(57,456,'4','密室','/images/findings/finding_56',0,'','2017-10-13 13:53:33'),(58,457,'4','药物','/images/findings/finding_57',0,'','2017-10-13 13:53:33'),(59,458,'4','汽油','/images/findings/finding_58',0,'','2017-10-13 13:53:33'),(60,459,'4','匕首','/images/findings/finding_59',0,'','2017-10-13 13:53:33'),(61,460,'4','电钻','/images/findings/finding_60',0,'','2017-10-13 13:53:33'),(62,461,'4','钢管','/images/findings/finding_61',0,'','2017-10-13 13:53:33'),(63,462,'4','瘟疫','/images/findings/finding_62',0,'','2017-10-13 13:53:33'),(64,463,'4','砍刀','/images/findings/finding_63',0,'','2017-10-13 13:53:33'),(65,464,'4','手枪','/images/findings/finding_64',0,'','2017-10-13 13:53:33'),(66,465,'4','农药','/images/findings/finding_65',0,'','2017-10-13 13:53:33'),(67,466,'4','毛巾','/images/findings/finding_66',0,'','2017-10-13 13:53:33'),(68,467,'4','化学品','/images/findings/finding_67',0,'','2017-10-13 13:53:33'),(69,468,'4','撕咬','/images/findings/finding_68',0,'','2017-10-13 13:53:33'),(70,469,'4','酒瓶','/images/findings/finding_69',0,'','2017-10-13 13:53:33'),(71,470,'4','水银','/images/findings/finding_70',0,'','2017-10-13 13:53:33'),(72,471,'4','恐吓','/images/findings/finding_71',0,'','2017-10-13 13:53:33'),(73,472,'4','虐待','/images/findings/finding_72',0,'','2017-10-13 13:53:33'),(74,473,'4','铁链','/images/findings/finding_73',0,'','2017-10-13 13:53:33'),(75,474,'4','绳索','/images/findings/finding_74',0,'','2017-10-13 13:53:33'),(76,475,'4','工作','/images/findings/finding_75',0,'','2017-10-13 13:53:33'),(77,476,'4','美工刀','/images/findings/finding_76',0,'','2017-10-13 13:53:33'),(78,477,'4','铁锤','/images/findings/finding_77',0,'','2017-10-13 13:53:33'),(79,478,'4','剪刀','/images/findings/finding_78',0,'','2017-10-13 13:53:33'),(80,479,'4','围巾','/images/findings/finding_79',0,'','2017-10-13 13:53:33'),(81,480,'4','雕塑','/images/findings/finding_80',0,'','2017-10-13 13:53:33'),(82,481,'4','毒气','/images/findings/finding_91',0,'','2017-10-13 13:53:33'),(83,482,'4','踢打','/images/findings/finding_92',0,'','2017-10-13 13:53:33'),(84,483,'4','割喉','/images/findings/finding_93',0,'','2017-10-13 13:53:33'),(85,484,'4','电线','/images/findings/finding_94',0,'','2017-10-13 13:53:33'),(86,485,'4','哑铃','/images/findings/finding_95',0,'','2017-10-13 13:53:33'),(87,486,'4','毒液','/images/findings/finding_96',0,'','2017-10-13 13:53:33'),(88,487,'4','软禁','/images/findings/finding_97',0,'','2017-10-13 13:53:33'),(89,488,'4','皮带','/images/findings/finding_98',0,'','2017-10-13 13:53:33'),(90,489,'4','刑具','/images/findings/finding_99',0,'','2017-10-13 13:53:33'),(91,5001,'5','漫画','/images/findings/item_001.png',0,'','2017-10-13 13:53:33'),(92,5019,'5','蛋糕','/images/findings/item_019.png',0,'','2017-10-13 13:53:33'),(93,5020,'5','皮包','/images/findings/item_020.png',0,'','2017-10-13 13:53:33'),(94,5021,'5','假牙','/images/findings/item_021.png',0,'','2017-10-13 13:53:33'),(95,5022,'5','杯子','/images/findings/item_022.png',0,'','2017-10-13 13:53:33'),(96,5023,'5','手电筒','/images/findings/item_023.png',0,'','2017-10-13 13:53:33'),(97,5024,'5','雨衣','/images/findings/item_024.png',0,'','2017-10-13 13:53:33'),(98,5025,'5','油漆','/images/findings/item_025.png',0,'','2017-10-13 13:53:33'),(99,5026,'5','睡袋','/images/findings/item_026.png',0,'','2017-10-13 13:53:33'),(100,5027,'5','日历','/images/findings/item_027.png',0,'','2017-10-13 13:53:33'),(101,5028,'5','试卷','/images/findings/item_028.png',0,'','2017-10-13 13:53:33'),(102,5029,'5','照片','/images/findings/item_029.png',0,'','2017-10-13 13:53:33'),(103,5030,'5','配方','/images/findings/item_030.png',0,'','2017-10-13 13:53:33'),(104,5031,'5','骨头','/images/findings/item_031.png',0,'','2017-10-13 13:53:33'),(105,5032,'5','子弹','/images/findings/item_032.png',0,'','2017-10-13 13:53:33'),(106,5033,'5','别针','/images/findings/item_033.png',0,'','2017-10-13 13:53:33'),(107,5034,'5','怀表','/images/findings/item_034.png',0,'','2017-10-13 13:53:33'),(108,5035,'5','外卖','/images/findings/item_035.png',0,'','2017-10-13 13:53:33'),(109,5036,'5','苹果','/images/findings/item_036.png',0,'','2017-10-13 13:53:33'),(110,5037,'5','纸箱','/images/findings/item_037.png',0,'','2017-10-13 13:53:33'),(111,5038,'5','欠条','/images/findings/item_038.png',0,'','2017-10-13 13:53:33'),(112,5039,'5','药材','/images/findings/item_039.png',0,'','2017-10-13 13:53:33'),(113,5040,'5','蚊子','/images/findings/item_040.png',0,'','2017-10-13 13:53:33'),(114,5041,'5','杂志','/images/findings/item_041.png',0,'','2017-10-13 13:53:33'),(115,5042,'5','扑克','/images/findings/item_042.png',0,'','2017-10-13 13:53:33'),(116,5044,'5','西装','/images/findings/item_044.png',0,'','2017-10-13 13:53:33'),(117,5045,'5','陀螺','/images/findings/item_045.png',0,'','2017-10-13 13:53:33'),(118,5046,'5','积木','/images/findings/item_046.png',0,'','2017-10-13 13:53:33'),(119,5047,'5','书刊','/images/findings/item_047.png',0,'','2017-10-13 13:53:33'),(120,5048,'5','拐杖','/images/findings/item_048.png',0,'','2017-10-13 13:53:33'),(121,5049,'5','拖鞋','/images/findings/item_049.png',0,'','2017-10-13 13:53:33'),(122,5050,'5','监控','/images/findings/item_050.png',0,'','2017-10-13 13:53:33'),(123,5051,'5','袜子','/images/findings/item_051.png',0,'','2017-10-13 13:53:33'),(124,5052,'5','扫把','/images/findings/item_052.png',0,'','2017-10-13 13:53:33'),(125,5053,'5','皮鞋','/images/findings/item_053.png',0,'','2017-10-13 13:53:33'),(126,5054,'5','开关','/images/findings/item_054.png',0,'','2017-10-13 13:53:33'),(127,5055,'5','花生','/images/findings/item_055.png',0,'','2017-10-13 13:53:33'),(128,5056,'5','骷髅','/images/findings/item_056.png',0,'','2017-10-13 13:53:33'),(129,5057,'5','日记','/images/findings/item_057.png',0,'','2017-10-13 13:53:33'),(130,5058,'5','狗毛','/images/findings/item_058.png',0,'','2017-10-13 13:53:33'),(131,5059,'5','相机','/images/findings/item_059.png',0,'','2017-10-13 13:53:33'),(132,5060,'5','印章','/images/findings/item_060.png',0,'','2017-10-13 13:53:33'),(133,5061,'5','乱码','/images/findings/item_061.png',0,'','2017-10-13 13:53:33'),(134,5062,'5','汽水','/images/findings/item_062.png',0,'','2017-10-13 13:53:33'),(135,5063,'5','记号','/images/findings/item_063.png',0,'','2017-10-13 13:53:33'),(136,5064,'5','模型','/images/findings/item_064.png',0,'','2017-10-13 13:53:33'),(137,5065,'5','数据','/images/findings/item_065.png',0,'','2017-10-13 13:53:33'),(138,5066,'5','门把','/images/findings/item_066.png',0,'','2017-10-13 13:53:33'),(139,5067,'5','玩具','/images/findings/item_067.png',0,'','2017-10-13 13:53:33'),(140,5068,'5','海绵','/images/findings/item_068.png',0,'','2017-10-13 13:53:33'),(141,5069,'5','毛发','/images/findings/item_069.png',0,'','2017-10-13 13:53:33'),(142,5070,'5','电路','/images/findings/item_070.png',0,'','2017-10-13 13:53:33'),(143,5071,'5','证件','/images/findings/item_071.png',0,'','2017-10-13 13:53:33'),(144,5072,'5','首饰','/images/findings/item_072.png',0,'','2017-10-13 13:53:33'),(145,5073,'5','外套','/images/findings/item_073.png',0,'','2017-10-13 13:53:33'),(146,5074,'5','传真','/images/findings/item_074.png',0,'','2017-10-13 13:53:33'),(147,5075,'5','报纸','/images/findings/item_075.png',0,'','2017-10-13 13:53:33'),(148,5076,'5','试管','/images/findings/item_076.png',0,'','2017-10-13 13:53:33'),(149,5077,'5','戒指','/images/findings/item_077.png',0,'','2017-10-13 13:53:33'),(150,5078,'5','录音','/images/findings/item_078.png',0,'','2017-10-13 13:53:33'),(151,5079,'5','信封','/images/findings/item_079.png',0,'','2017-10-13 13:53:33'),(152,5080,'5','面膜','/images/findings/item_080.png',0,'','2017-10-13 13:53:33'),(153,5081,'5','石材','/images/findings/item_081.png',0,'','2017-10-13 13:53:33'),(154,5082,'5','镊子','/images/findings/item_082.png',0,'','2017-10-13 13:53:33'),(155,5083,'5','镜子','/images/findings/item_083.png',0,'','2017-10-13 13:53:33'),(156,5084,'5','糖果','/images/findings/item_084.png',0,'','2017-10-13 13:53:33'),(157,5085,'5','传单','/images/findings/item_085.png',0,'','2017-10-13 13:53:33'),(158,5086,'5','猫咪','/images/findings/item_086.png',0,'','2017-10-13 13:53:33'),(159,5087,'5','咖啡','/images/findings/item_087.png',0,'','2017-10-13 13:53:33'),(160,5088,'5','头盔','/images/findings/item_088.png',0,'','2017-10-13 13:53:33'),(161,5089,'5','麻袋','/images/findings/item_089.png',0,'','2017-10-13 13:53:33'),(162,5090,'5','齿轮','/images/findings/item_090.png',0,'','2017-10-13 13:53:33'),(163,5091,'5','磁盘','/images/findings/item_091.png',0,'','2017-10-13 13:53:33'),(164,5092,'5','帽子','/images/findings/item_092.png',0,'','2017-10-13 13:53:33'),(165,5093,'5','抹布','/images/findings/item_093.png',0,'','2017-10-13 13:53:33'),(166,5094,'5','木屑','/images/findings/item_094.png',0,'','2017-10-13 13:53:33'),(167,5095,'5','墨水','/images/findings/item_095.png',0,'','2017-10-13 13:53:33'),(168,5096,'5','签名','/images/findings/item_096.png',0,'','2017-10-13 13:53:33'),(169,5097,'5','泡沫','/images/findings/item_097.png',0,'','2017-10-13 13:53:33'),(170,5098,'5','灰尘','/images/findings/item_098.png',0,'','2017-10-13 13:53:33'),(171,5099,'5','调料','/images/findings/item_099.png',0,'','2017-10-13 13:53:33'),(172,5100,'5','针管','/images/findings/item_100.png',0,'','2017-10-13 13:53:33'),(173,5101,'5','情书','/images/findings/item_101.png',0,'','2017-10-13 13:53:33'),(174,5102,'5','标本','/images/findings/item_102.png',0,'','2017-10-13 13:53:33'),(175,5103,'5','木材','/images/findings/item_103.png',0,'','2017-10-13 13:53:33'),(176,5104,'5','丝袜','/images/findings/item_104.png',0,'','2017-10-13 13:53:33'),(177,5105,'5','古董','/images/findings/item_105.png',0,'','2017-10-13 13:53:33'),(178,5106,'5','蜡烛','/images/findings/item_106.png',0,'','2017-10-13 13:53:33'),(179,5107,'5','乐器','/images/findings/item_107.png',0,'','2017-10-13 13:53:33'),(180,5108,'5','票据','/images/findings/item_108.png',0,'','2017-10-13 13:53:33'),(181,5109,'5','煤油','/images/findings/item_109.png',0,'','2017-10-13 13:53:33'),(182,5110,'5','木偶','/images/findings/item_110.png',0,'','2017-10-13 13:53:33'),(183,5111,'5','水果','/images/findings/item_111.png',0,'','2017-10-13 13:53:33'),(184,5112,'5','项链','/images/findings/item_112.png',0,'','2017-10-13 13:53:33'),(185,5113,'5','香水','/images/findings/item_113.png',0,'','2017-10-13 13:53:33'),(186,5114,'5','钞票','/images/findings/item_114.png',0,'','2017-10-13 13:53:33'),(187,5115,'5','面具','/images/findings/item_115.png',0,'','2017-10-13 13:53:33'),(188,5116,'5','针线','/images/findings/item_116.png',0,'','2017-10-13 13:53:33'),(189,5117,'5','沙漏','/images/findings/item_117.png',0,'','2017-10-13 13:53:33'),(190,5118,'5','油渍','/images/findings/item_118.png',0,'','2017-10-13 13:53:33'),(191,5119,'5','点滴','/images/findings/item_119.png',0,'','2017-10-13 13:53:33'),(192,5120,'5','拼图','/images/findings/item_120.png',0,'','2017-10-13 13:53:33'),(193,5121,'5','茶叶','/images/findings/item_121.png',0,'','2017-10-13 13:53:33'),(194,5122,'5','硬币','/images/findings/item_122.png',0,'','2017-10-13 13:53:33'),(195,5123,'5','肥皂','/images/findings/item_123.png',0,'','2017-10-13 13:53:33'),(196,5124,'5','鲜花','/images/findings/item_124.png',0,'','2017-10-13 13:53:33'),(197,5125,'5','手表','/images/findings/item_125.png',0,'','2017-10-13 13:53:33'),(198,5126,'5','雨伞','/images/findings/item_126.png',0,'','2017-10-13 13:53:33'),(199,5127,'5','粪便','/images/findings/item_127.png',0,'','2017-10-13 13:53:33'),(200,5128,'5','假发','/images/findings/item_128.png',0,'','2017-10-13 13:53:33'),(201,5129,'5','号码','/images/findings/item_129.png',0,'','2017-10-13 13:53:33'),(202,5130,'5','玫瑰','/images/findings/item_130.png',0,'','2017-10-13 13:53:33'),(203,5131,'5','快递','/images/findings/item_131.png',0,'','2017-10-13 13:53:33'),(204,5132,'5','墨镜','/images/findings/item_132.png',0,'','2017-10-13 13:53:33'),(205,5133,'5','雪茄','/images/findings/item_133.png',0,'','2017-10-13 13:53:33'),(206,5134,'5','鸡蛋','/images/findings/item_134.png',0,'','2017-10-13 13:53:33'),(207,5135,'5','蚊香','/images/findings/item_135.png',0,'','2017-10-13 13:53:33'),(208,5136,'5','胶水','/images/findings/item_136.png',0,'','2017-10-13 13:53:33'),(209,5137,'5','食材','/images/findings/item_137.png',0,'','2017-10-13 13:53:33'),(210,5138,'5','昆虫','/images/findings/item_138.png',0,'','2017-10-13 13:53:33'),(211,5139,'5','零食','/images/findings/item_139.png',0,'','2017-10-13 13:53:33'),(212,5140,'5','麻将','/images/findings/item_140.png',0,'','2017-10-13 13:53:33'),(213,5141,'5','异味','/images/findings/item_141.png',0,'','2017-10-13 13:53:33'),(214,5142,'5','耳机','/images/findings/item_142.png',0,'','2017-10-13 13:53:33'),(215,5143,'5','图钉','/images/findings/item_143.png',0,'','2017-10-13 13:53:33'),(216,5144,'5','钻石','/images/findings/item_144.png',0,'','2017-10-13 13:53:33'),(217,5145,'5','塑料','/images/findings/item_145.png',0,'','2017-10-13 13:53:33'),(218,5146,'5','耳环','/images/findings/item_146.png',0,'','2017-10-13 13:53:33'),(219,5147,'5','纹身','/images/findings/item_147.png',0,'','2017-10-13 13:53:33'),(220,5148,'5','音响','/images/findings/item_148.png',0,'','2017-10-13 13:53:33'),(221,5149,'5','笔记本电脑','/images/findings/item_149.png',0,'','2017-10-13 13:53:33'),(222,5150,'5','棉花','/images/findings/item_150.png',0,'','2017-10-13 13:53:33'),(223,5151,'5','内裤','/images/findings/item_151.png',0,'','2017-10-13 13:53:33'),(224,5152,'5','文档','/images/findings/item_152.png',0,'','2017-10-13 13:53:33'),(225,5153,'5','彩票','/images/findings/item_153.png',0,'','2017-10-13 13:53:33'),(226,5154,'5','鼠标','/images/findings/item_154.png',0,'','2017-10-13 13:53:33'),(227,5155,'5','文具','/images/findings/item_155.png',0,'','2017-10-13 13:53:33'),(228,5156,'5','手机','/images/findings/item_156.png',0,'','2017-10-13 13:53:33'),(229,5157,'5','密函','/images/findings/item_157.png',0,'','2017-10-13 13:53:33'),(230,5158,'5','行李','/images/findings/item_158.png',0,'','2017-10-13 13:53:33'),(231,5159,'5','谜题','/images/findings/item_159.png',0,'','2017-10-13 13:53:33'),(232,5160,'5','口红','/images/findings/item_160.png',0,'','2017-10-13 13:53:33'),(233,5161,'5','录像','/images/findings/item_161.png',0,'','2017-10-13 13:53:33'),(234,5162,'5','蚂蚁','/images/findings/item_162.png',0,'','2017-10-13 13:53:33'),(235,5163,'5','污垢','/images/findings/item_163.png',0,'','2017-10-13 13:53:33'),(236,5164,'5','冰块','/images/findings/item_164.png',0,'','2017-10-13 13:53:33'),(237,5165,'5','粉末','/images/findings/item_165.png',0,'','2017-10-13 13:53:33'),(238,5166,'5','粉笔','/images/findings/item_166.png',0,'','2017-10-13 13:53:33'),(239,5167,'5','老鼠','/images/findings/item_167.png',0,'','2017-10-13 13:53:33'),(240,5168,'5','密码','/images/findings/item_168.png',0,'','2017-10-13 13:53:33'),(241,5169,'5','手套','/images/findings/item_169.png',0,'','2017-10-13 13:53:33'),(242,5170,'5','果汁','/images/findings/item_170.png',0,'','2017-10-13 13:53:33'),(243,5171,'5','卡片','/images/findings/item_171.png',0,'','2017-10-13 13:53:33'),(244,5172,'5','纽扣','/images/findings/item_172.png',0,'','2017-10-13 13:53:33'),(245,5173,'5','证书','/images/findings/item_173.png',0,'','2017-10-13 13:53:33'),(246,5174,'5','手铐','/images/findings/item_174.png',0,'','2017-10-13 13:53:33'),(247,5175,'5','笔记','/images/findings/item_175.png',0,'','2017-10-13 13:53:33'),(248,5176,'5','锁头','/images/findings/item_176.png',0,'','2017-10-13 13:53:33'),(249,5177,'5','垃圾','/images/findings/item_177.png',0,'','2017-10-13 13:53:33'),(250,5178,'5','衣架','/images/findings/item_178.png',0,'','2017-10-13 13:53:33'),(251,5179,'5','蔬菜','/images/findings/item_179.png',0,'','2017-10-13 13:53:33'),(252,5180,'5','地图','/images/findings/item_180.png',0,'','2017-10-13 13:53:33'),(253,5181,'5','烟灰','/images/findings/item_181.png',0,'','2017-10-13 13:53:33'),(254,5182,'5','油画','/images/findings/item_182.png',0,'','2017-10-13 13:53:33'),(255,5183,'5','领带','/images/findings/item_183.png',0,'','2017-10-13 13:53:33'),(256,5184,'5','血液','/images/findings/item_184.png',0,'','2017-10-13 13:53:33'),(257,5185,'5','手镯','/images/findings/item_185.png',0,'','2017-10-13 13:53:33'),(258,5186,'5','电棒','/images/findings/item_186.png',0,'','2017-10-13 13:53:33'),(259,5187,'5','发夹','/images/findings/item_187.png',0,'','2017-10-13 13:53:33'),(260,5188,'5','请柬','/images/findings/item_188.png',0,'','2017-10-13 13:53:33'),(261,5189,'5','药丸','/images/findings/item_189.png',0,'','2017-10-13 13:53:33'),(262,5190,'5','铃声','/images/findings/item_190.png',0,'','2017-10-13 13:53:33'),(263,5191,'5','仪器','/images/findings/item_191.png',0,'','2017-10-13 13:53:33'),(264,5192,'5','馒头','/images/findings/item_192.png',0,'','2017-10-13 13:53:33'),(265,5193,'5','电话','/images/findings/item_193.png',0,'','2017-10-13 13:53:33'),(266,5194,'5','台灯','/images/findings/item_194.png',0,'','2017-10-13 13:53:33'),(267,5195,'5','窗帘','/images/findings/item_195.png',0,'','2017-10-13 13:53:33'),(268,5196,'5','钥匙','/images/findings/item_196.png',0,'','2017-10-13 13:53:33'),(269,5197,'5','工具','/images/findings/item_197.png',0,'','2017-10-13 13:53:33'),(270,5198,'5','字典','/images/findings/item_198.png',0,'','2017-10-13 13:53:33'),(271,5199,'5','筹码','/images/findings/item_199.png',0,'','2017-10-13 13:53:33'),(272,5200,'5','字条','/images/findings/item_200.png',0,'','2017-10-13 13:53:33'),(273,5201,'5','涂鸦','/images/findings/item_201.png',0,'','2017-10-13 13:53:33'),(274,5202,'5','颜料','/images/findings/item_202.png',0,'','2017-10-13 13:53:33'),(275,5203,'5','蜘蛛','/images/findings/item_203.png',0,'','2017-10-13 13:53:33'),(276,5204,'5','冷气','/images/findings/item_204.png',0,'','2017-10-13 13:53:33'),(277,5205,'5','镜片','/images/findings/item_205.png',0,'','2017-10-13 13:53:33'),(278,5206,'5','口罩','/images/findings/item_206.png',0,'','2017-10-13 13:53:33'),(279,5207,'5','烟头','/images/findings/item_207.png',0,'','2017-10-13 13:53:33'),(280,5208,'5','弹簧','/images/findings/item_208.png',0,'','2017-10-13 13:53:33'),(281,5209,'5','药方','/images/findings/item_209.png',0,'','2017-10-13 13:53:33'),(282,5210,'5','扇子','/images/findings/item_210.png',0,'','2017-10-13 13:53:33'),(283,5211,'5','小提琴','/images/findings/item_211.png',0,'','2017-10-13 13:53:33'),(284,5212,'5','纤维','/images/findings/item_212.png',0,'','2017-10-13 13:53:33'),(285,5213,'5','碎尸','/images/findings/item_213.png',0,'','2017-10-13 13:53:33'),(286,5214,'5','骰子','/images/findings/item_214.png',0,'','2017-10-13 13:53:33'),(287,5215,'5','电器','/images/findings/item_215.png',0,'','2017-10-13 13:53:33'),(288,5216,'5','蟑螂','/images/findings/item_216.png',0,'','2017-10-13 13:53:33'),(289,5217,'5','树叶','/images/findings/item_217.png',0,'','2017-10-13 13:53:33'),(290,5218,'5','制服','/images/findings/item_218.png',0,'','2017-10-13 13:53:33'),(291,5219,'5','邮票','/images/findings/item_219.png',0,'','2017-10-13 13:53:33'),(292,5220,'5','指甲','/images/findings/item_220.png',0,'','2017-10-13 13:53:33'),(293,5221,'5','枕头','/images/findings/item_221.png',0,'','2017-10-13 13:53:33'),(294,5222,'5','绷带','/images/findings/item_222.png',0,'','2017-10-13 13:53:33'),(295,5223,'5','灯泡','/images/findings/item_223.png',0,'','2017-10-13 13:53:33'),(296,5224,'5','剧本','/images/findings/item_224.png',0,'','2017-10-13 13:53:33'),(297,5225,'5','菜单','/images/findings/item_225.png',0,'','2017-10-13 13:53:33'),(298,5226,'5','胸章','/images/findings/item_226.png',0,'','2017-10-13 13:53:33'),(299,5227,'5','牙签','/images/findings/item_227.png',0,'','2017-10-13 13:53:33'),(300,5228,'5','迷宫','/images/findings/item_228.png',0,'','2017-10-13 13:53:33'),(301,5229,'5','铁钉','/images/findings/item_229.png',0,'','2017-10-13 13:53:33'),(302,5230,'5','植物','/images/findings/item_230.png',0,'','2017-10-13 13:53:33'),(303,5231,'5','网线','/images/findings/item_231.png',0,'','2017-10-13 13:53:33'),(304,5232,'5','内衣','/images/findings/item_232.png',0,'','2017-10-13 13:53:33'),(305,5233,'5','礼物','/images/findings/item_233.png',0,'','2017-10-13 13:53:33'),(306,5234,'5','沙子','/images/findings/item_234.png',0,'','2017-10-13 13:53:33'),(307,5235,'5','钱包','/images/findings/item_235.png',0,'','2017-10-13 13:53:33'),(308,5236,'5','纸巾','/images/findings/item_236.png',0,'','2017-10-13 13:53:33'),(309,5237,'5','红酒','/images/findings/item_237.png',0,'','2017-10-13 13:53:33'),(310,5238,'5','饭盒','/images/findings/item_238.png',0,'','2017-10-13 13:53:33');
/*!40000 ALTER TABLE `tbl_card_crime_item_clue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_card_crime_scene`
--

DROP TABLE IF EXISTS `tbl_card_crime_scene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_card_crime_scene` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_no` int(10) DEFAULT NULL COMMENT '编号',
  `item_type` int(10) DEFAULT NULL COMMENT '1.作案工具 2.作案线索',
  `content` varchar(200) DEFAULT NULL COMMENT '内容',
  `pic` varchar(100) DEFAULT '0' COMMENT '图片位置',
  `status` int(10) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_card_crime_scene`
--

LOCK TABLES `tbl_card_crime_scene` WRITE;
/*!40000 ALTER TABLE `tbl_card_crime_scene` DISABLE KEYS */;
INSERT INTO `tbl_card_crime_scene` VALUES (4,101,1,'窒息,重伤,失血,病发,中毒,意外','/images/clue/death.png',0,'死亡原因','2017-10-13 11:17:49'),(5,201,2,'公司,网吧,桑拿,赌场,邮局,衣柜','/images/clue/place/place_01.png',0,'案发地点','2017-10-13 11:17:49'),(6,202,2,'废墟,墓地,监狱,剧院,商场,楼顶','/images/clue/place/place_02.png',0,'案发地点','2017-10-13 11:17:49'),(7,203,2,'河边,荒山,营地,丛林,闹事,屠场','/images/clue/place/place_03.png',0,'案发地点','2017-10-13 11:17:49'),(8,204,2,'操场,教室,宿舍,食堂,电梯,厕所','/images/clue/place/place_04.png',0,'案发地点','2017-10-13 11:17:49'),(9,205,2,'客厅,房间,书房,浴室,厨房,露台','/images/clue/place/place_05.png',0,'案发地点','2017-10-13 11:17:49'),(10,206,2,'酒吧,书吧,餐厅,酒店,医院,工地','/images/clue/place/place_06.png',0,'案发地点','2017-10-13 11:17:49'),(11,207,2,'木屋,花园,地跌,公路,冷巷,吊桥','/images/clue/place/place_07.png',0,'案发地点','2017-10-13 11:17:49'),(12,208,2,'别墅,公园,超市,学校,广场,银行','/images/clue/place/place_08.png',0,'案发地点','2017-10-13 11:17:49'),(13,301,3,'高端,乱来,群嘲,沉默,离线,影帝','/images/clue/question/question_01.png',0,'凶手表现','2017-10-13 11:17:49'),(14,302,3,'文字,字母,数字,符号,光源,图形','/images/clue/question/question_02.png',0,'遗留迹象','2017-10-13 11:17:49'),(15,303,3,'亲戚,朋友,同事,师徒,情侣,陌生','/images/clue/question/question_03.png',0,'社会关系','2017-10-13 11:17:49'),(16,304,3,'仇杀,谋杀,暗杀,情杀,误杀,自杀','/images/clue/question/question_04.png',0,'作案动机','2017-10-13 11:17:49'),(17,305,3,'傲慢,卑鄙,暴怒,贪婪,淫邪,变态','/images/clue/question/question_05.png',0,'凶手性格','2017-10-13 11:17:49'),(18,306,3,'安详,挣扎,恐惧,痛苦,蒙面,异常','/images/clue/question/question_06.png',0,'面部表情','2017-10-13 11:17:49'),(19,307,3,'整齐,杂乱,华丽,破烂,奇特,裸体','/images/clue/question/question_07.png',0,'死者衣着','2017-10-13 11:17:49'),(20,308,3,'声音,动作,味道,影像,触觉,温度','/images/clue/question/question_08.png',0,'信息来源','2017-10-13 11:17:49'),(21,309,3,'性感,肥胖,瘦弱,高大,瘦小,畸形','/images/clue/question/question_09.png',0,'嫌疑体格','2017-10-13 11:17:49'),(22,310,3,'晴朗,雷雨,干燥,潮湿,寒冷,炎热','/images/clue/question/question_10.png',0,'天气状况','2017-10-13 11:17:49'),(23,311,3,'余温,僵硬,腐烂,残缺,完整,扭曲','/images/clue/question/question_11.png',0,'尸体情况','2017-10-13 11:17:49'),(24,312,3,'儿童,青年,中年,老人,男人,女人','/images/clue/question/question_12.png',0,'死者身份','2017-10-13 11:17:49'),(25,313,3,'断点,起火,访客,失窃,械斗,叫喊','/images/clue/question/question_13.png',0,'突发事件','2017-10-13 11:17:49'),(26,314,3,'瞬间,短暂,间断,漫长,数日,恒久','/images/clue/question/question_14.png',0,'作案市场','2017-10-13 11:17:49'),(27,315,3,'头部,胸部,手部,腰部,局部,全身','/images/clue/question/question_15.png',0,'作案疑点','2017-10-13 11:18:17'),(28,316,3,'御宅,玩咖,白领,难民,时尚,土鳖','/images/clue/question/question_16.png',0,'死者特征','2017-10-13 11:18:17'),(29,317,3,'指纹,脚印,淤青,血迹,体液,伤痕','/images/clue/question/question_17.png',0,'现场痕迹','2017-10-13 11:18:17'),(30,318,3,'碎屑,裂口,灰烬,水迹,杂乱,整齐','/images/clue/question/question_18.png',0,'现场状况','2017-10-13 11:18:17'),(31,319,3,'一般,严重,猎奇,残忍,恐怖,悬疑','/images/clue/question/question_19.png',0,'案件性质','2017-10-13 11:18:17'),(32,320,3,'娱乐,晕迷,争执,交易,斗殴,算计','/images/clue/question/question_20.png',0,'案发过程','2017-10-13 11:18:17'),(33,321,3,'老板,职员,工人,学生,特殊,无业','/images/clue/question/question_21.png',0,'凶手职业','2017-10-13 11:18:17');
/*!40000 ALTER TABLE `tbl_card_crime_scene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_current_game`
--

DROP TABLE IF EXISTS `tbl_current_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_current_game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_no` int(10) NOT NULL,
  `game_type` varchar(10) NOT NULL DEFAULT '0',
  `create_user` varchar(45) DEFAULT NULL,
  `nums` int(10) DEFAULT '0',
  `pos_of_crime_user` int(10) DEFAULT NULL,
  `pos_of_crime_ass_user` int(10) DEFAULT NULL,
  `pos_of_witness_user` int(10) DEFAULT NULL,
  `status` int(10) DEFAULT '0',
  `remark` varchar(100) DEFAULT NULL,
  `deleted` char(1) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='当前游戏简表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_current_game`
--

LOCK TABLES `tbl_current_game` WRITE;
/*!40000 ALTER TABLE `tbl_current_game` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_current_game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_current_game_detail`
--

DROP TABLE IF EXISTS `tbl_current_game_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_current_game_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_no` int(10) NOT NULL COMMENT '游戏房间号',
  `crime_item` int(10) DEFAULT '0' COMMENT '作案工具名称',
  `crime_item_name` varchar(45) DEFAULT '0' COMMENT '作案工具名称',
  `crime_clue` int(10) DEFAULT '0' COMMENT '作案线索名称',
  `crime_clue_name` varchar(45) DEFAULT '0' COMMENT '作案线索名称',
  `cause_of_death` int(10) DEFAULT '0' COMMENT '死亡原因',
  `cause_of_death_content` varchar(45) DEFAULT '0' COMMENT '死亡原因',
  `location_of_crime` int(10) DEFAULT '0' COMMENT '案发地点',
  `location_of_crime_content` varchar(45) DEFAULT '0' COMMENT '案发地点',
  `clue_1` int(10) DEFAULT '0' COMMENT '蓝牌1',
  `clue_1_content` varchar(100) DEFAULT '0' COMMENT '蓝牌1',
  `clue_1_title` varchar(100) DEFAULT '0' COMMENT '蓝牌1',
  `clue_2` int(10) DEFAULT '0' COMMENT '蓝牌2',
  `clue_2_content` varchar(100) DEFAULT '0' COMMENT '蓝牌2',
  `clue_2_title` varchar(100) DEFAULT '0' COMMENT '蓝牌2',
  `clue_3` int(10) DEFAULT '0' COMMENT '蓝牌3',
  `clue_3_content` varchar(100) DEFAULT '0' COMMENT '蓝牌3',
  `clue_3_title` varchar(100) DEFAULT '0' COMMENT '蓝牌3',
  `clue_4` int(10) DEFAULT '0' COMMENT '蓝牌4',
  `clue_4_content` varchar(100) DEFAULT '0' COMMENT '蓝牌4',
  `clue_4_title` varchar(100) DEFAULT '0' COMMENT '蓝牌4',
  `clue_to_replace_1` int(10) DEFAULT '0' COMMENT '抽取的可替换的蓝牌1',
  `clue_to_replace_1_content` varchar(100) DEFAULT '0' COMMENT '抽取的可替换的蓝牌1',
  `clue_to_replace_1_title` varchar(100) DEFAULT '0' COMMENT '抽取的可替换的蓝牌1',
  `clue_to_replace_2` int(10) DEFAULT '0' COMMENT '抽取的可替换的蓝牌2',
  `clue_to_replace_2_content` varchar(100) DEFAULT '0' COMMENT '抽取的可替换的蓝牌2',
  `clue_to_replace_2_title` varchar(100) DEFAULT '0' COMMENT '抽取的可替换的蓝牌2',
  `witness_chosen_1_pos` int(10) DEFAULT '0' COMMENT '目击者选择的线索1',
  `witness_chosen_1_name` varchar(45) DEFAULT '0' COMMENT '目击者选择的线索1',
  `witness_chosen_2_pos` int(10) DEFAULT '0' COMMENT '目击者选择的线索2',
  `witness_chosen_2_name` varchar(45) DEFAULT '0' COMMENT '目击者选择的线索2',
  `witness_chosen_3_pos` int(10) DEFAULT '0' COMMENT '目击者选择的线索3',
  `witness_chosen_3_name` varchar(45) DEFAULT '0' COMMENT '目击者选择的线索3',
  `witness_chosen_4_pos` int(10) DEFAULT '0' COMMENT '目击者选择的线索4',
  `witness_chosen_4_name` varchar(45) DEFAULT '0' COMMENT '目击者选择的线索4',
  `witness_chosen_cause_of_death_pos` int(10) DEFAULT '0' COMMENT '目击者选择的死亡原因',
  `witness_chosen_cause_of_death_name` varchar(45) DEFAULT '0' COMMENT '目击者选择的死亡原因',
  `witness_chosen_location_of_crime_pos` int(10) DEFAULT '0' COMMENT '目击者选择的案发地点',
  `witness_chosen_location_of_crime_name` varchar(45) DEFAULT '0' COMMENT '目击者选择的案发地点',
  `witness_chosen_weight` int(10) DEFAULT '0' COMMENT '线索权重，6位数字对应6张牌上线索的权重，1-6从重到轻',
  `status` int(10) DEFAULT '0',
  `remark` varchar(200) DEFAULT '',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_current_game_detail`
--

LOCK TABLES `tbl_current_game_detail` WRITE;
/*!40000 ALTER TABLE `tbl_current_game_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_current_game_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_current_player`
--

DROP TABLE IF EXISTS `tbl_current_player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_current_player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_no` varchar(45) NOT NULL COMMENT '用户微信号',
  `game_no` varchar(45) DEFAULT NULL COMMENT '游戏房间号,同tbl_game_current.game_no',
  `game_role` varchar(45) DEFAULT '' COMMENT '游戏角色',
  `game_pos` int(10) DEFAULT NULL COMMENT '当前用户的房间位置',
  `status` int(10) DEFAULT '0' COMMENT '当前用户的游戏状态',
  `crime_item_1` int(10) DEFAULT '0' COMMENT '作案工具1',
  `crime_item_2` int(10) DEFAULT '0' COMMENT '作案工具2',
  `crime_item_3` int(10) DEFAULT '0' COMMENT '作案工具3',
  `crime_item_4` int(10) DEFAULT '0' COMMENT '作案工具4',
  `crime_clue_1` int(10) DEFAULT '0' COMMENT '作案线索1',
  `crime_clue_2` int(10) DEFAULT '0' COMMENT '作案线索2',
  `crime_clue_3` int(10) DEFAULT '0' COMMENT '作案线索3',
  `crime_clue_4` int(10) DEFAULT '0' COMMENT '作案线索4',
  `crime_item_1_name` varchar(100) DEFAULT NULL COMMENT '作案工具1',
  `crime_item_2_name` varchar(100) DEFAULT NULL COMMENT '作案工具2',
  `crime_item_3_name` varchar(100) DEFAULT NULL COMMENT '作案工具3',
  `crime_item_4_name` varchar(100) DEFAULT NULL COMMENT '作案工具4',
  `crime_clue_1_name` varchar(100) DEFAULT NULL COMMENT '作案线索1',
  `crime_clue_2_name` varchar(100) DEFAULT NULL COMMENT '作案线索2',
  `crime_clue_3_name` varchar(100) DEFAULT NULL COMMENT '作案线索3',
  `crime_clue_4_name` varchar(100) DEFAULT NULL COMMENT '作案线索4',
  `crime_item_1_pic_url` varchar(100) DEFAULT NULL COMMENT '作案工具1',
  `crime_item_2_pic_url` varchar(100) DEFAULT NULL COMMENT '作案工具2',
  `crime_item_3_pic_url` varchar(100) DEFAULT NULL COMMENT '作案工具3',
  `crime_item_4_pic_url` varchar(100) DEFAULT NULL COMMENT '作案工具4',
  `crime_clue_1_pic_url` varchar(100) DEFAULT NULL COMMENT '作案线索1',
  `crime_clue_2_pic_url` varchar(100) DEFAULT NULL COMMENT '作案线索2',
  `crime_clue_3_pic_url` varchar(100) DEFAULT NULL COMMENT '作案线索3',
  `crime_clue_4_pic_url` varchar(100) DEFAULT NULL COMMENT '作案线索4',
  `remark` varchar(100) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='当前游戏用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_current_player`
--

LOCK TABLES `tbl_current_player` WRITE;
/*!40000 ALTER TABLE `tbl_current_player` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_current_player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_game`
--

DROP TABLE IF EXISTS `v_game`;
/*!50001 DROP VIEW IF EXISTS `v_game`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_game` AS SELECT 
 1 AS `gameNo`,
 1 AS `gameType`,
 1 AS `createUser`,
 1 AS `nums`,
 1 AS `posOfCrimeUser`,
 1 AS `posOfCrimeAssUser`,
 1 AS `posOfWitnessUser`,
 1 AS `gameStatus`,
 1 AS `crimeItem`,
 1 AS `crimeClue`,
 1 AS `crimeItemName`,
 1 AS `crimeClueName`,
 1 AS `cardCauseOfDeath`,
 1 AS `cardLocationOfCrime`,
 1 AS `cardCauseOfDeathContent`,
 1 AS `cardLocationOfCrimeContent`,
 1 AS `cardClue1`,
 1 AS `cardClue2`,
 1 AS `cardClue3`,
 1 AS `cardClue4`,
 1 AS `cardClue1Content`,
 1 AS `cardClue2Content`,
 1 AS `cardClue3Content`,
 1 AS `cardClue4Content`,
 1 AS `cardClue1Title`,
 1 AS `cardClue2Title`,
 1 AS `cardClue3Title`,
 1 AS `cardClue4Title`,
 1 AS `cardClueToReplace1`,
 1 AS `cardClueToReplace2`,
 1 AS `cardClueToReplace1Content`,
 1 AS `cardClueToReplace2Content`,
 1 AS `cardClueToReplace1Title`,
 1 AS `cardClueToReplace2Title`,
 1 AS `witnessCauseOfDeathPos`,
 1 AS `witnessLocationOfCrimePos`,
 1 AS `witnessClue1Pos`,
 1 AS `witnessClue2Pos`,
 1 AS `witnessClue3Pos`,
 1 AS `witnessClue4Pos`,
 1 AS `witnessCauseOfDeathName`,
 1 AS `witnessLocationOfCrimeName`,
 1 AS `witnessClue1Name`,
 1 AS `witnessClue2Name`,
 1 AS `witnessClue3Name`,
 1 AS `witnessClue4Name`,
 1 AS `witnessWeight`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_game`
--

/*!50001 DROP VIEW IF EXISTS `v_game`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`127.0.0.1` SQL SECURITY DEFINER */
/*!50001 VIEW `v_game` AS select `a`.`game_no` AS `gameNo`,`a`.`game_type` AS `gameType`,`a`.`create_user` AS `createUser`,`a`.`nums` AS `nums`,`a`.`pos_of_crime_user` AS `posOfCrimeUser`,`a`.`pos_of_crime_ass_user` AS `posOfCrimeAssUser`,`a`.`pos_of_witness_user` AS `posOfWitnessUser`,`a`.`status` AS `gameStatus`,`b`.`crime_item` AS `crimeItem`,`b`.`crime_clue` AS `crimeClue`,`b`.`crime_item_name` AS `crimeItemName`,`b`.`crime_clue_name` AS `crimeClueName`,`b`.`cause_of_death` AS `cardCauseOfDeath`,`b`.`location_of_crime` AS `cardLocationOfCrime`,`b`.`cause_of_death_content` AS `cardCauseOfDeathContent`,`b`.`location_of_crime_content` AS `cardLocationOfCrimeContent`,`b`.`clue_1` AS `cardClue1`,`b`.`clue_2` AS `cardClue2`,`b`.`clue_3` AS `cardClue3`,`b`.`clue_4` AS `cardClue4`,`b`.`clue_1_content` AS `cardClue1Content`,`b`.`clue_2_content` AS `cardClue2Content`,`b`.`clue_3_content` AS `cardClue3Content`,`b`.`clue_4_content` AS `cardClue4Content`,`b`.`clue_1_title` AS `cardClue1Title`,`b`.`clue_2_title` AS `cardClue2Title`,`b`.`clue_3_title` AS `cardClue3Title`,`b`.`clue_4_title` AS `cardClue4Title`,`b`.`clue_to_replace_1` AS `cardClueToReplace1`,`b`.`clue_to_replace_2` AS `cardClueToReplace2`,`b`.`clue_to_replace_1_content` AS `cardClueToReplace1Content`,`b`.`clue_to_replace_2_content` AS `cardClueToReplace2Content`,`b`.`clue_to_replace_1_title` AS `cardClueToReplace1Title`,`b`.`clue_to_replace_2_title` AS `cardClueToReplace2Title`,`b`.`witness_chosen_cause_of_death_pos` AS `witnessCauseOfDeathPos`,`b`.`witness_chosen_location_of_crime_pos` AS `witnessLocationOfCrimePos`,`b`.`witness_chosen_1_pos` AS `witnessClue1Pos`,`b`.`witness_chosen_2_pos` AS `witnessClue2Pos`,`b`.`witness_chosen_3_pos` AS `witnessClue3Pos`,`b`.`witness_chosen_4_pos` AS `witnessClue4Pos`,`b`.`witness_chosen_cause_of_death_name` AS `witnessCauseOfDeathName`,`b`.`witness_chosen_location_of_crime_name` AS `witnessLocationOfCrimeName`,`b`.`witness_chosen_1_name` AS `witnessClue1Name`,`b`.`witness_chosen_2_name` AS `witnessClue2Name`,`b`.`witness_chosen_3_name` AS `witnessClue3Name`,`b`.`witness_chosen_4_name` AS `witnessClue4Name`,`b`.`witness_chosen_weight` AS `witnessWeight` from (`tbl_current_game` `a` join `tbl_current_game_detail` `b` on((`a`.`game_no` = `b`.`game_no`))) where ((`a`.`status` <> 99) and (`b`.`status` <> 99)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-16  0:09:48

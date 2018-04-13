/*
SQLyog Community v12.3.3 (64 bit)
MySQL - 5.5.54 : Database - agentsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`agentsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `agentsystem`;

/*Table structure for table `account_details` */

DROP TABLE IF EXISTS `account_details`;

CREATE TABLE `account_details` (
  `detailId` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NOT NULL,
  `financeType` varchar(20) NOT NULL,
  `financeFund` float NOT NULL,
  `balance` float NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `createTime` date NOT NULL,
  PRIMARY KEY (`detailId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `account_details` */

insert  into `account_details`(`detailId`,`userId`,`financeType`,`financeFund`,`balance`,`remark`,`createTime`) values 
(1,2,'扣除【112】的正式注册资金',26000,1000000000,'黎明对112进行关键字申请审核通过自动正式扣款操作,扣除正式资金：26000','2018-04-09'),
(2,3,'返回预注册冻结资金',26000,1000000000,'晚霞对110进行关键字申请审核通过操作,扣除正式资金：26000','2018-04-09'),
(3,2,'返回预注册冻结资金',26000,1000000000,'黎明对112进行关键字申请审核通过操作,返回冻结资金：26000','2018-04-09'),
(4,2,'扣除续费资金3年78000',78000,1000000000,'黎明对hanlu进行关键字续费操作,扣除续费资金：78000','2018-04-09'),
(5,2,'扣除续费资金2年52000',52000,1000000000,'黎明对haha进行关键字续费操作,扣除正式资金：52000','2018-04-09'),
(6,2,'扣除续费资金2年52000',52000,1000000000,'黎明对12进行关键字续费操作,扣除正式资金：52000','2018-04-09'),
(7,3,'扣除【110】的正式注册资金',26000,1000000000,'晚霞对110进行关键字申请审核通过自动正式扣款操作,扣除正式资金：26000','2018-04-09');

/*Table structure for table `appinfo` */

DROP TABLE IF EXISTS `appinfo`;

CREATE TABLE `appinfo` (
  `appId` int(10) NOT NULL AUTO_INCREMENT,
  `appName` varchar(100) NOT NULL,
  `appUrl` varchar(255) NOT NULL,
  `appterm` int(10) NOT NULL,
  `appType` int(10) NOT NULL,
  `appAllocation` int(10) NOT NULL,
  `appStatus` int(1) DEFAULT '1',
  PRIMARY KEY (`appId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `appinfo` */

/*Table structure for table `contactsinfo` */

DROP TABLE IF EXISTS `contactsinfo`;

CREATE TABLE `contactsinfo` (
  `contactsId` int(10) NOT NULL AUTO_INCREMENT,
  `customerId` int(10) NOT NULL,
  `contactsName` varchar(20) NOT NULL,
  `contactsTel` varchar(13) NOT NULL,
  `contactsFax` varchar(13) DEFAULT NULL,
  `contactsPhone` varchar(11) NOT NULL,
  `contactsEmail` varchar(50) NOT NULL,
  `contactsPost` varchar(20) NOT NULL,
  PRIMARY KEY (`contactsId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `contactsinfo` */

insert  into `contactsinfo`(`contactsId`,`customerId`,`contactsName`,`contactsTel`,`contactsFax`,`contactsPhone`,`contactsEmail`,`contactsPost`) values 
(1,1,'测试1','1345654','52565','13588888888','11111111@qq.com','经理'),
(2,2,'测试1','1345654','52565','13588888888','11111111@qq.com','CEO'),
(3,3,'测试1','1345654','52565','13588888888','11111111@qq.com','经理'),
(4,4,'测试1','1345654','52565','13588888888','11111111@qq.com','经理'),
(5,5,'测试1','1345654','52565','13588888888','11111111@qq.com','经理');

/*Table structure for table `customerinfo` */

DROP TABLE IF EXISTS `customerinfo`;

CREATE TABLE `customerinfo` (
  `customerId` int(10) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(50) NOT NULL,
  `companyType` int(1) NOT NULL,
  `companyPages` varchar(255) DEFAULT NULL,
  `companyStatus` int(1) DEFAULT '1',
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `customerinfo` */

insert  into `customerinfo`(`customerId`,`companyName`,`companyType`,`companyPages`,`companyStatus`) values 
(1,'极大',7,'www.jida.com',1),
(2,'蛋蛋',8,'www.dandan.com',1),
(3,'中华',9,'www.zhonghua.com',1),
(4,'比利',7,'www.bili.com',1),
(5,'琪琪',7,'www.qiqi.com',1);

/*Table structure for table `finance_type` */

DROP TABLE IF EXISTS `finance_type`;

CREATE TABLE `finance_type` (
  `typeId` int(10) NOT NULL AUTO_INCREMENT,
  `parentId` int(10) DEFAULT NULL,
  `typeName` varchar(50) NOT NULL,
  `typeStatus` int(1) DEFAULT '1',
  `allocation` int(10) DEFAULT NULL,
  `realityAllocation` int(10) DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `finance_type` */

insert  into `finance_type`(`typeId`,`parentId`,`typeName`,`typeStatus`,`allocation`,`realityAllocation`) values 
(1,NULL,'客户类型',1,NULL,NULL),
(2,NULL,'财务类型',1,NULL,NULL),
(3,NULL,'服务类型',1,NULL,NULL),
(4,NULL,'证件类型',1,NULL,NULL),
(5,NULL,'优惠类型',1,NULL,NULL),
(6,NULL,'服务年限',1,NULL,NULL),
(7,1,'企业',1,NULL,NULL),
(8,1,'个人',1,NULL,NULL),
(9,1,'政府',1,NULL,NULL),
(10,2,'代理款',1,NULL,NULL),
(11,2,'转账',1,NULL,NULL),
(12,2,'财务打款',1,NULL,NULL),
(13,2,'冻结',1,NULL,NULL),
(14,2,'扣费',1,NULL,NULL),
(15,2,'代理款冲抵',1,NULL,NULL),
(16,2,'退费',1,NULL,NULL),
(17,2,'返款',1,NULL,NULL),
(18,2,'罚款',1,NULL,NULL),
(19,2,'代理款预录消费',1,NULL,NULL),
(20,3,'上传苹果商城',1,26000,26000),
(21,3,'不上传苹果商城',1,18000,18000),
(22,3,'不上传苹果商城',1,18000,18000),
(23,4,'国内身份证',1,NULL,NULL),
(24,4,'国外身份证',1,NULL,NULL),
(25,4,'营业执照',1,NULL,NULL),
(26,4,'其他证件',1,NULL,NULL),
(27,5,'买二赠一',1,2,3),
(28,6,'服务年限',1,2,2),
(29,6,'服务年限',1,3,3);

/*Table structure for table `keyword` */

DROP TABLE IF EXISTS `keyword`;

CREATE TABLE `keyword` (
  `keywordId` int(10) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(20) NOT NULL,
  `customerId` int(10) NOT NULL,
  `userId` int(10) NOT NULL,
  `term` int(10) NOT NULL,
  `createTime` date NOT NULL,
  `keywordStatus` int(1) DEFAULT '1',
  PRIMARY KEY (`keywordId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `keyword` */

insert  into `keyword`(`keywordId`,`keyword`,`customerId`,`userId`,`term`,`createTime`,`keywordStatus`) values 
(1,'112',1,2,3,'2013-12-12',1),
(2,'hanlu',2,2,3,'2017-12-12',1),
(3,'haha',3,2,3,'2015-12-12',1),
(4,'12',4,2,3,'2015-12-12',1),
(5,'110',5,2,3,'2015-12-12',1);

/*Table structure for table `operation_log` */

DROP TABLE IF EXISTS `operation_log`;

CREATE TABLE `operation_log` (
  `logId` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NOT NULL,
  `remark` varchar(255) NOT NULL,
  `createTime` date NOT NULL,
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `operation_log` */

insert  into `operation_log`(`logId`,`userId`,`remark`,`createTime`) values 
(1,2,'用户进行登录操作成功','2018-04-09'),
(2,2,'用户进行112关键字申请审核操作','2018-04-09'),
(3,2,'用户进行明旭查询操作成功','2018-04-09'),
(4,2,'用户进行hanlu进行关键字续费操作','2018-04-09'),
(5,2,'用户进行明旭查询操作成功','2018-04-09'),
(6,2,'用户进行12进行关键字续费操作','2018-04-09'),
(7,2,'用户进行明旭查询操作成功','2018-04-09'),
(8,3,'用户进行登录操作成功','2018-04-09'),
(9,3,'用户进行10进行关键字申请审核操作成功','2018-04-09'),
(10,3,'用户进行明旭查询操作成功','2018-04-09');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `permissionId` int(10) NOT NULL AUTO_INCREMENT,
  `roleId` int(10) NOT NULL,
  `resourceId` int(10) NOT NULL,
  PRIMARY KEY (`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

/*Table structure for table `protalinfo` */

DROP TABLE IF EXISTS `protalinfo`;

CREATE TABLE `protalinfo` (
  `protalId` int(10) NOT NULL AUTO_INCREMENT,
  `customerId` int(10) NOT NULL,
  `legalRepresentative` varchar(20) NOT NULL,
  `typeId` int(10) NOT NULL,
  `idNumber` varchar(18) NOT NULL,
  `companyTel` varchar(13) NOT NULL,
  `companyFax` varchar(13) DEFAULT NULL,
  `createTime` date NOT NULL,
  `state` varchar(20) DEFAULT NULL,
  `province` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL,
  `companyAddress` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`protalId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `protalinfo` */

insert  into `protalinfo`(`protalId`,`customerId`,`legalRepresentative`,`typeId`,`idNumber`,`companyTel`,`companyFax`,`createTime`,`state`,`province`,`city`,`district`,`companyAddress`,`remark`) values 
(1,1,'法人1',25,'123413135431454','123456','888','2018-04-09','中国','广东','深圳','罗湖','地址1','备注'),
(2,2,'法人1',25,'1234153135431454','123457','666','2018-04-09','中国','广东','深圳','福田','地址1','备注'),
(3,3,'法人1',26,'1234131335431454','123458','444','2018-04-09','中国','广东','深圳','布吉','地址1','备注'),
(4,4,'法人1',24,'1234131352431454','123454','777','2018-04-09','中国','广东','深圳','宝安','地址1','备注'),
(5,5,'法人1',25,'1234131354351454','123459','555','2018-04-09','中国','广东','深圳','坪山','地址1','备注');

/*Table structure for table `resource` */

DROP TABLE IF EXISTS `resource`;

CREATE TABLE `resource` (
  `resourceId` int(10) NOT NULL AUTO_INCREMENT,
  `resourceURL` varchar(255) NOT NULL,
  `parentId` int(10) DEFAULT NULL,
  `resourceName` varchar(100) NOT NULL,
  PRIMARY KEY (`resourceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `resource` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleId` int(10) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) NOT NULL,
  `createTime` date NOT NULL,
  `roleStatus` int(1) DEFAULT '1',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`roleId`,`roleName`,`createTime`,`roleStatus`) values 
(1,'系统管理员','2018-04-09',1),
(2,'代理商','2018-04-09',1),
(3,'财务','2018-04-09',1),
(4,'客服','2018-04-09',1),
(5,'市场','2018-04-09',1),
(6,'大区经理','2018-04-09',1),
(7,'渠道经理','2018-04-09',1);

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `userAccount` varchar(20) NOT NULL,
  `userPassword` varchar(20) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `roleId` int(10) NOT NULL,
  `userStatus` int(1) DEFAULT '1',
  `balance` float NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`userId`,`userAccount`,`userPassword`,`userName`,`roleId`,`userStatus`,`balance`) values 
(1,'admin','admin','系统管理员',1,1,1000000000),
(2,'liming','123','黎明',2,1,1000000000),
(3,'wanxia','123','晚霞',2,1,1000000000),
(4,'123','123','123',2,1,1000000000),
(5,'110','123','110',2,1,1000000000),
(6,'zhangsan','123','张三',3,1,10000000),
(7,'lisi','123','李四',4,1,100000),
(8,'wangwu','123','王五',5,1,10000000),
(9,'liuliu','123','刘六',6,1,1000000),
(10,'zhouqi','123','周琦',7,1,1000000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

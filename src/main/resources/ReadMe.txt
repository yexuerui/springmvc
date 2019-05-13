1. https://www.cnblogs.com/aflyun/p/6421441.html  参考搭建SSM项目


2. SSM需要的工具（Tomcat|mybaties-generate|mysql安装包以及客户端）
链接：https://pan.baidu.com/s/1EdtjZRNiuMTZhAdDhB7Y4w
提取码：0lpf


3. 表结构
DROP TABLE IF EXISTS `user_t`;

CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_t` */

insert  into `user_t`(`id`,`user_name`,`password`,`age`) values (1,'测试','sfasgfaf',24)
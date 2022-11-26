CREATE TABLE `NEWS_ARTICLES` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(300) NOT NULL,
  `link` varchar(300) DEFAULT NULL,
  `image_url` varchar(300) DEFAULT NULL,
  `category` varchar(1000) DEFAULT NULL,
  `published_date` datetime NOT NULL,
  `create_timestamp` datetime NOT NULL,
  `update_timestamp` datetime NOT NULL,
  `provider` varchar(100) NOT NULL,
  `manual_tags` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8375 DEFAULT CHARSET=latin1;
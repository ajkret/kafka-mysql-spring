CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) NOT NULL,
  `state` varchar(45) NOT NULL,
  `population` int(11) DEFAULT NULL,
  `residents` int(11) DEFAULT NULL,
  `foreigners` int(11) DEFAULT NULL,
  `domestic_units` int(11) DEFAULT NULL,
  `hdi_ranking` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `gdp` decimal(13,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `state_city_index` (`state`,`city`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

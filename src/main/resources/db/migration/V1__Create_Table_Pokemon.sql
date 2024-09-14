CREATE TABLE IF NOT EXISTS `Pokemon` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `type` varchar(80) NOT NULL,
  `gender` varchar(6) NOT NULL,

  PRIMARY KEY (`id`)
)




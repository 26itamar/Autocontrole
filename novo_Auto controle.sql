/*
CREATE TABLE `data` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `mes` varchar(40) DEFAULT NULL,
  `ano` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `data` VALUES (1,'Maio','2017'),(2,'Junho','2017');


drop table receitas;

CREATE TABLE `receitas` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao_receita` varchar(255) DEFAULT NULL,
  `valor_receita`  DOUBLE NULL,
  `id_data_r` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `id_data_r` (`id_data_r`),
  CONSTRAINT `id_data_r` FOREIGN KEY (`id_data_r`) REFERENCES `data` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `gastos` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao_gasto` varchar(255) DEFAULT NULL,
  `valor_gasto`  DOUBLE NULL,
  `id_data_g` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `id_data_g` (`id_data_g`),
  CONSTRAINT `id_data_g` FOREIGN KEY (`id_data_g`) REFERENCES `data` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/





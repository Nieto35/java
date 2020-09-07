-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.11-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla gepad.ambienteaprendizaje
CREATE TABLE IF NOT EXISTS `ambienteaprendizaje` (
  `codigoambiente` int(11) NOT NULL AUTO_INCREMENT,
  `nombreambiente` varchar(50) DEFAULT NULL,
  `capacidadambiente` int(11) DEFAULT NULL,
  `areaambiente` int(11) DEFAULT NULL,
  `codigotipoambiente` int(11) DEFAULT NULL,
  `numerosede` int(11) DEFAULT NULL,
  `estadoambiente` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoambiente`),
  KEY `FK_ambienteaprendizaje_tipoambiente` (`codigotipoambiente`),
  KEY `FK_ambienteaprendizaje_sede` (`numerosede`),
  CONSTRAINT `FK_ambienteaprendizaje_sede` FOREIGN KEY (`numerosede`) REFERENCES `sede` (`numerosede`),
  CONSTRAINT `FK_ambienteaprendizaje_tipoambiente` FOREIGN KEY (`codigotipoambiente`) REFERENCES `tipoambiente` (`codigotipoambiente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.ambienteaprendizaje: ~0 rows (aproximadamente)
DELETE FROM `ambienteaprendizaje`;
/*!40000 ALTER TABLE `ambienteaprendizaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `ambienteaprendizaje` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.aprendiz
CREATE TABLE IF NOT EXISTS `aprendiz` (
  `documentoaprendiz` bigint(20) NOT NULL,
  `estadoaprendiz` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`documentoaprendiz`),
  CONSTRAINT `FK_aprendiz_personal` FOREIGN KEY (`documentoaprendiz`) REFERENCES `personal` (`documentopersonal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.aprendiz: ~2 rows (aproximadamente)
DELETE FROM `aprendiz`;
/*!40000 ALTER TABLE `aprendiz` DISABLE KEYS */;
INSERT INTO `aprendiz` (`documentoaprendiz`, `estadoaprendiz`) VALUES
	(52183274, 'FORMACION'),
	(1116235891, 'FORMACION');
/*!40000 ALTER TABLE `aprendiz` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.area
CREATE TABLE IF NOT EXISTS `area` (
  `codigoarea` int(10) NOT NULL AUTO_INCREMENT,
  `nombrearea` varchar(50) DEFAULT NULL,
  `codigodependencia` int(10) DEFAULT NULL,
  PRIMARY KEY (`codigoarea`),
  KEY `FK_area_dependencia` (`codigodependencia`),
  CONSTRAINT `FK_area_dependencia` FOREIGN KEY (`codigodependencia`) REFERENCES `dependencia` (`codigodependencia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.area: ~36 rows (aproximadamente)
DELETE FROM `area`;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` (`codigoarea`, `nombrearea`, `codigodependencia`) VALUES
	(1, 'SUBDIRECCIÓN', 1),
	(2, 'ADMINISTRADOR GRANJA', 2),
	(3, 'ALMACEN', 2),
	(4, 'APE', 2),
	(5, 'APOYO CONTRATACIÓN COORDINACIÓN ADMINISTRATIVA', 2),
	(6, 'APOYO ADMINISTRATIVO COMPETENCIAS LABORALES ', 2),
	(7, 'APOYO AGENCIA POBLACIÓN VULNERABLE', 2),
	(8, 'APOYO CONTRATACIÓN COMPRAS', 2),
	(9, 'APOYO COORDINACIÓN ACADEMICA', 2),
	(10, 'APOYO FINANCIERO', 2),
	(11, 'APOYO GRANJA', 2),
	(12, 'APOYO JURIDICO', 2),
	(13, 'APOYO PETAR', 2),
	(14, 'APOYO SEDE', 2),
	(15, 'APOYO TECNOLOGO AMBIENTAL', 2),
	(16, 'APOYO VIATICOS', 2),
	(17, 'APOYOS DE SOSTENIMIENTO', 2),
	(18, 'AUXILIAR DE ENFERMERIA BIENESTAR', 2),
	(19, 'BIBLIOTECA', 2),
	(20, 'CERTIFICACIÓN', 2),
	(21, 'CONDUCTOR', 2),
	(22, 'DANZAS', 2),
	(23, 'DIRECCIONAMIENTO ESTRATEGICO', 2),
	(24, 'EVALUADOR DE COMPETENCIAS', 2),
	(25, 'GESTIÓN DOCUMENTAL', 2),
	(26, 'INGRESO', 2),
	(27, 'LÍDER ARTICULACIÓN', 2),
	(28, 'LIDER CONTRATO DE APRENDIZAJE', 2),
	(29, 'LÍDER SIGA', 2),
	(30, 'ON BASE', 2),
	(31, 'PAR ACADÉMICO', 2),
	(32, 'PSICOLOGA BIENESTAR', 2),
	(33, 'PSICOLOGA', 2),
	(34, 'SENNOVA', 2),
	(35, 'TRABAJADORA SOCIAL', 2),
	(36, 'SEGUIMIENTO ETAPA PRACTICA', 2);
/*!40000 ALTER TABLE `area` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.asignafichas
CREATE TABLE IF NOT EXISTS `asignafichas` (
  `fichatitulacion` int(11) NOT NULL,
  `documentoinstructor` bigint(20) NOT NULL,
  PRIMARY KEY (`fichatitulacion`,`documentoinstructor`),
  KEY `FK_asignafichas_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_asignafichas_fichatitulacion` FOREIGN KEY (`fichatitulacion`) REFERENCES `fichatitulacion` (`numeroficha`),
  CONSTRAINT `FK_asignafichas_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.asignafichas: ~0 rows (aproximadamente)
DELETE FROM `asignafichas`;
/*!40000 ALTER TABLE `asignafichas` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignafichas` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.capacitacion
CREATE TABLE IF NOT EXISTS `capacitacion` (
  `codigocapacitacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombrecapacitacion` varchar(100) DEFAULT NULL,
  `institucioncapacitacion` varchar(100) DEFAULT NULL,
  `fechacapacitacion` date DEFAULT NULL,
  `tiempocapacitacion` int(11) DEFAULT NULL,
  `tipotiempocapacitacion` varchar(50) DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigocapacitacion`),
  KEY `FK_capacitacion_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_capacitacion_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.capacitacion: ~0 rows (aproximadamente)
DELETE FROM `capacitacion`;
/*!40000 ALTER TABLE `capacitacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `capacitacion` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.coformador
CREATE TABLE IF NOT EXISTS `coformador` (
  `documentocoformador` bigint(20) NOT NULL,
  `nombrecoformador` varchar(50) DEFAULT NULL,
  `telefonocoformador` varchar(50) DEFAULT NULL,
  `numeroempresa` bigint(20) DEFAULT NULL,
  `cargocoformador` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`documentocoformador`),
  KEY `FK_coformador_empresa` (`numeroempresa`),
  CONSTRAINT `FK_coformador_empresa` FOREIGN KEY (`numeroempresa`) REFERENCES `empresa` (`numeroempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.coformador: ~0 rows (aproximadamente)
DELETE FROM `coformador`;
/*!40000 ALTER TABLE `coformador` DISABLE KEYS */;
/*!40000 ALTER TABLE `coformador` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.comite
CREATE TABLE IF NOT EXISTS `comite` (
  `documentopersonal` bigint(20) NOT NULL,
  `numeroseguimiento` int(11) NOT NULL,
  `cargocomite` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`documentopersonal`,`numeroseguimiento`),
  KEY `FK_comite_seguimiento` (`numeroseguimiento`),
  CONSTRAINT `FK_comite_personal` FOREIGN KEY (`documentopersonal`) REFERENCES `personal` (`documentopersonal`),
  CONSTRAINT `FK_comite_seguimiento` FOREIGN KEY (`numeroseguimiento`) REFERENCES `seguimiento` (`codigoseguimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.comite: ~0 rows (aproximadamente)
DELETE FROM `comite`;
/*!40000 ALTER TABLE `comite` DISABLE KEYS */;
/*!40000 ALTER TABLE `comite` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.comiteproductiva
CREATE TABLE IF NOT EXISTS `comiteproductiva` (
  `numerocomite` int(11) NOT NULL AUTO_INCREMENT,
  `codigoeproductiva` int(11) DEFAULT NULL,
  `fechacomite` date DEFAULT NULL,
  `observacionescomite` text DEFAULT NULL,
  `actacomite` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numerocomite`),
  KEY `FK_comiteproductiva_eproductivav` (`codigoeproductiva`),
  CONSTRAINT `FK_comiteproductiva_eproductivav` FOREIGN KEY (`codigoeproductiva`) REFERENCES `eproductiva` (`codigoeproductiva`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.comiteproductiva: ~0 rows (aproximadamente)
DELETE FROM `comiteproductiva`;
/*!40000 ALTER TABLE `comiteproductiva` DISABLE KEYS */;
/*!40000 ALTER TABLE `comiteproductiva` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.contrato
CREATE TABLE IF NOT EXISTS `contrato` (
  `numerocontrato` int(11) NOT NULL,
  `fechainiciocontrato` date DEFAULT NULL,
  `fechafincontrato` date DEFAULT NULL,
  `objetocontrato` text DEFAULT NULL,
  `estadocontrato` varchar(50) DEFAULT NULL,
  `valortotalcontrato` int(11) DEFAULT NULL,
  `documentocoordinador` bigint(20) DEFAULT NULL,
  `documentopersonal` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`numerocontrato`),
  KEY `FK_contrato_coordinador` (`documentocoordinador`),
  KEY `FK_contrato_personal` (`documentopersonal`),
  CONSTRAINT `FK_contrato_coordinador` FOREIGN KEY (`documentocoordinador`) REFERENCES `coordinador` (`documentocoordinador`),
  CONSTRAINT `FK_contrato_personal` FOREIGN KEY (`documentopersonal`) REFERENCES `personal` (`documentopersonal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.contrato: ~0 rows (aproximadamente)
DELETE FROM `contrato`;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.coordinador
CREATE TABLE IF NOT EXISTS `coordinador` (
  `documentocoordinador` bigint(20) NOT NULL,
  `tipocoordinador` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`documentocoordinador`),
  CONSTRAINT `FK_coordinador_personal` FOREIGN KEY (`documentocoordinador`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.coordinador: ~4 rows (aproximadamente)
DELETE FROM `coordinador`;
/*!40000 ALTER TABLE `coordinador` DISABLE KEYS */;
INSERT INTO `coordinador` (`documentocoordinador`, `tipocoordinador`) VALUES
	(14888888, 'ACADEMICO'),
	(14889925, 'ACADEMICO'),
	(14890737, 'SUBDIRECTOR'),
	(94472795, 'ADMINISTRATIVO');
/*!40000 ALTER TABLE `coordinador` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.dependencia
CREATE TABLE IF NOT EXISTS `dependencia` (
  `codigodependencia` int(10) NOT NULL AUTO_INCREMENT,
  `nombredependencia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigodependencia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.dependencia: ~2 rows (aproximadamente)
DELETE FROM `dependencia`;
/*!40000 ALTER TABLE `dependencia` DISABLE KEYS */;
INSERT INTO `dependencia` (`codigodependencia`, `nombredependencia`) VALUES
	(1, 'SUBDIRECCIÓN'),
	(2, 'ADMINISTRATIVA');
/*!40000 ALTER TABLE `dependencia` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.elemento
CREATE TABLE IF NOT EXISTS `elemento` (
  `codigoelemento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionelemento` text DEFAULT NULL,
  `serialelemento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoelemento`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.elemento: ~7 rows (aproximadamente)
DELETE FROM `elemento`;
/*!40000 ALTER TABLE `elemento` DISABLE KEYS */;
INSERT INTO `elemento` (`codigoelemento`, `descripcionelemento`, `serialelemento`) VALUES
	(1, 'HHJKHJ', '786767'),
	(2, 'KLHKH KHFGS JKDGASJKGD JASHDJA ASJH', '878978977'),
	(3, 'JHJKHJ', 'JHJH'),
	(4, 'asdasd', 'adasd'),
	(5, 'kjhjkhjkh', 'kjhjh'),
	(6, 'kjhkjh', 'jjhjkhj'),
	(7, 'sdfsdfdsf', 'fsdfds');
/*!40000 ALTER TABLE `elemento` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `numeroempresa` bigint(20) NOT NULL,
  `nombreempresa` varchar(50) DEFAULT NULL,
  `direccionempresa` varchar(50) DEFAULT NULL,
  `telefonoempresa` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numeroempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.empresa: ~0 rows (aproximadamente)
DELETE FROM `empresa`;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.eproductiva
CREATE TABLE IF NOT EXISTS `eproductiva` (
  `codigoeproductiva` int(11) NOT NULL AUTO_INCREMENT,
  `fechainicioeproductiva` date DEFAULT NULL,
  `fechafineproductiva` date DEFAULT NULL,
  `funcioneseproductiva` text DEFAULT NULL,
  `estadoeproductiva` varchar(50) DEFAULT NULL,
  `documentoaprendiz` bigint(20) DEFAULT NULL,
  `codigotipopractica` int(11) DEFAULT NULL,
  `numeroempresa` bigint(20) DEFAULT NULL,
  `documentocoformador` bigint(20) DEFAULT NULL,
  `documentofuncionario` bigint(20) DEFAULT NULL,
  `etapaeproductiva` varchar(50) DEFAULT NULL,
  `bitacoraseproductiva` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoeproductiva`),
  KEY `FK_eproductiva_aprendiz` (`documentoaprendiz`),
  KEY `FK_eproductiva_tipopractica` (`codigotipopractica`),
  KEY `FK_eproductiva_empresa` (`numeroempresa`),
  KEY `FK_eproductiva_funcionario` (`documentofuncionario`),
  CONSTRAINT `FK_eproductiva_aprendiz` FOREIGN KEY (`documentoaprendiz`) REFERENCES `aprendiz` (`documentoaprendiz`),
  CONSTRAINT `FK_eproductiva_empresa` FOREIGN KEY (`numeroempresa`) REFERENCES `empresa` (`numeroempresa`),
  CONSTRAINT `FK_eproductiva_funcionario` FOREIGN KEY (`documentofuncionario`) REFERENCES `funcionario` (`documentofuncionario`),
  CONSTRAINT `FK_eproductiva_tipopractica` FOREIGN KEY (`codigotipopractica`) REFERENCES `tipopractica` (`codigotipopractica`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.eproductiva: ~0 rows (aproximadamente)
DELETE FROM `eproductiva`;
/*!40000 ALTER TABLE `eproductiva` DISABLE KEYS */;
/*!40000 ALTER TABLE `eproductiva` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.experiencia
CREATE TABLE IF NOT EXISTS `experiencia` (
  `codigoexperiencia` int(11) NOT NULL AUTO_INCREMENT,
  `empresaexperiencia` varchar(50) DEFAULT NULL,
  `ocupacionexperiencia` varchar(50) DEFAULT NULL,
  `fechaingresoexperiencia` date DEFAULT NULL,
  `fecharetiroexperiencia` date DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigoexperiencia`),
  KEY `FK_experiencia_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_experiencia_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.experiencia: ~0 rows (aproximadamente)
DELETE FROM `experiencia`;
/*!40000 ALTER TABLE `experiencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `experiencia` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.fichatitulacion
CREATE TABLE IF NOT EXISTS `fichatitulacion` (
  `numeroficha` int(11) NOT NULL,
  `jornadaficha` varchar(50) DEFAULT NULL,
  `codigoprograma` int(11) DEFAULT NULL,
  `numerosede` int(11) DEFAULT NULL,
  `fechainicio` date DEFAULT NULL,
  `fechafin` date DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`numeroficha`),
  KEY `FK_fichatitulacion_instructor` (`documentoinstructor`),
  KEY `FK_fichatitulacion_programa` (`codigoprograma`),
  KEY `FK_fichatitulacion_sede` (`numerosede`),
  CONSTRAINT `FK_fichatitulacion_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`),
  CONSTRAINT `FK_fichatitulacion_programa` FOREIGN KEY (`codigoprograma`) REFERENCES `programa` (`codigoprograma`),
  CONSTRAINT `FK_fichatitulacion_sede` FOREIGN KEY (`numerosede`) REFERENCES `sede` (`numerosede`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.fichatitulacion: ~3 rows (aproximadamente)
DELETE FROM `fichatitulacion`;
/*!40000 ALTER TABLE `fichatitulacion` DISABLE KEYS */;
INSERT INTO `fichatitulacion` (`numeroficha`, `jornadaficha`, `codigoprograma`, `numerosede`, `fechainicio`, `fechafin`, `documentoinstructor`) VALUES
	(156565, 'NOCTURNA', 228106, NULL, '2019-11-03', '2019-11-13', 6137989),
	(1134299, 'DIURNA', 228106, NULL, '2017-08-04', '2017-08-04', 6137989),
	(1838890, 'MIXTA', 228106, NULL, '2019-11-04', '2019-11-20', 14802285);
/*!40000 ALTER TABLE `fichatitulacion` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.formacion
CREATE TABLE IF NOT EXISTS `formacion` (
  `codigoformacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombreformacion` varchar(100) DEFAULT NULL,
  `institucionformacion` varchar(100) DEFAULT NULL,
  `anioformacion` int(11) DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigoformacion`),
  KEY `FK_formacion_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_formacion_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.formacion: ~0 rows (aproximadamente)
DELETE FROM `formacion`;
/*!40000 ALTER TABLE `formacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `formacion` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `documentofuncionario` bigint(20) NOT NULL,
  `codigoarea` int(11) NOT NULL,
  PRIMARY KEY (`documentofuncionario`),
  KEY `FK_funcionario_area` (`codigoarea`),
  CONSTRAINT `FK_funcionario_area` FOREIGN KEY (`codigoarea`) REFERENCES `area` (`codigoarea`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_funcionario_personal` FOREIGN KEY (`documentofuncionario`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.funcionario: ~44 rows (aproximadamente)
DELETE FROM `funcionario`;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`documentofuncionario`, `codigoarea`) VALUES
	(14890737, 1),
	(14895433, 2),
	(16367533, 3),
	(1116252066, 4),
	(31790970, 5),
	(66872755, 6),
	(1116235893, 7),
	(66715586, 8),
	(1112104556, 9),
	(1116264206, 9),
	(29876448, 10),
	(6498528, 11),
	(1006217360, 11),
	(1116240221, 11),
	(31202516, 12),
	(1115068144, 13),
	(29533266, 14),
	(1032939671, 14),
	(1112100314, 14),
	(1115068462, 15),
	(1115066373, 16),
	(14894090, 17),
	(1116239995, 18),
	(1116245277, 18),
	(1116250682, 18),
	(66716297, 19),
	(1094927401, 20),
	(94387428, 21),
	(14796175, 22),
	(31656799, 23),
	(42114788, 24),
	(94395869, 24),
	(66931504, 25),
	(1116240054, 26),
	(38875264, 27),
	(29873285, 28),
	(14891933, 29),
	(1112102132, 30),
	(1115080400, 31),
	(31791919, 32),
	(66775045, 32),
	(52183274, 33),
	(66772489, 34),
	(1116238083, 35);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.guarda
CREATE TABLE IF NOT EXISTS `guarda` (
  `documentoguarda` bigint(20) NOT NULL,
  PRIMARY KEY (`documentoguarda`),
  CONSTRAINT `FK_guarda_personal` FOREIGN KEY (`documentoguarda`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.guarda: ~0 rows (aproximadamente)
DELETE FROM `guarda`;
/*!40000 ALTER TABLE `guarda` DISABLE KEYS */;
INSERT INTO `guarda` (`documentoguarda`) VALUES
	(1116235892);
/*!40000 ALTER TABLE `guarda` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.hablaidioma
CREATE TABLE IF NOT EXISTS `hablaidioma` (
  `documentoinstructor` bigint(20) NOT NULL,
  `codigoidioma` int(11) NOT NULL,
  `nivelhabla` varchar(50) DEFAULT NULL,
  `nivelescribe` varchar(50) DEFAULT NULL,
  `nivellee` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`documentoinstructor`,`codigoidioma`),
  KEY `FK_hablaidioma_idioma` (`codigoidioma`),
  CONSTRAINT `FK_hablaidioma_idioma` FOREIGN KEY (`codigoidioma`) REFERENCES `idioma` (`codigoidioma`),
  CONSTRAINT `FK_hablaidioma_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.hablaidioma: ~0 rows (aproximadamente)
DELETE FROM `hablaidioma`;
/*!40000 ALTER TABLE `hablaidioma` DISABLE KEYS */;
/*!40000 ALTER TABLE `hablaidioma` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.idioma
CREATE TABLE IF NOT EXISTS `idioma` (
  `codigoidioma` int(11) NOT NULL AUTO_INCREMENT,
  `nombreidioma` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoidioma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.idioma: ~0 rows (aproximadamente)
DELETE FROM `idioma`;
/*!40000 ALTER TABLE `idioma` DISABLE KEYS */;
/*!40000 ALTER TABLE `idioma` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.inasistencia
CREATE TABLE IF NOT EXISTS `inasistencia` (
  `codigoinasistencia` int(11) NOT NULL AUTO_INCREMENT,
  `documentoaprendiz` bigint(20) DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  `fechainasistencia` date DEFAULT NULL,
  `horasinasistencia` int(11) DEFAULT NULL,
  `excusainasistencia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoinasistencia`),
  KEY `FK_inasistencia_aprendiz` (`documentoaprendiz`),
  KEY `FK_inasistencia_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_inasistencia_aprendiz` FOREIGN KEY (`documentoaprendiz`) REFERENCES `aprendiz` (`documentoaprendiz`),
  CONSTRAINT `FK_inasistencia_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.inasistencia: ~0 rows (aproximadamente)
DELETE FROM `inasistencia`;
/*!40000 ALTER TABLE `inasistencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `inasistencia` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.ingreso
CREATE TABLE IF NOT EXISTS `ingreso` (
  `numeroingreso` int(11) NOT NULL AUTO_INCREMENT,
  `fechaingreso` date DEFAULT NULL,
  `horaingreso` varchar(50) DEFAULT NULL,
  `fechasalida` date DEFAULT NULL,
  `horasalida` varchar(50) DEFAULT NULL,
  `motivoingreso` text DEFAULT NULL,
  `documentopersonal` bigint(20) DEFAULT NULL,
  `numeroelemento` int(11) DEFAULT NULL,
  PRIMARY KEY (`numeroingreso`),
  KEY `FK_ingreso_personal` (`documentopersonal`),
  KEY `FK_ingreso_elemento` (`numeroelemento`),
  CONSTRAINT `FK_ingreso_elemento` FOREIGN KEY (`numeroelemento`) REFERENCES `elemento` (`codigoelemento`),
  CONSTRAINT `FK_ingreso_personal` FOREIGN KEY (`documentopersonal`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.ingreso: ~15 rows (aproximadamente)
DELETE FROM `ingreso`;
/*!40000 ALTER TABLE `ingreso` DISABLE KEYS */;
INSERT INTO `ingreso` (`numeroingreso`, `fechaingreso`, `horaingreso`, `fechasalida`, `horasalida`, `motivoingreso`, `documentopersonal`, `numeroelemento`) VALUES
	(1, '2017-08-02', '10:40:19', NULL, '10:40:39', NULL, 1116235891, NULL),
	(2, '2017-08-02', '10:41:39', '2017-08-02', '10:41:48', NULL, 1116235891, NULL),
	(3, '2017-08-02', '14:19:58', '2017-08-02', '14:20:09', NULL, 1116235891, NULL),
	(4, '2017-08-02', '17:30:10', '2017-08-02', '17:30:26', '19870122', 1116235891, NULL),
	(5, '2017-08-04', '10:21:56', '2017-08-04', '10:22:05', NULL, 1116235891, NULL),
	(6, '2017-08-04', '10:23:17', '2017-08-04', '10:25:16', 'MOTIVO', 1116235891, 1),
	(7, '2017-08-04', '14:19:36', '2017-08-04', '14:19:45', NULL, 1116235891, NULL),
	(8, '2017-08-04', '14:21:38', '2017-08-04', '14:59:23', '19870122', 1116235891, NULL),
	(9, '2017-08-04', '15:12:05', '2017-08-04', '15:14:10', 'PRUEBA DE INGRESO CON ELEMENTO', 1116235891, 2),
	(10, '2017-08-04', '15:14:26', '2017-08-04', '15:15:20', 'JKHJH', 1116235891, 3),
	(11, '2017-08-04', '15:16:36', '2017-08-04', '15:16:45', 'sadsdasd', 1116235891, 4),
	(12, '2017-08-04', '15:26:30', '2017-08-04', '16:09:37', 'jhjhj', 1116235891, 5),
	(14, '2017-08-04', '16:08:25', '2017-08-04', '16:08:33', 'fdsfsdfsdf', 1116235892, 7),
	(15, '2017-08-04', '16:53:15', NULL, NULL, NULL, 1116235891, NULL),
	(16, '2017-08-14', '15:49:47', '2017-08-14', '15:49:55', NULL, 1116235891, NULL);
/*!40000 ALTER TABLE `ingreso` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.instructor
CREATE TABLE IF NOT EXISTS `instructor` (
  `documentoinstructor` bigint(20) NOT NULL,
  `tipoinstructor` varchar(50) DEFAULT NULL,
  `perfilocupacionalinstructor` text DEFAULT NULL,
  `logrosinstructor` text DEFAULT NULL,
  PRIMARY KEY (`documentoinstructor`),
  CONSTRAINT `FK_instructor_personal` FOREIGN KEY (`documentoinstructor`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.instructor: ~218 rows (aproximadamente)
DELETE FROM `instructor`;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` (`documentoinstructor`, `tipoinstructor`, `perfilocupacionalinstructor`, `logrosinstructor`) VALUES
	(1000, 'CONTRATISTA', NULL, NULL),
	(2000, 'PLANTA', NULL, NULL),
	(3000, 'CONTRATISTA', NULL, NULL),
	(4000, 'CONTRATISTA', NULL, NULL),
	(5000, 'PLANTA', NULL, NULL),
	(3482453, 'CONTRATISTA', 'ADMINISTRADOR EN SALUD', 'Esp. en Servicios de Salud'),
	(4408060, 'CONTRATISTA', 'INGENIERO ELECTRICISTA', ''),
	(6137989, 'CONTRATISTA', 'ZOOCTECNISTA', 'ESPECIALIZACION TECNICA EN ALIMENTACION ALTERNATIVA'),
	(6198189, 'CONTRATISTA', 'INGENIERO AGRONOMO', ''),
	(6200685, 'CONTRATISTA', 'ABOGADO', 'SEGURIDAD SOCIAL'),
	(6356646, 'CONTRATISTA', 'CONTADOR PUBLICO', ''),
	(6498352, 'CONTRATISTA', 'ADMINISTRADOR FINANCIERO', 'Espe. Tecnologia en Gestióm de Proyectos'),
	(6498998, 'CONTRATISTA', 'LICENCIADO DE EDUCACION FISICA', ''),
	(6499389, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS', 'ESP EN FINANZAS'),
	(6499423, 'CONTRATISTA', 'INGENIERO INDUSTRIAL', 'MAESTRIA EN ADMINISTRACION DE EMPRESAS'),
	(6500262, 'CONTRATISTA', 'INGENIERO AMBIENTAL', ''),
	(6501796, 'CONTRATISTA', 'ABOGADO', 'ASISTENCIA TECNICA'),
	(9152761, 'CONTRATISTA', 'QUIMICO FARMACEUTICO', ''),
	(10292173, 'CONTRATISTA', 'INGENIERO DE SISTEMAS ', ''),
	(12187322, 'CONTRATISTA', 'INGENIERO AGRICOLA', 'GESTION DE ASISTENCIA TECNICA AGROPECUARIA'),
	(14704807, 'CONTRATISTA', 'INGENIERA AGRICOLA', ''),
	(14795060, 'CONTRATISTA', 'LICENCIADO EN LENGUAS MODERNAS', ''),
	(14795372, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', ''),
	(14796542, 'CONTRATISTA', 'LICENCIADO EN EDUCACION CON ENFASIS EN EDUCACION FISICA(RECREACIÓN Y DEPORTE)', ''),
	(14799364, 'CONTRATISTA', 'ADMINISTRADOR AGROPECUARIO', 'GANADERIA INTENSIVA'),
	(14801705, 'CONTRATISTA', 'ADMINISTRADOTR DE EMPRESAS AGROPECUARIAS', 'ESPECIALIZACION TECNICA EN ESPECIES MENORES'),
	(14802285, 'CONTRATISTA', 'INGENIERO DE SISTEMAS', NULL),
	(14878719, 'CONTRATISTA', 'ADMINISTRADOR PUBLICO', ''),
	(14882452, 'CONTRATISTA', 'INGENIERO AGRONOMO', ''),
	(14885750, 'CONTRATISTA', 'CONTADOR PUBLICO', 'Maestria en Administración. ESP. en Finanzas y en Revisor Fiscal y Auditoria'),
	(14889459, 'CONTRATISTA', 'ADMINISTRACION DE EMPRESAS', 'GESTION DE MANEJO DE RESIDUOS SOLIDOS'),
	(14890585, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS', ''),
	(14891011, 'CONTRATISTA', 'ADMINISTRAOR DE EMPRESAS', 'MAGISTER EN ADMINISTRACIÓN'),
	(14891226, 'CONTRATISTA', 'INGENIERO AGRONOMO', ''),
	(14892405, 'CONTRATISTA', 'ZOOTECNISTA', ''),
	(14892979, 'CONTRATISTA', 'ADMINISTRACION DE EMPRESAS', ''),
	(14893993, 'CONTRATISTA', 'ADMINISTRACION AGROPECUARIO', 'ESPECIALIZACION SISTEMA DE GESTION DE CALIDAD EN EL SISTEMA AGROPECUARIO'),
	(14895079, 'CONTRATISTA', 'INGENIERO AGRONOMO', ''),
	(14896559, 'CONTRATISTA', 'PROFESIONAL EN SALUD OCUPACIONAL', ''),
	(14897229, 'CONTRATISTA', 'ADMINISTRADOR DE NEGOCIOS', ''),
	(14898070, 'CONTRATISTA', 'INGENIERO AGRONOMO', 'Maestria en ADMINISTRACION DE EMPRESAS'),
	(15918435, 'CONTRATISTA', 'LICENCIADO EN EDUCACION FISICA', 'NO'),
	(16222766, 'CONTRATISTA', 'Administrador de Empresas Agropecuarias', 'Agroecologia - Alimentacion alternativa de animales de Granja'),
	(16234415, 'CONTRATISTA', 'ZOOTECNISTA', 'ESTUDIANTE DE DOCENCIA UNIVERSITARIA'),
	(16260064, 'CONTRATISTA', 'INGENIERO AGRONOMO', ''),
	(16280474, 'CONTRATISTA', 'INGENIERO AGRONOMO', 'ESPECIALIZACION TECNOLOGICA EN ASISTENCIA TECNICA'),
	(16348821, 'CONTRATISTA', 'TECNOLOGO EN RECURSOS NATURALEZ', 'SISTEMA DE GESTION INTEGRADO PARA EL SECTOR AGROPECUARIO'),
	(16358684, 'CONTRATISTA', 'INGENIERO AGRONOMO', 'MAESTRIA PROTECCION DE CULTIVOS'),
	(16366537, 'CONTRATISTA', 'INGENIERO DE SISTEMAS', 'Esp. En gestión Educativa'),
	(16367151, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS', ''),
	(16368987, 'CONTRATISTA', 'CONTADOR PUBLICO', ''),
	(16552383, 'CONTRATISTA', 'ADMINISTRADOR DE SISTEMAS INFORMATICOS ', ''),
	(16590486, 'CONTRATISTA', 'CONTADOR PUBLICO', 'Esp en MArketing EStrategico'),
	(16613100, 'CONTRATISTA', 'INGENIERO AGRONOMO', ''),
	(16796521, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS', ''),
	(17658884, 'CONTRATISTA', 'INGENIERO AGROECOLOGO', ''),
	(21811664, 'CONTRATISTA', 'ADMINISTRADORA FINANCIERA', 'Esp. Gestión de Proyectos'),
	(25286245, 'CONTRATISTA', 'HISTORIADORA', ''),
	(26471980, 'CONTRATISTA', 'Zootecnista', 'Esp SENA en Especies Menores'),
	(29142993, 'CONTRATISTA', 'CONTADOR PUBLICO', 'Especialista Administración Financiera'),
	(29185945, 'CONTRATISTA', 'ZOOTECNISTA', 'ESTUDIANTE BPA'),
	(29186692, 'CONTRATISTA', 'BACTERIOLOGA', 'ESPECIALIZACION ADMINISTRACION EN SALUD'),
	(29186804, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESAS', ''),
	(29186941, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESAS', 'ESTUDIANTE DE ESPECIALIZACION EN PEDAGOGIA Y DOCENCIA'),
	(29282067, 'CONTRATISTA', 'PROFESIONAL GESTION DOCUMENTAL', ''),
	(29284823, 'CONTRATISTA', 'ADMINISTRADORA FINANCIERA', ''),
	(29287323, 'CONTRATISTA', 'PSICOLOGA', 'ESP ETICA Y PEDAGOGIA'),
	(29307769, 'CONTRATISTA', 'INGENIERA AMBIENTAL Y DE RECURSOS NATURALES', ''),
	(29309904, 'CONTRATISTA', 'PROFESIONAL SALUD OCUPACIONAL', 'EVALUACION PEDAGOGICA, MAESTRIA EN EDUCACION'),
	(29314302, 'CONTRATISTA', 'QUIMICA', ''),
	(29433366, 'CONTRATISTA', 'PSICOLOGA ', 'ESPEC. GESTION DE PROYECTOS.    MAESTRIA EN SICOLOGIA'),
	(29683035, 'CONTRATISTA', 'INGENIERA AGRICOLA', ''),
	(29757606, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESAS AGROPECUARIAS', 'ESPECIALIZACION TECNICA DE ESPECIALES MENORES Y ALIMENTACION ALTERNATIVA'),
	(29785289, 'CONTRATISTA', 'PROFESIONAL EN SALUD OCUPACIONAL', ''),
	(29817337, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESA', ''),
	(29873118, 'CONTRATISTA', 'PRFESIONAL EN ENFERMERIA', 'ESTUDIANTE SEGURIDAD Y SALUD EN EL TRABAJO'),
	(29873150, 'CONTRATISTA', 'Ingeniera Ambiental y de Recursos Naturales', ''),
	(29873381, 'CONTRATISTA', 'INGENIERA INDUSTRIAL', 'Maestria en Logistica y Negociacion Internacional'),
	(29875145, 'CONTRATISTA', 'ADMINISTRACION DE EMPRESAS AGROPECUARIAS', ''),
	(29875954, 'CONTRATISTA', 'INGENIERO DE SISTEMAS', ''),
	(29876355, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESAS', ''),
	(29877544, 'CONTRATISTA', 'INGENIERO AMBIENTAL', 'Especialista en Gerencia de Proyectos'),
	(29877545, 'CONTRATISTA', 'INGENIERA INDUSTRIAL', ''),
	(29993888, 'CONTRATISTA', 'Administracion de Empresas Agropecuaria', 'Tecnico en Especies Menores'),
	(30311965, 'CONTRATISTA', 'LICENCIADA EN LENGUAS MODERNAS', ''),
	(31166225, 'CONTRATISTA', 'INGENIERO AGRONOMO', ''),
	(31189608, 'CONTRATISTA', 'Ingenieria de Alimentos', 'Gestion de Proyectos'),
	(31189932, 'CONTRATISTA', 'CONTADOR PUBLICO', 'Esp Tecnologoca en Contabilidad de Costos SENA'),
	(31193147, 'CONTRATISTA', 'ABOGADA', ''),
	(31194207, 'CONTRATISTA', 'PSICOLOGA SOCIAL COMUNITARIO', 'ESP EN PROYECTOS'),
	(31196463, 'CONTRATISTA', 'PROFESIONAL EN SALUD OCUPACI', ''),
	(31197370, 'CONTRATISTA', 'INGENIERO INDUSTRIAL', 'Especialista Gerencia de Proyectos'),
	(31201818, 'CONTRATISTA', 'CONTADOR PUBLICO', 'Esp. en Negocios Internacionales con enfasis en Logistica'),
	(31202853, 'CONTRATISTA', 'CONTADOR PUBLICO', ''),
	(31416143, 'CONTRATISTA', 'INGENIERA AGRICOLA', ''),
	(31437342, 'CONTRATISTA', 'Tecnologa en Administración Documental', ''),
	(31640461, 'CONTRATISTA', 'ADMINISTRACION DE EMPRESAS', ''),
	(31657309, 'CONTRATISTA', 'ECONOMISTA', ''),
	(31755103, 'CONTRATISTA', 'CONTADOR PUBLICO', 'Maestria en Educación'),
	(31791348, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESAS', 'Esp. Tecnologica en Proyectos SENA'),
	(31791366, 'CONTRATISTA', 'LICENCIADA EN EDUCACION BASICA CON ENFASIS EN LENGUA EXTRANJERA', ''),
	(31791653, 'CONTRATISTA', 'CONTADURIA PUBLICA', 'ETICA Y PEDAGOGIA Y MAG. EN COMERCIO EXTERIOR'),
	(31792489, 'CONTRATISTA', 'CONTADOR PUBLICO', 'Esp en Finanzas'),
	(31793192, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', ''),
	(31793858, 'CONTRATISTA', 'INGENIERA INDUSTRIAL', ''),
	(31793894, 'CONTRATISTA', 'INGENIERO AMBIENTAL', ''),
	(31794602, 'CONTRATISTA', 'COMUNICADORA SOCIAL', 'Esp. Sistemas integrados de Gestión'),
	(31794763, 'CONTRATISTA', 'CONTADOR PUBLICO', ''),
	(31794856, 'CONTRATISTA', 'Medico Veterinaria Zootecnista', ''),
	(31810074, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS', 'Esp. Gerencia Financiera'),
	(31875359, 'CONTRATISTA', 'TECNOLOGA EN ALIMENTOS', ''),
	(31951934, 'CONTRATISTA', 'LICENCIADA EN EDUCACIÓN BASICA EN CIENCIAS NATURALES Y EDUCACIÓN AMBIENTAL. TECNICA PROFESIONAL EN GESTIÓN DE RECURSOS NATURALES', ''),
	(31983737, 'CONTRATISTA', 'INGENIERA AGRONOMA', ''),
	(34322238, 'CONTRATISTA', 'INGENIERA AGROFORESTAL', 'ESTUDIANTE MAESTRIA DE EDUCACION AMBIENTAL Y DESARROLLO SOSTENIBLE'),
	(34564875, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', 'ESPECIALIZACION EN PEDAGOGIA PARA EL DESARROLLO DEL APRENDIZAJE AUTONOMO Y ESTUDIANTE DE MAESTRIA EN ADMINISTRACION DE ORGANIZACIÓNES'),
	(38555834, 'CONTRATISTA', 'INGENIERO AMBIENTAL Y RECURSOS NATURALES', ''),
	(38790099, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESAS', 'ESTUDIANTE MAESTRIA SEGURIDAD Y SALUD EN EL TRABAJO'),
	(38790890, 'CONTRATISTA', 'INGENIERA AMBIENTAL', 'Maestria en energias renovables'),
	(38792038, 'CONTRATISTA', 'ADMINISTRACION FINANCIERA', 'GERENCIA DEL TALENTO HUMANO'),
	(38792369, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESAS', 'MAESTRIA EN ADMINISTRACIÓN Y DIRECCIÓN DE PROYECTOS'),
	(38792768, 'CONTRATISTA', 'ADMINISTRADOR FINANCIERO', ''),
	(38794509, 'CONTRATISTA', 'INGENIERA AMBIENTAL', ''),
	(38795222, 'CONTRATISTA', 'ADMINISTRACION DE EMPRESAS', ''),
	(38796631, 'CONTRATISTA', 'INGENIERA INDUSTRIAL', 'Esp. en Gerencia de salud ocupacional'),
	(38859741, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESA', 'Esp. en gerencia de personal y de seguros'),
	(38869122, 'CONTRATISTA', 'CONTADOR PUBLICO', ''),
	(38879499, 'CONTRATISTA', 'ADMINISTRACION DE NEGOCIOS', ''),
	(41944840, 'CONTRATISTA', 'PROFESIONAL EN HOTELERIA Y TURISMO ECOLOGICO', ''),
	(41952684, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESAS AGROPECUARIAS', 'Espe. Gerencia de Proyectos'),
	(42015472, 'CONTRATISTA', 'CONTADOR PUBLICO', 'Maestria en Finanzas Corporativas'),
	(42875897, 'CONTRATISTA', 'PROFESIONAL E ENFERMERIA', 'GERENCIA DEL TALENTO HUMANO'),
	(43508604, 'CONTRATISTA', 'LICENCIADA EN ETICA', ''),
	(52085354, 'CONTRATISTA', 'MEDICA VETERINARIA', ''),
	(66660491, 'CONTRATISTA', 'INGENIERA AGRICOLA', ''),
	(66712227, 'CONTRATISTA', 'CONTADOR PUBLICO', 'ESP.TECNOLOGICA EN COSTOS'),
	(66718544, 'CONTRATISTA', 'INGENIERA AMBIENTAL', 'Esp. en Salud Ocupacional'),
	(66720662, 'CONTRATISTA', 'CONTADOR PUBLICO', 'ESP. TECNOLOGICA EN COSTOS'),
	(66720691, 'CONTRATISTA', 'INGENIERA AMBIENTAL', 'Esp. Tecnologica Producción y consumo sostenible '),
	(66724715, 'CONTRATISTA', 'Administrador de Empresas', 'Estudiante de Especializacion de Seguridad y Salud en el trabajo'),
	(66724717, 'CONTRATISTA', 'INGENIERA AGRONOMA', ''),
	(66726036, 'CONTRATISTA', 'CONTADURIA PUBLICA', 'MARKETIN ESTRATEGICO'),
	(66726150, 'CONTRATISTA', 'INGENIERA EN ALIMENTOS', ''),
	(66729836, 'CONTRATISTA', 'ENFERMERA ', ''),
	(66751978, 'CONTRATISTA', 'CONTADOR PUBLICO', ''),
	(66801799, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESAS', ''),
	(66804224, 'CONTRATISTA', 'INGENIERA AGRICOLA', ''),
	(66850067, 'CONTRATISTA', 'INGENIERIA INDUSTRIAL', ''),
	(66902155, 'CONTRATISTA', 'INGENIERA AGRONOMA, TECNOLOGA EN ALIMENTOS', ''),
	(66930544, 'CONTRATISTA', 'CONTADORA PUBLICA-ADMINISTRADORA DE EMPRESAS', ''),
	(66931180, 'CONTRATISTA', 'INGENIERO COMERCIAL', ''),
	(66931412, 'CONTRATISTA', 'INGENIERA INDUSTRIAL', 'ESPECIALISTA EN SALUD OCUPACIONAL'),
	(66983210, 'CONTRATISTA', 'MEDICA VETERINARIA ZOOTECNISTA', ''),
	(67031593, 'CONTRATISTA', 'INGENIERA AGRONOMA', ''),
	(71905008, 'CONTRATISTA', 'INGENIERO AGRONOMO', 'EST. Gestion de Asistencia Tecnica Agropecuaria'),
	(73109148, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS', 'ESP. EN NEGOCIOS INTERNACIONALES, LOGISTICA INTERNACIONAL. Especialista en Gestión Ambiental'),
	(75082123, 'CONTRATISTA', 'INGENIERO SISTEMAS', ''),
	(75108450, 'CONTRATISTA', 'MEDICO VETERINARIO', 'MAESTRIA SISTEMAS DE PRODUCCION AGROPECUARIA'),
	(76306931, 'CONTRATISTA', 'PROFESIONAL EN SALUD OCUPACIONAL', 'Estudiante Especializacion en Seguridad y Salud en el Trabajo'),
	(76324492, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS', 'Est. Marketin estrategico'),
	(91284330, 'CONTRATISTA', 'TECNOLOGOGO EN ADMINISTRACION EMPRESAS AGROPECUARIAS', ''),
	(91438736, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS HOTELERAS Y TURISTICAS', ''),
	(91479566, 'CONTRATISTA', 'LICENCIADO EN EDUCACION FISICA', ''),
	(94151777, 'CONTRATISTA', 'PSICOLOGO', 'Esp. Tecnologica en Gestión d eproyectos. '),
	(94152060, 'CONTRATISTA', 'INGENIERIA AMBIENTAL', 'EDUCACION AMBIENTAL, ASISTENCIA TECNICA AGROPECUARIA'),
	(94153316, 'CONTRATISTA', 'COMUNICADOR SOCIAL', ''),
	(94153675, 'CONTRATISTA', 'LICENCIADO EN EDUCACION CON ENFASIS EN EDUCACION FISICA(RECREACIÓN Y DEPORTE)', ''),
	(94154184, 'CONTRATISTA', 'INGENIERIA AMBIENTAL', 'GERENCIA EDUCATIVA'),
	(94154232, 'CONTRATISTA', 'INGENIERO AMBIENTAL', ''),
	(94225794, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS', 'MAESTRANTE EN ADMINISTRACION'),
	(94229067, 'CONTRATISTA', 'INGENIERO EN SISTEMAS', 'Esp. Tecnologica desarrollo en dispositivos Moviles'),
	(94230308, 'CONTRATISTA', 'ADMINISTRADOR DE NEGOCIOS', 'MAGISTER EN DESARROLLO ORGANIZACIONAL'),
	(94265335, 'CONTRATISTA', 'INGENIERO AGRICOLA', 'MAESTRIA LEVANTAMIENTO DE RECURSOS NATURALES'),
	(94276055, 'CONTRATISTA', 'PSICOLOGO', ''),
	(94300135, 'CONTRATISTA', 'INGENIERO INDUSTRIAL', ''),
	(94300648, 'CONTRATISTA', 'INGENIERO AGRONOMO', ''),
	(94325496, 'CONTRATISTA', 'FINANZAS Y NEGOCIOS INTERNACIONALES', 'Esp. Gerencia de Marketing Estrategico'),
	(94356606, 'CONTRATISTA', 'CONTADOR PUBLICO', ''),
	(94364756, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', ''),
	(94366043, 'CONTRATISTA', 'ADMINISTRACION FINANCIERA', ''),
	(94368285, 'CONTRATISTA', 'LICENCIADO EN EDUCACIÓN FISICA', 'Esp. en Dirección y Gestión Deportiva'),
	(94369027, 'CONTRATISTA', 'ADMINISTRACION DE EMPRESAS', ''),
	(94388847, 'CONTRATISTA', 'TECNOLOGO AGROPECUARIO', ''),
	(94391225, 'CONTRATISTA', 'CONTADOR PUBLICO', ''),
	(94392383, 'CONTRATISTA', 'INGENIERO INDUSTRIAL', 'ESPECIALIZACION EN PROYECTOS TECNOLOGICA'),
	(94394545, 'CONTRATISTA', 'INGENIERO AMBIENTAL', 'MAESTRIA EN ADMINISTRACION'),
	(94395777, 'CONTRATISTA', 'INGENIERO INDUSTRIAL', ''),
	(94471577, 'CONTRATISTA', 'PSICOLOGO', 'GESTION DE PROYECTOS'),
	(94472629, 'CONTRATISTA', '', ''),
	(94475502, 'CONTRATISTA', 'MEDICO VETERINARIO', ''),
	(94475905, 'CONTRATISTA', 'ABOGADO', ''),
	(94477091, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS', ''),
	(94480337, 'CONTRATISTA', 'INGENIERO AGROINDUSTRIAL', 'DIPLOMADO EN SISTEMAS DE GESTION DE CALIDAD PARA EMPRESAS DE ALIMENTOS'),
	(1110457030, 'CONTRATISTA', 'MEDICO VETERINARIO, ZOOTENISTA', 'ESTUDIANTE NUTRICION ANIMAL SOSTENIBLE'),
	(1112098072, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS Y CONTADURIA PUBLICA', 'ESPECIALIZACION DE REVISORIA FISCAL Y CONTRALORIA Y ESP. TECNOLOGICA GESTION DEL TALENTO HUMANO POR COMPETENCIAS'),
	(1112099702, 'CONTRATISTA', 'ZOOTECNISTA', 'GERENCIA DE PROYECTOS'),
	(1112100266, 'CONTRATISTA', 'COMUNICADOR SOCIAL', ''),
	(1112625065, 'CONTRATISTA', 'COMUNICADORA SOCIAL', ''),
	(1112773384, 'CONTRATISTA', 'DISEÑADOR GRAFICO', ''),
	(1114118406, 'CONTRATISTA', 'ADMINISTRADOR AGROPECUARIO', ''),
	(1115064457, 'CONTRATISTA', 'TECNOLOGO EN CONTROL AMBIENTAL', 'Esp. Tecnologica en Sistemas de Gestión de Calidad'),
	(1115070510, 'CONTRATISTA', 'PSICÓLOGO', 'Esp. ética y pedagogía'),
	(1115071823, 'CONTRATISTA', 'COMUNICADORA SOCIAL', ''),
	(1115074422, 'CONTRATISTA', 'FISIOTERAPEUTA', 'SALUD OCUPACIONAL'),
	(1115079655, 'CONTRATISTA', 'Administradora en Salud Ocupacional', ''),
	(1116235526, 'CONTRATISTA', 'TRABAJADORA SOCIAL', 'Esp. En gerencia de proyectos'),
	(1116235537, 'CONTRATISTA', 'INGENIERO ELECTRICISTA', ''),
	(1116235700, 'CONTRATISTA', 'TECNOLOGA EN ADMINISTRACIÓN HOTELERA Y TURISMO', 'ADMINISTRADORA PUBLICA Y ESPECIALISTA EN GERENCIA SOCIAL'),
	(1116238204, 'CONTRATISTA', 'ADMINISTRADORA DE EMPRESAS', ''),
	(1116238490, 'CONTRATISTA', 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', ''),
	(1116238701, 'CONTRATISTA', 'CONTADORA PUBLICA', 'Esp. en administracion en la salud'),
	(1116242450, 'CONTRATISTA', 'LICENCIADO EN LENGUAS EXTRANJERAS', 'ESTUDIANTE MAESTRIA ENSEÑANZA INGLES, COMO LENGUA EXTRANJERA'),
	(1116243314, 'CONTRATISTA', 'PROFESIONAL EN COMERCIO INTERNACIONAL', ''),
	(1116244664, 'CONTRATISTA', 'CONTADOR PUBLICO', ''),
	(1116246600, 'CONTRATISTA', 'Zootecnista', ''),
	(1116256886, 'CONTRATISTA', 'LICENCIADO EN LENGUAS EXTRANJERAS', ''),
	(1116722533, 'CONTRATISTA', 'ADMINISTRACION FINANCIERA', 'MAESTRIA ADMINISTRACION'),
	(1130613755, 'CONTRATISTA', 'PROFESIONAL EN FINANZAS Y NEGOCIOS INTERNACIONALES', ''),
	(1144058877, 'CONTRATISTA', 'ABOGADA', '');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.novedadlectiva
CREATE TABLE IF NOT EXISTS `novedadlectiva` (
  `numeronovedad` int(11) NOT NULL AUTO_INCREMENT,
  `nombrenovedad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numeronovedad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.novedadlectiva: ~0 rows (aproximadamente)
DELETE FROM `novedadlectiva`;
/*!40000 ALTER TABLE `novedadlectiva` DISABLE KEYS */;
/*!40000 ALTER TABLE `novedadlectiva` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.novedadproductiva
CREATE TABLE IF NOT EXISTS `novedadproductiva` (
  `numeronovedad` int(11) NOT NULL AUTO_INCREMENT,
  `codigoeproductiva` int(11) DEFAULT NULL,
  `fechanovedad` date DEFAULT NULL,
  `observacionesnovedad` text DEFAULT NULL,
  PRIMARY KEY (`numeronovedad`),
  KEY `FK_novedadproductiva_eproductiva` (`codigoeproductiva`),
  CONSTRAINT `FK_novedadproductiva_eproductiva` FOREIGN KEY (`codigoeproductiva`) REFERENCES `eproductiva` (`codigoeproductiva`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.novedadproductiva: ~0 rows (aproximadamente)
DELETE FROM `novedadproductiva`;
/*!40000 ALTER TABLE `novedadproductiva` DISABLE KEYS */;
/*!40000 ALTER TABLE `novedadproductiva` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.particular
CREATE TABLE IF NOT EXISTS `particular` (
  `documentocliente` bigint(20) NOT NULL,
  PRIMARY KEY (`documentocliente`),
  CONSTRAINT `FK_clienteexterno_personal` FOREIGN KEY (`documentocliente`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.particular: ~0 rows (aproximadamente)
DELETE FROM `particular`;
/*!40000 ALTER TABLE `particular` DISABLE KEYS */;
INSERT INTO `particular` (`documentocliente`) VALUES
	(1116235892);
/*!40000 ALTER TABLE `particular` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.permiso
CREATE TABLE IF NOT EXISTS `permiso` (
  `codigopermiso` int(11) NOT NULL AUTO_INCREMENT,
  `fechapermiso` date DEFAULT NULL,
  `horadesdepermiso` time DEFAULT NULL,
  `horahastapermiso` time DEFAULT NULL,
  `motivopermiso` varchar(100) DEFAULT NULL,
  `estadopermiso` varchar(50) DEFAULT NULL,
  `documentocoordinador` bigint(20) DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  `documentoaprendiz` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigopermiso`),
  KEY `FK_permiso_coordinador` (`documentocoordinador`),
  KEY `FK_permiso_instructor` (`documentoinstructor`),
  KEY `FK_permiso_aprendiz` (`documentoaprendiz`),
  CONSTRAINT `FK_permiso_aprendiz` FOREIGN KEY (`documentoaprendiz`) REFERENCES `aprendiz` (`documentoaprendiz`),
  CONSTRAINT `FK_permiso_coordinador` FOREIGN KEY (`documentocoordinador`) REFERENCES `coordinador` (`documentocoordinador`),
  CONSTRAINT `FK_permiso_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.permiso: ~3 rows (aproximadamente)
DELETE FROM `permiso`;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
INSERT INTO `permiso` (`codigopermiso`, `fechapermiso`, `horadesdepermiso`, `horahastapermiso`, `motivopermiso`, `estadopermiso`, `documentocoordinador`, `documentoinstructor`, `documentoaprendiz`) VALUES
	(1, '2017-08-02', '09:19:03', '13:19:05', 'DFAFSF', 'APROBADO', 14889925, 6137989, 52183274),
	(5, '2017-08-16', '05:00:00', '15:00:00', 'me quiero ir', 'PENDIENTE', 14889925, NULL, 1116235891),
	(6, '2017-08-16', '02:00:00', '06:00:00', 'cita medica', 'PENDIENTE', 14889925, NULL, 1116235891);
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.personal
CREATE TABLE IF NOT EXISTS `personal` (
  `documentopersonal` bigint(20) NOT NULL,
  `nombrepersonal` varchar(100) NOT NULL,
  `apellidopersonal` varchar(100) NOT NULL,
  `direccionpersonal` varchar(100) DEFAULT NULL,
  `correopersonal` varchar(100) DEFAULT NULL,
  `telefonopersonal` varchar(100) DEFAULT NULL,
  `clavepersonal` varchar(255) DEFAULT NULL,
  `fechanacimientopersonal` date DEFAULT NULL,
  `lugarnacimientopersonal` varchar(50) DEFAULT NULL,
  `fotopersonal` varchar(100) DEFAULT NULL,
  `correoinstitucionalpersonal` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`documentopersonal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.personal: ~268 rows (aproximadamente)
DELETE FROM `personal`;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` (`documentopersonal`, `nombrepersonal`, `apellidopersonal`, `direccionpersonal`, `correopersonal`, `telefonopersonal`, `clavepersonal`, `fechanacimientopersonal`, `lugarnacimientopersonal`, `fotopersonal`, `correoinstitucionalpersonal`) VALUES
	(1000, 'Freddy', 'Mercury', NULL, 'freddy@mail.com', '315', '1000', NULL, NULL, NULL, NULL),
	(2000, 'Axl', 'Rose', NULL, 'axl@mail.com', '316', '2000', NULL, NULL, NULL, NULL),
	(3000, 'Saul', 'Hudson', NULL, 'saul@mail.com', '320', '3000', NULL, NULL, NULL, NULL),
	(4000, 'Bob', 'Dylan', NULL, 'bob@mail.com', '311', '4000', NULL, NULL, NULL, NULL),
	(5000, 'Till', 'Lindemann', NULL, 'till@mail.com', '300', '5000', NULL, NULL, NULL, NULL),
	(425154, 'OMAR', 'MOTTA', NULL, 'OMAR@MAIL.COM', '', '5d8b9bc328fe94482ad05cef3af30bde', NULL, NULL, NULL, 'OMOTTA@SENA.EDU.CO'),
	(3482453, 'DUBERLEY ', 'OSORIO PATIÑO', NULL, ' DLEYOSORIO@GMAIL.COM ', '3177685226', '45d483334777175e8bdc576563ef4322', NULL, NULL, NULL, NULL),
	(4408060, 'JORGE IVAN JIMENEZ SERNA', '', 'CARRERA 27BIS # 40-20', ' ivanjorgejimenezs@yahoo.es ', '3205204746', 'f70a0bd830c1e8fa329976607cd4aae9', NULL, 'Tulua', '', ' jojimenezs@sena.edu.co '),
	(6137989, 'IVAN HUGO ', 'VELEZ MESSA', 'Carrera 7 No. 7-25', ' IHVELEZM@GMAIL.COM ', '3148328602', 'd8f47aa722a348a1dd4a090a6b2e0eed', NULL, 'BOLIVAR', '', ' ihvelez@sena.edu.co '),
	(6198189, 'EDINSON RAMIREZ OROZCO', '', 'Calle 32 18a 10', ' mercacelsus@gmail.com ', '3117472039', '3374e38f2cb112206072e64ef1d190b6', NULL, 'Tulua', '', ' erorozco@sena.edu.co '),
	(6200685, 'ANDRES MAURICIO ARANA ESQUIVEL', '', 'Calle 31 No.42-20', ' mauroara44@hotmail.com ', '3178868381', 'aaaa242d7806e4d080bd195687673102', NULL, 'Tulua', '', ' aaranae@sena.edu.co '),
	(6356646, 'EDUAR FIERRO PEÑA', '', 'Calle 11 No.13-59', 'fierropena@hotmail.com', '3154765161', '30b4568525ebb90d7e732dabe4625c62', NULL, 'UNION', '', 'efierrop@sena.edu.co'),
	(6498352, 'HOMERO ALFONSO DUQUE ZULUAGA', '', 'Diagonal 26 c3 t oeste 18', 'hoalduzu@misena.edu.co', '3173830677', 'c6ccd1d94a15f5c90eeb91bc0d56555c', NULL, 'TULUA', '', 'hduque@sena.edu.co'),
	(6498528, 'ALEXANDER BUITRAGO MEDINA ', '', 'Carrera 37 # 28a44', 'alexbuitrag@gmail.com', '3104341405', '36075c61bbf9c5cb203da2a4d2522ccd', NULL, 'Tulua', '', 'abuitragom@sena.edu.co'),
	(6498998, 'JHON ABAD FLOREZ SEPULVEDA', '', 'Carrera 39 No. 28-43', ' abadedf@hotmail.com ', '3233623012', 'd4e4fdb03f2bf735dc6c32481f9be97c', NULL, 'Tulua', '', ' jflorezs@sena.edu.co '),
	(6499389, 'JORGE OLMEDO GUEVARA BELALCAZAR', '', 'CALLE 17 30-57 ', ' Jogb0610@hotmail.com ', '3162295698', '2d1c710738a4be572b1822f7d79c7577', NULL, 'Tulua', '', ' jguevarab@sena.edu.co '),
	(6499423, 'HUGO NELSON CORDOBA VELASQUEZ', '', 'Calle 41A 26-134', ' hugocordoba@hotmail.com ', '3185922864', '914efcc439fd2918ead27622ec9eab4e', NULL, 'Tulua', '', ' hcordobav@sena.edu.co '),
	(6500262, 'DIEGO FERNANDO TIRADO HERNANDEZ', '', 'Calle 14 No.20-30', ' tiradoo585@hotmail.com ', '3164645249', 'cdfbdd78f50ef0e20809b983f678733d', NULL, 'Tulua', '', ' dtirado@sena.edu.co '),
	(6501796, 'RAMON ANTONIO ARANGO AGUDELO', '', 'Carrera 5 No. 7-80', ' ramon1664@hotmail.com ', '3174451621', '6501796', NULL, 'La Marina', '', ' rarangoa@sena.edu.co '),
	(9152761, 'DAVID CARABALLO PEREZ', '', 'Carrera 34 No.25-22', ' dacape0304@hotmail.es ', '3103860790', '9785d16872d5020b1c2b762935eee9f0', NULL, 'Tulua', '', ' dcaraballop@sena.edu.co '),
	(10292173, 'EDWIN MAURICIO VELASCO GUERRERO', '', 'Calle 4 d 36-33', 'edwinvelasco@misena.edu.co', '3128271163', '7bd4776963f54ea152301b6170269bf0', NULL, 'Popayan', '', 'emvelasco@sena.edu.co'),
	(12187322, 'JOSE ALIRIO MUÑOZ CARDOSO', '', 'Calle 3 No. 7-04', ' jamc_1957@hotmail.com ', '3017350077', 'd5450166e57028ad846be82af36045a7', NULL, 'Ginebra', '', ' jamunozca@sena.edu.co '),
	(14704807, 'JOHN HANER VARGAS ACEVEDO', '', 'Calle 71 26-104', ' hanersin@hotmail.com ', '3166095541', '20dc01f68bcd11fbe175e9658d429b1e', NULL, 'Palmira', '', ' johvargasa@sena.edu.co '),
	(14795060, 'HECTOR MARIO MONTAÑO GRAJALES', '', 'Carrera 5a 21-46', ' mariomongra12@gmail.com ', '3185201949', 'f6d29a0d001eae4eba0ed01305265dcb', NULL, 'Tulua', '', ' hmontanog@sena.edu.co '),
	(14795372, 'DANNY ALBERTO MUÑOZ TRUJILLO', '', 'Tres esquinas vereda la caballera', 'dannyalbertomuoz@hotmail.com', '3137421652', '7ec83669d5fa1a464a437d98a5456f98', NULL, 'TULUA', '', 'dmunozt@sena.edu.co'),
	(14796175, 'LUIS FERNANDO LOPEZ ', '', 'Carrera 35 29-20 ', 'l_f_l82@hotmail.com', '3107286677', '977724654f8b7096af088e10cd47b338', NULL, 'Tulua', '', 'luflopez@sena.edu.co'),
	(14796542, 'OSCAR VICENTE OTALVORA CIFUENTES', '', 'Calle 43 33-07', ' otalvora60@gmail.com ', '3178588127', '8d00bc6f3a73bc661a2fbffd9824bc94', NULL, 'Tulua', '', ' ootalvorac@sena.edu.co '),
	(14799364, 'GERMAN ALONSO CASTILLO ORJUELA', '', 'Carrera 31 No.25-37', 'germancastillo1984@hotmail.com', '3175765396', 'ee8cefa42b92285a34f7063dd01bf279', NULL, 'Tulua', '', 'gcastilloo@sena.edu.co'),
	(14801705, 'JULIAN ADOLFO ALCALDE LOZANO', '', 'Carrera 21 No.22-73', ' alcalde110@gmail.com ', '3104020842', 'b7fd08797891495f2c9857dd57ef980f', NULL, 'Tulua', '', ' jalcalde@sena.edu.co '),
	(14802285, 'ANDRÉS FELIPE', 'ESCOBAR', NULL, 'ANFELES@MISENA.EDU.CO', '311', '6306bc219380d72098bdb2bb3ffe3f73', NULL, NULL, NULL, 'AFESCOBARV@SENA.EDU.CO'),
	(14878719, 'JAMES DOMINGUEZ ARAGON', '', 'Carrera 30 No.14a-71', ' jamesdominguezaragon@hotmail.com ', '3166803426', '6059932a20c75e0d2c3a1ad4c093a33e', NULL, 'Buga', '', ' jdomingueza@sena.edu.co '),
	(14882452, 'ADRIANO SARRIA SALGUERO', '', 'Carrera 3 No.2-18', ' adrianosarria@hotmail.com ', '3206521702', '4848e3a1ecab27015752041b9e7b98d2', NULL, 'Yotoco', '', ' asarrias@sena.edu.co '),
	(14885750, 'FERNANDO FIGUEROA PAYAN', '', 'Calle 14 sur 10-15', 'ffp002@gmail.com', '3217181456', 'ad2bf39fccefa0264699db9e90fca675', NULL, 'Buga', '', 'ffigueroa@sena.edu.co'),
	(14888888, 'MARIA CRISTINA', 'LEMUS PEREZ', NULL, 'MCLEMUS@SENA.EDU.CO', '312333333', '202cb962ac59075b964b07152d234b70', NULL, NULL, NULL, NULL),
	(14889459, 'FREDY HENAO LOPEZ', '', 'Calle 5 No. 2-22', ' fred-hl@hotmail.com ', '3156615004', '81b7f9c01488360e19825daa5b589e22', NULL, 'Buga', '', ' fhenaol@sena.edu.co '),
	(14889925, 'DARIO GERMAN', 'MARTINEZ MONTOYA', NULL, 'DGMARTINEZ@SENA.EDU.CO', '312555555', '9c79bc03a76fc56bccacb2b31ac49366', NULL, NULL, NULL, NULL),
	(14890585, 'NELSON ALBERTO TORRES ARCE', '', 'CALLE 2 SUR 4-25', 'natorrez@misena.edu.co', '3153755286', '98958454fe618c2036e47bf912e315c0', NULL, 'Buga', '', 'ntorresa@sena.edu.co'),
	(14890737, 'GERMÁN', 'SUÁREZ GARCÍA', '', 'GERMAN.SUAREZ@SENA.EDU.CO', '314567800', 'b172699eb39ff6681403a4ebaea69921', NULL, '', '', NULL),
	(14891011, 'FERNANDO LEON LOPEZ TORO', '', 'Carrera 9 9sur35', 'ferloto3@gmail.com', '3186849392', 'c8c3657f5e8ba12101f5ae55a7772b96', NULL, 'Buga', '', 'flopezt@sena.edu.co'),
	(14891226, 'RAFAEL ENRIQUE ARIAS FIGUEROA', '', 'Carrera 36a No.31-47', ' ariasgro2@hotmail.com ', '3136138039', '3fef4a1eebe3dc42a7a417884953573a', NULL, 'Tulua', '', ' reariasf@sena.edu.co '),
	(14891933, 'GERMAN ANTONIO DUQUE BEDOYA', '', 'Carrera 25b #44-55', 'germandb5@gmail.com', '3212821372', 'e83b48277e4e03c90136f48071ff0b43', NULL, 'Buga', '', 'gaduque@sena.edu.co'),
	(14892405, 'FABIAN ALEXANDER ANGEL ANGEL', '', 'Carrera 1c1 No.68-33', ' angelfa41@gmail.com ', '3113343719', 'f2cca8373c3961ce1a5703292807fd54', NULL, 'Cali', '', ' fangel@sena.edu.co '),
	(14892979, 'HOOVER ZULETA RENDON', '', 'Carrera 26 no. 18-95', ' hoover.zuleta@gmail.com ', '3153461791', 'b91babf0c4b0d523f36e00a311e8ec90', NULL, 'Buga', '', ' hzuletar@sena.edu.co '),
	(14893993, 'CARLOS ARTURO ALVARADO RENGIFO', '', 'Calle 7asur No.16-68', ' calirengifo@hotmail.com ', '3175524334', 'b1c7a3065a85854c1c03c122226ce9b7', NULL, 'Buga', '', ' calvarador@sena.edu.co '),
	(14894090, 'ANNWAR SUDKY ABDALLAH MILLAN', '', 'Calle 3 sur # 4-28', 'valletronics@gmail.com', '3166777776', '1ab876fb8788bfc9ece40fcb6fbf1ba6', NULL, 'Buga', '', 'aabdallah@sena.edu.co'),
	(14895079, 'JOSE FERNANDO AYALA MOLINA', '', 'Carrera 7 No.5sur -35', ' sempiterno3@yahoo.es ', '3165604930', 'f7abeadbedcfd70f2e5a338ffd2cbbd8', NULL, 'Buga', '', ' jayalam@sena.edu.co '),
	(14895433, 'JUAN CARLOS BETANCOURTH BOLIVAR', '', 'CARRERA 8 # 7-13', 'juancbb@misena.edu.co', '3006583125', 'a8d789ea6131f572ef6ca5c78a8f8263', NULL, 'Buga', '', 'jbetancourth@sena.edu.co'),
	(14896559, 'JHON ALEXANDER ZULUAGA ARCE', '', 'Carrera 3 8sur20', ' jazuluaga955@misena.edu.co ', '3008358077', '6fab2f1bc0cc74eb335b7938edd159a6', NULL, 'BUGA', '', ' azuluagaa@sena.edu.co '),
	(14897229, 'ALBETH MARTINEZ VALENCIA', '', 'Calle 12 10-29', ' a@misena.edu.co ', '3186163033', '7441aa39e930a23e8415c1b3685b612f', NULL, 'Buga', '', ' amartinezva@sena.edu.co '),
	(14898070, 'HERY FABIAN VIAFARA MILLAN', '', 'carrera 4 6-20', ' heryfabian@hotmail.com ', '3157030863', '53f207dba79e908ea57281932f6e8893', NULL, 'Buga', '', ' hviafara@sena.edu.co '),
	(15918435, 'JUAN CARLOS VARGAS AGUIRRE', '', 'Calle 31 43-32', ' juan-pa06@hotmail.com ', '3188310480', '1c74f99bf7d8fcb6cc7e7cf4df9f6574', NULL, 'Tulua', '', ' juvargasa@sena.edu.co '),
	(16222766, 'JHONNY ALEXANDER NUÑEZ FLOREZ', '', 'Carrera 11 No.14-70', 'jhonny-42florez@hotmail.com', '3107295879', '78ecef07eafe2ccfb2fd813b065e3bb7', NULL, 'Cartago', '', 'janunez@sena.edu.co'),
	(16234415, 'ALEXANDER ALDANA MEJIA', '', 'Carrera 1Norte No.25-81', ' aaldana5@misena.edu.co ', '3206069393', 'f9e996ccae453cf922d9341f1da306a6', NULL, 'Cartago', '', ' aaldanam@sena.edu.co '),
	(16260064, 'JORGE LUIS MONDRAGON SAA', '', 'Km 6 Via al Paraiso Corregimiento Santa Elena', 'jorgeluismondragonsaa@hotmail.com', '3208096588', 'c08e19e87e654b711b03bcdca6576a89', NULL, 'Cerrito', '', 'jmondragon@sena.edu.co'),
	(16280474, 'JORGE ELIECER RIVADENEIRA GONZALEZ', '', 'Calle 65 No. 31c-17', ' jrivadeneirag@misena.edu.co ', '3218458040', '0de5b6504a7a9512a4d1538a8431e759', NULL, 'Palmira', '', ' jrivadeneirag@sena.edu.co '),
	(16348821, 'HUMBERTO MEJIA VALLEJO', '', 'Calle 22 No. 19-29', ' bambuqueando@hotmail.com ', '3217735019', '1e82c9876299b2b587efb4ca2dd29144', NULL, 'Tulua', '', ' hmejiav@sena.edu.co '),
	(16358684, 'CARLOS ARTURO BEJARANO MENDOZA', '', 'Carrera 22No. 39-36', ' carlinbeja@hotmail.com ', '3113070323', '26204b25a7ff614f2a5d5a5e6cc98f41', NULL, 'Tulua', '', ' cbejaranom@sena.edu.co '),
	(16366537, 'HUGO FERNANDO ZULUAGA OSPINA', '', 'Bosques de maracaibo manza 3 casa 12', ' hugo-zuluaga@hotmail.com ', '3104642230', 'a0afeaa959d2c50aca9f04d4d21d1c10', NULL, 'Tulua', '', ' hzuluagao@sena.edu.co '),
	(16367151, 'MAURICIO POLANCO HUERTAS', '', 'Carrera 30 36-95', 'maopolan69@hotmail.com', '3178488764', 'c2e56f5be8e933393d70691b456ca39b', NULL, 'Tulua', '', 'mpolanco@sena.edu.co'),
	(16367533, 'JHON JAIRO CORTES QUINTERO', '', 'Calle 37c # 44-149', 'jjcortes335@misena.edu.co', '3183900171', '826269b020fe25dbe8dbdf83e95b6595', NULL, 'Tulua', '', 'jjcortes@sena.edu.co'),
	(16368987, 'FERNANDO ALONSO ARIAS RAMIREZ', '', 'Carrera 26a 39-49', ' kalokery@hotmail.com ', '3177780725', 'd5006f441b204a43ed27ef42d8a50b24', NULL, 'Tulua', '', ' afernandoa@sena.edu.co '),
	(16552383, 'JUAN CAMILO LEMOS GIL', '', 'carrera 7 norte 6-78', ' jclemosg@gmail.com ', '3003050126', '82956be31039e27b5e387b3c2bfbfa59', NULL, 'Roldanillo', '', ' cgilj@sena.edu.co '),
	(16590486, 'RAMON ELIAS ALVIS MORALES', '', 'Carrera 11 12-59', ' ramonalvis@hotmail.com ', '3174282994', 'fe3a724e05c8a43aa86dd293d8c281f1', NULL, 'La Unión', '', ' remorales@sena.edu.co '),
	(16613100, 'JAIME ARCE BURBANO', '', 'CALLE 16 2-95', 'jarceburbano@misena.edu.co', '3113263300', 'aad5cdaad586196ae3a2e109bfff9c4e', NULL, 'Toro', '', 'jarceb@sena.edu.co'),
	(16796521, 'LUIS HERNANDO VARONA VILLEGAS', '', 'Calle 22 32-36', ' luishernandovarona@hotmail.com ', '3154970486', 'c94bc83a4a30e2235e310c2942742fef', NULL, 'Tulua', '', ' lvaronav@sena.edu.co '),
	(17658884, 'CARLOS AUGUSTO GAVIRIA ALBAÑIL', '', 'CARRERA 27 A 22-00', 'carlosgaviria2204@gmail.com', '3203433068', '04c04c51c5efaa053e52d97e2c79f280', NULL, 'Armenia', '', 'cgaviria@sena.edu.co'),
	(21811664, 'BEATRIZ ELENA VERA CADAVID', '', 'Calle 16a 25-29', 'beatriz_71@hotmail.com', '3187813644', 'ec96daf032c0273fb6d9a60aded73e54', NULL, 'TULUA', '', 'bverac@sena.edu.co'),
	(25286245, 'MARIA DEL MAR ILLERA CAJIAO', '', 'Calle 37 27a18', ' mariadelmarillera@hotmail.com ', '3173763441', '4e5f957f16e27ee3bc86b613736d23a3', NULL, 'Tulua', '', ' millera@sena.edu.co '),
	(26471980, 'ESMERALDA RODRIGUEZ ROJAS', '', 'Carrera 36 30-77', 'esmeraldarr@misena.edu.co', '3182581250', '71dcc45fc0b818cd6223838f2107c963', NULL, 'Tulua', '', 'erodriguezro@sena.edu.co'),
	(29142993, 'OLGA SOFIA GONZALEZ ARIAS', '', 'Cr 3a C 20a-08', 'sofygonzalez2911@gmail.com', '3186773636', '4ca1b2b979a67ec898044924849ab530', NULL, 'Andalucia', '', 'osgonzaleza@sena.edu.co'),
	(29185945, 'ADELA ISABEL ANDRADE COLONIA', '', 'Carrera 2 No.4-46', ' adelaisabela@hotmail.com ', '3163185574', '0d98d9287d9c5e5c7055183638c8167a', NULL, 'BOLIVAR', '', ' adandradec@sena.edu.co '),
	(29186692, 'VIVIANNA MORALES JIMENEZ', '', 'Carrera 25a No.44-25', ' vimoji28@hotmail.com ', '3103886762', '1a73c6759dd5d74064c524b1a2f5f8af', NULL, 'Tulua', '', ' vmoralesj@sena.edu.co '),
	(29186804, 'PAOLA ANDREA RESTREPO CASTAÑO', '', 'Carrera 24 a39-74', ' panreca16@hotmail.com ', '3174428424', 'a7d2ba9c95edc1b11879c782bc930990', NULL, 'Tulua', '', ' prestrepoc@sena.edu.co '),
	(29186941, 'MARIA ANDREA DE LA TORRE VIDARTE', '', 'Calle 28A 37A-04', ' matv_dela14@hotmail.com ', '3103999382', '895ca09bcc8f6a93168a5677a7761953', NULL, 'Tulua', '', ' mtorrev@sena.edu.co '),
	(29282067, 'ANA NEYDA GOMEZ DE ECHEVERRY', '', 'Calle10sur No. 3-92', ' leyda49@gmail.com ', '3176390023', '6d0ae81e5c984fc41c17350d5d5b8bf9', NULL, 'Buga', '', ' angomezd@sena.edu.co '),
	(29284823, 'JESSICA ANDREA AMAYA LASSO', '', 'Calle 7 b sur 15-48', 'jessica_amayalasso@yahoo.com', '3163337622', '1fe18f8fd023561cff8f0e697c70cb7d', NULL, 'Buga', '', 'jamayal@sena.edu.co'),
	(29287323, 'ANGELA MARIA GOMEZ PEÑA', '', 'Carrera 38 12c17', ' angelagomezp@gmail.com ', '3185230605', '31dc1a05b06837bf8722f1bae641e70b', NULL, 'Tulua', '', ' amgomezp@sena.edu.co '),
	(29307769, 'YAMILED GONZALEZ ROJAS', '', 'Calle 3 sur 7/43', 'yamiled.gonzalez2@hotmail.com', '3164591756', 'cd0a041ef2c587230cd57fc56be35c48 ', NULL, 'Bugalagrande', '', 'ygonzalezr@sena.edu.co'),
	(29309904, 'SANDRA YULIETH GARCIA GONZALEZ', '', 'Diagonal 18 No.25AI-08', ' sayugar@misena.edu.co ', '3165374064', '4a32106f2b6366a38f07faccbfc80a49', NULL, 'Tulua', '', ' sgarciag@sena.edu.co '),
	(29314302, 'VIVIANA ANDREA RESTREPO VICTORIA', '', 'Calle 9 3-56', ' virestrep09@yahoo.es ', '3176448923', '9f29e0cb766d74b6de7575455e80fd09', NULL, 'Bugalagrande', '', ' vrestrepov@sena.edu.co '),
	(29433366, 'ROSA LILIANA PEREZ', '', 'Calle 4 bis 3a 47', ' rosa.liliana.20@hotmail.com ', '3113549398', 'de00c2843d93fc72c9b80d2242dc810d', NULL, 'Chancos', '', ' rlperez@sena.edu.co '),
	(29533266, 'MARTHA LEONOR RAMIREZ PEÑA', '', 'Carrera 30No.24-06', 'marthaleonor_ramirez@hotmail.com', '3154899896', '03590bc270a553b73433e04b53a56dc7', NULL, 'Ginebra', '', 'maramirezp@sena.edu.co'),
	(29683035, 'ANGELA MARCELA HOYOS MURCIA', '', 'Calle 37 40-36', ' mhangel57@hotmail.com ', '3182235085', '46ccd009fdfcf678dac38a51acf3dccb', NULL, 'Palmira', '', ' amhoyosm@sena.edu.co '),
	(29757606, 'MARCELA CAROLINA ROJAS RAYO', '', 'Carrera 7 No. 7-25', ' mcrojasrayo@gmail.com ', '3105071226', '1673e016b66bf26b34e4520f36fa4e4c', NULL, 'BOLIVAR', '', ' mcrojasr@sena.edu.co '),
	(29785289, 'PAOLA ANDREA CALDERON ZAPATA', '', 'Calle 38 A 22-55', ' paolamao@hotmail.com ', '3193317960', 'b574e6188090e207dde8992959deafef', NULL, 'SAN PEDRO', '', ' pcalderonz@sena.edu.co '),
	(29817337, 'MARTHA CECILIA RAMIREZ TABARES', '', 'MANZANA C CASA 30', 'phandres1@hotmail.com', '3128190641', '17b4cc98e9ee2587c04d96cd2ed553ca', NULL, 'Tulua', '', 'mcramirezt@sena.edu.co'),
	(29873118, 'VICTORIA EUGENIA GOMEZ BRAVO', '', 'Calle 26a No. 38-34', ' vegomezb@yahoo.es ', '3218121184', 'a02d435477ea36b775055a7a57618dbf', NULL, 'Tulua', '', ' vgomezb@sena.edu.co '),
	(29873150, 'VIADID MARTINEZ ROMERO', '', 'Calle 28b 39-37', 'viadid@hotmail.com', '3163290451', 'c4d7f1da3d5bcbbdb079c59ac424eab9', NULL, 'Tulua', '', 'vmartinezr@sena.edu.co'),
	(29873285, 'SANDRA MARGOTH BARON GIRALDO', '', 'Carrera 34 a # 34-28', 'samaba21@gmail.com', '3122886236', 'a9170f45024ac6d725ec6534dbd30af4', NULL, 'Tulua', '', 'sbarong@sena.edu.co'),
	(29873381, 'YULI VANESA DAVILA MUÑOZ', '', 'Calle 40 No.27b-73', 'yuly.davila@gmail.com', '3183399207', 'c64660ac966fd2352433b7a9d9306cde', NULL, 'Tulua', '', 'ydavilam@sena.edu.co'),
	(29875145, 'ROSMERY CORTES ESCOBAR', '', 'Calle 10B No.28a-126', ' rosme1978@hotmail.es ', '3166235238', '411a25ebb0039c38bd5b2ed87a52e816', NULL, 'Tulua', '', ' rcortes@sena.edu.co '),
	(29875954, 'GLORIA YANETH LOPEZ RAMIREZ', '', 'Calle 38 34-14', ' mi.archivo.tulua@gmail.com ', '3153155931', 'd21cc53dca81c098f8c06fa341d10b2c', NULL, 'Tulua', '', ' glopezr@sena.edu.co '),
	(29876355, 'ANGELA MARIA JIMENEZ OÑATE', '', '', ' angelajimenezo@hotmail.com ', '3166187293', 'dc7f82af842012522237ee4285758047', NULL, 'Tulua', '', ' ajimenezo@sena.edu.co '),
	(29876448, 'MARGARITA MARIA CALDERON ACEVEDO', '', 'Carrera 21 38c12', 'marcal79@hotmail.com', '3186595424', '2106cf409ed39c14dfa3c9653bab6bc1', NULL, 'Tulua', '', 'mncalderon@sena.edu.co'),
	(29877544, 'ALEJANDRA MARIA PLAZAS SANTA', '', 'Calle 39 B 20-88', 'amplazassanta@gmail.com', '3164826746', '0588f49be8d0d8b82c034715b396f062', NULL, 'Tuluá', '', 'aplazass@sena.edu.co'),
	(29877545, 'LINA MARIA BERNAL OJEDA', '', 'Carrera 23 No. 35a-32', ' linabe33@hotmail.com ', '3176863664', 'c0fd2d63cd058dc47eb0021647fc4e51', NULL, 'Tulua', '', ' lbernalo@sena.edu.co '),
	(29993888, 'NANCY BETANCOURTH BADOS', '', 'Carrera 30 No. 42-65', 'na.n.59@hotmail.com', '3164284389', '6662c2683013496fddbfe62ccd7f7fe8', NULL, 'Tulua', '', 'nbetancourth@sena.edu.co'),
	(30311965, 'MARGARITA MARIA VILLA LONDOÑO', '', 'CALLE 6 8-14 B Monserrate', 'maggievilla@gmail.com', '3113744302', 'eefc314d7f36ba8a7e4708e6b5be03d8', NULL, 'ARGELIA', '', 'mmvillal@sena.edu.co'),
	(31166225, 'XIMENA GONZALEZ MEZA', '', '', 'menagon1a@hotmail.com', '3186905597', 'ea782de10bf6c60c14006ef4157183a1', NULL, '', '', 'xgonzalezm@sena.edu.co'),
	(31189608, 'GLORIA MERY RUSSI COY', '', 'Calle 32 No. 27a-51', 'grussicoy@misena.edu.co', '3175179845', '69de2437f2effe7aaa235a08057ed061', NULL, 'Tulua', '', 'grussi@sena.edu.co'),
	(31189932, 'MIRYAM FARFAN', '', 'Carrera 29 28a81', 'mirfa_7@hotmail.com', '3153069805', '8da45a1daeb69b849f989cbbad21d352', NULL, 'Tulua', '', 'mifarfan@sena.edu.co'),
	(31193147, 'MARIA ISABEL MUÑOZ MANTILLA', '', 'Carrera 27 No.21-49', ' mariaixabel@hotmail.com ', '3117700417', 'c43f1f930bbf91f289b800e325092ce3', NULL, 'Tulua', '', ' mimunozm@sena.edu.co '),
	(31194207, 'AMANDA GIRALDO TOBON', '', 'CALLE 34 37-15', ' agiraldotobon12@hotmail.com ', '3182587160', 'ad6d7e4d6ad636f96cb29f6434a489a6', NULL, 'Tulua', '', ' agiraldot@sena.edu.co '),
	(31196463, 'MARIA EUGENIA AGUADO MORALES', '', 'Carrera 36a 20-04', ' maeaguado@hotmail.com ', '3164911211', '157d8e61b3b6e26b0e78df7fd2abdb3c', NULL, 'Tulua', '', ' mamorales@sena.edu.co '),
	(31197370, 'ALICIA SARRIA DE AGUILERA', '', 'Cr 38 #39-59', ' aliciasarria@yahoo.com ', '3184212469', '8d5fbb2a304fa9dde0f7691a5ff60658', NULL, 'Tulua', '', ' asarria@sena.edu.co '),
	(31201818, 'CARMEN ALICIA REBOLLEDO VELEZ', '', 'CARRERA 35 39-06', 'carmenarv@hotmail.com', '3157968614', 'b9f5300c3da68933edc61b92e40b45b6', NULL, 'Tulua', '', 'crebolledov@sena.edu.co'),
	(31202516, 'MIRYAM PATRICIA GARCIA ZUÑIGA', '', 'Calle 26d #14-25', 'mipagar@hotmail.com', '3163476266', '93ac3a42f35b30849bdacd48c716c22d', NULL, 'Tulua', '', 'mgarciaz@sena.edu.co'),
	(31202853, 'BIBIANA ALVAREZ FONSECA', '', 'Carrera 27 34-48', 'balvarez3@misena.edu.co', '3165278631', '22fac9a6533239e250a164b353a6971c', NULL, 'Tulua', '', 'balvarezf@sena.edu.co'),
	(31416143, 'MARIELA VALENCIA AGUDELO', '', 'Carrera 3 No.18-29', ' valenciamariela2011@gmail.com ', '3113363853', '6850a10a34f2eb4e4398d1f652f750a7', NULL, 'Cartago', '', ' mvalenciaa@sena.edu.co '),
	(31437342, 'ILEANA DURAN MONSALVE', '', 'Manzana 10 14a 27', 'nanadm24@hotmail.com', '3206690414', 'a48c0ee85ba9297d8e5c3596d1b41ac4', NULL, 'Tulua', '', 'iduranm@sena.edu.co'),
	(31640461, 'DOLLY GONZALEZ BOLAÑOZ', '', 'Carrera 20 No.2sur -47', ' dollygonzo@hotmail.com ', '3175349905', 'ae4821daadc4701e79f072c2b7a12980', NULL, 'Buga', '', ' dgonzalezbo@sena.edu.co '),
	(31656799, 'ANGELA LONDOÑO CASTRO', '', 'Calle 31 # 17-40', 'angielondcast@hotmail.com', '3137258647', '683e895e16dc7fe2346eec3074b739fa', NULL, 'Buga', '', 'anlondonoc@sena.edu.co'),
	(31657309, 'SANDRA BIBIANA ACOSTA CIFUENTES', '', 'Carrera 11 No. 2-38', ' sandrita974@gmail.com ', '3168759574', '4524e3d4c7b2f3a4bd696a1e1e60d10e', NULL, 'Buga', '', ' sacostac@sena.edu.co '),
	(31755103, 'YANETH POSSO WILCHES', '', 'Carrera 26 26-39', 'japowil@hotmail.com', '3153442498', '0267a6ad881768535444fab674384c14', NULL, 'TULUA', '', 'yposso@sena.edu.co'),
	(31790970, 'MARTA CECILIA GUTIERREZ PATIÑO', '', 'Pasaje 18b 33-52', 'mcgutierrez07@misena.edu.co', '3166957030', '6b9d209857a98133c39128ba6fc9c701', NULL, 'Tulua', '', 'mcgutierrezpa@sena.edu.co'),
	(31791348, 'CLAUDIA XIMENA VILLEGAS RAMIREZ', '', 'Urbanizacion la villa manzana 8 38a 21', 'cxvillegas@misena.edu.co', '3155614159', '2bae6c48dfa7dd29768a1433ffbc7ea6', NULL, 'Tulua', '', 'cxvillegas@sena.edu.co'),
	(31791366, 'MARITZA ROMAN RODRIGUEZ', '', 'Carrera 34 No. 30-41', ' mromanip@gmail.com ', '3174859366', '91f33de035503ee93d88dfd5a419e4f7', NULL, 'Tulua', '', ' mroman@sena.edu.co '),
	(31791653, 'DIANA PATRICIA', 'CANO MARQUEZ', 'calle 31 No.43-43', ' DIDI_CANO@HOTMAIL.COM ', '3175786300', 'cd7a7ac4c771daaf91b6a82f436d65e7', NULL, 'Tulua', '', ' dcanom@sena.edu.co '),
	(31791919, 'LUZ ADRIANA RESTREPO LOPEZ ', '', 'Calle 6 5-21', 'luzarl03791@hotmail.com', '3128625335', '2a5cce30632e01ef570418baa8c41fb0', NULL, 'Tulua', '', 'lurestrepol@sena.edu.co'),
	(31792489, 'MONICA ANDREA GOMEZ BARONA', '', 'Carrera 34 16a29', ' gallefi@hotmail.com ', '3185569893', '28664619862f5ca094f376f4da1b7adc', NULL, 'Tulua', '', ' magomez@sena.edu.co '),
	(31793192, 'KATHERINE HEDMONT SANCHEZ', '', 'Carrera 34 28-11', 'katthe_hedmont@hotmail.com', '3163752017', 'cd77f847bf4a41ac829fa8fdbcedbc40', NULL, 'Tulua', '', 'khedmonts@sena.edu.co'),
	(31793858, 'DIANA LORENA', 'GONZALEZ VALENCIA', 'Carrera 45 38-46', ' DLGVALENCIA@GMAIL.COM ', '3152324621', '1ab934d5a53ddee97cb4ff23664d6627', NULL, 'Tulua', '', ' dgonzalezv@sena.edu.co '),
	(31793894, 'LUZ ELENA RODRIGUEZ CHAPARRO', '', 'Carrera 37 31a16', 'lucevale4@gmail.com', '3176874029', '9f0868abae9f773383d1724325f0ba5f', NULL, 'Tulua', '', 'lurodriguezc@sena.edu.co'),
	(31794602, 'BEATRIZ EUGENIA LOZANO GONZALEZ', '', 'La Colina casa 11', 'beatrizlozano811@gmail.com', '3183061053', '1d2d64f6a9490a0c4f5b34e9fd7438d2', NULL, 'Tulua', '', 'blozano@sena.edu.co'),
	(31794763, 'LEIDY JOHANNA GARCIA HINCAPIE', '', 'Calle 31 34a19', ' leidyjj16@hotmail.com ', '3166514066', '7f7f2647f621a70c39c87d36008b938e', NULL, 'Tulua', '', ' lgarciah@sena.edu.co '),
	(31794856, 'JULIANA ANDREA BETANCUR QUINTERO', '', 'Diagonal 15 #25AS-06', 'sbb27@hotmail.com', '3173680968', 'e7617ff4912b56319a10ae4deeeae8fe', NULL, 'Tuluá', '', 'jubetancur@sena.edu.co'),
	(31810074, 'MARIA CECILIA CHAVEZ GUTIERREZ', '', 'Carrera 38b 13d14', ' macechagu@hotmail.co ', '3177823241', 'd6b04a119df7b3c3aa7152867e6bec03', NULL, 'Tulua', '', ' mchavezg@sena.edu.co '),
	(31875359, 'ADALCINDA BLANDON QUIROGA', '', 'CALLE 61 NORTE FN 88', 'adalblaqui@gmail.com', '3156816280', '33ee1bcc45c41d8696a3cf98c8b8f1f8', NULL, 'CALI', '', 'ablandonq@sena.edu.co'),
	(31951934, 'MARIA DEL CARMEN CACERES CALDERON', '', 'Casa 29 portal del rio', ' carmenzacaceres@hotmail.com ', '3106021339', '534a5f9d8151a5b064a526a2f38f1a72', NULL, 'Buga', '', ' mcaceresc@sena.edu.co '),
	(31983737, 'MONICA HERNANDEZ ALVAREZ', '', 'Carrera 13 No.1a-41', ' moher681@yahoo.com ', '3108927402', 'bf88ce582b46b5e1ae8d8e2d8fba97be', NULL, 'Cali', '', ' mhalvarez@sena.edu.co '),
	(34322238, 'MARITZA ALEJANDRA NOGUERA JIMENEZ', '', 'Calle 29 No34-13', ' alejandradesarria@hotmail.com ', '3127709038', 'b8b7a4cf73fd33ece493d4a2e1b65d23', NULL, 'Tulua', '', ' mnogueraj@sena.edu.co '),
	(34564875, 'MARIA TERESA VALENCIA PINEDA', '', 'Diagonal 15 25AS-23', ' mariat0112@hotmail.com ', '3187704461', '10fec7f1e3a34eb325351ff8461365b3', NULL, 'Tulua', '', ' mvalenciap@sena.edu.co '),
	(38555834, 'MARTHA CECILIA DIAZ MORANTE', '', 'Calle 12 5-39', 'macdimo@gmail.com', '3137105809', '8c31620cb7e3388778c89f45b2cb6c01', NULL, 'Andalucia', '', ' macdiaz@sena.edu.co'),
	(38790099, 'ALEJANDRA CECILIA MEJIA AGUDELO', '', 'Calle 28C No. 37-40', ' alejamejia82@hotmail.com ', '3183762265', 'fb2ce5f46308d6e198531f740211f3d4', NULL, 'Tulua', '', ' acmejiaa@sena.edu.co '),
	(38790890, 'JANIS BIVIANA CHICA MUÑOZ', '', 'Carrera 2 20-48', ' janisbivianachica@hotmail.com ', '3158347621', '1a9d2cb85203c0bb7e5f8a3635dd7b4c', NULL, 'Tulua', '', ' jbchica@sena.edu.co '),
	(38792038, 'ISABEL CRISTINA SEPULVEDA HINCAPIE', '', 'Calle 25C No.8-102', ' isepulve09@hotmail.com ', '3166506148', 'dadccc945bf61b1039518e80020aaeda', NULL, 'Tulua', '', ' isepulvedah@sena.edu.co '),
	(38792369, 'LINA VIVIANA VILLEGAS OSORIO', '', 'Calle 21 22-70', ' lina.vi48@gmail.com ', '3007534043', '98be182df616ea83794db730063a58c7', NULL, 'Tulua', '', ' lvillegaso@sena.edu.co '),
	(38792768, 'MARIA DEL PILAR FRANKY GONZALEZ', '', 'CAlle 26 c 10-48', 'mariadelpilar0724@hotmail.com', '3186900535', 'cc16173f3ce58762978b08f3236cb192', NULL, 'Tulua', '', 'mfrankyg@sena.edu.co'),
	(38794509, 'LORENA ROCIO LOPEZ ARCINIEGAS', '', 'Calle 13B No.38c-14', ' loren_arc@yahoo.com ', '3183759600', '9b56c93558272eb61415bfa09d470b80', NULL, 'Tulua', '', ' lrlopeza@sena.edu.co '),
	(38795222, 'MONICA ELENA PORRAS ARCE', '', 'Calle 41A No.23-53', ' monicaporrasarce@hotmail.com ', '3168735867', 'ed4b8a9188fa3ae1d76a1d4a0b02d2e6', NULL, 'Tulua', '', ' mporras@sena.edu.co '),
	(38796631, 'NATALIA LONDOÑO SANCHEZ', '', 'Avenida 3 e norte 45-113', 'natalialonsa@gmail.com', '3165767360', 'a30816f334f1780df3d0b0e3aff4d0d6', NULL, 'Cali', '', 'nlondonos@sena.edu.co'),
	(38859741, 'FANNY MARIN GIRALDO', '', 'Calle 17 No 38 11', 'fannymg49@hotmail.com', '3175028640', '7f2ca40650879198f07ae052fb52f20f', NULL, 'Tulua', '', 'fmaring@sena.edu.co'),
	(38869122, 'BERTHA LUCIA ORTIZ LOZANO', '', 'Calle 17 8-35', ' beloz920@yahoo.com ', '3103980292', 'a2e0a5dedb2c617cdddaa107f80736b8', NULL, 'Buga', '', ' bortizl@sena.edu.co '),
	(38875264, 'LAURA LEON ZUÑIGA', '', 'Calle 5 # 2-22', 'lalezu2005@hotmail.com', '3173655344', '6f117de6392b17ce7479aa7c794b3c85', NULL, 'Buga', '', 'lleonz@sena.edu.co'),
	(38879499, 'MARIA ISMENIA RIOS OSSA', '', 'Calle 14 9a17', 'isbrasa.comercio@hotmail.com', '3174243665', 'bf319ef23a1f856f1862c2972082fb0e', NULL, 'Buga', '', 'mirioso@sena.edu.co'),
	(41944840, 'LIDA PATRICIA MURIEL ROJAS', '', 'Casa huertas 30', 'lidapatricia28@hotmail.com', '3108400618', 'd52d7fb0c615623e12a8ac3ca08c8c56', NULL, 'Tulua', '', 'lmurielr@sena.edu.co'),
	(41952684, 'MARIA TERESA SABOGAL RESTREPO', '', 'Carrera 38 28a16', 'mariat24@gmail.com', '3182447061', 'da7fa05ee6902a5e8030428184fd94bb', NULL, 'Tulua', '', 'msabogalr@sena.edu.co'),
	(42015472, 'PAULA MARIA MARIN VARGAS', '', 'Calle 44 a 23a15', ' paulam1226@hotmail.com ', '3164205780', '323e3f588106f29ab467a95ef04fb1a2', NULL, 'Tulua', '', ' pmarinv@sena.edu.co '),
	(42114788, 'SOR JANETH OSORNO ARRUBLA', '', 'Carrera 29 17-57', 'arteyseda@gmail.com', '3113376061', '3ea79f2fddcf18d845e92d66b8089388', NULL, 'Pereira', '', 'sjosorno@sena.edu.co'),
	(42875897, 'GLORIA MARIA VILLADA BEDOYA', '', 'Los chancos', ' gloriamvillada0808@hotmail.com ', '3113006473', 'cf3dacd3f4112cda1bf05ee40cf08670', NULL, 'San Pedro', '', ' gvilladab@sena.edu.co '),
	(43508604, 'ANA ISABEL SANCHEZ SALAZAR', '', 'Carrera 26 34-45', ' anitasena@misena.edu.co ', '3202085190', '1c90f7546947f3dab2d9483625c318a6', NULL, 'Tulua', '', ' asanchezs@sena.edu.co '),
	(52085354, 'LUZ ADRIANA RAMIREZ LUNA', '', 'Carrera 20a 33-18', 'luzatati@gmail.com', '3173731480', '48d4fec89fc311aaf173b57836e89e8b', NULL, 'Tulua', '', 'lramirezl@sena.edu.co'),
	(52183274, 'ADRIANA LUCIA FRANCO CASALLAS ', '', 'Manzana 8 casa 14', 'adrylufranca@gmail.com', '3107143891', '8e632dffc750d7d68df255425d841727', NULL, 'Bogota', '', 'alfrancoc@sena.edu.co'),
	(66660491, 'MARIA ISABEL VARELA QUINTERO', '', 'Calle 40a No.23-46', 'm.isabel.varela.q@gmail.com', '3173823326', '7c118d9448abd7edf585341cf470dd7b', NULL, 'Tuluá', '', 'mvarelaq@sena.edu.co'),
	(66712227, 'YANETH GOMEZ NOVOA', '', 'Calle 10a 28a44', ' yangotqm1@hotmail.com ', '3188940003', '54756eeb109a33d28468707f57847979', NULL, 'Tulua', '', ' ygomezn@sena.edu.co '),
	(66715586, 'MARTHA CECILIA ROMERO MACANA ', '', 'Calle 37c # 44-149', 'mcromero6@misena.edu.co', '3104100821', '3a3d05bc9a303acab01ed889753b2cd4', NULL, 'Tulua', '', 'marthacromerom@sena.edu.co'),
	(66716297, 'YUDI FALLA BOHORQUEZ', '', 'Carrera 37 # 16-51', 'yudifalla@hotmail.com', '3177697964', '3da04655bf9111e95eb6d4502e9231de', NULL, 'Tulua', '', 'yfbohorquez@sena.edu.co'),
	(66718544, 'LINA MARIA JARAMILLO CARMONA', '', 'Carrera 39 24-47', ' lina_jaramillo@yahoo.es ', '3128330935', '642aca43f97a167ed00a9586e090f980', NULL, 'Tulua', '', ' ljaramilloc@sena.edu.co '),
	(66720662, 'PAULA ANDREA SANCHEZ OLIVEROS', '', 'Calle 5a 20-68', ' jonathan-atelo@hotmail.com ', '3147744778', 'e6e50fbe7a26ccd464a740b0c8c97870', NULL, 'Tulua', '', ' psanchezo@sena.edu.co '),
	(66720691, 'SANDRA PATRICIA JIMENEZ HERNANDEZ', '', 'Calle 36 26-70', 'sandrapj2219@yahoo.es', '3174956970', '766197f9db5275e29b382ac7f639d5a5', NULL, 'Tulua', '', 'sjimenezh@sena.edu.co'),
	(66724715, 'LINA MARIA TABORDA CASTAÑO', '', 'Calle 39a 25-37', 'linatabordac@hotmail.com', '3155282945', 'bb272716c55b9a364e7f9c2f7f87f2f5', NULL, 'Tulua', '', 'ltaborda@sena.edu.co'),
	(66724717, 'ELEONORA ECHEVERRY ZAFRA', '', 'Carrera 35 25-52', 'eecheverryz@gmail.com', '3165411144', 'c3898ebf639cdefba9a57cb4a0bdc48e', NULL, 'Tulua', '', 'eecheverryz@sena.edu.co'),
	(66726036, 'CAROLINE PEREA CABAL', '', 'Carrera 28B No.17-69', ' carolineperea@hotmail.com ', '3184375497', '5b4ce740601a8e4f18ff0bdc405e363e', NULL, 'Tulua', '', ' cpereac@sena.edu.co '),
	(66726150, 'CLAUDIA LICED SALDARRIAGA GALLEGO', '', 'CARRERA 14 26-59', 'liced-0211@hotmail.com', '3165415394', '6a361cab4d62a93d1cf175051fb345e0', NULL, 'Tulua', '', 'csaldarriagag@sena.edu.co'),
	(66729836, 'FRANCY NED RAMIREZ GOMEZ', '', 'Calle 26 b 3-31', 'francyned25@hotmail.com', '3166178244', 'a8a0efeee84a24aca747771934a0089d', NULL, 'Tulua', '', 'fnramirez@sena.edu.co'),
	(66751978, 'SONIA YANETH VINASCO LOPEZ', '', 'Carrera 16 19-101', 'sjvinascolopez@yahoo.es', '3117448496', '82aace54fda1a2c4583e0425818251be', NULL, 'La Union', '', 'svinasco@sena.edu.co'),
	(66772489, 'HAIDEE TAMARA GONZALEZ LOZANO', '', 'Carrera 24 # 39-95', 'tagolo@misena.edu.co', '3173801718', 'eb0a23b81a89625b412407d149810730', NULL, 'Palmira', '', 'hgonzalezl@sena.edu.co'),
	(66775045, 'MARLY YINED ZAPATA TORO ', '', 'Calle 48 25-16', 'marlyined31@hotmail.com', '3217739837', '8225072cb77fb1ad41364b7700554b81', NULL, 'Palmira', '', 'mayizapata@sena.edu.co'),
	(66801799, 'CRISTINA LOZANO SARRIA', '', 'CARRERA 4 19-72', 'cristinalozanosarria@gmail.com', '3104678079', 'cf169a00973c081d1e0a820c610221da', NULL, 'Andalucia', '', 'clozanos@sena.edu.co'),
	(66804224, 'ALEJANDRA HENAO PUERTA ', '', 'CALLE 9 SUR 7-61', ' alejahenaop@misena.edu.co ', '3162798403', '21572a3b8d1fa4d47566b039f7088a81', NULL, 'BUGA', '', ' alhenaop@sena.edu.co '),
	(66850067, 'SANDRA PATRICIA SANCHEZ PATIÑO', '', 'Calle13B No.24a-04', ' sapito2372@hotmail.com ', '3013384577', 'e8a4af9eb0cfb81dd294af064f9ff1e2', NULL, 'Tulua', '', ' sasanchezp@sena.edu.co '),
	(66872755, 'KAROLINA VALENCIA ALCALÁ', '', 'Calle 17 # 34-58', 'karolinavalencia25@hotmail.com', '3188253247', 'b1230d0dced07e374501fd9e284ec089', NULL, 'Roldanillo', '', 'kvalenciaa@sena.edu.co'),
	(66902155, 'SANDRA FLORENTINA ORTIZ USECHE', '', 'Carrera 5 No.4-30', ' floramutante07@hotmail.com ', '3105317994', '9762c2c6a00ed327d865c9a047b93e1c', NULL, 'Bugalagrande', '', ' sortizu@sena.edu.co '),
	(66930544, 'MARICELA GALLARDO MINDINEROS', '', 'Carrera 9 1-97', ' magamind@hotmail.com ', '3103910228', '8edbd1285e2019bb78a965d3c42f4cba', NULL, 'Pradera', '', ' mgallardom@sena.edu.co '),
	(66931180, 'INGRID CATALINA VASQUEZ ARGUELLES', '', 'Carrera11 No.9-54', ' l.cali.pmaa@gmail.com ', '3135779430', '5867b8102cfbe462dbc3b1cade1d3fe1', NULL, 'Pradera', '', ' ivasqueza@sena.edu.co '),
	(66931412, 'SANDRA MILENA HURTADO PRADO', '', 'Calle 25 b 10-20', ' shurtados7@gmail.com ', '3148639364', '60815dc8b72e47bbd17d7a9b9b9639b1', NULL, 'Tulua', '', ' shurtado@sena.edu.co '),
	(66931504, 'CLARA INES VACA TORRES', '', 'Carrera 43a # 28a34', 'civaca@misena.edu.co', '3225052912', '271bec6228faddd573bc8a39091958fb', NULL, 'Pradera', '', 'cvacat@sena.edu.co'),
	(66983210, 'ROCIO MARYSOPHY VILLA NARANJO', '', 'Carrera 11d 33f26', 'rociomvillan@misena.edu.co', '3127580014', '3a5c0427bfa3c3004c5d6a0e0aa4b044', NULL, 'CALI', '', 'rvillan@sena.edu.co'),
	(67031593, 'OLGA LUCIA CARDONA PEREZ', '', 'Calle 44a No.5a-10', ' ocardonap@misena.edu.co ', '3156694358', '2c7d6c01535b1c13663227e51f396b7f', NULL, 'Cali', '', ' ocardonap@sena.edu.co '),
	(71905008, 'JESUS ENRIQUE PALACIO SANCHEZ', '', 'Carrera 92A No. 4-99', 'jesusps@misena.edu.co', '3105322059', 'db27434f0259acae0c573d16cab9532f', NULL, 'CALI', '', 'jepalacios@sena.edu.co'),
	(73109148, 'ROY MARTHELO THORRENS', '', 'Calle 12a 38-69', ' roymartelo64@yahoo.es ', '3163249251', 'a9a9d5fa43ff5cdc4148576941a962ee', NULL, 'Tulua', '', ' rthorrens@sena.edu.co '),
	(75082123, 'GERMAN EDUARDO RAMIREZ RAMIREZ', '', 'Calle 20 No.33a-42', ' germaneramirez@hotmail.com ', '3122896709', '160b3c56c62d9bfa1b55c74307812723', NULL, 'Tulua', '', ' geramirezr@sena.edu.co '),
	(75108450, 'JAIME ALBERTO BERMUDEZ LOAIZA', '', 'Calle 40B No.25-34', ' jaime.bermudez986@gmail.com ', '3117293645', '4c224b1941557525b27f41b60b0c1b6e', NULL, 'Tulua', '', ' jabermudezl@sena.edu.co '),
	(76306931, 'MARTIN ARIEL CASTAÑO GONZALEZ', '', 'Calle 31 43-86', ' pmdmac@misena.edu.co ', '3117462743', '3335ebf95c68e723fef4598a1f1541ff', NULL, 'Tulua', '', ' mcastanog@sena.edu.co '),
	(76324492, 'ARIS JOAO CADAVID GUTIERREZ', '', 'Calle 6 No.7-38', 'miespaciored@hotmail.com', '3206570056', '7ed8c0cdf14330427dafdd1e3813d348', NULL, 'Buga', '', 'acadavidg@sena.edu.co'),
	(91284330, 'MIGUEL ANTONIO VARGAS CATAMUSCAY', '', 'Carrera 14b No. 27a-25', ' miguelvargas68@hotmail.com ', '3187020670', '851a34502daf501fc0b6c876820b9184', NULL, 'Buga', '', ' mavargasc@sena.edu.co '),
	(91438736, 'JAVIER JESUS MALDONADO AYALA', '', 'Carrera 21 25-14', ' javymaldoayala@yahoo.com ', '3186551063', '6028c5bb6217fc6e3455a86ad906efc0', NULL, 'Tulua', '', ' jmaldonado@sena.edu.co '),
	(91479566, 'NELSON DARIO RAMIREZ CACERES', '', 'Calle 28c 37-55', ' nelsondrc12@hotmail.com ', '3158927102', 'e2b0d9490afcb0167141b55406f4328f', NULL, 'Tulua', '', ' nramirezc@sena.edu.co '),
	(94151777, 'EFRAIN ARBOLEDA SAAVEDRA', '', 'Calle 26d 13-61', ' psicoarboleda@gmail.com ', '3164055042', '3208e6d053ea2b11ac0a5d6cb8caac5f', NULL, 'Tulua', '', ' earboleda@sena.edu.co '),
	(94152060, 'ANDRES FERNANDO JIMENEZ RAMIREZ', '', 'Carrera 35 No.28-58', ' andresing25@gmail.com ', '3165320160', 'ab78f2df4f0f7f5da7c70b3578e3bbac', NULL, 'Tulua', '', ' anjimenezr@sena.edu.co '),
	(94153316, 'JUAN FELIPE CHAMORRO HURTADO', '', 'Carrera 36 20-18', ' jchamorro330@gamil.com ', '3045943804', '04c4cfbfbb09595c950085d6815c09de', NULL, 'Tulua', '', ' jchamorroh@sena.edu.co '),
	(94153675, 'GUSTAVO ADOLFO LOZANO PEDRAZA', '', 'Calle 18a 13-20', ' lozanopedrazag@hotmail.es ', '3135049776', 'a2f5ba19a089d94e4f8bdbe00e5be986', NULL, 'Tulua', '', ' glozanop@sena.edu.co '),
	(94154184, 'ANDRES MAURICIO BEDOYA ARBOLEDA', '', 'Carrera 27 No. 39-60', ' andres1mauricio1@gmail.com ', '3182658969', '175c76885c9aed46a37080846fc2327b', NULL, 'Tulua', '', ' abedoyaa@sena.edu.co '),
	(94154232, 'JORGE HERNAN CIFUENTES MALDONADO', '', 'Calle 35 No.24-43', ' j_cifuentes2081@hotmail.com ', '3167500357', 'd37d2b0d174c0608c8648fa103a28a4d', NULL, 'Tulua', '', ' jhcifuentesm@sena.edu.co '),
	(94225794, 'DIEGO LUIS PAREJA MARIN', '', 'Calle 41 25-61', ' dipama41@hotmail.com ', '3012034254', '934095a86e13a2237dc076c5a8b1e75b', NULL, 'Tulua', '', ' dparejam@sena.edu.co '),
	(94229067, 'DIEGO ALBERTO PINILLA HERNANDEZ', '', 'Calle 12a 38-62', ' dpinillah@hotmail.com ', '3173778330', 'e6fe5160ca092e5e0e7fb904a939fc36', NULL, 'Tulua', '', ' dpinilla@sena.edu.co '),
	(94230308, 'CARLOS ANDRES CRUZ JURADO', '', 'Carrera 16a No.11-120', 'carloscruz2001@hotmail.com', '3155392268', 'b751fd9d50720abe5e1ffd130dde3bfd', NULL, 'Zarzal', '', 'ccruzj@sena.edu.co'),
	(94265335, 'SAUL ENRIQUE PEREZ PEREZ', '', 'Carrera 53 No.13e-51', ' saulpepe@yahoo.com ', '3183900144', 'ad0933c63228cc014ebce8bb54766639', NULL, 'Cali', '', ' saperezp@sena.edu.co '),
	(94276055, 'DIEGO FERNANDO RENDON GUTIERREZ', '', 'Carrera 9 No. 26g-76', ' diferegu24@hotmail.com ', '3164441373', 'a5251cce1e9b9b5e38fd46e2cac3abfa', NULL, 'Tulua', '', ' drendong@sena.edu.co '),
	(94300135, 'GERARDO LEYTON MARTINEZ', '', 'Manzana a casa 14', ' gerardo-leyton@hotmail.com ', '3122378586', '49c0215016f75e189cb604aac732e4d9', NULL, 'Pradera', '', ' gleytonm@sena.edu.co '),
	(94300648, 'LEANDRO BEJARANO', '', 'CALLE 16 No.26-122', ' beloleo32@yahoo.es ', '3122372659', '2d639c31aee9fc9fdd179c2a2c2166ee', NULL, 'Palmira', '', ' lbejarano@sena.edu.co '),
	(94325496, 'CARLOS ANDRES TORRES SILVA', '', 'Calle 29 9-41', 'ctorressilva07@gmail.com', '3137437191', 'd875efff420331ac0023dd4622fd9cbe', NULL, 'Palmira', '', 'catorress@sena.edu.co'),
	(94356606, 'EDBERTHS SALDARRIAGA POSSO', '', 'Calle 30 43-40', ' edberthssp@gmail.com ', '3155300189', '1a3280f9f69c1b6063ffabde7da4305a', NULL, 'Tulua', '', ' esaldarriagap@sena.edu.co '),
	(94364756, 'JUAN ESTEBAN SERNA JARAMILLO', '', 'CARRERA 38 28A16', 'juesja71@hotmail.com', '3162996971', '72c154f43f805cae66ad69db194bb476', NULL, 'Tulua', '', 'jsernaj@sena.edu.co'),
	(94366043, 'CARLOS HERNAN GUEVARA SALCEDO', '', 'Carrera 36 No. 33-16', ' cahegue1821@hotmail.com ', '3183398223', '9678b8c3ef8d09182eaeb36f9815b4a6', NULL, 'Tulua', '', ' caguevaras@sena.edu.co '),
	(94368285, 'ALEJANDRO ANTONIO CASTELLANOS DIAZ', '', 'Carrera 38b 12-32', ' alejocd17@gmail.com ', '3174272199', '94368285', NULL, 'Tulua', '', ' acastellanosd@sena.edu.co '),
	(94369027, 'HAROLD ORLANDO GUEVARA GUEVARA', '', 'Calle 42 No. 26-95', ' harold.guevara@hotmail.com ', '3176452095', '94369027', NULL, 'Tulua', '', ' hguevarag@sena.edu.co '),
	(94387428, 'DIEGO MAURICIO QUINTANA ROBLEDO', '', 'Manzana 35 Casa 7', 'mao_robledo@hotmail.com', '3122946699', '94387428', NULL, 'Bolivar', '', 'dquintana@sena.edu.co'),
	(94388847, 'OLMER SANCHEZ DUARTE', '', ' Calle 38 27-68 ', 'asofamora@yahoo.com', '3155406542', '94388847', NULL, 'Tulua', '', 'olsanchez@sena.edu.co'),
	(94391225, 'ALFREDO VARGAS', '', 'Calle 39 24a07', ' alfredov913@hotmail.com ', '3154854410', '94391225', NULL, 'Tulua', '', ' alvargas@sena.edu.co '),
	(94392383, 'ANDRES FERNANDO GOMEZ FAJARDO', '', 'Calle 26E No.14-18', ' ingandres11@hotmail.com ', '3044841756', '94392383', NULL, 'Tulua', '', ' afgomezf@sena.edu.co '),
	(94394545, 'MAURICIO GOMEZ FAJARDO', '', 'Calle 26e No14-18', ' goma200@hotmail.com ', '3175052418', '94394545', NULL, 'Tulua', '', ' mgomezf@sena.edu.co '),
	(94395777, 'MILTON GEOVANNY ARBOLEDA SAAVEDRA', '', 'Carrera 33 No.36-59', ' milgear86@hotmail.com ', '3136546034', '94395777', NULL, '', '', ' marboleda@sena.edu.co '),
	(94395869, 'JHON ALEXANDER ARROYAVE MEJIA', '', 'Calle 31 33-40', 'johnarroyave@hotmail.com', '3187170098', '94395869', NULL, 'Tulua', '', 'jarroyavem@sena.edu.co'),
	(94471577, 'JULIO CESAR LLANO ISAZA', '', 'Calle 7 No.4-33', ' jucella17@hotmail.com ', '3043701891', '94471577', NULL, 'Buga', '', ' jcllano@sena.edu.co '),
	(94472629, 'JAIME LEONARDO OSPINA CALLE', '', 'Calle 2 Sur 5-26 Apto 401', 'jlospina@gmail.com', '3013375301', '94472629', NULL, 'Buga', '', 'jospinac@sena.edu.co'),
	(94472795, 'ANDRES', 'PRIETO', NULL, 'ANDRES@SENA.EDU.CO', '312566890', '94472795', NULL, NULL, NULL, NULL),
	(94475502, 'ALVARO HERNAN LIBREROS ZAPATA', '', 'Carrera 15 6-69', 'librerosalvaro@hotmail.com', '3166969002', '94475502', NULL, 'Buga', '', 'alibreros@sena.edu.co'),
	(94475905, 'JOSE HERNAN ARIZA ARBELAEZ', '', 'Calle 29a No.25-37', ' jhariza5@misena.edu.co ', '3188170421', '94475905', NULL, 'Tulua', '', ' jharizaa@sena.edu.co '),
	(94477091, 'MAURICIO ANDRES SOTO MARTINEZ', '', 'Calle 3b 1-39', ' mauro136@gmail.com ', '3186935748', '94477091', NULL, 'Yotoco', '', ' masotom@sena.edu.co '),
	(94480337, 'GUSTAVO ALBERTO LASSO', '', 'Carrera 7 a No 5 sur 6 4', 'guslasso83@gmail.com', '3186083319', '94480337', NULL, 'Buga', '', 'galasso@sena.edu.co'),
	(1006217360, 'MANUEL FERNANDO MARIN RIOS ', '', 'Calle 9 6-65', 'manuelfernandomarinrios@gmail.com', '3183217221', '1006217360', NULL, 'Palmira', '', ' mfmarin@sena.edu.co'),
	(1032939671, 'ANGIE VANESSA RIVERA CRUZ', '', 'Manzan 9 38b45', 'angievriverac@hotmail.com', '3004014220', '1032939671', NULL, 'Soledad ', '', 'avriverac@sena.edu.co'),
	(1094927401, 'JOHANNA ANDREA BUSTAMANTE CARDENAS', '', 'Carrera 34 # 31-28', 'jhoanita_092@hotmail.com', '3147728205', '1094927401', NULL, 'Armenia', '', 'jbustamantec@sena.edu.co'),
	(1110457030, 'ALIXON YULIETH REINA NIETO', '', 'Calle43 No. 23a-62', ' areinan@misena.edu.co ', '3175731984', '1110457030', NULL, 'Tulua', '', ' areinan@sena.edu.co '),
	(1112098072, 'LINA MARCELA MEJIA ARIAS', '', 'Calle 13B No. 38D-87', ' linamarcelamejiaarias@hotmail.com ', '3163731672', '1112098072', NULL, 'Tulua', '', ' limejiaa@sena.edu.co '),
	(1112099702, 'JORGE EDUARDO TRUJILLO PUERTA', '', 'Calle28 No.30-26', ' jorgetrujillozootec@gmail.com ', '3112806717', '1112099702', NULL, 'Tulua', '', ' jtrujillop@sena.edu.co '),
	(1112100266, 'HERNAN FELIPE MARMOLEJO LIZALDA', '', 'Carrera 32a 22-10', ' hfmarmolejo@gmail.com ', '3184766373', '1112100266', NULL, 'Tulua', '', ' hmarmolejol@sena.edu.co '),
	(1112100314, 'JUAN GABRIEL VELA HENAO', '', 'Calle 13 43-40', 'gabriel19901990@hotmail.com', '3166186191', '1112100314', NULL, 'Andalucia', '', 'jvelah@sena.edu.co'),
	(1112102132, 'MARIA CRISTINA LOPEZ ', '', 'Manzana 15 casa 32', 'crislopez19@misena.edu.co', '3167529913', '1112102132', NULL, 'Andalucia', '', 'malopezv@sena.edu.co'),
	(1112104556, 'IVONNE TATIANA GARCES ARBOLEDA', '', 'Carrera 4 # 15-71', 'itgarces@misena.edu.co', '3184479258', '1112104556', NULL, 'Andalucia', '', 'igarcesa@sena.edu.co'),
	(1112625065, 'NATALIA URREGO TAMAYO', '', 'Calle 41 No. 33-25', ' naty.urrego20@gmail.com ', '3147775070', '1112625065', NULL, 'Tulua', '', ' nurregot@sena.edu.co '),
	(1112773384, 'SANTIAGO GOMEZ DAMELINES', '', 'Carrera 14 n 16b-104', ' sgdamelines@gmail.com ', '3136953034', '1112773384', NULL, 'Cartago', '', ' sagomezd@sena.edu.co '),
	(1114118406, 'VICTOR HUGO MARMOLEJO VALENCIA', '', 'Carrera 3 No.2-58', 'vhmarmolejo@misena.edu.co', '3207752651', '1114118406', NULL, 'Bolivar', '', 'vmarmolejov@sena.edu.co'),
	(1115064457, 'JAVIER ANCIZAR MONTES ARIAS', '', 'Calle 19 19-01', ' jamontesa@misena.edu.co ', '3207662862', '1115064457', NULL, 'BUga', '', ' jmontesa@sena.edu.co '),
	(1115066373, 'OSCAR FELIPE BELLO MEJIA ', '', 'Carrera 11 2-38', 'scarf16_07@hotmail.com', '3173727147', '1115066373', NULL, 'Buga', '', 'obellom@sena.edu.co'),
	(1115068144, 'JHON ALEXANDER MARIN GONZALEZ', '', 'Carrera 4 13a84', 'jamarin441@misena.edu.co', '3168784635', '1115068144', NULL, 'Buga', '', 'jamaring@sena.edu.co'),
	(1115068462, 'WILFREDO MARTINEZ RODRIGUEZ', '', 'Carrera 1 # 8-93', 'wilmartinez0604@gmail.com', '3172494248', '1115068462', NULL, 'Buga', '', 'wimartinezr@sena.edu.co'),
	(1115070510, 'JUAN MANUEL ROMERO SOTO', '', 'Carrera 7 13 45', 'juanmanuelrs7@hotmail.com', '3122491352', '1115070510', NULL, 'Buga', '', 'jmromeros@sena.edu.co'),
	(1115071823, 'GLORIA MARIA BELLO MEJIA', '', 'Carrera 7 No.3sur-10', ' gloriabello11@hotmail.com ', '3183609258', '1115071823', NULL, 'Buga', '', ' gbellom@sena.edu.co '),
	(1115074422, 'CARLOS ANDRES CRUZ RAMIREZ', '', 'Carrera 9 No. 9sur -45', ' carlos.andrescruz@hotmail.com ', '3175138180', '1115074422', NULL, 'Buga', '', ' ccruzr@sena.edu.co '),
	(1115079655, 'DANIELA ANDREA BALCAZAR RAMIREZ', '', 'Cr 7 11-49', 'daniela-sarita@hotmail.com', '3153080533', '1115079655', NULL, 'Buga', '', 'bbalcazar@sena.edu.co'),
	(1115080400, 'KAREN LORENA MORA RAMIREZ', '', 'Carrera 5 # 12 asur 29', 'karenlmora@hotmail.com', '3005308509', '1115080400', NULL, 'Buga', '', 'kmora@sena.edu.co'),
	(1116235526, 'CLAUDIA FERNANDA MAZUERA', '', 'Calle 37 30-21', ' clauferm20@gmail.com ', '3176359507', '1116235526', NULL, 'Tulua', '', ' cmazuera@sena.edu,.co '),
	(1116235537, 'DIEGO FERNANDO MURILLO LOPEZ', '', 'Calle 46 24a 06', 'dfmurillo7@misena.edu.co', '3104225385', '1116235537', NULL, 'Tulua', '', 'dmurillol@sena.edu.co'),
	(1116235700, 'KAREN RIASCOS QUIÑONES', '', 'Calle 12b 24-03', ' kriascosqui@gmail.com ', '3128895169', '1116235700', NULL, 'Tulua', '', ' kriascos@sena.edu.co '),
	(1116235891, 'DIANA LORENA ', 'VELANDIA VANEGAS', 'CARRERA 41 35-51', 'DILOVE0122@GMAIL.COM ', '3164903091', '111', NULL, 'TULUA', '1116235891.png', ' dvelandia@sena.edu.co '),
	(1116235892, 'DIANA LORENA', 'VELANDIA VANEGAS', NULL, NULL, NULL, '123', NULL, NULL, NULL, NULL),
	(1116235893, 'ANGELA MARIA GARCIA GONZALEZ', '', 'Carrera 32 # 28-13', 'angela986@hotmail.com', '3162681631', '1116235893', NULL, 'Tulua', '', 'angarciag@sena.edu.co'),
	(1116238083, 'LIZETTE YULIANA GONZALEZ RESTREPO', '', 'Calle 33 # 35-43', 'lizettegonzalez87@gmail.com', '3155839696', '1116238083', NULL, 'Tulua', '', 'ligonzalezr@sena.edu.co'),
	(1116238204, 'JOHANNA ANDREA NARVAEZ GIRALDO', '', 'Calle 34 #33-46', 'jjohanna2006@hotmail.com', '3103626005', '1116238204', NULL, 'Tuluá', '', 'jnarvaezg@sena.edu.co'),
	(1116238490, 'JOHN JAIRO MARIN ARBOLEDA', '', 'CAlle 36 24-73', 'marinjj@misena.edu.co', '3106041389', '1116238490', NULL, 'Tulua', '', 'jhmarin@sena.edu.co'),
	(1116238701, 'KATHERINE PEREZ VELEZ', '', 'CALLE 29 N 34 22', 'katherineperez_817@hotmail.com', '3186978727', '1116238701', NULL, 'Tuluá', '', 'kperezv@sena.edu.co'),
	(1116239995, 'INGRY LORENA VASQUEZ GIRALDO', '', 'Calle 30a 42-19', 'ingrysud@gmail.com', '3185727459', '1116239995', NULL, 'Tulua', '', 'ivasquezg@sena.edu.co'),
	(1116240054, 'ANDRES MAURICIO RENDON OCAMPO', '', 'Carrera 9b # 8-36', 'amauro_rendon@hotmail.com', '3156456669', '1116240054', NULL, 'Tulua', '', 'arendono@sena.edu.co'),
	(1116240221, 'JULIAN ORTIZ NOREÑA', '', 'Manzana 12 casa45', 'juliandavidortiz25@hotmail.com', '3155084427', '1116240221', NULL, 'Tulua', '', 'jortizn@sena.edu.co'),
	(1116242450, 'JUAN DIEGO SALAMANDO AGUIRRE', '', 'Carrera 33 No.40-18', ' juandiego003@hotmail.com ', '3182682078', '1116242450', NULL, 'Tulua', '', ' jsalamando@sena.edu.co '),
	(1116243314, 'JUAN DAVID LOZANO GALVEZ', '', 'Carrera 36 31a15', ' juandavid_ampm@hotmail.com ', '3166228179', '1116243314', NULL, 'Tulua', '', ' jdlozanog@sena.edu.co '),
	(1116244664, 'ANGELICA HERNANDEZ ROMERO', '', 'Calle 36 23-34', ' angelica2389hernandez@hotmail.com ', '3043369866', '1116244664', NULL, 'Tulua', '', ' ahernandezro@sena.edu.co '),
	(1116245277, 'YULI MARCELA ALVAREZ DELGADO', '', 'Carrera 22 17-09', 'markela@misena.ed.co', '3004852898', '1116245277', NULL, 'Tulua', '', 'yulimalvarez@sena.edu.co'),
	(1116246600, 'SERGIO LOPEZ GONZALEZ', '', 'Calle 29 30-12', 'sergiolopez999@hotmail.com', '3168710454', '1116246600', NULL, 'Tulua', '', 'selopezg@sena.edu.co'),
	(1116250682, 'JENNIFER SANCHEZ GARCIA', '', 'Carrera24a 4a08', 'jsanchez286@misena.edu.co', '3217801162', '1116250682', NULL, 'Tulua', '', 'jesanchezg@sena.edu.co'),
	(1116252066, 'ALEJANDRA GONZALEZ VILLEGAS', '', 'Carrera 27b 42-26', 'aleja910913@gmail.com', '3154244365', '1116252066', NULL, 'Tulua', '', 'agvillegas@sena.edu.co'),
	(1116256886, 'CHRISTIAN ANDRES CUERO GAMBOA', '', 'Calle 30 43-10', ' cuero6@misena.edu.co ', '3188392364', '1116256886', NULL, 'Tulua', '', ' ccuerog@sena.edu.co '),
	(1116264206, 'YAMILETH PEREZ NOREÑA ', '', 'Carrera 22 # 4b22', 'yperez559@misena.edu.co', '3156512801', '1116264206', NULL, 'Tulua', '', 'yperezn@sena.edu.co'),
	(1116722533, 'ELIZABETH LOPEZ MONSALVE', '', 'Carrera 45 No. 30-03', ' elizalm26@hotmail.com ', '3013043884', '9dbad8d404388eeb1a78356668fc5bf6', NULL, 'Tulua', '', ' elopezmo@sena.edu.co '),
	(1130613755, 'LADY ALEJANDRA GALINDO CASTILLO', '', 'Calle 39 20-25', 'alejagalindo00@hotmail.com', '3187419456', '3531e051940480e128fdd09e40e5d659', NULL, 'Tulua', '', 'lgalindoc@sena.edu.co'),
	(1144058877, 'LINA MARCELA VALENCIA VILLAFAÑE', '', 'Calle 7 a sur 13b53', 'lina_valenciav@hotmail.com', '3148504849', 'f8bfcd9802a2d72afa51da91bc0838a9', NULL, 'Buga', '', 'lmvalencia@sena.edu.co');
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.perteneceficha
CREATE TABLE IF NOT EXISTS `perteneceficha` (
  `documentoaprendiz` bigint(20) NOT NULL,
  `numeroficha` int(11) NOT NULL,
  `estadoperteneceficha` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`documentoaprendiz`,`numeroficha`),
  KEY `FK_perteneceficha_fichatitulacion` (`numeroficha`),
  CONSTRAINT `FK_perteneceficha_aprendiz` FOREIGN KEY (`documentoaprendiz`) REFERENCES `aprendiz` (`documentoaprendiz`),
  CONSTRAINT `FK_perteneceficha_fichatitulacion` FOREIGN KEY (`numeroficha`) REFERENCES `fichatitulacion` (`numeroficha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.perteneceficha: ~0 rows (aproximadamente)
DELETE FROM `perteneceficha`;
/*!40000 ALTER TABLE `perteneceficha` DISABLE KEYS */;
INSERT INTO `perteneceficha` (`documentoaprendiz`, `numeroficha`, `estadoperteneceficha`) VALUES
	(1116235891, 1134299, 'EN FORMACION');
/*!40000 ALTER TABLE `perteneceficha` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.programa
CREATE TABLE IF NOT EXISTS `programa` (
  `codigoprograma` int(10) NOT NULL,
  `nombreprograma` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigoprograma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.programa: ~0 rows (aproximadamente)
DELETE FROM `programa`;
/*!40000 ALTER TABLE `programa` DISABLE KEYS */;
INSERT INTO `programa` (`codigoprograma`, `nombreprograma`) VALUES
	(228106, 'ADSI');
/*!40000 ALTER TABLE `programa` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.regional
CREATE TABLE IF NOT EXISTS `regional` (
  `codigoregional` int(11) NOT NULL AUTO_INCREMENT,
  `nombreregional` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoregional`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.regional: ~32 rows (aproximadamente)
DELETE FROM `regional`;
/*!40000 ALTER TABLE `regional` DISABLE KEYS */;
INSERT INTO `regional` (`codigoregional`, `nombreregional`) VALUES
	(1, 'Amazonas'),
	(2, 'Antioquia'),
	(3, 'Arauca'),
	(4, 'Atlántico'),
	(5, 'Bolívar'),
	(6, 'Boyacá'),
	(7, 'Caldas'),
	(8, 'Caquetá'),
	(9, 'Casanare'),
	(10, 'Cauca'),
	(11, 'Cesar'),
	(12, 'Chocó'),
	(13, 'Córdoba'),
	(14, 'Cundinamarca'),
	(15, 'Güainia'),
	(16, 'Guaviare'),
	(17, 'Huila'),
	(18, 'La Guajira'),
	(19, 'Magdalena'),
	(20, 'Meta'),
	(21, 'Nariño'),
	(22, 'Norte de Santander'),
	(23, 'Putumayo'),
	(24, 'Quindío'),
	(25, 'Risaralda'),
	(26, 'San Andrés y Providencia'),
	(27, 'Santander'),
	(28, 'Sucre'),
	(29, 'Tolima'),
	(30, 'Valle del Cauca'),
	(31, 'Vaupés'),
	(32, 'Vichada');
/*!40000 ALTER TABLE `regional` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.reservaambiente
CREATE TABLE IF NOT EXISTS `reservaambiente` (
  `codigoreservaambiente` int(11) NOT NULL AUTO_INCREMENT,
  `codigoambiente` int(11) DEFAULT NULL,
  `documentopersonal` bigint(20) DEFAULT NULL,
  `numeroficha` int(11) DEFAULT NULL,
  `fechainicioreservaambiente` date DEFAULT NULL,
  `fechafinreservaambiente` date DEFAULT NULL,
  `horainicioreservaambiente` time DEFAULT NULL,
  `horafinreservaambiente` time DEFAULT NULL,
  PRIMARY KEY (`codigoreservaambiente`),
  KEY `FK_reservaambiente_ambienteaprendizaje` (`codigoambiente`),
  KEY `FK_reservaambiente_personal` (`documentopersonal`),
  KEY `FK_reservaambiente_fichatitulacion` (`numeroficha`),
  CONSTRAINT `FK_reservaambiente_ambienteaprendizaje` FOREIGN KEY (`codigoambiente`) REFERENCES `ambienteaprendizaje` (`codigoambiente`),
  CONSTRAINT `FK_reservaambiente_fichatitulacion` FOREIGN KEY (`numeroficha`) REFERENCES `fichatitulacion` (`numeroficha`),
  CONSTRAINT `FK_reservaambiente_personal` FOREIGN KEY (`documentopersonal`) REFERENCES `personal` (`documentopersonal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.reservaambiente: ~0 rows (aproximadamente)
DELETE FROM `reservaambiente`;
/*!40000 ALTER TABLE `reservaambiente` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservaambiente` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.sede
CREATE TABLE IF NOT EXISTS `sede` (
  `numerosede` int(11) NOT NULL AUTO_INCREMENT,
  `nombresede` varchar(50) DEFAULT NULL,
  `direccionsede` varchar(50) DEFAULT NULL,
  `documentofuncionario` bigint(20) DEFAULT NULL,
  `estadosede` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numerosede`),
  KEY `FK_sede_funcionario` (`documentofuncionario`),
  CONSTRAINT `FK_sede_funcionario` FOREIGN KEY (`documentofuncionario`) REFERENCES `funcionario` (`documentofuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.sede: ~0 rows (aproximadamente)
DELETE FROM `sede`;
/*!40000 ALTER TABLE `sede` DISABLE KEYS */;
/*!40000 ALTER TABLE `sede` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.seguimiento
CREATE TABLE IF NOT EXISTS `seguimiento` (
  `codigoseguimiento` int(11) NOT NULL AUTO_INCREMENT,
  `numeroseguimiento` int(11) DEFAULT NULL,
  `fechaseguimiento` date DEFAULT NULL,
  `faseseguimiento` varchar(50) DEFAULT NULL,
  `observacionesseguimiento` text DEFAULT NULL,
  `conclusionesseguimiento` text DEFAULT NULL,
  `compromisosseguimiento` text DEFAULT NULL,
  `lugarseguimiento` varchar(50) DEFAULT NULL,
  `horainicioseguimiento` time DEFAULT NULL,
  `horafinseguimiento` time DEFAULT NULL,
  `estadoseguimiento` varchar(50) DEFAULT NULL,
  `numeroficha` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoseguimiento`),
  KEY `FK_seguimiento_fichatitulacion` (`numeroficha`),
  CONSTRAINT `FK_seguimiento_fichatitulacion` FOREIGN KEY (`numeroficha`) REFERENCES `fichatitulacion` (`numeroficha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.seguimiento: ~0 rows (aproximadamente)
DELETE FROM `seguimiento`;
/*!40000 ALTER TABLE `seguimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguimiento` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.seguimientoaprendiz
CREATE TABLE IF NOT EXISTS `seguimientoaprendiz` (
  `documentoaprendiz` bigint(20) NOT NULL,
  `numeroseguimiento` int(11) NOT NULL,
  `rendimientoseguimiento` text DEFAULT NULL,
  `numeronovedad` int(11) DEFAULT NULL,
  PRIMARY KEY (`documentoaprendiz`,`numeroseguimiento`),
  KEY `FK_seguimientoaprendiz_novedad` (`numeronovedad`),
  KEY `FK_seguimientoaprendiz_seguimiento` (`numeroseguimiento`),
  CONSTRAINT `FK_seguimientoaprendiz_aprendiz` FOREIGN KEY (`documentoaprendiz`) REFERENCES `aprendiz` (`documentoaprendiz`),
  CONSTRAINT `FK_seguimientoaprendiz_novedad` FOREIGN KEY (`numeronovedad`) REFERENCES `novedadlectiva` (`numeronovedad`),
  CONSTRAINT `FK_seguimientoaprendiz_seguimiento` FOREIGN KEY (`numeroseguimiento`) REFERENCES `seguimiento` (`codigoseguimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.seguimientoaprendiz: ~0 rows (aproximadamente)
DELETE FROM `seguimientoaprendiz`;
/*!40000 ALTER TABLE `seguimientoaprendiz` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguimientoaprendiz` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.tipoambiente
CREATE TABLE IF NOT EXISTS `tipoambiente` (
  `codigotipoambiente` int(11) NOT NULL AUTO_INCREMENT,
  `descripciontipoambiente` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigotipoambiente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.tipoambiente: ~0 rows (aproximadamente)
DELETE FROM `tipoambiente`;
/*!40000 ALTER TABLE `tipoambiente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoambiente` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.tipopractica
CREATE TABLE IF NOT EXISTS `tipopractica` (
  `codigotipopractica` int(11) NOT NULL AUTO_INCREMENT,
  `nombretipopractica` varchar(50) DEFAULT NULL,
  `descripciontipopractica` text DEFAULT NULL,
  PRIMARY KEY (`codigotipopractica`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.tipopractica: ~0 rows (aproximadamente)
DELETE FROM `tipopractica`;
/*!40000 ALTER TABLE `tipopractica` DISABLE KEYS */;
INSERT INTO `tipopractica` (`codigotipopractica`, `nombretipopractica`, `descripciontipopractica`) VALUES
	(1, 'CONTRATO LABORAL', 'kjhkhjhj');
/*!40000 ALTER TABLE `tipopractica` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.turno
CREATE TABLE IF NOT EXISTS `turno` (
  `codigoturno` int(11) NOT NULL AUTO_INCREMENT,
  `codigoarea` int(11) DEFAULT NULL,
  `documentocliente` bigint(20) DEFAULT NULL,
  `numeroturno` int(11) DEFAULT NULL,
  `fechaturno` date DEFAULT NULL,
  `horaingresoturno` time DEFAULT NULL,
  `horasalidaturno` time DEFAULT NULL,
  `motivoturno` text DEFAULT NULL,
  `estadoturno` varchar(50) DEFAULT NULL,
  `observacionesturno` text DEFAULT NULL,
  PRIMARY KEY (`codigoturno`),
  KEY `FK_turno_area` (`codigoarea`),
  KEY `FK_turno_particular` (`documentocliente`),
  CONSTRAINT `FK_turno_area` FOREIGN KEY (`codigoarea`) REFERENCES `area` (`codigoarea`),
  CONSTRAINT `FK_turno_particular` FOREIGN KEY (`documentocliente`) REFERENCES `particular` (`documentocliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.turno: ~0 rows (aproximadamente)
DELETE FROM `turno`;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.usodeambiente
CREATE TABLE IF NOT EXISTS `usodeambiente` (
  `codigousoambiente` int(11) NOT NULL AUTO_INCREMENT,
  `idguarda` bigint(20) DEFAULT NULL,
  `codigoambiente` int(11) DEFAULT NULL,
  `documentopersonal` bigint(20) DEFAULT NULL,
  `fichatitulacion` int(11) DEFAULT NULL,
  `fechausoambiente` date DEFAULT NULL,
  `horaentradausoambiente` time DEFAULT NULL,
  `horasalidausoambiente` time DEFAULT NULL,
  `entregausoambiente` char(50) DEFAULT NULL,
  `observacionesusoambiente` text DEFAULT NULL,
  `codigoreserva` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigousoambiente`),
  KEY `FK_usodeambiente_guarda` (`idguarda`),
  KEY `FK_usodeambiente_ambienteaprendizaje` (`codigoambiente`),
  KEY `FK_usodeambiente_personal` (`documentopersonal`),
  KEY `FK_usodeambiente_fichatitulacion` (`fichatitulacion`),
  KEY `FK_usodeambiente_reservaambiente` (`codigoreserva`),
  CONSTRAINT `FK_usodeambiente_ambienteaprendizaje` FOREIGN KEY (`codigoambiente`) REFERENCES `ambienteaprendizaje` (`codigoambiente`),
  CONSTRAINT `FK_usodeambiente_fichatitulacion` FOREIGN KEY (`fichatitulacion`) REFERENCES `fichatitulacion` (`numeroficha`),
  CONSTRAINT `FK_usodeambiente_guarda` FOREIGN KEY (`idguarda`) REFERENCES `guarda` (`documentoguarda`),
  CONSTRAINT `FK_usodeambiente_personal` FOREIGN KEY (`documentopersonal`) REFERENCES `personal` (`documentopersonal`),
  CONSTRAINT `FK_usodeambiente_reservaambiente` FOREIGN KEY (`codigoreserva`) REFERENCES `reservaambiente` (`codigoreservaambiente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.usodeambiente: ~0 rows (aproximadamente)
DELETE FROM `usodeambiente`;
/*!40000 ALTER TABLE `usodeambiente` DISABLE KEYS */;
/*!40000 ALTER TABLE `usodeambiente` ENABLE KEYS */;

-- Volcando estructura para tabla gepad.visita
CREATE TABLE IF NOT EXISTS `visita` (
  `numerovisita` int(11) NOT NULL AUTO_INCREMENT,
  `codigoeproductiva` int(11) DEFAULT NULL,
  `fechavisita` date DEFAULT NULL,
  `observacionesvisita` text DEFAULT NULL,
  `estadovisita` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numerovisita`),
  KEY `FK_visita_eproductiva` (`codigoeproductiva`),
  CONSTRAINT `FK_visita_eproductiva` FOREIGN KEY (`codigoeproductiva`) REFERENCES `eproductiva` (`codigoeproductiva`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.visita: ~0 rows (aproximadamente)
DELETE FROM `visita`;
/*!40000 ALTER TABLE `visita` DISABLE KEYS */;
/*!40000 ALTER TABLE `visita` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

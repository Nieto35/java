CREATE TABLE `config_correo` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`tipoCorreo` VARCHAR(80) NOT NULL COLLATE 'utf8mb4_general_ci',
	`starttls` CHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',
	`puerto` INT(10) NOT NULL DEFAULT '0',
	`usuario` VARCHAR(100) NOT NULL DEFAULT '0' COLLATE 'utf8mb4_general_ci',
	`clave` VARCHAR(100) NOT NULL DEFAULT '0' COLLATE 'utf8mb4_general_ci',
	`credenciales` CHAR(50) NOT NULL DEFAULT '0' COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_general_ci'
;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='gepad';
SHOW TABLE STATUS FROM `gepad`;
SHOW FUNCTION STATUS WHERE `Db`='gepad';
SHOW PROCEDURE STATUS WHERE `Db`='gepad';
SHOW TRIGGERS FROM `gepad`;
SELECT *, EVENT_SCHEMA AS `Db`, EVENT_NAME AS `Name` FROM information_schema.`EVENTS` WHERE `EVENT_SCHEMA`='gepad';
SELECT * FROM `information_schema`.`COLUMNS` WHERE TABLE_SCHEMA='gepad' AND TABLE_NAME='config_correo' ORDER BY ORDINAL_POSITION;
SHOW INDEXES FROM `config_correo` FROM `gepad`;
SELECT * FROM information_schema.REFERENTIAL_CONSTRAINTS WHERE   CONSTRAINT_SCHEMA='gepad'   AND TABLE_NAME='config_correo'   AND REFERENCED_TABLE_NAME IS NOT NULL;
SELECT * FROM information_schema.KEY_COLUMN_USAGE WHERE   CONSTRAINT_SCHEMA='gepad'   AND TABLE_NAME='config_correo'   AND REFERENCED_TABLE_NAME IS NOT NULL;
/* Entrando a la sesión "developer" */
SHOW CREATE TABLE `gepad`.`config_correo`;
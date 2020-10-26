CREATE TABLE `config_correo` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`smtp` VARCHAR(80) NOT NULL COLLATE 'utf8mb4_general_ci',
	`starttls` VARCHAR(5) NOT NULL DEFAULT '' COMMENT 'true o false' COLLATE 'utf8mb4_general_ci',
	`puerto` INT(10) NOT NULL DEFAULT '0',
	`usuario` VARCHAR(100) NOT NULL DEFAULT '0' COLLATE 'utf8mb4_general_ci',
	`clave` VARCHAR(100) NOT NULL DEFAULT '0' COLLATE 'utf8mb4_general_ci',
	`auth` VARCHAR(5) NOT NULL DEFAULT '0' COMMENT 'true o false' COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Corretora
-- -----------------------------------------------------
DROP DATABASE `Corretora`;

-- -----------------------------------------------------
-- Schema Corretora
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Corretora` DEFAULT CHARACTER SET utf8 ;
USE `Corretora` ;

-- -----------------------------------------------------
-- Table `Corretora`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Corretora`.`Cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `hashUsuario` VARCHAR(256) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Corretora`.`Imovel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Corretora`.`Imovel` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `descricao` VARCHAR(5000) NOT NULL,
  `numeroDeQuartos` INT NOT NULL,
  `numeroDeBanheiros` INT NOT NULL,
  `numeroDeSuites` INT NOT NULL,
  `numeroDeVagasNaGaragem` INT NOT NULL,
  `area` DOUBLE NOT NULL,
  `valor` DECIMAL(10, 2) NOT NULL,
  `tipo` VARCHAR(50) NOT NULL,
  `finalidade` VARCHAR(50) NOT NULL,
  `logradouro` VARCHAR(100) NOT NULL,
  `numero` VARCHAR(4) NOT NULL,
  `complemento` VARCHAR(100) NOT NULL,
  `bairro` VARCHAR(50) NOT NULL,
  `cidade` VARCHAR(50) NOT NULL,
  `estado` VARCHAR(50) NOT NULL,
  `cep` VARCHAR(10) NOT NULL,
  `exibir` BOOLEAN NOT NULL,
  `Cliente_id` INT NOT NULL,
  PRIMARY KEY (`codigo`, `Cliente_id`),
  INDEX `fk_Imovel_Cliente1_idx` (`Cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_Imovel_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `Corretora`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Corretora`.`Corretor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Corretora`.`Corretor` (
  `creci` VARCHAR(20) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `hashUsuario` VARCHAR(256) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  `taxaDeComissao` DECIMAL(3,3) NOT NULL,
  PRIMARY KEY (`creci`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Corretora`.`Avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Corretora`.`Avaliacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `estrelas` INT NOT NULL,
  `comentario` LONGTEXT NOT NULL,
  `Cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Cliente_id`),
  INDEX `fk_Avaliacao_Cliente_idx` (`Cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_Avaliacao_Cliente`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `Corretora`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Corretora`.`Transacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Corretora`.`Transacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dataDaTransacao` DATETIME NOT NULL,
  `tipo` VARCHAR(50) NOT NULL,
  `valor` DECIMAL(10, 2) NOT NULL,
  `Imovel_codigo` INT NOT NULL,
  `Cliente_id` INT NOT NULL,
  `Corretor_creci` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`, `Imovel_codigo`, `Cliente_id`, `Corretor_creci`),
  INDEX `fk_Transacao_Imovel1_idx` (`Imovel_codigo` ASC) VISIBLE,
  INDEX `fk_Transacao_Cliente1_idx` (`Cliente_id` ASC) VISIBLE,
  INDEX `fk_Transacao_Corretor1_idx` (`Corretor_creci` ASC) VISIBLE,
  CONSTRAINT `fk_Transacao_Imovel1`
    FOREIGN KEY (`Imovel_codigo`)
    REFERENCES `Corretora`.`Imovel` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transacao_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `Corretora`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transacao_Corretor1`
    FOREIGN KEY (`Corretor_creci`)
    REFERENCES `Corretora`.`Corretor` (`creci`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

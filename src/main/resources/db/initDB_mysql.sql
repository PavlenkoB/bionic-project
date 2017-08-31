-- MySQL Script generated by MySQL Workbench
-- Fri Sep  1 00:08:52 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema supSite
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `supSite` ;

-- -----------------------------------------------------
-- Schema supSite
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `supSite` DEFAULT CHARACTER SET utf8 ;
USE `supSite` ;

-- -----------------------------------------------------
-- Table `supSite`.`categorys`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`categorys` ;

CREATE TABLE IF NOT EXISTS `supSite`.`categorys` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `parrent_cat_id` INT NULL DEFAULT  NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supSite`.`currencys`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`currencys` ;

CREATE TABLE IF NOT EXISTS `supSite`.`currencys` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `factor` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supSite`.`products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`products` ;

CREATE TABLE IF NOT EXISTS `supSite`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `categorys_id` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `price` REAL NOT NULL,
  `currencys_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_products_categorys1_idx` (`categorys_id` ASC),
  INDEX `fk_products_currencys1_idx` (`currencys_id` ASC),
  CONSTRAINT `fk_products_categorys1`
  FOREIGN KEY (`categorys_id`)
  REFERENCES `supSite`.`categorys` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_currencys1`
  FOREIGN KEY (`currencys_id`)
  REFERENCES `supSite`.`currencys` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supSite`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`users` ;

CREATE TABLE IF NOT EXISTS `supSite`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `role` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supSite`.`products_users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`products_users` ;

CREATE TABLE IF NOT EXISTS `supSite`.`products_users` (
  `id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `products_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_products_users_user1_idx` (`user_id` ASC),
  INDEX `fk_products_users_products1_idx` (`products_id` ASC),
  CONSTRAINT `fk_products_users_user1`
  FOREIGN KEY (`user_id`)
  REFERENCES `supSite`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_users_products1`
  FOREIGN KEY (`products_id`)
  REFERENCES `supSite`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supSite`.`attributes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`attributes` ;

CREATE TABLE IF NOT EXISTS `supSite`.`attributes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supSite`.`variants`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`variants` ;

CREATE TABLE IF NOT EXISTS `supSite`.`variants` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  `attribute_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_atributes_variants_atribute1_idx` (`attribute_id` ASC),
  CONSTRAINT `fk_atributes_variants_atribute1`
  FOREIGN KEY (`attribute_id`)
  REFERENCES `supSite`.`attributes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supSite`.`categorys_atributes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`categorys_atributes` ;

CREATE TABLE IF NOT EXISTS `supSite`.`categorys_atributes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `categorys_id` INT NOT NULL,
  `atributes_id` INT NOT NULL,
  INDEX `fk_categorys_atributes_categorys1_idx` (`categorys_id` ASC),
  INDEX `fk_categorys_atributes_atributes1_idx` (`atributes_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_categorys_atributes_categorys1`
  FOREIGN KEY (`categorys_id`)
  REFERENCES `supSite`.`categorys` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categorys_atributes_atributes1`
  FOREIGN KEY (`atributes_id`)
  REFERENCES `supSite`.`attributes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supSite`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`orders` ;

CREATE TABLE IF NOT EXISTS `supSite`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `datetime` DATETIME NULL,
  `description` VARCHAR(45) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_orders_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_orders_users1`
  FOREIGN KEY (`users_id`)
  REFERENCES `supSite`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supSite`.`products_orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`products_orders` ;

CREATE TABLE IF NOT EXISTS `supSite`.`products_orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orders_id` INT NOT NULL,
  `products_id` INT NOT NULL,
  `counter` REAL NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_products_orders_orders1_idx` (`orders_id` ASC),
  INDEX `fk_products_orders_products1_idx` (`products_id` ASC),
  CONSTRAINT `fk_products_orders_orders1`
  FOREIGN KEY (`orders_id`)
  REFERENCES `supSite`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_orders_products1`
  FOREIGN KEY (`products_id`)
  REFERENCES `supSite`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supSite`.`users_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`users_info` ;

CREATE TABLE IF NOT EXISTS `supSite`.`users_info` (
  `users_id` INT NOT NULL,
  INDEX `fk_users_info_users1_idx` (`users_id` ASC),
  PRIMARY KEY (`users_id`),
  CONSTRAINT `fk_users_info_users1`
  FOREIGN KEY (`users_id`)
  REFERENCES `supSite`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supSite`.`supliers_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supSite`.`supliers_info` ;

CREATE TABLE IF NOT EXISTS `supSite`.`supliers_info` (
  `users_id` INT NOT NULL,
  INDEX `fk_supliers_info_users1_idx` (`users_id` ASC),
  PRIMARY KEY (`users_id`),
  CONSTRAINT `fk_supliers_info_users1`
  FOREIGN KEY (`users_id`)
  REFERENCES `supSite`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

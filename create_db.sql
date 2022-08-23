-- MySQL Script generated by MySQL Workbench
-- Tue Aug 23 16:15:50 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema employees
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema employees
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `employees` DEFAULT CHARACTER SET utf8 ;
USE `employees` ;

-- -----------------------------------------------------
-- Table `employees`.`JOBS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employees`.`JOBS` ;

CREATE TABLE IF NOT EXISTS `employees`.`JOBS` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(255) NOT NULL,
  `SALARY` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employees`.`GENDERS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employees`.`GENDERS` ;

CREATE TABLE IF NOT EXISTS `employees`.`GENDERS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employees`.`EMPLOYEES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employees`.`EMPLOYEES` ;

CREATE TABLE IF NOT EXISTS `employees`.`EMPLOYEES` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `GENDER_ID` INT NOT NULL,
  `JOB_ID` INT NOT NULL,
  `NAME` VARCHAR(255) NOT NULL,
  `LAST_NAME` VARCHAR(255) NOT NULL,
  `BIRTHDATE` DATE NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_EMPLOYEES_JOBS_idx` (`JOB_ID` ASC) ,
  INDEX `fk_EMPLOYEES_GENDERS1_idx` (`GENDER_ID` ASC) ,
  CONSTRAINT `fk_EMPLOYEES_JOBS`
    FOREIGN KEY (`JOB_ID`)
    REFERENCES `employees`.`JOBS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EMPLOYEES_GENDERS1`
    FOREIGN KEY (`GENDER_ID`)
    REFERENCES `employees`.`GENDERS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `employees`.`EMPLOYEE_WORKED_HOURS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `employees`.`EMPLOYEE_WORKED_HOURS` ;

CREATE TABLE IF NOT EXISTS `employees`.`EMPLOYEE_WORKED_HOURS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_ID` INT NOT NULL,
  `WORKED_HOURS` INT NOT NULL,
  `WORKED_DATE` DATE NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_EMPLOYEE_WORKED_HOURS_EMPLOYEES1_idx` (`EMPLOYEE_ID` ASC) ,
  CONSTRAINT `fk_EMPLOYEE_WORKED_HOURS_EMPLOYEES1`
    FOREIGN KEY (`EMPLOYEE_ID`)
    REFERENCES `employees`.`EMPLOYEES` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
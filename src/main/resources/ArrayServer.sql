CREATE DATABASE `arrayserver` DEFAULT CHARACTER SET utf8;

USE `arrayserver`;

SET FOREIGN_KEY_CHECKS=0;

/*
student table
 */
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
    `userId` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(64) NOT NULL,
    `password` varchar(255) NOT NULL,
    `studentId` char(13) NOT NULL DEFAULT '0000000000000',
    `nickname` varchar(64) NOT NULL DEFAULT 'student',
    `mail` varchar(64) DEFAULT NULL,
    `telephone` char(11) DEFAULT NULL,
    `userFace` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*
teacher table
 */
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
    `teacherId` int(11) NOT NULL AUTO_INCREMENT,
    `teacherName` varchar(64) NOT NUll,
    `teacherPassword` varchar(255) NOT NULL ,
    PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*
course table
 */
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
    `courseId` int(11) NOT NULL AUTO_INCREMENT,
    `examId` int(11) DEFAULT NULL,
    `teacherId` int(11) DEFAULT NULL,
    `courseName` varchar(64) NOT NULL,
    PRIMARY KEY (`courseId`),
    CONSTRAINT `fk_course_teacher` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*
user_course table
 */
DROP TABLE IF EXISTS `user_course`;
CREATE TABLE `user_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `grade` TINYINT DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `courseId` (`courseId`),
  CONSTRAINT `fk_course` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE,
  CONSTRAINT `fk_user` FOREIGN KEY (`userId`) REFERENCES `student` (`userId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*
homework table
 */
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework` (
    `homeworkId` int(11) NOT NULL AUTO_INCREMENT,
    `courseId` int(11) NOT NULL,
    `homeworkContent` text,
    `homeworkTime` datetime DEFAULT NULL,
    PRIMARY KEY (`homeworkId`),
    CONSTRAINT `fk_course_homework` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*
question table
 */
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
    `questionId` int(11) NOT NULL AUTO_INCREMENT,
    `homeworkId` int(11) NOT NULL,
    `examId` int(11) DEFAULT NUll,
    `questionName` varchar(255) DEFAULT NULL,
    `questionContent` text DEFAULT NULL,
    PRIMARY KEY (`questionId`),
    CONSTRAINT `fk_question_homework` FOREIGN KEY (`homeworkId`) REFERENCES `homework` (`homeworkId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;


/*
useCase table
 */
DROP TABLE IF EXISTS `useCase`;
CREATE TABLE `useCase` (
    `useCaseId` int(11) NOT NULL AUTO_INCREMENT,
    `questionId` int(11) NOT NULL,
    `useCaseContent` text DEFAULT NULL,
    PRIMARY KEY (`useCaseId`),
    CONSTRAINT `fk_case_question` FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*
record table
 */
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `questionId` int(11) NOT NULL,
  `recordGrade` int(11) NOT NUll,
  `lang` varchar(64) NOT NUll,
  `recordContent` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `questionId` (`questionId`),
  CONSTRAINT `fk_question_record` FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_record` FOREIGN KEY (`userId`) REFERENCES `student` (`userId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*
comment table
 */
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `questionId` int(11) NOT NULL,
  `commentContent` text DEFAULT NULL,
  `commentTime` datetime DEFAULT NULL ,
  PRIMARY KEY (`commentId`),
  KEY `userId` (`userId`),
  KEY `questionId` (`questionId`),
  CONSTRAINT `fk_question1_comment` FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_comment` FOREIGN KEY (`userId`) REFERENCES `student` (`userId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*
message table
 */
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT,
  `messageContent` text NOT NULL,
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `message_user`;
CREATE TABLE `message_user` (
  `messageId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `state` TINYINT DEFAULT 0,
  KEY `messageId` (`messageId`),
  KEY `userId` (`userId`),
  CONSTRAINT `fk_message` FOREIGN KEY (`messageId`) REFERENCES `message` (`messageId`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_message` FOREIGN KEY (`userId`) REFERENCES `student` (`userId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;







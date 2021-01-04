/*
 Navicat Premium Data Transfer

 Source Server         : ToXUQY
 Source Server Type    : Oracle
 Source Server Version : 110200
 Source Host           : localhost:1521
 Source Schema         : XUQY

 Target Server Type    : Oracle
 Target Server Version : 110200
 File Encoding         : 65001

 Date: 04/01/2021 12:06:42
*/


-- ----------------------------
-- Table structure for TimeStatistics
-- ----------------------------
DROP TABLE "XUQY"."TimeStatistics";
CREATE TABLE "XUQY"."TimeStatistics" (
  "Id" NUMBER NOT NULL,
  "Developer" VARCHAR2(255 BYTE),
  "ServNo" VARCHAR2(255 BYTE),
  "EngineePoint" VARCHAR2(255 BYTE),
  "Title" VARCHAR2(255 BYTE),
  "Status" VARCHAR2(255 BYTE),
  "Type" VARCHAR2(255 BYTE),
  "Content" VARCHAR2(255 BYTE),
  "BeginTime" VARCHAR2(255 BYTE),
  "EndTime" VARCHAR2(255 BYTE),
  "WorkLoad" VARCHAR2(255 BYTE),
  "Remarks" VARCHAR2(255 BYTE),
  "Group" VARCHAR2(255 BYTE)
)
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Primary Key structure for table TimeStatistics
-- ----------------------------
ALTER TABLE "XUQY"."TimeStatistics" ADD CONSTRAINT "SYS_C0011091" PRIMARY KEY ("Id");

-- ----------------------------
-- Checks structure for table TimeStatistics
-- ----------------------------
ALTER TABLE "XUQY"."TimeStatistics" ADD CONSTRAINT "SYS_C0011090" CHECK ("Id" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

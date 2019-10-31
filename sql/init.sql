create database authdb;

use authdb;
grant all on authdb.* to authuser IDENTIFIED by '!Q2w3e4r';

CREATE  table org_info(
   id int PRIMARY key auto_increment COMMENT '主键',
   org_name varchar(20) NOT NULL COMMENT '机构名称',
   org_code varchar(20) NOT NULL COMMENT '机构代码',
   expire_date varchar(10) NOT NULL COMMENT '到期日',
   remark varchar(20) NOT NULL COMMENT '备注',
   org_status varchar(1) NOT NULL COMMENT '机构状态：0正常 1停用',
   create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近更新时间'
) comment ='机构信息';
insert into org_info (org_code,org_name,expire_date,remark) values ('TAOBAO','淘宝','20201008','测试机构');

CREATE  table auth_history(
  id int PRIMARY key auto_increment COMMENT '主键',
  licence_key_id int COMMENT '许可证id',
  licence_key varchar(200) COMMENT '许可证',
  remark varchar(20) COMMENT '备注',
  result_code varchar(50) NOT NULL COMMENT '认证结果代码',
  result varchar(50) NOT NULL COMMENT '认证结果',
  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近更新时间'
) comment ='认证历史';


CREATE  table licence_key_info(
   id int PRIMARY key auto_increment COMMENT '主键',
   org_code varchar(20) NOT NULL COMMENT '系统代码',
   expire_date varchar(10) NOT NULL COMMENT '到期日',
   ip varchar(30) NOT NULL COMMENT 'ip',
   mac varchar(30) NOT NULL COMMENT 'mac地址',
   salt varchar(50) NOT NULL COMMENT '混淆因子',
   licence_key_seed varchar(200) NOT NULL COMMENT '许可序列号',
   licence_key varchar(200) NOT NULL COMMENT '许可序列号',
   status varchar(1) NOT NULL COMMENT '许可证状态  0正常 1停用',
   create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近更新时间',
   UNIQUE KEY licencekey_seed_index (org_code,expire_date,ip,mac,salt)
) COMMENT = '许可证信息';
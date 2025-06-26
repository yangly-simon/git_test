/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2025/6/25 16:45:11                           */
/*==============================================================*/
create database greenroad_demo charset utf8;
use greenroad_demo;

drop table if exists academy;

drop table if exists college;

drop table if exists counselor;

drop table if exists file;

drop table if exists grade;

drop table if exists greenroad;

drop table if exists greenroad_item;

drop table if exists item;

drop table if exists req;

drop table if exists req_1;

drop table if exists req_2;

drop table if exists req_2_item;

drop table if exists req_3;

drop table if exists rooter;

drop table if exists student;

/*==============================================================*/
/* Table: academy                                               */
/*==============================================================*/
create table academy
(
   id                   bigint not null auto_increment,
   rooter_id            bigint,
   greenroad_id         bigint,
   user                 varchar(50),
   major                 varchar(50),
   phone                bigint,
   quota                bigint comment '爱心大礼包名额数量',
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table academy comment '学院';

/*==============================================================*/
/* Table: college                                               */
/*==============================================================*/
create table college
(
   id                   bigint not null auto_increment,
   rooter_id            bigint,
   user                 varchar(50),
   phone                varchar(50),
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table college comment '学校';

/*==============================================================*/
/* Table: counselor                                             */
/*==============================================================*/
create table counselor
(
   id                   bigint not null auto_increment,
   rooter_id            bigint,
   user                 varchar(50),
   grade                bigint,
   college              varchar(50),
   phone                varchar(50),
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table counselor comment '辅导员';

/*==============================================================*/
/* Table: file                                                  */
/*==============================================================*/
create table file
(
   id                   bigint not null auto_increment,
   req_1_id             bigint,
   name                 varchar(50),
   address              varchar(50),
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table file comment '文件';

/*==============================================================*/
/* Table: grade                                                 */
/*==============================================================*/
create table grade
(
   id                   bigint not null auto_increment,
   academy_id           bigint,
   name                 varchar(50),
   quota               bigint comment '爱心大礼包年级配额',
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table grade comment '年级';

/*==============================================================*/
/* Table: greenroad                                             */
/*==============================================================*/
create table greenroad
(
   id                   bigint not null auto_increment,
   college_id           bigint,
   req_strat            datetime,
   req_end              datetime,
   upload_ddl           datetime,
   year                 bigint,
   fund                 bigint,
   state1               bigint,
   state2               bigint,
   state3               bigint,
   max                  bigint,
   batch                bigint,
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table greenroad comment '绿色通道';

/*==============================================================*/
/* Table: greenroad_item                                        */
/*==============================================================*/
create table greenroad_item
(
   id                   bigint not null auto_increment,
   greenroad_id         bigint not null,
   item_id              bigint not null,
   primary key (id)
);

alter table greenroad_item comment '绿色通道-物品';

/*==============================================================*/
/* Table: item                                                  */
/*==============================================================*/
create table item
(
   id                   bigint not null auto_increment,
   img_name             varchar(50),
   img                  longtext,
   item_name            varchar(50),
   size                 varchar(50),
   intro                longtext,
   type                 longtext,
   price                bigint,
   sex                  bigint,
   necessory            bool,
   gift                 bool,
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table item comment '物品';

/*==============================================================*/
/* Table: req                                                   */
/*==============================================================*/
create table req
(
   id                   bigint not null auto_increment,
   req_3_id             bigint,
   greenroad_id         bigint,
   req_1_id             bigint,
   req_2_id             bigint,
   student_id           bigint,
   id_num               bigint,
   type                 bigint,
   state                bigint,
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table req comment '申请';

/*==============================================================*/
/* Table: req_1                                                 */
/*==============================================================*/
create table req_1
(
   id                   bigint not null auto_increment,
   req_id               bigint,
   Xvefei               bool,
   Zhusu                bool,
   Money_Xvefei         bigint,
   Money_Zhusu          bigint,
   reason               bigint,
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table req_1 comment '欠费单申请';

/*==============================================================*/
/* Table: req_2                                                 */
/*==============================================================*/
create table req_2
(
   id                   bigint not null auto_increment,
   req_id               bigint,
   num                  bigint,
   reason               longtext,
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table req_2 comment '爱心大礼包申请';

/*==============================================================*/
/* Table: req_2_item                                            */
/*==============================================================*/
create table req_2_item
(
   id                   bigint not null auto_increment,
   req_2_id             bigint not null,
   item_id              bigint not null,
   primary key (id)
);

alter table req_2_item comment '爱心大礼包申请-物品';

/*==============================================================*/
/* Table: req_3                                                 */
/*==============================================================*/
create table req_3
(
   id                   bigint not null auto_increment,
   req_id               bigint,
   type                 bigint,
   money_num            bigint,
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table req_3 comment '补助申请';

/*==============================================================*/
/* Table: rooter                                                */
/*==============================================================*/
create table rooter
(
   id                   bigint not null auto_increment,
   college_id           bigint,
   academy_id           bigint,
   counselor_id         bigint,
   user                 bigint,
   password             bigint,
   QvanXian             varchar(50),
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table rooter comment '管理员';

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   id                   bigint not null auto_increment,
   counselor_id         bigint,
   college_id           bigint,
   academy_id           bigint,
   name                 varchar(50),
   age                  varchar(50),
   id_num               bigint,
   grade                bigint,
   pro                  varchar(50),
   XveYvan              varchar(50),
   clazz                varchar(50),
   DaiKuan              bigint,
   phone                bigint,
   password             bigint,
   is_deleted           bool default 0 comment '逻辑删除',
   create_time          datetime default CURRENT_TIMESTAMP comment '创建时间',
   update_time          datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   primary key (id)
);

alter table student comment '学生';

alter table academy add constraint FK_greenroad foreign key (greenroad_id)
      references greenroad (id) on delete restrict on update restrict;

alter table academy add constraint FK_rooter_academy foreign key (rooter_id)
      references rooter (id) on delete restrict on update restrict;

alter table college add constraint FK_rooter_college2 foreign key (rooter_id)
      references rooter (id) on delete restrict on update restrict;

alter table counselor add constraint FK_rooter_rooter2 foreign key (rooter_id)
      references rooter (id) on delete restrict on update restrict;

alter table file add constraint FK_req_1_file foreign key (req_1_id)
      references req_1 (id) on delete restrict on update restrict;

alter table grade add constraint FK_academy_grade foreign key (academy_id)
      references academy (id) on delete restrict on update restrict;

alter table greenroad add constraint FK_greenroad_college foreign key (college_id)
      references college (id) on delete restrict on update restrict;

alter table greenroad_item add constraint FK_greenroad_item foreign key (greenroad_id)
      references greenroad (id) on delete restrict on update restrict;

alter table greenroad_item add constraint FK_greenroad_item2 foreign key (item_id)
      references item (id) on delete restrict on update restrict;

alter table req add constraint FK_greenroad_req foreign key (greenroad_id)
      references greenroad (id) on delete restrict on update restrict;

alter table req add constraint FK_req_req_1 foreign key (req_1_id)
      references req_1 (id) on delete restrict on update restrict;

alter table req add constraint FK_req_req_3 foreign key (req_2_id)
      references req_2 (id) on delete restrict on update restrict;

alter table req add constraint FK_req_req_5 foreign key (req_3_id)
      references req_3 (id) on delete restrict on update restrict;

alter table req add constraint FK_student_req foreign key (student_id)
      references student (id) on delete restrict on update restrict;


alter table req_2_item add constraint FK_req_2_item foreign key (req_2_id)
      references req_2 (id) on delete restrict on update restrict;

alter table req_2_item add constraint FK_req_2_item2 foreign key (item_id)
      references item (id) on delete restrict on update restrict;


alter table student add constraint FK_academy_student foreign key (academy_id)
      references academy (id) on delete restrict on update restrict;

alter table student add constraint FK_college_student foreign key (college_id)
      references college (id) on delete restrict on update restrict;

alter table student add constraint FK_counselor_student foreign key (counselor_id)
      references counselor (id) on delete restrict on update restrict;


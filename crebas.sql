/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     4/16/2018 8:47:53 PM                         */
/*==============================================================*/


drop table if exists code;

drop table if exists friend;

drop table if exists getshare;

drop table if exists user;

/*==============================================================*/
/* Table: code                                                  */
/*==============================================================*/
create table code
(
   code_id              varchar(120) not null,
   url                  varchar(120),
   user_id              varchar(120),
   is_public            bool,
   primary key (code_id)
);

/*==============================================================*/
/* Table: friend                                                */
/*==============================================================*/
create table friend
(
   friend_id            varchar(120) not null,
   user_id              varchar(120),
   user_email           varchar(120),
   primary key (friend_id)
);

/*==============================================================*/
/* Table: getshare                                              */
/*==============================================================*/
create table getshare
(
   share_id             varchar(120) not null,
   user_id              varchar(120),
   code_id              varchar(120),
   user_email           varchar(120),
   primary key (share_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              varchar(120) not null,
   user_email           varchar(30),
   passwd               varchar(120),
   name                 varchar(120),
   person_name          varchar(240),
   icon                 varchar(120),
   bg_icon              varchar(120),
   primary key (user_id)
);

alter table code add constraint FK_Reference_1 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table friend add constraint FK_Reference_6 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table getshare add constraint FK_Reference_7 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict;

alter table getshare add constraint FK_Reference_8 foreign key (code_id)
      references code (code_id) on delete restrict on update restrict;


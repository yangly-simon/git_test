-- auto-generated definition
create table tb_user
(
    id          bigint unsigned auto_increment comment '主键' primary key,
    phone       varchar(11)                            not null comment '手机号码',
    password    varchar(128) default ''                null comment '密码，加密存储',
    nick_name   varchar(32)  default ''                null comment '昵称，默认是用户id',
    icon        varchar(255) default ''                null comment '人物头像',
    create_time timestamp    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time timestamp    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint uniqe_key_phone
        unique (phone)
)
    collate = utf8mb4_general_ci
    row_format = COMPACT;


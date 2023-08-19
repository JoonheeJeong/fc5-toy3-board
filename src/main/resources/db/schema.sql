drop table if exists member_authority cascade;
drop table if exists member cascade;
drop table if exists authority cascade;
drop table if exists grade cascade;

create table authority (
    id          bigint          not null auto_increment primary key,
    name        varchar(16)     not null unique,
    created_at  timestamp       not null default now(),
    updated_at  timestamp
);

create table grade (
    id          bigint          not null auto_increment primary key,
    name        varchar(16)     not null unique,
    created_at  timestamp       not null default now(),
    updated_at  timestamp
);

create table member (
    id          bigint          not null auto_increment primary key,
    grade_id    bigint          not null,
    username    varchar(32)     not null unique,
    email       varchar(64)     not null unique,
    password    char(60)        not null,
    nickname    varchar(16)     not null unique,
    created_at  timestamp       not null default now(),
    updated_at  timestamp,
    foreign key (grade_id) references grade(id)
);

create table member_authority (
    id            bigint        not null auto_increment primary key,
    member_id     bigint        not null,
    authority_id  bigint        not null,
    created_at    timestamp     not null default now(),
    updated_at    timestamp,
    foreign key (member_id)    references member(id),
    foreign key (authority_id) references authority(id)
);

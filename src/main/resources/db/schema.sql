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

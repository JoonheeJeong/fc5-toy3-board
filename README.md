# 게시판 제작하기 프로젝트

<br/>

## 기능 요구 사항

### 🙌🏼 로그인
- [로그인 페이지] `GET /login`
  - 미로그인 상태로 로그인 필요한 요청을 했을 경우 로그인 페이지로 전환
- [로그인] `POST /login`
  - ``` { _csrf, username, password } ``` 
  - 로그인 성공 시, 
    - 로그인 페이지로 진입한 경우: 게시물 목록 페이지로 전환
    - 미로그인 상태로 로그인 필요한 요청을 했던 경우: 원래 요청 수행 
  - 로그인 실패 시, 다시 로그인 페이지 및 검증 메시지 출력
- [로그아웃] `POST /logout`
    - ``` { _csrf } ```
    - 로그아웃 시 로그인 페이지로 이동

### 📝 회원가입

### 🪧 게시판

<br/>

## 기술 스택

- 시스템 전반 <br/>
  <img alt="SpringBoot" src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=springboot&logoColor=white">
  <img alt="Spring Security" src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=springsecurity&logoColor=white">
  <img alt="Thymeleaf" src="https://img.shields.io/badge/Thymeleaf-005F0F?style=flat-square&logo=thymeleaf&logoColor=white">
  <img alt="Java 11" src="https://img.shields.io/badge/Java 11-FF160B?style=flat-square&logo=java&logoColor=white">
  <img alt="JPA" src="https://img.shields.io/badge/JPA-EC1C24?style=flat-square&logo=jpa&logoColor=white">
  <img alt="Gradle" src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white">
- 테스트용 디비 <br/>
  <img alt="H2" src="https://img.shields.io/badge/H2-071D49?style=flat-square&logo=h2&logoColor=white">
- 메인 디비 <br/>
  <img alt="MySQL" src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white">
  <img alt="Docker" src="https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white">

<br/>

## 구조

<br/>

## DB 스키마 
```sql
create table authority (
    id          bigint          not null auto_increment primary key,
    name        varchar(16)     not null unique,
    created_at  timestamp       not null default now(),
    updated_at  timestamp
);
```
```sql
create table authority (
    id          bigint          not null auto_increment primary key,
    name        varchar(16)     not null unique,
    created_at  timestamp       not null default now(),
    updated_at  timestamp
);
```
```sql
create table grade (
    id          bigint          not null auto_increment primary key,
    name        varchar(16)     not null unique,
    created_at  timestamp       not null default now(),
    updated_at  timestamp
)
```
```sql
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
)
```
```sql
create table member_authority (
    id            bigint        not null auto_increment primary key,
    member_id     bigint        not null,
    authority_id  bigint        not null,
    created_at    timestamp     not null default now(),
    updated_at    timestamp,
    foreign key (member_id)    references member(id),
    foreign key (authority_id) references authority(id)
);
```

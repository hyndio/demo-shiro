-- drop table account;
-- drop table role
-- drop table permission
-- drop table account_role
-- drop table account_permission
-- drop table role_permission

-- 用户
create table account (
    username varchar(25) not null,
    password varchar(25)  not null,
    email varchar(80) not null,
    constraint pk_account primary key (username)
);

-- 角色
create table role (
	rolename varchar(25) not null,
	description varchar(80) not null,
	constraint pk_role primary key (rolename)
);

-- 权限
create table permission (
	token varchar(25) not null,
	url varchar(200) not null,
	description varchar(80) not null,
	constraint pk_permission primary key (token)
);

-- 用户与角色
create table account_role (
	username varchar(25) not null,
	rolename varchar(25) not null,
	constraint pk_account_role primary key (username, rolename)
);

/*
select b.* from account_role a 
left join role b on a.rolename = b.rolename
where a.username = 
*/

-- 用户与权限
create table account_permission (
	username varchar(25) not null,
	token varchar(25) not null,
	constraint pk_account_permission primary key (username, token)
);

/*
select b.* from account_permission a
left join permission b on a.token = b.token
where a.username = 
*/

-- 角色与权限
create table role_permission (
	rolename varchar(25) not null,
	token varchar(25) not null,
	constraint pk_role_permission primary key (rolename, token)
)

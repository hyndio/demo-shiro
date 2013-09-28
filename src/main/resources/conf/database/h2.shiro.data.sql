-- 用户
INSERT INTO account VALUES('hyd', 'hyd', 'yuandong.huang@gmail.com');
INSERT INTO account VALUES('j2ee', 'j2ee', 'j2ee@shiro.apache.com');

-- 角色
INSERT INTO role VALUES('R_CODER', '程序员');
INSERT INTO role VALUES('R_TESTING', '测试员');

-- 权限
INSERT INTO permission VALUES('edit', '/authc/edit.do', '编辑');
INSERT INTO permission VALUES('view', '/authc/view.do', '查看');
INSERT INTO permission VALUES('self', '/authc/self.do', '用户直接关联url');

-- 用户与角色
INSERT INTO account_role VALUES('hyd', 'R_CODER');
INSERT INTO account_role VALUES('j2ee', 'R_TESTING');

-- 用户与权限
INSERT INTO account_permission VALUES('hyd', 'self');

-- 角色与权限
INSERT INTO role_permission VALUES('R_CODER', 'edit');
INSERT INTO role_permission VALUES('R_TESTING', 'view');

/*
select a.rolename, b.url 
from role_permission a
inner join permission b on a.token = b.token
*/
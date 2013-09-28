package h.demo.shiro.service.impl;

import java.util.List;

import h.demo.shiro.entity.Account;
import h.demo.shiro.entity.Permission;
import h.demo.shiro.entity.Role;
import h.demo.shiro.mapper.AccountMapper;
import h.demo.shiro.service.AccountService;
import h.demo.shiro.service.PermissionService;
import h.demo.shiro.service.RoleService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;

    public Account getAccount(String username) {
        Account account = this.accountMapper.getAccountByUsername(username);
        if (account != null) {
            // 用户的角色
            List<Role> roles = this.roleService.getRoles(username);
            account.setRoles(roles);
            // 用户的权限
            List<Permission> permissions = this.permissionService.getPermissions(username);
            account.setPermissions(permissions);
        }
        return account;
    }

    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return this.accountMapper.getAccountByUsernameAndPassword(account);
    }

    @Override
    public void insertAccount(Account account) {
        
    }

    @Override
    public void updateAccount(Account account) {
        
    }
   
}

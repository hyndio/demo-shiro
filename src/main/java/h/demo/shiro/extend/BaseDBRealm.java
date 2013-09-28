/*
 * Copyright 2000-2013 by Asiainfo-Linkage Tech. Co. Ltd. All Rights Reserved.
 * 
 * @Description：
 * 
 * @author：yuandong.huang@gmail.com
 * 
 * @date：2013-9-12
 */
package h.demo.shiro.extend;

import h.demo.shiro.entity.Account;
import h.demo.shiro.entity.Permission;
import h.demo.shiro.entity.Role;
import h.demo.shiro.service.AccountService;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户登录
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-12
 */
public class BaseDBRealm extends AuthorizingRealm {
    
    private final static Logger logger = LoggerFactory.getLogger(BaseDBRealm.class);

    private AccountService accountService;

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 与new SimpleAuthenticationInfo(account, account.getPassword(), getName());一致
        Account account = (Account) principals.fromRealm(getName()).iterator().next();
        if (account == null) {
            return null;
        }
        
        logger.info("--------------account: {}-----------------", account.getUsername());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 用户的角色
        List<Role> roles = account.getRoles();
        logger.info("------------------roles------------------");
        for (Role role : roles) {
            logger.info("{} : {}", role.getRolename(), role.getDescription());
            info.addRole(role.getRolename());
        }
        // 用户的权限
        logger.info("--------------permissions---------------");
        List<Permission> permissions = account.getPermissions();
        for (Permission permission : permissions) {
            logger.info("{} : {} : {}", new String[]{permission.getToken(), permission.getUrl(), permission.getDescription()});
            info.addStringPermission(permission.getToken());
        }
        logger.info("----------------------------------------");
        
        return info;
    }
    
    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        Account account = this.accountService.getAccount(upToken.getUsername());
        if (account == null) {
            throw new UnknownAccountException("No account found for user [" + upToken.getUsername() + "]");
        }
        return new SimpleAuthenticationInfo(account, account.getPassword(), getName());
    }
    
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

}

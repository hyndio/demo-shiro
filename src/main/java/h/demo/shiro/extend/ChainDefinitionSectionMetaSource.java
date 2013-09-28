/*
 * Copyright 2000-2013 by Asiainfo-Linkage Tech. Co. Ltd. All Rights Reserved.
 * 
 * @Description：
 * 
 * @author：yuandong.huang@gmail.com
 * 
 * @date：2013-9-18
 */
package h.demo.shiro.extend;

import h.demo.shiro.entity.Permission;
import h.demo.shiro.service.PermissionService;
import h.demo.shiro.service.RoleService;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * 权限对应信息
 * 
 * FactoryBean<Ini.Section>
 * 
 * Spring中有两种类型的Bean，一种是普通Bean，另一种是工厂Bean，即FactoryBean。
 * 工厂Bean跟普通Bean不同，其返回的对象不是指定类的一个实例，其返回的是该工厂Bean的getObject方法所返回的对象。
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-18
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {
    
    private final static Logger logger = LoggerFactory.getLogger(ChainDefinitionSectionMetaSource.class);

    /**
     * filterChainDefinitionMap里面的键就是链接URL,值就是存在什么条件才能访问该链接，如perms、roles。
     * filterChainDefinitionMap是一个Map，shiro扩展出一个Map的子类Ini.Section
     */
    private String filterChainDefinitions;
    
    private PermissionService permissionService;
    
    private RoleService roleService;

    /**
     * 默认premission字符串
     */
    public static final String PREMISSION_STRING = "perms[\"{0}\"]";
    /**
     * 默认roles字符串
     */
    public static final String ROLE_STRING = "roles[\"{0}\"]";

    @Override
    public Section getObject() throws Exception {
        
        // 1. url : perms
        List<Permission> permissions = this.permissionService.getAll();
        
        // 2. url : roles
        List<Map<String, String>> rolePerms = this.roleService.getRolePerms();
        
        Ini ini = new Ini();
        
        // 放在最后，加载默认的url
        ini.load(filterChainDefinitions);
        
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        // 循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
        // 里面的键就是链接URL,值就是存在什么条件才能访问该链接
        for (Permission permission : permissions) {
            // 如果不为空值添加到section中
            if (StringUtils.isNotEmpty(permission.getUrl())
                    && StringUtils.isNotEmpty(permission.getToken())) {
                
                logger.info("{} : {}", permission.getUrl(), permission.getToken());
                
                section.put(permission.getUrl(), 
                    MessageFormat.format(PREMISSION_STRING, permission.getToken()));
            }
        }
        
        for (Map<String, String> map : rolePerms) {
            // 如果不为空值添加到section中
            if (StringUtils.isNotEmpty(map.get("URL"))
                    && StringUtils.isNotEmpty(map.get("ROLENAME"))) {
                
                logger.info("{} : {}", map.get("URL"), map.get("ROLENAME"));
                
                section.put(map.get("URL"), 
                    MessageFormat.format(ROLE_STRING, map.get("ROLENAME")));
            }
        }
        
        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

}

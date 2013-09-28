/*
 * Copyright 2000-2013 by Asiainfo-Linkage Tech. Co. Ltd. All Rights Reserved.
 * @Description： 
 * @author：yuandong.huang@gmail.com
 * @date：2013-9-17
 */
package h.demo.shiro.mapper;

import h.demo.shiro.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-17 
 */
public interface RoleMapper {
    
    /**
     * 用户拥有的角色
     * 
     * @param username
     * @return List<Role>
     */
    List<Role> getRoleByAccount(String username);
    
    /**
     * 角色可访问的权限(url)
     * 
     * @return List<Map<String,String>>
     */
    List<Map<String, String>> getRolePerms();

}

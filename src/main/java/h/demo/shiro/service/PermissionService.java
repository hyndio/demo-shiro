/*
 * Copyright 2000-2013 by Asiainfo-Linkage Tech. Co. Ltd. All Rights Reserved.
 * @Description： 
 * @author：yuandong.huang@gmail.com
 * @date：2013-9-17
 */
package h.demo.shiro.service;

import h.demo.shiro.entity.Permission;

import java.util.List;

/**
 * 
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-17 
 */
public interface PermissionService {
    
    /**
     * 用户的直接权限
     * 
     * @param username
     * @return List<Permission>
     */
    List<Permission> getPermissions(String username);
    
    /**
     * 加载所有的数据
     * 
     * @return List<Permission>
     */
    List<Permission> getAll();
    
}

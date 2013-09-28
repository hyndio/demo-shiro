/*
 * Copyright 2000-2013 by Asiainfo-Linkage Tech. Co. Ltd. All Rights Reserved.
 * @Description： 
 * @author：yuandong.huang@gmail.com
 * @date：2013-9-17
 */
package h.demo.shiro.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import h.demo.shiro.entity.Permission;
import h.demo.shiro.mapper.PermissionMapper;
import h.demo.shiro.service.PermissionService;

/**
 * 
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-17 
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissions(String username) {
        return this.permissionMapper.getPermissionByAccount(username);
    }

    @Override
    public List<Permission> getAll() {
        return this.permissionMapper.getAll();
    }

}

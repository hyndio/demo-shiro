/*
 * Copyright 2000-2013 by Asiainfo-Linkage Tech. Co. Ltd. All Rights Reserved.
 * @Description： 
 * @author：yuandong.huang@gmail.com
 * @date：2013-9-17
 */
package h.demo.shiro.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import h.demo.shiro.entity.Role;
import h.demo.shiro.mapper.RoleMapper;
import h.demo.shiro.service.RoleService;

/**
 * 
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-17 
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoles(String username) {
        return this.roleMapper.getRoleByAccount(username);
    }

    @Override
    public List<Map<String, String>> getRolePerms() {
        return this.roleMapper.getRolePerms();
    }

}

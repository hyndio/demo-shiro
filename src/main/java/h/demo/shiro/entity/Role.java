/*
 * Copyright 2000-2013 by Asiainfo-Linkage Tech. Co. Ltd. All Rights Reserved.
 * 
 * @Description：
 * 
 * @author：yuandong.huang@gmail.com
 * 
 * @date：2013-9-17
 */
package h.demo.shiro.entity;

/**
 * 角色
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-17
 */
public class Role implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    
    private String rolename;
    private String description;

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

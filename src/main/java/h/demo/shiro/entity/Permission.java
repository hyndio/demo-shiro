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

import java.io.Serializable;

/**
 * 权限
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-17
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;
    private String url;
    private String description;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

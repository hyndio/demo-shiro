/*
 * Copyright 2000-2013 by Asiainfo-Linkage Tech. Co. Ltd. All Rights Reserved.
 * @Description： 
 * @author：yuandong.huang@gmail.com
 * @date：2013-9-12
 */
package h.demo.shiro;

import org.junit.Test;

/**
 * 
 * 
 * @author yuandong.huang@gmail.com
 * @version V1.00 2013-9-12 
 */
public class ArgsTest {
    
    @Test
    public void args() {
        //a("a", "b", "c");
        //a(new String[]{"a", "b", "c"});
        b(ArgsTest.class);
    }
    
    public void a(String... args) {
        for (String s : args) {
            System.out.println(s);
        }
    }
    
    public void b(Class<?> clazz) {
        System.out.println(clazz);
    }

}

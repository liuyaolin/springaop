/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.hzins.springaop.server; 

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzins.springaop.area.service.AreaService;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月13日 下午3:36:58
 * @version      
 */
public class SpringAopServer {
    
    public static void main(String[] args) {
	 final ClassPathXmlApplicationContext context =
	                new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
	 AreaService AreaService = context.getBean(AreaService.class);
    }

}
 
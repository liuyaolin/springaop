/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.hzins.springaop; 

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzins.springaop.area.model.Area;
import com.hzins.springaop.area.redis.AreaRedis;
import com.hzins.springaop.area.service.AreaService;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月13日 下午3:34:24
 * @version      
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestAop {

    @Resource
    private AreaService areaService;
    
    @Test
    public void saveAreaTest(){
        Area a = new Area();
        a.setId(1);
        a.setName("testSpring aop");
	areaService.saveArea(a);
	System.out.println(AreaRedis.areaMap.get(1));
    }
    @Test
    public void getAreaTest(){
        Area a = new Area();
        a.setId(1);
        a.setName("testSpring aop");
	areaService.saveArea(a);
	areaService.getArea(1);
    }
    
}
 
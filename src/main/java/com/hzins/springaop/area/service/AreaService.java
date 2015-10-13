/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.hzins.springaop.area.service; 

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hzins.springaop.area.model.Area;
import com.hzins.springaop.area.persistence.AreaMapper;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月13日 下午3:38:10
 * @version      
 */
@Component
public class AreaService {
    
    @Resource
    private AreaMapper areaMapper;
    
    public Area saveArea(Area a){
	System.out.println("保存数据到数据库中");
	areaMapper.saveArea(a);
	throw new RuntimeException("哈哈哈");
//	return a;
    }
    
    public Area getArea(Integer id){
	System.out.println("从数据库中获取区域=====");
	return areaMapper.getAreaById(id);
    }

}
 
/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.hzins.springaop.area.persistence; 

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hzins.springaop.area.model.Area;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月13日 下午3:40:52
 * @version      
 */
@Component
public class AreaMapper {
    
    public static Map<Integer,Area> areaMap=new HashMap<Integer,Area>();
    
    public  Area saveArea(Area a){
	areaMap.put(a.getId(), a);
	return a;
    }
    
    public Area getAreaById(Integer id){
	return areaMap.get(id);
    }

}
 
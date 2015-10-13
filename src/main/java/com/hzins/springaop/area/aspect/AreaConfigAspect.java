/**
 * Copyright (c) 2006-2015 Hzins Ltd. All Rights Reserved. 
 *  
 * This code is the confidential and proprietary information of   
 * Hzins. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Hzins,http://www.hzins.com.
 *  
 */   
package com.hzins.springaop.area.aspect; 

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.hzins.springaop.area.redis.AreaRedis;

/**
 * <p>
 * 
 *
 *
 * </p>
 * @author	hz1412998 
 * @date	2015年10月13日 下午4:46:45
 * @version      
 */
@Component
public class AreaConfigAspect {
    
    public Object afterSave(Object retVal) {
	   String  json = JSONObject.toJSONString(retVal);
	   AreaRedis.areaMap.put(JSONObject.parseObject(json).getInteger("id"),retVal);
	   System.out.println("成功保存到redis缓存数据库");
	   return retVal;
    }
}
 
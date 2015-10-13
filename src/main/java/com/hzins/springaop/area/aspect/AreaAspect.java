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

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
 * @date	2015年10月13日 下午3:39:15
 * @version      
 */
//@Aspect
//@Component
public class AreaAspect {
       @Pointcut("execution(* com.hzins.*.area.service.AreaService.save*(..))")
	public void pointcutSave() {
		// 定义一个pointcut，下面用Annotation标注的通知方法可以公用这个pointcut
	}
       
       @Pointcut("execution(* com.hzins.*.area.service.AreaService.get*(..))")
	public void pointcutGet() {
	}
       
       @AfterReturning(value = "pointcutSave()",returning = "retVal")
       public Object afterSave(Object retVal) {
	   String  json = JSONObject.toJSONString(retVal);
	   AreaRedis.areaMap.put(JSONObject.parseObject(json).getInteger("id"),retVal);
	   System.out.println("成功保存到redis缓存数据库");
	   return retVal;
       }
       
       
    /*   @Around(value = "pointcutGet()")
	public Object aroundGet(ProceedingJoinPoint joinPoint) throws Throwable {
	   Object result =null;
	   if(joinPoint.getArgs()[0]!=null){
	       System.out.println("从redis缓存数据库中获取数据");
	       return AreaRedis.areaMap.get(joinPoint.getArgs()[0]);
	   }
		try {
		    result= joinPoint.proceed();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}*/
       
       @Before(value="pointcutGet()")
       public void beforeGet(JoinPoint point) throws Throwable {
	   System.out.println("请求参数为"+point.getArgs()[0]);
	   System.out.println("请求方法为"+point.getSignature());
       }
       
       @After(value = "pointcutSave()")
       public void afterSave(JoinPoint point) {
	   System.out.println("返回请求参数为"+point.getArgs()[0]);
	   System.out.println("返回请求方法为"+point.getSignature());
       }
       
       @AfterThrowing(value="pointcutSave()")
       public void afterExceptionSave(JoinPoint point) {
	   System.out.println("异常信息时请求参数为"+point.getArgs()[0]);
	   System.out.println("异常信息请求方法为"+point.getSignature());
       }
    
}
 
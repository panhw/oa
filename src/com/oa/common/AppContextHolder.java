package com.oa.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContextHolder implements ApplicationContextAware {
	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context=applicationContext;
	}
	
	public static ApplicationContext getContext(){
		if (null==context){
			System.out.println("----------------null context---------------");
			return null;
		}
		else return context;
	}

}

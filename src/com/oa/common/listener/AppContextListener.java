package com.oa.common.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.oa.common.AppContextHolder;
import com.oa.workflow.ProcessEngineHandler;

/**
 * spring启动监听器，监听spring启动，
 * @author sunxs
 */
public class AppContextListener implements ApplicationListener {
	private static Logger logger=LoggerFactory.getLogger(AppContextListener.class);

	public void onApplicationEvent(ApplicationEvent arg0) {
		//spring启动后需要执行的代码
		logger.info("--------------------spring 启动完成-------------------");
		AppContextHolder.getContext().getBean(ProcessEngineHandler.class).test();
	}



}

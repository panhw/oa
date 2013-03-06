package com.oa.common.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 运行（调用hibernate配置）手动生成 数据库
 * @author pan
 *
 */
public class ExportUtils {
	public static void main(String[] args) {
		//使用hibernate自动建表，每次部署应用时自动更新数据库
		
		
		
	/*	
	 * 该方法由于删除了hibernate.cfg.xml失效
		Configuration cfg = new Configuration().configure();
		
		SchemaExport e = new SchemaExport(cfg);
		
		e.create(true,	true);*/
		
	}
}

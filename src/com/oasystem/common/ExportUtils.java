package com.oasystem.common;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 运行（调用hibernate配置）手动生成 数据库
 * @author pan
 *
 */
public class ExportUtils {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		
		SchemaExport e = new SchemaExport(cfg);
		
		e.create(true,	true);
		
	}
}

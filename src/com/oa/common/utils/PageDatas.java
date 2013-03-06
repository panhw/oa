package com.oa.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类是帮助完成分页效果的辅助类，以面向对象的方式将分页的结果返回回来
 * @author sunxs
 * @param <T>	模板参数
 */

public class PageDatas<T> {

	/** 获得的分页的具体数据 **/
	private List<T> datas = new ArrayList<T>();
	/** 获得的总记录数 **/
	private long count;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}


}

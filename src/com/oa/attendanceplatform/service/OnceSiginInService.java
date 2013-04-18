package com.oa.attendanceplatform.service;

import java.util.Date;
import java.util.List;

import com.oa.attendanceplatform.entity.OnceSiginIn;

public interface OnceSiginInService {
	/**
	 * 添加一次签到
	 * @return 保存后的签到id
	 */
	String addOnceSiginIn(OnceSiginIn onceSiginIn);
	
	/**
	 * 列出签到历史
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @param count 需要查询的条目数量
	 * @return 签到list
	 */
	List<OnceSiginIn> listOnceSiginIn(Date startDate,Date endDate,int count);
	
}

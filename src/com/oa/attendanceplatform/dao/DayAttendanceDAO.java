package com.oa.attendanceplatform.dao;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

import com.oa.attendanceplatform.entity.DayAttendance;
import com.oa.common.BaseDAO;
import com.oa.common.utils.PageDatas;

@Component
public class DayAttendanceDAO extends BaseDAO<DayAttendance> {

	public PageDatas<DayAttendance> getPageDatas(int startIndex, int maxResult,
			String whereHQL, Object[] params,
			LinkedHashMap<String, String> orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

}

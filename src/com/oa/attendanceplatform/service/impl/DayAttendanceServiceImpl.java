package com.oa.attendanceplatform.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oa.attendanceplatform.dao.DayAttendanceDAO;
import com.oa.attendanceplatform.entity.AttendanceCount;
import com.oa.attendanceplatform.entity.DayAttendance;
import com.oa.attendanceplatform.service.DayAttendanceService;

@Component("dayAttendanceService")
public class DayAttendanceServiceImpl implements DayAttendanceService {
	@Autowired
	private DayAttendanceDAO dayAttendanceDAO;

	public String addDayAttendance(DayAttendance dayAtt) {
		dayAttendanceDAO.save(dayAtt);
		return dayAtt.getId();
	}

	public void updateDayAttendance(DayAttendance dayAtt) {
		dayAttendanceDAO.update(dayAtt);
	}

	public AttendanceCount countAttendance(Date startDate,Date endDate) {
		AttendanceCount count=new AttendanceCount();
		count.setStartDate(startDate);
		count.setEndDate(endDate);
		//FIXME 分页查询，哎，，，，，
		//dayAttendanceDAO.getSeperatePageData(0, 50, whereHQL, params, orderBy)
		return null;
	}

}

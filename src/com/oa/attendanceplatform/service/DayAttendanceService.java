package com.oa.attendanceplatform.service;

import java.util.Date;

import com.oa.attendanceplatform.entity.AttendanceCount;
import com.oa.attendanceplatform.entity.DayAttendance;

public interface DayAttendanceService {
	/**
	 * 添加日考勤
	 * @param dayAtt 日考勤
	 * @return 日考勤id
	 */
	String addDayAttendance(DayAttendance dayAtt);
	
	/**
	 * 修改日考勤
	 * @param dayAtt 日考勤
	 * @return true如果修改成功
	 */
	void updateDayAttendance(DayAttendance dayAtt);
	
	/**
	 * 考勤统计
	 * @param startDate 统计开始时间
	 * @param endDate 统计结束时间
	 * @return 考勤统计
	 */
	AttendanceCount countAttendance(Date startDate,Date endDAte);
}

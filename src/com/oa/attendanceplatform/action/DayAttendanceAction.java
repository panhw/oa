package com.oa.attendanceplatform.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.attendanceplatform.service.DayAttendanceService;
import com.oa.common.BaseAction;

@Component
public class DayAttendanceAction extends BaseAction {
	@Resource
	private DayAttendanceService dayAttendanceService;
	
	@ResponseBody
	public String testResponseBody(){
		return "hello wrold";
	}
}

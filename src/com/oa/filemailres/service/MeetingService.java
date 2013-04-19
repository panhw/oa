package com.oa.filemailres.service;

import com.oa.filemailres.entity.Meeting;

public interface MeetingService {

	/**
	 * 查询会议
	 * @param id
	 * @return
	 */
	public Meeting getMeeting(String id);
	/**
	 * 预约会议
	 * @param meeting
	 */
	public void addMeeting(Meeting meeting);
	/**
	 * 取消预约
	 * @param meeting
	 */
	public void remMeeting(Meeting meeting);
}

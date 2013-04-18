package com.oa.attendanceplatform;

import java.util.Date;

/**
 * 考勤常量
 * @author sunxs
 */
public class AttendanceConts {
	
	//系统常量
	
	/** 上班时间（小时，24小时制） */
	public static int START_WORK_HOUR=8;
	/** 上班时间（分钟） */
	public static int START_WORK_MINUTE=30;
	/** 下班时间（小时，24小时制） */
	public static int END_WORK_HOUR=18;
	/** 下班时间（分钟） */
	public static int END_WORK_MINUTE=0;
	
	//签到常量
	
	/** 签到类型：上班签到 */
	public static final String SIGN_TYPE_IN="sign_in";
	/** 签到类型：下班签到 */
	public static final String SIGN_TYPE_OUT="sign_out";
	
	//考勤状态
	
	/** 正常 */
	private static final String STATE_OK="ok";
	/** 迟到 */
	private static final String STATE_LATE="late";
	/** 早退 */
	private static final String STATE_LEAVW_EARLY="leave_early";
	/** 缺勤 */
	private static final String STATE_ABSENCE="absence";
	/** 请假 */
	private static final String STATE_LEAVE="leave";
	/** 出差 */
	private static final String STATE_BUSINESS_TRIP="business_trip";
	/** 其他正常情况 */
	private static final String STATE_OTHER_NORMAL="other_normal";
	/** 其他异常情况 */
	private static final String STATE_OTHER_UNUSUAL="other-unusal";
}

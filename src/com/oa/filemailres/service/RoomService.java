package com.oa.filemailres.service;

import com.oa.filemailres.entity.Room;

public interface RoomService {

	/**
	 * 查询会员室
	 * @param id
	 * @return
	 */
	public Room getRoom(String id);
	
	/**
	 * 新增会议室
	 * @param room
	 */
	public void AddRoom(Room room);
	
	/**
	 * 修改会议室
	 * @param room
	 */
	public void Update(Room room);
	
	/**
	 * 删除会议室
	 * @param room
	 */
	public void DelRoom(Room room);
}

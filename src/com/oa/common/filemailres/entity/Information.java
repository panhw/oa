package com.oa.filemailres.entity;

import java.util.Date;

import com.oa.personal.entity.Employee;



/**
 *  消息
 * @author pan
 *
 */
public class Information {

	/**
	 * 消息ID
	 */
	private String id;
	/**
	 * 发件人ID
	 */
	private Employee empSend;
	/**
	 * 所属人ID
	 */
	private Employee emp;
	/**
	 * 收件人ID
	 */
	private Employee empReceiver;
	
	/**
	 * 主题
	 */
	private String topical;
	/**
	 * 消息内容
	 */
	private String info;
	/**
	 * 是否是群邮件  0 群  1收  2 草稿邮件  3发
	 */
	private String manystate;
	/**
	 * 发件时间
	 */
	private Date date;
	/**
	 * 邮件状态  0已读 1未读
	 */
	private String status;
	/**
	 * 邮件状态 0 删除 1正常
	 */
	private String state;
	/**
	 * 扩展功能 未定义
	 */
	private String undifined;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Employee getEmpSend() {
		return empSend;
	}
	public void setEmpSend(Employee empSend) {
		this.empSend = empSend;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Employee getEmpReceiver() {
		return empReceiver;
	}
	public void setEmpReceiver(Employee empReceiver) {
		this.empReceiver = empReceiver;
	}
	public String getTopical() {
		return topical;
	}
	public void setTopical(String topical) {
		this.topical = topical;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getManystate() {
		return manystate;
	}
	public void setManystate(String manystate) {
		this.manystate = manystate;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUndifined() {
		return undifined;
	}
	public void setUndifined(String undifined) {
		this.undifined = undifined;
	}
	@Override
	public String toString() {
		return "Information [id=" + id + ", empSend=" + empSend + ", emp="
				+ emp + ", empReceiver=" + empReceiver + ", topical=" + topical
				+ ", info=" + info + ", manystate=" + manystate + ", date="
				+ date + ", status=" + status + ", state=" + state
				+ ", undifined=" + undifined + "]";
	}
	
}

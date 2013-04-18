package com.oa.workflow.leave.action;

import org.springframework.stereotype.Controller;

import com.oa.common.BaseAction;

/**
 * leaveAction
 * @author sunxs
 */
@Controller
public class LeaveAction extends BaseAction {
	
	public String leaveApply(){
		return "applyLeave";
	}
	
	public String backLeave(){
		return "backLeave";
	}
}

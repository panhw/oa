package com.oa.attendanceplatform.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oa.attendanceplatform.dao.OnceSiginInDAO;
import com.oa.attendanceplatform.entity.OnceSiginIn;
import com.oa.attendanceplatform.service.OnceSiginInService;

@Component("onceSiginInService")
public class OnceSiginInServiceImpl implements OnceSiginInService {
	@Autowired
	private OnceSiginInDAO onceSiginInDAO;

	public List<OnceSiginIn> listOnceSiginIn(Date startDate, Date endDate,
			int count) {
		// TODO 分页查询，哎！！
		return null;
	}

	public String addOnceSiginIn(OnceSiginIn onceSiginIn) {
		onceSiginInDAO.save(onceSiginIn);
		return onceSiginIn.getId();
	}

}

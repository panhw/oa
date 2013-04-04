package com.oa.filemailres.dao.impl;

import java.util.LinkedHashMap;

import com.oa.common.BaseDAO;
import com.oa.common.utils.PageDatas;
import com.oa.filemailres.dao.FileDao;
import com.oa.filemailres.entity.FileVO;

public class FileDaoImpl extends BaseDAO<FileVO> implements FileDao {

	public PageDatas<FileVO> getPageDatas(int startIndex, int maxResult,
			String whereHQL, Object[] params,
			LinkedHashMap<String, String> orderBy) {
		return null;
	}

}

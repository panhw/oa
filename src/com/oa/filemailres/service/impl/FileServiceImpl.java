package com.oa.filemailres.service.impl;

import java.util.List;

import com.oa.filemailres.dao.FileDao;
import com.oa.filemailres.entity.FileVO;
import com.oa.filemailres.service.FileService;
import com.oa.personal.entity.Employee;

public class FileServiceImpl implements FileService {

	private FileDao fileDao;
	public List<FileVO> findAllFolders(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<FileVO> findAllFiles(String fatherid) {
		// TODO Auto-generated method stub
		return null;
	}

	public FileVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(FileVO newFile) {
		// TODO Auto-generated method stub
		
	}

	public FileDao getFileDao() {
		return fileDao;
	}

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	
}

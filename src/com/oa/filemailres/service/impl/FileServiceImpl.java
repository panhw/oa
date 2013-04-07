package com.oa.filemailres.service.impl;

import java.util.List;

import com.oa.filemailres.dao.FileDao;
import com.oa.filemailres.entity.FileVO;
import com.oa.filemailres.service.FileService;
import com.oa.personal.entity.Employee;

public class FileServiceImpl implements FileService {

	private FileDao fileDao;
	
	public List<FileVO> findAllFolders(Employee emp) {
		return fileDao.findAllFolders(emp);
	}

	public List<FileVO> findAllFiles(String fatherid,int page) {
		
		return fileDao.findAllFiles(fatherid,page);
	}

	public FileVO findById(String id) {
		
		return fileDao.findById(id);
	}

	public void save(FileVO newFile) {
		fileDao.save(newFile);	
	}

	public FileDao getFileDao() {
		return fileDao;
	}

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	public List<FileVO> findAllFiles(Employee emp,int page) {
		
		return fileDao.findAllFiles(emp,page);
	}

	public int numAllFiles(Employee emp) {
		
		return fileDao.numAllFiles(emp);
	}

	public int numFiles(String fatherid) {
		
		return fileDao.numFiles(fatherid);
	}

	
}

package com.oa.filemailres.service;

import java.util.List;

import com.oa.filemailres.entity.FileVO;
import com.oa.personal.entity.Employee;

public interface FileService {

	/**
	 * 查找所有文件夹
	 * @param emp
	 * @return
	 */
	public List<FileVO> findAllFolders(Employee emp);
	
	/**
	 * 查找子文件
	 * @param folder
	 * @return
	 */
	public List<FileVO> findAllFiles(String fatherid);
	
	/**
	 * 根据ID获取文件文件夹
	 * @param id
	 * @return
	 */
	public FileVO findById(String id);

	/**
	 * 保存文件记录
	 * @param newFile
	 */
	public void save(FileVO newFile);
}

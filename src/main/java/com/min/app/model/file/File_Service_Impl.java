package com.min.app.model.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.min.app.dto.File_Dto;
import com.min.app.dto.User_Dto;
import com.min.app.model.user.User_IDao;
import com.min.app.model.user.User_Service_Impl;

@Repository
public class File_Service_Impl implements File_IService{
	@Autowired
	private File_IDao dao;
	
	private Logger logger = LoggerFactory.getLogger(File_Service_Impl.class);
	
	@Override
	@Transactional
	public boolean imageUp(File_Dto dto) {
		logger.info("imageUp"+dto);
		return dao.imageUp(dto);
		
	}

	@Override
	public boolean imageIn(String user_email) {
		return dao.imageIn(user_email);
	}

	@Override
	public File_Dto imageSe(int user_seq) {
		return dao.imageSe(user_seq);
	}

	

}

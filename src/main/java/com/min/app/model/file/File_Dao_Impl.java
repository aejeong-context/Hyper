package com.min.app.model.file;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.app.dto.File_Dto;
import com.min.app.dto.User_Dto;

@Repository
public class File_Dao_Impl implements File_IDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private final String NS = "com.min.app.model.file.";
	
	@Override
	public boolean imageIn(String user_email) {
		return session.insert(NS+"imageIn",user_email)>0?true:false;
	}

	@Override
	public boolean imageUp(File_Dto dto) {
		return session.update(NS+"imageUp",dto)>0?true:false;
	}

	@Override
	public File_Dto imageSe(int user_seq) {
		return session.selectOne(NS+"imageSe",user_seq);
	}

}

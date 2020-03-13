package com.min.app.model.user;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.app.dto.Setting_Dto;
import com.min.app.dto.User_Dto;

@Repository
public class User_Dao_Impl implements User_IDao{

	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.min.app.model.user.";
	
	@Override
	public boolean signUpUser(User_Dto dto) {
		return session.insert(NS+"signUpUser", dto)>0?true:false;
	}

	@Override
	public boolean signUpSetting(User_Dto dto) {
		return session.insert(NS+"signUpSetting",dto)>0?true:false;
	}

	@Override
	public User_Dto signIn(String user_email) {
		return session.selectOne(NS+"signIn", user_email);
	}

	@Override
	public boolean signDown(int user_seq) {
		return session.delete(NS+"signDown",user_seq)>0?true:false;
	}

	@Override
	public String emailCheck(String user_email) {
		return session.selectOne(NS+"emailCheck",user_email);
	}

	@Override
	public String nckCheck(String user_nck) {
		return session.selectOne(NS+"nckCheck",user_nck);
	}

	@Override
	public boolean resetPw(User_Dto dto) {
		return session.update(NS+"resetPw",dto)>0?true:false;
	}

	@Override
	public boolean resetNck(User_Dto dto) {
		return session.update(NS+"resetNck",dto)>0?true:false;
	}

	@Override
	public String selectSm(int user_seq) {
		return session.selectOne(NS+"selectSm",user_seq);
	}

	@Override
	public boolean updateSm(Setting_Dto dto) {
		return session.update(NS+"updateSm",dto)>0?true:false;
	}

	@Override
	public String selectTm(int setting_theme) {
		return session.selectOne(NS+"selectTm",setting_theme);
	}

	@Override
	public boolean updateTm(Setting_Dto dto) {
		return session.update(NS+"updateTm",dto)>0?true:false;
	}
	
}

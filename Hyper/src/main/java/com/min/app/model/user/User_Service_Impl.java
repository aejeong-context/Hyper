package com.min.app.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.min.app.dto.Setting_Dto;
import com.min.app.dto.User_Dto;

@Repository
public class User_Service_Impl implements User_IService{
	
	@Autowired
	private User_IDao dao;
	
	@Override
	@Transactional
	public boolean signUp(User_Dto dto) {
		int cnt = 0;
		
		if (dao.signUpUser(dto)) {
			cnt++;
		};
		
		if (dao.signUpSetting(dto)) {
			cnt++;
		}
		
		return (cnt==2)?true:false;
	}

	@Override
	public int signIn(User_Dto dto) {
		return dao.signIn(dto);
	}

	@Override
	public boolean signDown(int user_seq) {
		return dao.signDown(user_seq);
	}

	@Override
	public String emailCheck(String user_email) {
		return dao.emailCheck(user_email);
	}

	@Override
	public String nckCheck(String user_nck) {
		return dao.nckCheck(user_nck);
	}

	@Override
	public boolean resetPw(User_Dto dto) {
		return dao.resetPw(dto);
	}

	@Override
	public boolean resetNck(User_Dto dto) {
		return dao.resetNck(dto);
	}

	@Override
	public String selectSm(int user_seq) {
		return dao.selectSm(user_seq);
	}

	@Override
	public boolean updateSm(Setting_Dto dto) {
		return dao.updateSm(dto);
	}

	@Override
	public String selectTm(int setting_theme) {
		return dao.selectTm(setting_theme);
	}

	@Override
	public boolean updateTm(Setting_Dto dto) {
		return dao.updateTm(dto);
	}

}

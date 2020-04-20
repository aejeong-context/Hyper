package com.min.app.model.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.min.app.dto.Login_Dto;
import com.min.app.dto.Setting_Dto;
import com.min.app.dto.User_Dto;
import com.min.app.model.event.Event_IDao;
import com.min.app.model.event.Event_IService;

@Repository
public class User_Service_Impl implements User_IService{
	
	private Logger logger = LoggerFactory.getLogger(User_Service_Impl.class);
	
	@Autowired
	private User_IDao dao;
	
	@Autowired
	private Event_IService eService;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Override
	@Transactional
	public boolean signUp(User_Dto dto) {
		int cnt = 0;
		
		if (dao.signUpUser(dto)) {
			cnt++;
		};
		
		if (dao.signUpSetting(dto)) {
			cnt++;
		};
		
		Setting_Dto sDto = dao.getSettingInfo(dto.getSetting_nck());
		
		if (eService.settingKey(sDto.getUser_seq())) {
			cnt++;
		};
		
		return (cnt==3)?true:false;
	}

	@Override
	public Login_Dto signIn(String user_email, String password) {
		Login_Dto lDTO = new Login_Dto();
		User_Dto uDTO = dao.signIn(user_email);
		
		// 이메일이 존재한다면
		if(uDTO != null) {
			// 비밀번호 대조
			boolean passMatch = passEncoder.matches(password,uDTO.getUser_pw());
			if (passMatch) {
				logger.info("User_Service_impl.signIn() - "+uDTO.getSetting_nck()+"님 로그인");
				lDTO.setUser_dto(uDTO);
				lDTO.setResult(true);
				return lDTO;
			}
		}
		logger.info("User_Service_impl.signIn() - 로그인 실패");
		lDTO.setResult(false);
		
		return lDTO;
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
	public String[] selectUserSet(int user_seq) {
		String message = dao.selectSm(user_seq);
		if (message=="") {
			message="상태메시지가 설정되지 않았습니다.";
		}
		String [] arUserSet = {message,dao.selectTm(user_seq)};
		return arUserSet;
	}

	@Override
	@Transactional
	public boolean updateUserSet(Setting_Dto dto) {
		int cnt = 0;
		
		if (dao.updateSm(dto)) {
			cnt++;
		}
		if (dao.updateTm(dto)) {
			cnt++;
		}
		
		return cnt==2?true:false;
	}

	@Override
	public Setting_Dto getSettingInfo(String nickname) {
		return dao.getSettingInfo(nickname);
	}

}

package com.min.app.model.user;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.app.dto.Login_Dto;
import com.min.app.dto.Setting_Dto;
import com.min.app.dto.User_Dto;

@Service
public interface User_IService {

//	닉네임으로 셋팅정보 가져오기
	public Setting_Dto getSettingInfo(String nickname);
	
//	회원가입
	public boolean signUp(User_Dto dto);

//	로그인                    
	public Login_Dto signIn(String user_email, String password);

//	회원탈퇴
	public boolean signDown(int user_seq);

//	이메일 중복검사
	public String emailCheck(String user_email);

//	닉네임 중복검사
	public String nckCheck(String user_nck);

//	비밀번호 재설정
	public boolean resetPw(User_Dto dto);

//	닉네임 재설정
	public boolean resetNck(User_Dto dto);
	
//	상태메시지 및 테마 조회
	public String[] selectUserSet(int user_seq);
	
//	상태메시지 및 테마 변경
	public boolean updateUserSet(Setting_Dto dto);
	
}

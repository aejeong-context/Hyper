package com.min.app.model.user;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.app.dto.Setting_Dto;
import com.min.app.dto.User_Dto;

@Service
public interface User_IDao {
	
//	닉네임으로 셋팅정보 가져오기
	public Setting_Dto getSettingInfo(String nickname);
	
//	회원가입
	public boolean signUpUser(User_Dto dto);

	public boolean signUpSetting(User_Dto dto);

//	로그인                    
	public User_Dto signIn(String user_email);

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
	
//	상태메시지 조회
	public String selectSm(int user_seq);
	
//	상태메시지 수정
	public boolean updateSm(Setting_Dto dto);
	
//	테마 조회
	public String selectTm(int user_seq);
	
//	테마 변경
	public boolean updateTm(Setting_Dto dto);
	
}

package com.min.app.model.file;

import org.springframework.stereotype.Service;

import com.min.app.dto.File_Dto;
import com.min.app.dto.User_Dto;

@Service
public interface File_IService {

//  이미지 수정
	public boolean imageUp(File_Dto dto);
	
//	이미지 기본셋팅
	public boolean imageIn(String user_email);
	
//  이미지 이름 가져오기
	public File_Dto imageSe(int user_seq);
	
}

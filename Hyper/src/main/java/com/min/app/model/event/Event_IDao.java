package com.min.app.model.event;

import java.util.List;

import org.springframework.stereotype.Service;

import com.min.app.dto.Day_Dto;
import com.min.app.dto.Key_Dto;

@Service
public interface Event_IDao {
//	단축키 생성
	public boolean settingKey(Key_Dto dto);
	
//	단축키 조회
	public List<Key_Dto> selectKey(int user_seq);
	
//	단축키 수정
	public boolean updateKey(Key_Dto dto);
	
//	디데이 생성
	public boolean insertDay(Day_Dto dto);
	
//	디데이 조회
	public List<Day_Dto> selectDay(int user_seq);
	
//	디데이 수정
	public boolean updateDay(Day_Dto dto);
	
//	디데이 삭제
	public boolean deleteDay(int key_seq);

}

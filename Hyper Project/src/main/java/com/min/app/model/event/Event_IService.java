package com.min.app.model.event;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.app.dto.Day_Dto;
import com.min.app.dto.Key_Dto;
import com.min.app.dto.Memo_Dto;

@Service
public interface Event_IService {
//	단축키 생성
	public boolean settingKey(int user_seq);
	
//	단축키 조회
	public Map<String,String[]> selectKey(int user_seq);
	
//	단축키 수정
	public boolean updateKey(Key_Dto dto);

//	디데이 생성
	public boolean insertDay(Day_Dto dto);
	
//	디데이 조회
	public List<Day_Dto> selectDay(int user_seq);
	
//	디데이 수정
	public boolean updateDay(Day_Dto dto);
	
//	디데이 삭제
	public boolean deleteDay(int day_seq);
	
//  메모 조회
	public List<Memo_Dto> getMemo(int user_seq);

//  메모 작성
	public boolean setMemo(Memo_Dto dto);
	
//  메모 삭제
	public boolean removeMemo(int memo_seq);

}

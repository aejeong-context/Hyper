package com.min.app.model.event;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.app.dto.Day_Dto;
import com.min.app.dto.Key_Dto;

@Repository
public class Event_Dao_Impl implements Event_IDao{

	@Autowired
	private SqlSessionTemplate session;
	
	private final String NS="com.min.app.model.user.";

	@Override
	public boolean settingKey(Key_Dto dto) {
		return session.insert(NS+"settingKey",dto)>0?true:false;
	}

	@Override
	public List<Key_Dto> selectKey(int user_seq) {
		return session.selectList(NS+"selectKey",user_seq);
	}

	@Override
	public boolean updateKey(Key_Dto dto) {
		return session.update(NS+"updateKey",dto)>0?true:false;
	}

	@Override
	public boolean insertDay(Day_Dto dto) {
		return session.insert(NS+"insertDay", dto)>0?true:false;
	}

	@Override
	public List<Day_Dto> selectDay(int user_seq) {
		return session.selectList(NS+"selectDay", user_seq);
	}

	@Override
	public boolean updateDay(Day_Dto dto) {
		return session.update(NS+"updateDay", dto)>0?true:false;
	}

	@Override
	public boolean deleteDay(int key_seq) {
		return session.delete(NS+"deleteDay", key_seq)>0?true:false;
	}
	
}

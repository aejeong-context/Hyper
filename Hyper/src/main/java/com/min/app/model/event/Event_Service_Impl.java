package com.min.app.model.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.min.app.dto.Day_Dto;
import com.min.app.dto.Key_Dto;

@Repository
public class Event_Service_Impl implements Event_IService{

	@Autowired
	private Event_IDao dao;

	@Override
	@Transactional
	public boolean settingKey(int user_seq) {
		int cnt = 0;
		String [] arKey = {"Q","W","E","R","T","Y","U","I","O","P",
				"A","S","D","F","G","H","J","K","L",
				"Z","X","C","V","B","N","M"};

		for (int i = 0; i < arKey.length; i++) {
			Key_Dto dto = new Key_Dto(user_seq, arKey[i], "", "", (i+1));
			
			if (dao.settingKey(dto)) {
				cnt++;
			}
		}
		return (cnt==arKey.length)?true:false;
	}

	@Override
	public List<Key_Dto> selectKey(int user_seq) {
		return dao.selectKey(user_seq);
	}

	@Override
	public boolean updateKey(Key_Dto dto) {
		return dao.updateKey(dto);
	}

	@Override
	public boolean insertDay(Day_Dto dto) {
		return dao.insertDay(dto);
	}

	@Override
	public List<Day_Dto> selectDay(int user_seq) {
		return dao.selectDay(user_seq);
	}

	@Override
	public boolean updateDay(Day_Dto dto) {
		return dao.updateDay(dto);
	}

	@Override
	public boolean deleteDay(int key_seq) {
		return dao.deleteDay(key_seq);
	}

}

package com.min.app.model.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.min.app.dto.Day_Dto;
import com.min.app.dto.Key_Dto;
import com.min.app.dto.Memo_Dto;

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
	public Map<String,String[]> selectKey(int user_seq) {
		Map<String,String[]> map = new HashMap<String, String[]>();
		List<Key_Dto> kList = dao.selectKey(user_seq);
		// 하나씩 꺼내기
		String arKey[] = new String[26];
		String arIcon[] = new String[26];
		String arLink[] = new String[26];
		int cnt = 0;
		for (Key_Dto kDto : kList) {
			// 스트링 배열에 담기
			arKey[cnt] = kDto.getLink_key();
			arIcon[cnt] = kDto.getLink_icon();
			arLink[cnt] = kDto.getLink_url();
			cnt++;
		}
		
		// 맵에 스트링 배열 담기
		map.put("key", arKey);
		map.put("icon", arIcon);
		map.put("link", arLink);
		
		return map;
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
		List<Day_Dto> list = dao.selectDay(user_seq);
		if (list!=null) {
			//포멧 형식 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatter2 = new SimpleDateFormat("yy.MM.dd");
			//현재 날짜
			String nowTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			//현재날짜 포멧형식 적용
			Date beginDate;
			try {
				beginDate = formatter.parse(nowTime);
		
	
				for(int i=0;i<list.size();i++) {
					//사용자 날짜 포멧형식 적용
					Date endDate = formatter.parse(list.get(i).getDay_date());
					//날짜 계산
					long diff = beginDate.getTime()-endDate.getTime();
					
					//시간, 분, 초를 곱한 값으로 나누어 하루 단위
					long diffDays = diff / (24*60*60*1000);
					String Days = diffDays>0?"+"+diffDays:diffDays+"";
					
					//결과 String으로 변경후 Ddto에 저장
					Date oldDateObj = formatter.parse(list.get(i).getDay_date());
					String oldDate = formatter2.format(oldDateObj);
					
					list.get(i).setDay_oldDate(oldDate);
					list.get(i).setDay_date(Days);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean updateDay(Day_Dto dto) {
		return dao.updateDay(dto);
	}

	@Override
	public boolean deleteDay(int day_seq) {
		return dao.deleteDay(day_seq);
	}

	@Override
	public List<Memo_Dto> getMemo(int user_seq) {
		return dao.getMemo(user_seq);
	}

	/*
	 * Memo_Dto : USER_SEQ,MEMO_CON
	 */
	@Override
	public boolean setMemo(Memo_Dto dto) {
		return dao.setMemo(dto);
	}

	@Override
	public boolean removeMemo(int memo_seq) {
		return dao.removeMemo(memo_seq);
	}
	
}

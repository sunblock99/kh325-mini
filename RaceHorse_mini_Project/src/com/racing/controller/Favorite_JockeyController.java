package com.racing.controller;

import java.util.List;

import com.racing.model.service.Favorite_JockeyService;
import com.racing.model.service.JockeyService;
import com.racing.model.vo.Favorite_Jockey;
import com.racing.model.vo.Jockey;

public class Favorite_JockeyController {

	private Favorite_JockeyService favorite_JockeyService = new Favorite_JockeyService();
	private JockeyService jockeyservice = new JockeyService();

	public List<Favorite_Jockey> selectAll(int uNo) {
		return favorite_JockeyService.selectAll(uNo);
	}

	public List<Favorite_Jockey> selectByName(int uNo, String jockeyName) {
		return favorite_JockeyService.selectByName(uNo, jockeyName);
	}

	public List<Favorite_Jockey> selectByJockeyNumber(int uNo, String jockeyNum) {
		return favorite_JockeyService.selectByJockeyNumber(uNo, jockeyNum);
	}

	// 기수번호로 검색 후 insert
	public int insert(int UNO, String jkno) {
		return favorite_JockeyService.insert(UNO, jkno);
	}

	// 기수명으로 검색 후 insert
	public int insertJockeyName(int UNO, String jkname) {
		List<Jockey> list = jockeyservice.selectByJkName(jkname);
		for (Jockey jockey : list) {
			return favorite_JockeyService.insert(UNO, jockey.getJkNo());
		}
		return -1;
	}

	// 기수번호로 검색 후 delete
	public int delete(int UNO, String jkno) {
		return favorite_JockeyService.delete(UNO, jkno);
	}

	// 기수명으로 검색 후 delete
	public int deleteJockeyName(int UNO, String jkname) {
		List<Jockey> list = jockeyservice.selectByJkName(jkname);
		for (Jockey jockey : list) {
			return favorite_JockeyService.delete(UNO, jockey.getJkName());
		}
		return -1;
	}
}

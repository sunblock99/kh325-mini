package com.racing.controller;

import java.util.List;

import com.racing.model.service.Favorite_HorseService;
import com.racing.model.service.RaceHorseService;
import com.racing.model.vo.Favorite_Horse;
import com.racing.model.vo.RaceHorse;

public class Favorite_HorseController {
	private Favorite_HorseService favorite_HorseService = new Favorite_HorseService();
	private RaceHorseService raceHorseService = new RaceHorseService();

	public List<Favorite_Horse> selectAll(int uNo) {
		return favorite_HorseService.selectAll(uNo);
	}

	public List<Favorite_Horse> selectByName(int uNo, String horseName) {
		return favorite_HorseService.selectByName(uNo, horseName);
	}

	public List<Favorite_Horse> selectByHorseNumber(int uNo, String horseNum) {
		return favorite_HorseService.selectByHorseNumber(uNo, horseNum);
	}

	// 마번으로 검색 후 insert
	public int insert(int UNO, String hrNo) {
		return favorite_HorseService.insert(UNO, hrNo);
	}

	// 마명으로 검색 후 insert
	public int insertHorseName(int UNO, String hrName) {
		List<RaceHorse> list = raceHorseService.selectByHorseName(hrName);
		for (RaceHorse h : list) {
			return favorite_HorseService.insert(UNO, h.getHrNo());
		}
		return -1;
	}

	// 마번으로 검색 후 delete
	public int delete(int UNO, String hrNo) {
		return favorite_HorseService.delete(UNO, hrNo);
	}

	// 마명으로 검색 후 delete
	public int deleteHorseName(int UNO, String hrName) {
		List<RaceHorse> list = raceHorseService.selectByHorseName(hrName);
		for (RaceHorse h : list) {
			return favorite_HorseService.delete(UNO, h.getHrNo());
		}
		return -1;
	}
}

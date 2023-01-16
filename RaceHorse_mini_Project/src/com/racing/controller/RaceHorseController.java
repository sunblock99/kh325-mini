package com.racing.controller;

import java.util.List;

import com.racing.api.RaceHorseOpenApiManager;
import com.racing.model.service.RaceHorseService;
import com.racing.model.vo.RaceHorse;

public class RaceHorseController {
	private RaceHorseService RaceHorseService = new RaceHorseService();

	public void initRaceHorse() {
		while (true) {
			List<RaceHorse> list = RaceHorseOpenApiManager.callRaceHorseOpenListByXML();

			if (list == null || list.isEmpty()) {
				continue;
			}
			int count = 0;
			for (RaceHorse box : list) {
				if (count++ % 10 == 0) {
					System.out.println(count);
				}
				RaceHorseService.insert(box);
			}
		}
	}

	public List<RaceHorse> getAllMvList() {
		return RaceHorseService.selectAll();
	}

	public List<RaceHorse> selectByHorseNo(String horseNo) {
		return RaceHorseService.selectByHorseNo(horseNo);
	}

	public List<RaceHorse> selectByHorseName(String horseName) {
		return RaceHorseService.selectByHorseName(horseName);
	}

	public List<RaceHorse> selectByrcCntT() {
		return RaceHorseService.selectByrcCntT();
	}

	public List<RaceHorse> selectByhrLastAmt() {
		return RaceHorseService.selectByhrLastAmt();
	}

	public List<RaceHorse> selectBychaksunT() {
		return RaceHorseService.selectBychaksunT();
	}

	public static void main(String[] args) {
		RaceHorseController controller = new RaceHorseController();
		controller.initRaceHorse();
	}
}

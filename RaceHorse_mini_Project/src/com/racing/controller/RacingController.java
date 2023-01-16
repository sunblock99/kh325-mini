package com.racing.controller;

import java.util.List;

import com.racing.api.RacingOpenApiManager;
import com.racing.model.service.RacingService;
import com.racing.model.vo.Racing;

public class RacingController {
	RacingService racingService = new RacingService();

	public void initRacing() {
		while (true) {
			List<Racing> list = RacingOpenApiManager.callRacingListByXML();

			if (list == null || list.isEmpty()) {
				continue;
			}

			for (Racing box : list) {
				System.out.println(box);
				racingService.insert(box);
			}
		}
	}

	public List<Racing> selectDateNo(String rcDate, int rcNo) {
		return racingService.selectDateNo(rcDate, rcNo);
	}

	public List<Racing> selectByHrName(String hrName) {
		return racingService.selectByHrName(hrName);
	}

	public List<Racing> selectByJkName(String JkName) {
		return racingService.selectByJkName(JkName);

	}

	public List<Racing> selectDate(String rcDate) {
		return racingService.selectDate(rcDate);
	}

	public static void main(String[] args) {
		RacingController controller = new RacingController();
		controller.initRacing();
	}

}

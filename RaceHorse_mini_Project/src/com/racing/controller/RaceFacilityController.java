package com.racing.controller;

import java.util.List;

import com.racing.api.RaceFacilityOpenApiManager;
import com.racing.model.service.RaceFacilityService;
import com.racing.model.vo.RaceFacility;

public class RaceFacilityController {
	private RaceFacilityService RaceFacilityService = new RaceFacilityService();

	public void initRaceFacility() {

		while (true) {
			List<RaceFacility> list = RaceFacilityOpenApiManager.callRaceFacilityListByXML();

			if (list == null || list.isEmpty()) {
				continue;
			}

			for (RaceFacility box : list) {
				System.out.println(box);
				RaceFacilityService.insert(box);
			}
		}
	}

	public List<RaceFacility> selectBySearchFltTitle(String facTitle) {
		return RaceFacilityService.selectBySearchFltTitle(facTitle);
	}

	public List<RaceFacility> selectByBuyTicket() {
		return RaceFacilityService.selectByBuyTicket();
	}

	public List<RaceFacility> selectByFood() {
		return RaceFacilityService.selectByFood();
	}

	public List<RaceFacility> selectBySee() {
		return RaceFacilityService.selectBySee();
	}

	public List<RaceFacility> selectByFun() {
		return RaceFacilityService.selectByFun();
	}

	public List<RaceFacility> selectByFac() {
		return RaceFacilityService.selectByFac();
	}

	public List<RaceFacility> selectByMemOnly() {
		return RaceFacilityService.selectByMemOnly();
	}

	public List<RaceFacility> selectByEtc() {
		return RaceFacilityService.selectByEtc();
	}

	public static void main(String[] args) {
		RaceFacilityController controller = new RaceFacilityController();
		controller.initRaceFacility();
	}
}

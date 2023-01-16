package com.racing.controller;

import java.util.List;

import com.racing.api.jockeyApiManager;
import com.racing.model.service.JockeyService;
import com.racing.model.vo.Jockey;

public class JockeyController {

	private JockeyService jockeyService = new JockeyService();

	public void initJockey() {

		while (true) {
			List<Jockey> list = jockeyApiManager.callCurrentJockeyInfoByXML();

			if (list == null || list.isEmpty()) {
				continue;
			}

			for (Jockey jockey : list) {
				jockeyService.insert(jockey);
			}
		}
	}

	public List<Jockey> selectAll() {
		return jockeyService.selectAll();
	}

	public List<Jockey> selectByJkNo(String jockeyNum) {
		return jockeyService.selectByJkNo(jockeyNum);
	}

	public List<Jockey> selectByJkName(String JockeyName) {
		return jockeyService.selectByJkName(JockeyName);
	}

	public List<Jockey> rankedByRcCntT() {
		return jockeyService.rankedByRcCntT();
	}

	public List<Jockey> rankedByOrd1CntT() {
		return jockeyService.rankedByOrd1CntT();
	}

	public static void main(String[] args) {
		JockeyController jc = new JockeyController();

		jc.initJockey();
	}
}

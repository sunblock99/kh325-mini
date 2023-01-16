package com.racing.model.service;

import static com.racing.common.JDBCTemplate.*;
import static com.racing.common.JDBCTemplate.openConnection;
import static com.racing.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.racing.model.dao.RaceHorseDao;
import com.racing.model.vo.RaceHorse;

public class RaceHorseService {
	private RaceHorseDao dao = new RaceHorseDao();
	private Connection conn = null;

	public RaceHorseService() {
		conn = openConnection();
	}

	public List<RaceHorse> selectAll() {
		return dao.selectAll(conn);
	}

	public List<RaceHorse> selectByHorseNo(String horseNo) {
		return dao.selectByHorseNo(conn, horseNo);
	}

	public List<RaceHorse> selectByHorseName(String horseName) {
		return dao.selectByHorseName(conn, horseName);
	}

	public List<RaceHorse> selectByrcCntT() {
		return dao.selectByrcCntT(conn);
	}

	public List<RaceHorse> selectByhrLastAmt() {
		return dao.selectByhrLastAmt(conn);
	}

	public List<RaceHorse> selectBychaksunT() {
		return dao.selectBychaksunT(conn);
	}

	public int insert(RaceHorse raceHorse) {
		Connection conn2 = openConnection();
		int result = dao.insert(conn2, raceHorse);
		if (result > 0) {
			commit(conn2);
		} else {
			rollback(conn2);
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		close(conn2);
		return result;
	}

}

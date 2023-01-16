package com.racing.model.service;

import static com.racing.common.JDBCTemplate.commit;
import static com.racing.common.JDBCTemplate.openConnection;
import static com.racing.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.racing.model.dao.RacingDao;
import com.racing.model.vo.Racing;

public class RacingService {
	private RacingDao racingDao = new RacingDao();
	private Connection conn = null;

	public RacingService() {
		conn = openConnection();
	}

	public List<Racing> selectDateNo(String rcDate, int rcNo) {
		return racingDao.selectDateNo(conn, rcDate, rcNo);
	}

	public List<Racing> selectByHrName(String hrName) {
		return racingDao.selectByHrName(conn, hrName);
	}

	public List<Racing> selectByJkName(String JkName) {
		return racingDao.selectByJkName(conn, JkName);
	}

	public List<Racing> selectDate(String rcDate) {
		return racingDao.selectDate(conn, rcDate);
	}

	public int insert(Racing racing) {
		int result = racingDao.insert(conn, racing);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

}

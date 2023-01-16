package com.racing.model.service;

import static com.racing.common.JDBCTemplate.close;
import static com.racing.common.JDBCTemplate.commit;
import static com.racing.common.JDBCTemplate.openConnection;
import static com.racing.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.racing.model.dao.RaceFacilityDao;
import com.racing.model.vo.RaceFacility;

public class RaceFacilityService {
	private RaceFacilityDao dao = new RaceFacilityDao();
	private Connection conn = null;

	public RaceFacilityService() {
		conn = openConnection();
	}

	public List<RaceFacility> selectBySearchFltTitle(String facTitle) {
		return dao.selectBySearchFltTitle(conn, facTitle);
	}

	public List<RaceFacility> selectByBuyTicket() {
		return dao.selectByBuyTicket(conn);
	}

	public List<RaceFacility> selectByFood() {
		return dao.selectByFood(conn);
	}

	public List<RaceFacility> selectBySee() {
		return dao.selectBySee(conn);
	}

	public List<RaceFacility> selectByFun() {
		return dao.selectByFun(conn);
	}

	public List<RaceFacility> selectByFac() {
		return dao.selectByFac(conn);
	}

	public List<RaceFacility> selectByMemOnly() {
		return dao.selectByMemOnly(conn);
	}

	public List<RaceFacility> selectByEtc() {
		return dao.selectByEtc(conn);
	}

	public int insert(RaceFacility raceFacility) {
		Connection conn2 = openConnection();
		int result = dao.insert(conn2, raceFacility);
		if (result > 0) {
			commit(conn2);
		} else {
			rollback(conn2);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		close(conn2);
		return result;
	}

}

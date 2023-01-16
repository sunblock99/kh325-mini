package com.racing.model.service;

import static com.racing.common.JDBCTemplate.commit;
import static com.racing.common.JDBCTemplate.openConnection;
import static com.racing.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.racing.model.dao.jockeyDao;
import com.racing.model.vo.Jockey;

public class JockeyService {
	private jockeyDao dao = new jockeyDao();
	private Connection conn = null;

	public JockeyService() {
		conn = openConnection();
	}

	public List<Jockey> selectAll() {
		return dao.selectAll(conn);
	}

	public int insert(Jockey jockey) {
		int result = dao.insert(conn, jockey);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public List<Jockey> selectByJkName(String JockeyName) {
		return dao.selectByJkName(conn, JockeyName);
	}

	public List<Jockey> selectByJkNo(String jockeyNum) {
		return dao.selectByJkNo(conn, jockeyNum);
	}

	public List<Jockey> rankedByRcCntT() {
		return dao.rankedByRcCntT(conn);
	}

	public List<Jockey> rankedByOrd1CntT() {
		return dao.rankedByOrd1CntT(conn);
	}
}

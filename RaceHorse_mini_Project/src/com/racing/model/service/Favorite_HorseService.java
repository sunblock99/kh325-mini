package com.racing.model.service;

import static com.racing.common.JDBCTemplate.commit;
import static com.racing.common.JDBCTemplate.openConnection;
import static com.racing.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.racing.model.dao.FavoriteDao_Horse;
import com.racing.model.vo.Favorite_Horse;

public class Favorite_HorseService {
	private FavoriteDao_Horse favoriteDao_Horse = new FavoriteDao_Horse();
	private Connection conn = null;

	public Favorite_HorseService() {
		conn = openConnection();
	}

	public List<Favorite_Horse> selectAll(int uNo) {
		return favoriteDao_Horse.selectAll(conn, uNo);
	}

	public List<Favorite_Horse> selectByName(int uNo, String horseName) {
		return favoriteDao_Horse.selectByName(conn, uNo, horseName);
	}

	public List<Favorite_Horse> selectByHorseNumber(int uNo, String horseNum) {
		return favoriteDao_Horse.selectByHorseNumber(conn, uNo, horseNum);
	}


	// 마번으로 검색 후 insert
	public int insert(int UNO, String hrNo) {
		int result = favoriteDao_Horse.insert(conn, UNO, hrNo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	// 마번으로 검색 후 delete
	public int delete(int UNO, String hrNo) {
		int result = favoriteDao_Horse.delete(conn, UNO, hrNo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

}

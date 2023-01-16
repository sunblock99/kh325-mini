package com.racing.model.dao;

import static com.racing.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.racing.model.vo.Favorite_Horse;

public class FavoriteDao_Horse {

	public List<Favorite_Horse> selectAll(Connection conn, int uNo) {
		// 즐겨찾기 목록 전체출력
		// 내가 말즐겨찾기에서 출력하고 싶은 칼럼 => 즐겨찾기 번호 /회원번호 / 마번/ 마명
		List<Favorite_Horse> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT FH.UNO, FH.hrNo, H.hrName\r\n"
					+ "FROM FAVORITE_HORSE FH, USERINFO U, HORSE_INFO H\r\n"
					+ "WHERE FH.hrNo = H.hrNo AND FH.UNO = U.UNO and fh.uno = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uNo);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int UNO = rs.getInt("UNO");
				String hrNo = rs.getString("hrNo");
				String hrName = rs.getString("hrName");
				Favorite_Horse fvh = new Favorite_Horse(UNO, hrNo, hrName);
				list.add(fvh);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}

	public List<Favorite_Horse> selectByName(Connection conn, int uNo, String horseName) {
		// 즐겨찾기 테이블에서 말이름를 입력받아서 해당하는 즐겨찾기 한 회원번호/마명/마번/생년월일 출력
		List<Favorite_Horse> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT u.uno, H.hrName, H.hrNo, H.birthday "
					+ "FROM FAVORITE_HORSE FH, USERINFO U, HORSE_INFO H "
					+ "WHERE FH.hrNo = H.hrNo AND FH.UNO = U.UNO AND fh.uno = ? AND H.hrName = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uNo);
			pstmt.setString(2, horseName);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int UNO = rs.getInt("UNO");
				String hrName = rs.getString("hrName");
				String hrNo = rs.getString("hrNo");
				String birthday = rs.getString("birthday");
				Favorite_Horse fvh = new Favorite_Horse(UNO, hrName, hrNo, birthday);
				list.add(fvh);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}

	public List<Favorite_Horse> selectByHorseNumber(Connection conn, int uNo, String horseNum) {
		// 즐겨찾기 테이블에서 마번을 입력받아서 해당하는 즐겨찾기 한 회원번호/마명/마번/생년월일 출력
		List<Favorite_Horse> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT u.uno, H.hrName, H.hrNo, H.birthday "
					+ "FROM FAVORITE_HORSE FH, USERINFO U, HORSE_INFO H "
					+ "WHERE FH.hrNo = H.hrNo AND FH.UNO = U.UNO AND fh.uno = ? AND H.hrNo = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uNo);
			pstmt.setString(2, horseNum);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int UNO = rs.getInt("UNO");
				String hrName = rs.getString("hrName");
				String hrNo = rs.getString("hrNo");
				String birthday = rs.getString("birthday");
				Favorite_Horse fvh = new Favorite_Horse(UNO, hrName, hrNo, birthday);
				list.add(fvh);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;

	}

	public int insert(Connection conn, int UNO, String hrNo) {
		// 즐겨찾기 정보 삽입시 마번랑 회원번호 입력받아서 정보 삽입
		try {
			String sql = "INSERT INTO FAVORITE_HORSE (HNO ,hrNo, UNO) VALUES(SEQ_FAV_HORSENO.NEXTVAL,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, hrNo);
			pstmt.setInt(2, UNO);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int delete(Connection conn, int UNO, String hrNo) {// 즐겨찾기 정보 삽입시 회원번호랑 마번 입력받아서 정보 삭제
		try {
			String sql = "DELETE FROM FAVORITE_HORSE WHERE UNO = ? AND hrNo = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, UNO);
			pstmt.setString(2, hrNo);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
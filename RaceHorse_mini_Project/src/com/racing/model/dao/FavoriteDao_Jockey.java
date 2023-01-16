package com.racing.model.dao;

import static com.racing.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.racing.model.vo.Favorite_Jockey;

public class FavoriteDao_Jockey {

	public List<Favorite_Jockey> selectAll(Connection conn, int uNo) {
		// 즐겨찾기 목록 전체출력
		// 내가 기수즐겨찾기에서 출력하고 싶은 칼럼 => 즐겨찾기 번호 / 회원번호 / 기수번호/ 기수명
		List<Favorite_Jockey> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = " SELECT DISTINCT FJ.UNO , J.jkNo, J.jkName\r\n"
					+ " FROM FAVORITE_JOCKEY FJ, USERINFO U, JOCKEY J\r\n"
					+ " WHERE FJ.jkNo = J.jkNo AND FJ.UNO = u.uno AND FJ.uno = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uNo);

			rs = pstmt.executeQuery();

			while (rs.next() == true) {
//				int JNO = rs.getInt("JNO");
				int UNO = rs.getInt("UNO");
				String jkNo = rs.getString("jkNo");
				String jkName = rs.getString("jkName");// JNO,
				Favorite_Jockey fvj = new Favorite_Jockey(UNO, jkNo, jkName);
				list.add(fvj);
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

	public List<Favorite_Jockey> selectByName(Connection conn, int uNo, String jockeyName) {
		// 즐겨찾기 테이블에서 기수이름을 입력받아서 해당하는 즐겨찾기 한 회원번호/기수명/기수번호/생년월일 출력
		List<Favorite_Jockey> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT u.uno, j.jkno, j.jkname " + "FROM FAVORITE_JOCKEY FJ, USERINFO U, JOCKEY J "
					+ "WHERE FJ.jkNo = J.jkNo AND FJ.UNO = u.uno AND FJ.uno = ? AND j.jkname LIKE ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uNo);
			pstmt.setString(2, "%" + jockeyName + "%");
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int uno = rs.getInt("uno");
				String jkno = rs.getString("jkno");
				String jkname = rs.getString("jkname");
				Favorite_Jockey fvj = new Favorite_Jockey(uno, jkno, jkname);
				list.add(fvj);
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

	public List<Favorite_Jockey> selectByJockeyNumber(Connection conn, int uNo, String jockeyNum) {
		// 즐겨찾기 테이블에서 마번을 입력받아서 해당하는 즐겨찾기 한 회원번호/기수명/기수번호/생년월일 출력
		List<Favorite_Jockey> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = " SELECT DISTINCT u.uno, j.jkno, j.jkname " + "FROM FAVORITE_JOCKEY FJ, USERINFO U, JOCKEY J "
					+ "WHERE FJ.jkNo = J.jkNo AND FJ.UNO = u.uno AND FJ.uno = ? AND j.jkno = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uNo);
			pstmt.setString(2, jockeyNum);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				int UNO = rs.getInt("UNO");
				String jkno = rs.getString("jkno");
				String jkname = rs.getString("jkname");
				Favorite_Jockey fvj = new Favorite_Jockey(UNO, jkno, jkname);
				list.add(fvj);
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

	public int insert(Connection conn, int UNO, String jkno) {// 즐겨찾기 정보 삽입시 회원번호랑 기수번호 입력받아서 정보 삽입
		try {
			String sql = "INSERT INTO FAVORITE_JOCKEY (JNO ,UNO, jkno) VALUES(SEQ_FAV_JOCKEY_NO.NEXTVAL,?,?) ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(2, jkno);
			pstmt.setInt(1, UNO);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int delete(Connection conn, int UNO, String jkno) {// 즐겨찾기 정보 삽입시 회원번호랑 기수번호 입력받아서 정보 삭제
		try {
			String sql = "DELETE FROM FAVORITE_JOCKEY WHERE UNO = ? AND jkno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, UNO);
			pstmt.setString(2, jkno);

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
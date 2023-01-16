package com.racing.model.dao;

import static com.racing.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.racing.model.vo.Jockey;

public class jockeyDao {

	public int insert(Connection conn, Jockey jockey) {
		try {
			String sql = "INSERT INTO "
					+ "JOCKEY(jkNo, jkName, meet, age, debut, rcCntT, ord1CntT, ord2CntT, ord3CntT) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			pstmt.setString(cnt++, jockey.getJkNo());
			pstmt.setString(cnt++, jockey.getJkName());
			pstmt.setString(cnt++, jockey.getMeet());
			pstmt.setInt(cnt++, jockey.getAge());
			pstmt.setDate(cnt++, (Date) jockey.getDebut());
			pstmt.setInt(cnt++, jockey.getRcCntT());
			pstmt.setInt(cnt++, jockey.getOrd1CntT());
			pstmt.setInt(cnt++, jockey.getOrd2CntT());
			pstmt.setInt(cnt++, jockey.getOrd3CntT());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public List<Jockey> selectAll(Connection conn) {
		List<Jockey> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM JOCKEY ORDER BY jkNo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String jkNo = rs.getString(count++);
				String jkName = rs.getString(count++);
				String meet = rs.getString(count++);
				int age = rs.getInt(count++);
				Date debut = rs.getDate(count++);
				int rcCntT = rs.getInt(count++);
				int ord1CntT = rs.getInt(count++);
				int ord2CntT = rs.getInt(count++);
				int ord3CntT = rs.getInt(count++);

				Jockey info = new Jockey(jkNo, jkName, meet, age, debut, rcCntT, ord1CntT, ord2CntT, ord3CntT);
				list.add(info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public List<Jockey> selectByJkNo(Connection conn, String jockeyNum) {
		List<Jockey> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM JOCKEY WHERE jkNo LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + jockeyNum + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String jkNo = rs.getString(count++);
				String jkName = rs.getString(count++);
				String meet = rs.getString(count++);
				int age = rs.getInt(count++);
				Date debut = rs.getDate(count++);
				int rcCntT = rs.getInt(count++);
				int ord1CntT = rs.getInt(count++);
				int ord2CntT = rs.getInt(count++);
				int ord3CntT = rs.getInt(count++);

				Jockey info = new Jockey(jkNo, jkName, meet, age, debut, rcCntT, ord1CntT, ord2CntT, ord3CntT);
				list.add(info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public List<Jockey> selectByJkName(Connection conn, String JockeyName) {
		List<Jockey> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM JOCKEY WHERE jkName LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + JockeyName + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String jkNo = rs.getString(count++);
				String jkName = rs.getString(count++);
				String meet = rs.getString(count++);
				int age = rs.getInt(count++);
				Date debut = rs.getDate(count++);
				int rcCntT = rs.getInt(count++);
				int ord1CntT = rs.getInt(count++);
				int ord2CntT = rs.getInt(count++);
				int ord3CntT = rs.getInt(count++);

				Jockey info = new Jockey(jkNo, jkName, meet, age, debut, rcCntT, ord1CntT, ord2CntT, ord3CntT);
				list.add(info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public List<Jockey> rankedByRcCntT(Connection conn) {
		List<Jockey> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ROWNUM AS 순위, E.*" + "FROM(SELECT * FROM JOCKEY ORDER BY rcCntT DESC) E "
					+ "WHERE ROWNUM BETWEEN 1 AND 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int rowNum = rs.getInt(count++);
				String jkNo = rs.getString(count++);
				String jkName = rs.getString(count++);
				String meet = rs.getString(count++);
				int age = rs.getInt(count++);
				Date debut = rs.getDate(count++);
				int rcCntT = rs.getInt(count++);
				int ord1CntT = rs.getInt(count++);
				int ord2CntT = rs.getInt(count++);
				int ord3CntT = rs.getInt(count++);

				Jockey info = new Jockey(rowNum, jkNo, jkName, meet, age, debut, rcCntT, ord1CntT, ord2CntT, ord3CntT);
				list.add(info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public List<Jockey> rankedByOrd1CntT(Connection conn) {
		List<Jockey> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ROWNUM AS 순위, E.*"
					+ " FROM(SELECT * FROM JOCKEY ORDER BY ord1CntT DESC, ord2CntT DESC, ord3CntT DESC) E "
					+ "WHERE ROWNUM BETWEEN 1 AND 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int rowNum = rs.getInt(count++);
				String jkNo = rs.getString(count++);
				String jkName = rs.getString(count++);
				String meet = rs.getString(count++);
				int age = rs.getInt(count++);
				Date debut = rs.getDate(count++);
				int rcCntT = rs.getInt(count++);
				int ord1CntT = rs.getInt(count++);
				int ord2CntT = rs.getInt(count++);
				int ord3CntT = rs.getInt(count++);

				Jockey info = new Jockey(rowNum, jkNo, jkName, meet, age, debut, rcCntT, ord1CntT, ord2CntT, ord3CntT);
				list.add(info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
}

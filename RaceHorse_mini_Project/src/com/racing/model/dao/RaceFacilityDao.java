package com.racing.model.dao;

import static com.racing.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.racing.common.JDBCTemplate;
import com.racing.model.vo.RaceFacility;

public class RaceFacilityDao {

	// 부대시설명(fltTitle)으로 검색
	public List<RaceFacility> selectBySearchFltTitle(Connection conn, String facTitle) {
		List<RaceFacility> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM racefacility WHERE flttitle LIKE ? AND fltLcodeName LIKE '서울'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + facTitle + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String fltSeq = rs.getString(count++);
				String fltTitle = rs.getString(count++);
				String fltEcodeName = rs.getString(count++);
				String fltEndday = rs.getString(count++);
				String fltHour = rs.getString(count++);
				String fltLcodeName = rs.getString(count++);
				String fltMcodeName = rs.getString(count++);
				String fltObjText = rs.getString(count++);
				String fltPositionAdd = rs.getString(count++);
				String fltRentStatusName = rs.getString(count++);
				String fltScodeName = rs.getString(count++);
				String fltStatusName = rs.getString(count++);
				String fltText = rs.getString(count++);

				RaceFacility info = new RaceFacility(fltSeq, fltTitle, fltEcodeName, fltEndday, fltHour, fltLcodeName,
						fltMcodeName, fltObjText, fltPositionAdd, fltRentStatusName, fltScodeName, fltStatusName,
						fltText);
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

	// 마권사는곳
	public List<RaceFacility> selectByBuyTicket(Connection conn) {
		List<RaceFacility> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM racefacility WHERE fltecodename LIKE '마권사는곳' AND fltLcodeName LIKE '서울'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String fltSeq = rs.getString(count++);
				String fltTitle = rs.getString(count++);
				String fltEcodeName = rs.getString(count++);
				String fltEndday = rs.getString(count++);
				String fltHour = rs.getString(count++);
				String fltLcodeName = rs.getString(count++);
				String fltMcodeName = rs.getString(count++);
				String fltObjText = rs.getString(count++);
				String fltPositionAdd = rs.getString(count++);
				String fltRentStatusName = rs.getString(count++);
				String fltScodeName = rs.getString(count++);
				String fltStatusName = rs.getString(count++);
				String fltText = rs.getString(count++);

				RaceFacility info = new RaceFacility(fltSeq, fltTitle, fltEcodeName, fltEndday, fltHour, fltLcodeName,
						fltMcodeName, fltObjText, fltPositionAdd, fltRentStatusName, fltScodeName, fltStatusName,
						fltText);
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

	// 먹거리
	public List<RaceFacility> selectByFood(Connection conn) {
		List<RaceFacility> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM racefacility WHERE fltecodename LIKE '먹거리' AND fltLcodeName LIKE '서울'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String fltSeq = rs.getString(count++);
				String fltTitle = rs.getString(count++);
				String fltEcodeName = rs.getString(count++);
				String fltEndday = rs.getString(count++);
				String fltHour = rs.getString(count++);
				String fltLcodeName = rs.getString(count++);
				String fltMcodeName = rs.getString(count++);
				String fltObjText = rs.getString(count++);
				String fltPositionAdd = rs.getString(count++);
				String fltRentStatusName = rs.getString(count++);
				String fltScodeName = rs.getString(count++);
				String fltStatusName = rs.getString(count++);
				String fltText = rs.getString(count++);

				RaceFacility info = new RaceFacility(fltSeq, fltTitle, fltEcodeName, fltEndday, fltHour, fltLcodeName,
						fltMcodeName, fltObjText, fltPositionAdd, fltRentStatusName, fltScodeName, fltStatusName,
						fltText);
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

	// 볼거리
	public List<RaceFacility> selectBySee(Connection conn) {
		List<RaceFacility> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM racefacility WHERE fltecodename LIKE '볼거리' AND fltLcodeName LIKE '서울'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String fltSeq = rs.getString(count++);
				String fltTitle = rs.getString(count++);
				String fltEcodeName = rs.getString(count++);
				String fltEndday = rs.getString(count++);
				String fltHour = rs.getString(count++);
				String fltLcodeName = rs.getString(count++);
				String fltMcodeName = rs.getString(count++);
				String fltObjText = rs.getString(count++);
				String fltPositionAdd = rs.getString(count++);
				String fltRentStatusName = rs.getString(count++);
				String fltScodeName = rs.getString(count++);
				String fltStatusName = rs.getString(count++);
				String fltText = rs.getString(count++);

				RaceFacility info = new RaceFacility(fltSeq, fltTitle, fltEcodeName, fltEndday, fltHour, fltLcodeName,
						fltMcodeName, fltObjText, fltPositionAdd, fltRentStatusName, fltScodeName, fltStatusName,
						fltText);
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

	// 즐길거리
	public List<RaceFacility> selectByFun(Connection conn) {
		List<RaceFacility> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM racefacility WHERE fltecodename LIKE '즐길거리' AND fltLcodeName LIKE '서울'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String fltSeq = rs.getString(count++);
				String fltTitle = rs.getString(count++);
				String fltEcodeName = rs.getString(count++);
				String fltEndday = rs.getString(count++);
				String fltHour = rs.getString(count++);
				String fltLcodeName = rs.getString(count++);
				String fltMcodeName = rs.getString(count++);
				String fltObjText = rs.getString(count++);
				String fltPositionAdd = rs.getString(count++);
				String fltRentStatusName = rs.getString(count++);
				String fltScodeName = rs.getString(count++);
				String fltStatusName = rs.getString(count++);
				String fltText = rs.getString(count++);

				RaceFacility info = new RaceFacility(fltSeq, fltTitle, fltEcodeName, fltEndday, fltHour, fltLcodeName,
						fltMcodeName, fltObjText, fltPositionAdd, fltRentStatusName, fltScodeName, fltStatusName,
						fltText);
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

	// 편의시설
	public List<RaceFacility> selectByFac(Connection conn) {
		List<RaceFacility> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM racefacility WHERE fltecodename LIKE '편의시설' AND fltLcodeName LIKE '서울'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String fltSeq = rs.getString(count++);
				String fltTitle = rs.getString(count++);
				String fltEcodeName = rs.getString(count++);
				String fltEndday = rs.getString(count++);
				String fltHour = rs.getString(count++);
				String fltLcodeName = rs.getString(count++);
				String fltMcodeName = rs.getString(count++);
				String fltObjText = rs.getString(count++);
				String fltPositionAdd = rs.getString(count++);
				String fltRentStatusName = rs.getString(count++);
				String fltScodeName = rs.getString(count++);
				String fltStatusName = rs.getString(count++);
				String fltText = rs.getString(count++);

				RaceFacility info = new RaceFacility(fltSeq, fltTitle, fltEcodeName, fltEndday, fltHour, fltLcodeName,
						fltMcodeName, fltObjText, fltPositionAdd, fltRentStatusName, fltScodeName, fltStatusName,
						fltText);
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

	// 회원전용실
	public List<RaceFacility> selectByMemOnly(Connection conn) {
		List<RaceFacility> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM racefacility WHERE fltecodename LIKE '회원전용실' AND fltLcodeName LIKE '서울'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String fltSeq = rs.getString(count++);
				String fltTitle = rs.getString(count++);
				String fltEcodeName = rs.getString(count++);
				String fltEndday = rs.getString(count++);
				String fltHour = rs.getString(count++);
				String fltLcodeName = rs.getString(count++);
				String fltMcodeName = rs.getString(count++);
				String fltObjText = rs.getString(count++);
				String fltPositionAdd = rs.getString(count++);
				String fltRentStatusName = rs.getString(count++);
				String fltScodeName = rs.getString(count++);
				String fltStatusName = rs.getString(count++);
				String fltText = rs.getString(count++);

				RaceFacility info = new RaceFacility(fltSeq, fltTitle, fltEcodeName, fltEndday, fltHour, fltLcodeName,
						fltMcodeName, fltObjText, fltPositionAdd, fltRentStatusName, fltScodeName, fltStatusName,
						fltText);
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

	// 기타
	public List<RaceFacility> selectByEtc(Connection conn) {
		List<RaceFacility> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM racefacility WHERE fltecodename IS NULL";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String fltSeq = rs.getString(count++);
				String fltTitle = rs.getString(count++);
				String fltEcodeName = rs.getString(count++);
				String fltEndday = rs.getString(count++);
				String fltHour = rs.getString(count++);
				String fltLcodeName = rs.getString(count++);
				String fltMcodeName = rs.getString(count++);
				String fltObjText = rs.getString(count++);
				String fltPositionAdd = rs.getString(count++);
				String fltRentStatusName = rs.getString(count++);
				String fltScodeName = rs.getString(count++);
				String fltStatusName = rs.getString(count++);
				String fltText = rs.getString(count++);

				RaceFacility info = new RaceFacility(fltSeq, fltTitle, fltEcodeName, fltEndday, fltHour, fltLcodeName,
						fltMcodeName, fltObjText, fltPositionAdd, fltRentStatusName, fltScodeName, fltStatusName,
						fltText);
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

	public int insert(Connection conn, RaceFacility raceFacility) {
		try {
			String sql = "INSERT INTO " + "RACEFACILITY(fltSeq, fltTitle, fltEcodeName, fltEndday, fltHour, "
					+ "				fltLcodeName, fltMcodeName, fltObjText, fltPositionAdd, "
					+ "				fltRentStatusName, fltScodeName, fltStatusName, fltText) "
					+ "VALUES(?, ?, ?, ?, ?, " + "        ?, ?, ?, ?, " + "        ?, ?, ?, ?) ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;

			pstmt.setString(cnt++, raceFacility.getFltSeq());
			pstmt.setString(cnt++, raceFacility.getFltTitle());
			pstmt.setString(cnt++, raceFacility.getFltEcodeName());
			pstmt.setString(cnt++, raceFacility.getFltEndday());
			pstmt.setString(cnt++, raceFacility.getFltHour());
			pstmt.setString(cnt++, raceFacility.getFltLcodeName());
			pstmt.setString(cnt++, raceFacility.getFltMcodeName());
			pstmt.setString(cnt++, raceFacility.getFltObjText());
			pstmt.setString(cnt++, raceFacility.getFltPositionAdd());
			pstmt.setString(cnt++, raceFacility.getFltRentStatusName());
			pstmt.setString(cnt++, raceFacility.getFltScodeName());
			pstmt.setString(cnt++, raceFacility.getFltStatusName());
			pstmt.setString(cnt++, raceFacility.getFltText());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = JDBCTemplate.openConnection();
		List<RaceFacility> list = new RaceFacilityDao().selectByEtc(conn);
		for (RaceFacility info : list) {
			System.out.println(info);
		}
		System.out.println("==================");

		List<RaceFacility> list2 = new RaceFacilityDao().selectBySearchFltTitle(conn, "편");
		for (RaceFacility info : list2) {
			System.out.println(info);
		}
		System.out.println("==================");

		RaceFacility info = new RaceFacility("가", "나", "다", "라", "마", "바", "사", "1", "2", "3", "4", "5", "6");
		int result = new RaceFacilityDao().insert(conn, info);
		conn.commit();
		System.out.println(result);
//		list = new RaceFacilityDao().selectAll(conn);
//		for (RaceFacility info2 : list) {
//			System.out.println(info2);
//		}
	}
}

package com.racing.model.dao;

import static com.racing.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.racing.common.JDBCTemplate;
import com.racing.model.vo.Racing;

public class RacingDao {

	public List<Racing> selectAll(Connection conn) {
		List<Racing> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM rc_info ";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int RNO = rs.getInt(count++);
				String rcDate2 = rs.getString(count++);
				int rcNo2 = rs.getInt(count++);
				int rcDist = rs.getInt(count++); // 경주거리
				int rcOrd = rs.getInt(count++); // 순위
				double rcTime = rs.getDouble(count++); // 경주기록
				int rcChul = rs.getInt(count++); // 출전번호
				String hrno = rs.getString(count++); // 마번
				String hrName = rs.getString(count++); // 마명
				int wgHr = rs.getInt(count++); // 마체중
				String jkNo = rs.getString(count++); // 기수번호
				String jkName = rs.getString(count++); // 기수명
				int chaksun = rs.getInt(count++); // 착순상금
				String weath = rs.getString(count++); // 날씨

				Racing info = new Racing(RNO, rcDate2, rcNo2, rcDist, rcOrd, rcTime, rcChul, hrno, hrName, wgHr, jkNo,
						jkName, chaksun, weath);

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

	public List<Racing> selectDateNo(Connection conn, String rcDate, int rcNo) {
		List<Racing> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM rc_info WHERE rcDate = ? AND rcNo = ? ORDER BY rcOrd ASC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rcDate);
			pstmt.setInt(2, rcNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int RNO = rs.getInt(count++);
				String rcDate2 = rs.getString(count++);
				int rcNo2 = rs.getInt(count++);
				int rcDist = rs.getInt(count++); // 경주거리
				int rcOrd = rs.getInt(count++); // 순위
				double rcTime = rs.getDouble(count++); // 경주기록
				int rcChul = rs.getInt(count++); // 출전번호
				String hrno = rs.getString(count++); // 마번
				String hrName = rs.getString(count++); // 마명
				int wgHr = rs.getInt(count++); // 마체중
				String jkNo = rs.getString(count++); // 기수번호
				String jkName = rs.getString(count++); // 기수명
				int chaksun = rs.getInt(count++); // 착순상금
				String weath = rs.getString(count++); // 날씨

				Racing info = new Racing(RNO, rcDate2, rcNo2, rcDist, rcOrd, rcTime, rcChul, hrno, hrName, wgHr, jkNo,
						jkName, chaksun, weath);

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

	public List<Racing> selectByHrName(Connection conn, String hrName) {
		List<Racing> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM rc_info WHERE HRNAME LIKE ? ORDER BY rcDate DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + hrName + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int RNO = rs.getInt(count++);
				String rcDate = rs.getString(count++);
				int rcNo = rs.getInt(count++);
				int rcDist = rs.getInt(count++);
				int rcOrd = rs.getInt(count++);
				double rcTime = rs.getDouble(count++);
				int rcChul = rs.getInt(count++);
				String hrno = rs.getString(count++);
				String hrName2 = rs.getString(count++);
				int wgHr = rs.getInt(count++);
				String jkNo = rs.getString(count++);
				String jkName = rs.getString(count++);
				int chaksun = rs.getInt(count++);
				String weath = rs.getString(count++);

				Racing info = null;
				info = new Racing(RNO, rcDate, rcNo, rcDist, rcOrd, rcTime, rcChul, hrno, hrName2, wgHr, jkNo, jkName,
						chaksun, weath);
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

	public List<Racing> selectByJkName(Connection conn, String jkName) {
		List<Racing> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM rc_info WHERE JKNAME LIKE ? ORDER BY rcDate DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + jkName + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int RNO = rs.getInt(count++);
				String rcDate = rs.getString(count++);
				int rcNo = rs.getInt(count++);
				int rcDist = rs.getInt(count++);
				int rcOrd = rs.getInt(count++);
				double rcTime = rs.getDouble(count++);
				int rcChul = rs.getInt(count++);
				String hrno = rs.getString(count++);
				String hrName = rs.getString(count++);
				int wgHr = rs.getInt(count++);
				String jkNo = rs.getString(count++);
				String jkName2 = rs.getString(count++);
				int chaksun = rs.getInt(count++);
				String weath = rs.getString(count++);

				Racing info = new Racing(RNO, rcDate, rcNo, rcDist, rcOrd, rcTime, rcChul, hrno, hrName, wgHr, jkNo,
						jkName2, chaksun, weath);
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

	public List<Racing> selectDate(Connection conn, String rcDate) {
		List<Racing> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT rcno\r\n" + "FROM rc_info\r\n" + "WHERE rcDate\r\n" + "= ?\r\n"
					+ "ORDER BY rcno ASC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rcDate);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;

				int rcNo = rs.getInt(count++);

				Racing info = new Racing(rcNo);

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

	public int insert(Connection conn, Racing info) {

		try {
			String sql = "INSERT INTO " + "RC_INFO(RNO, rcDate, rcNo, "
					+ "rcDist, rcOrd, rcTime, rcChul, hrNo, hrName, wgHr, jkNo, jkName, chaksun,weath) "
					+ " VALUES (SEQ_BOX_NO.NEXTVAL, ?, ?, ? , ?, ? , ?, ?, ? , ? , ? , ?, ?, ?) ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
//			pstmt.setInt(cnt++, info.getRNO());
			pstmt.setString(cnt++, info.getRcDate());
			pstmt.setInt(cnt++, info.getRcNo());
			pstmt.setInt(cnt++, info.getRcDist());
			pstmt.setInt(cnt++, info.getRcOrd());
			pstmt.setDouble(cnt++, info.getRcTime());
			pstmt.setInt(cnt++, info.getRcChul());
			pstmt.setString(cnt++, info.getHrno());
			pstmt.setString(cnt++, info.getHrName());
			pstmt.setInt(cnt++, info.getWgHr());
			pstmt.setString(cnt++, info.getJkNo());
			pstmt.setString(cnt++, info.getJkName());
			pstmt.setInt(cnt++, info.getChaksun());
			pstmt.setString(cnt++, info.getWeath());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public static void main(String[] args) throws Exception {
		Connection conn = JDBCTemplate.openConnection();
		List<Racing> list = new RacingDao().selectByJkName(conn, "이");
		for (Racing info : list) {
			System.out.println(info.toString());
		}

		List<Racing> nlist = new ArrayList<Racing>();
		nlist.add(new Racing(10, "20220507", 1, 1200, 8, 63.8, 2, "0040471", "금당나래원", 425, "080500", "안안", 0, "흐림"));
		nlist.add(new Racing(12, "20220507", 1, 1200, 8, 78.7, 1, "80486", "에클레어더원", 444, "080476", "장조림", 0, "흐림"));

		for (Racing info : nlist) {
			int result = new RacingDao().insert(conn, info);
			conn.commit();
			System.out.println(result);
		}

//		list = new RacingDao().selectByJkName(conn, "이");
//		for (Racing info2 : list) {
//			System.out.println(info2);
//		}
	}

}

package com.racing.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.racing.common.JDBCTemplate;
import com.racing.model.vo.User;

public class UserDao {

	public User selectOne(Connection conn, int uNo) {
		try {
			String sql = "SELECT * FROM USERINFO WHERE UNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uNo);

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			uNo = rs.getInt(1);
			String id = rs.getString(2);
			String password = rs.getString(3);
			String name = rs.getString(4);

			User user = new User(uNo, id, password, name);

			pstmt.close();
			rs.close();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User selectByID(Connection conn, String id) {
		try {
			String sql = "SELECT * FROM USERINFO WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int uNo = rs.getInt(1);
			id = rs.getString(2);
			String password = rs.getString(3);
			String name = rs.getString(4);

			User user = new User(uNo, id, password, name);

			pstmt.close();
			rs.close();
			return user;
		} catch (Exception e) {
		}
		return null;
	}

	public int insert(Connection conn, User user) {
		try {
			String sql = "INSERT INTO USERINFO VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());

			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
		}
		return -1;
	}

	public static void main(String[] args) {
		Connection conn = JDBCTemplate.openConnection();
		User user = new UserDao().selectOne(conn, 2);
		System.out.println(user);
		user = new UserDao().selectByID(conn, "test1");
		System.out.println(user);
	}
}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import model.dto.MemberDTO;
import util.DBUtil;

public class MemberDAO {
	private static ResourceBundle sql = DBUtil.getResourceBundle();

	public static boolean checkId(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("checkId"));
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = id.equals(rset.getString(1));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return result;
	}

	public static boolean insertUser(MemberDTO newUser) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnection();
			System.out.println(newUser.getId() + " " + newUser.getPassword());
			pstmt = con.prepareStatement("insert into member values (?,?,?)");
			pstmt.setString(1, newUser.getId());
			pstmt.setString(2, newUser.getPassword());
			pstmt.setString(3, newUser.getName());
			result = pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result == 0 ? false : true;
	}
	
	public static boolean checkUser(String id, String password) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("checkUser"));
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = id.equals(rset.getString(1));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return result;
	}
}

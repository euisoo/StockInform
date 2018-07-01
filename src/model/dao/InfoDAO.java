package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import model.dto.InfoDTO;
import model.dto.StockDTO;
import util.DBUtil;

public class InfoDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	public static ArrayList<InfoDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<InfoDTO> data = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from info");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				data.add(new InfoDTO(rset.getString(1), rset.getString(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}
	public static String getNameBycmpCode(String cmpCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String name = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT cmpName FROM info WHERE cmpCode=?");
			pstmt.setString(1, cmpCode);
			rset = pstmt.executeQuery();
			System.out.println(rset);
			if (rset.next()) {
				name = rset.getString(1);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return name;
	}

	public static ArrayList<String> getByBusName(String busName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> busNameList = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT cmpName from info WHERE busName=?");
			pstmt.setString(1, busName);
			rset = pstmt.executeQuery();
			busNameList = new ArrayList<>();
			while (rset.next()) {
				busNameList.add(rset.getString(1));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return busNameList;
	}

	public static ArrayList<InfoDTO> getByName(String cmpName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<InfoDTO> comps = new ArrayList<InfoDTO>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectByName"));
			pstmt.setString(1, "%" + cmpName + "%");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				comps.add(new InfoDTO(rset.getString(1), rset.getString(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return comps;
	}

	// 종목명, 업종명 : 종목코드
	public static ArrayList<InfoDTO> getByNameNBus(String cmpName, String busName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<InfoDTO> comps = new ArrayList<InfoDTO>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectByNameNBus"));
			pstmt.setString(1, "%" + cmpName + "%");
			pstmt.setString(2, busName);
			rset = pstmt.executeQuery();
			System.out.println(rset);
			while (rset.next()) {
				comps.add(new InfoDTO(rset.getString(1), rset.getString(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return comps;
	}

	// 업종명 : 업종 전체의 all 종목코드
	public static ArrayList<InfoDTO> getByBus(String busName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<InfoDTO> comps = new ArrayList<InfoDTO>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectByBus"));
			pstmt.setString(1, busName);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				comps.add(new InfoDTO(rset.getString(1), rset.getString(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return comps;
	}

	public static ArrayList<InfoDTO> getAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<InfoDTO> comps = new ArrayList<InfoDTO>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectAll"));
			rset = pstmt.executeQuery();
			while (rset.next()) {
				comps.add(new InfoDTO(rset.getString(1), rset.getString(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return comps;
	}

	public static void insertAll(List<InfoDTO> infoList) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement("INSERT INTO info VALUES (?, ?)");

			for (InfoDTO info : infoList) {
				pstmt.setString(1, info.getCmpName());
				pstmt.setString(2, info.getBusName());
				pstmt.executeUpdate();
			}
			con.commit();
		} catch (SQLException e) {
			con.rollback();
			throw e;
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
}
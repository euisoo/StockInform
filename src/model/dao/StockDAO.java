package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import model.dto.StockDTO;
import util.DBUtil;

public class StockDAO {

static ResourceBundle sql = DBUtil.getResourceBundle();
	
	//종목코드 : 
	public static ArrayList<StockDTO> getBycmpName(String cmpName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<StockDTO> data = new ArrayList<StockDTO>();
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectStockData"));
			pstmt.setString(1, cmpName);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				data.add(new StockDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						              rset.getString(5), rset.getString(6), rset.getString(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}
	
	public static ArrayList<StockDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<StockDTO> data = new ArrayList<StockDTO>();
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from stock");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				data.add(new StockDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						              rset.getString(5), rset.getString(6), rset.getString(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}
	
	public static void insertAll(List<StockDTO> stockList) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement("INSERT INTO stock VALUES (?, ?, ?, ?, ?, ?, ?)");
			
			for (StockDTO stock : stockList) {
				System.out.println(stock.getRecordDate());
				pstmt.setString(1, stock.getCmpName());
				pstmt.setString(2, stock.getRecordDate());
				pstmt.setString(3, stock.getClose());
				pstmt.setString(4, stock.getHigh());
				pstmt.setString(5, stock.getLow());
				pstmt.setString(6, stock.getOpen());
				pstmt.setString(7, stock.getVolume());

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

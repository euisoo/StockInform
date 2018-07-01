package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import model.dto.FinanceDTO;
import util.DBUtil;

public class FinanceDAO {

	static ResourceBundle sql = DBUtil.getResourceBundle();

	public static ArrayList<FinanceDTO> getSameBusComp(String cmpCode, String year) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FinanceDTO> comps = new ArrayList<FinanceDTO>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectAllCompinSameBus"));
			pstmt.setString(1, year);
			pstmt.setString(2, "3");
			pstmt.setString(3, cmpCode);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				comps.add(new FinanceDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9),
						rset.getString(10), rset.getString(11), rset.getString(12), rset.getString(13),
						rset.getString(14), rset.getString(15), rset.getString(16), rset.getString(17),
						rset.getString(18)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return comps;
	}

	public static ArrayList<FinanceDTO> getAllBycmpNameOrderYear(String cmpName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FinanceDTO> financeList = new ArrayList<FinanceDTO>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM finance WHERE cmpName=? ORDER BY year DESC");
			pstmt.setString(1, cmpName);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				financeList.add(new FinanceDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
											   rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9),
											   rset.getString(10), rset.getString(11), rset.getString(12), rset.getString(13),
											   rset.getString(14), rset.getString(15), rset.getString(16), rset.getString(17),rset.getString(18)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return financeList;
	}

	public static ArrayList<FinanceDTO> getAllDataByIfrs(String cmpName, String ifrs) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FinanceDTO> data = new ArrayList<FinanceDTO>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectAllDataByIfrs"));
			pstmt.setString(1, cmpName);
			pstmt.setString(2, ifrs);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				data.add(new FinanceDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9),
						rset.getString(10), rset.getString(11), rset.getString(12), rset.getString(13),
						rset.getString(14), rset.getString(15), rset.getString(16), rset.getString(17),
						rset.getString(18)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}

	public static ArrayList<FinanceDTO> getSummaryData(String cmpCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FinanceDTO> data = new ArrayList<FinanceDTO>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("selectFinSummaryData"));
			pstmt.setString(1, cmpCode);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				data.add(new FinanceDTO(rset.getString(1), rset.getString(2), rset.getString(3), null, null, null, null,
						null, null, rset.getString(4), rset.getString(5), null, rset.getString(6), null,
						rset.getString(7), null, null, null));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}

	public static ArrayList<FinanceDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FinanceDTO> data = new ArrayList<FinanceDTO>();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from finance");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				data.add(new FinanceDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9),
						rset.getString(10), rset.getString(11), rset.getString(12), rset.getString(13),
						rset.getString(14), rset.getString(15), rset.getString(16), rset.getString(17),
						rset.getString(18)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return data;
	}

	public static void insertAll(List<FinanceDTO> financeList) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement("INSERT INTO finance VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			for (FinanceDTO finance : financeList) {
				pstmt.setString(1, finance.getCmpName());
				pstmt.setString(2, finance.getRevenue());
				pstmt.setString(3, finance.getOperatingIncome());
				pstmt.setString(4, finance.getNetIncome());
				pstmt.setString(5, finance.getTotalAsset());
				pstmt.setString(6, finance.getTotalDebt());
				pstmt.setString(7, finance.getCapitalGross());
				pstmt.setString(8, finance.getCapex());
				pstmt.setString(9, finance.getFcf());
				pstmt.setString(10, finance.getNetProfitRatio());
				pstmt.setString(11, finance.getRoe());
				pstmt.setString(12, finance.getRoa());
				pstmt.setString(13, finance.getEps());
				pstmt.setString(14, finance.getPer());
				pstmt.setString(15, finance.getBps());
				pstmt.setString(16, finance.getPbr());
				pstmt.setString(17, finance.getIfrs());
				pstmt.setString(18, finance.getYear());
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

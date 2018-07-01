package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sun.beans.editors.IntegerEditor;

import model.dao.FinanceDAO;
import model.dao.InfoDAO;
import model.dao.StockDAO;
import model.dto.FinanceDTO;
import model.dto.InfoDTO;
import model.dto.StockDTO;

public class SelectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmpName = request.getParameter("cmpName");
		String busName = request.getParameter("busName");
		try {
			request.setAttribute("stockData", candleData(cmpName));
			request.setAttribute("financeData3", FinanceDAO.getAllDataByIfrs(cmpName, "3"));
			request.setAttribute("financeData4", FinanceDAO.getAllDataByIfrs(cmpName, "4"));
			String[] finData = barData(busName);
			request.setAttribute("finData1", finData[0]);
			request.setAttribute("finData2", finData[1]);
			request.setAttribute("finData3", finData[2]);
			request.setAttribute("finData4", finData[3]);
			request.setAttribute("finData5", finData[4]);
			request.setAttribute("finData6", finData[5]);
		
			request.getRequestDispatcher("reportView.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String candleData(String cmpName) throws SQLException {
		StringBuilder result = new StringBuilder();
		result.append("[");
		for (StockDTO s : StockDAO.getBycmpName(cmpName)) {
			result.append("['");
			result.append(s.getRecordDate());
			result.append("',");
			result.append(s.getLow());
			result.append(","); 
			result.append(s.getOpen());
			result.append(",");
			result.append(s.getClose());
			result.append(",");
			result.append(s.getHigh());
			result.append("],");
		}
		int length = result.length();
		result.delete(length - 1, length);
		result.append("]");
		return result.toString();
	}

	public static String[] barData(String busName) throws SQLException {
		String years[] = {"2012", "2013", "2014", "2015", "2016"};
		List<String> cmpNameList = InfoDAO.getByBusName(busName);
		HashMap<String, ArrayList<FinanceDTO>> map = new HashMap<>();
		for (String c : cmpNameList) {
			map.put(c, FinanceDAO.getAllBycmpNameOrderYear(c));
		}
		String result = "[['Company',";
		for (String c : cmpNameList) {
			result += ("'" + c + "',");
		}
		result += "{ role: 'annotation' }],";
		
		String revenue = result;
		String netIncome = result;
		String totalAsset = result;
		String totalDebt = result;
		String per = result;
		String pbr = result;
	
		for (int i=0; i<years.length;i++) {
			revenue += ("['" + years[i] + "',");
			netIncome += ("['" + years[i] + "',");
			totalAsset += ("['" + years[i] + "',");
			totalDebt += ("['" + years[i] + "',");
			per += ("['" + years[i] + "',");
			pbr += ("['" + years[i] + "',");
			for (String c : cmpNameList) {
				revenue += ((map.get(c).get(i).getRevenue()==null ? "0": map.get(c).get(i).getRevenue()) + ",");
				netIncome += ((map.get(c).get(i).getNetIncome()==null ? "0":map.get(c).get(i).getNetIncome()) + ",");
				totalAsset += ((map.get(c).get(i).getTotalAsset()==null ? "0":map.get(c).get(i).getTotalAsset()) + ",");
				totalDebt += ((map.get(c).get(i).getTotalDebt()==null ? "0":map.get(c).get(i).getTotalDebt()) + ",");
				per += ((map.get(c).get(i).getPer()==null ? "0":map.get(c).get(i).getPer()) + ",");
				pbr += ((map.get(c).get(i).getPbr()==null ? "0":map.get(c).get(i).getPbr()) + ",");
			}
			revenue += "''],";
			netIncome += "''],";
			totalAsset += "''],";
			totalDebt += "''],";
			per += "''],";
			pbr += "''],";
		}
		
		revenue = revenue.substring(0, revenue.length()-1);
		netIncome = netIncome.substring(0, netIncome.length()-1);
		totalAsset = totalAsset.substring(0, totalAsset.length()-1);
		totalDebt = totalDebt.substring(0, totalDebt.length()-1);
		per = per.substring(0, per.length()-1);
		pbr = pbr.substring(0, pbr.length()-1);
		
		revenue += "]";
		netIncome += "]";
		totalAsset += "]";
		totalDebt += "]";
		per += "]";
		pbr += "]";
		
		return new String[]{revenue, netIncome, totalAsset, totalDebt, per, pbr};
	}
}


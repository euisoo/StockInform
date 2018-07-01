package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiDevice.Info;

import model.dao.FinanceDAO;
import model.dao.InfoDAO;
import model.dao.StockDAO;
import model.dto.FinanceDTO;
import model.dto.InfoDTO;
import model.dto.StockDTO;

public class ABC extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			inserInfo();
			insertFinance();
			inserStock();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void insertFinance() throws SQLException, FileNotFoundException, IOException {
		try (BufferedReader in = new BufferedReader(new FileReader("C:\\0.bigData\\4.web\\Web_MJ\\data\\Finance.csv"))) {
			ArrayList<FinanceDTO> a = new ArrayList<>();
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				String[] s = line.split(",");

				a.add(new FinanceDTO(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10], s[11],
						s[12], s[13], s[14], s[15], s[16], s[17]));
			}
			

			FinanceDAO.insertAll(a);
		}
	}

	private void inserStock() throws FileNotFoundException, IOException, SQLException {
		try (BufferedReader in = new BufferedReader(new FileReader("C:\\0.bigData\\4.web\\Web_MJ\\data\\Stock.csv"))) {
			ArrayList<StockDTO> a = new ArrayList<>();
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				String[] s = line.split(",");
				a.add(new StockDTO(s[0], s[1], s[2], s[3], s[4], s[5], s[6]));
			}
			StockDAO.insertAll(a);
		}
	}
	
	private void inserInfo() throws FileNotFoundException, IOException, SQLException {
		try (BufferedReader in = new BufferedReader(new FileReader("C:\\0.bigData\\4.web\\Web_MJ\\data\\Info.csv"))) {
			ArrayList<InfoDTO> a = new ArrayList<>();
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				String[] s = line.split(",");
				a.add(new InfoDTO(s[0], s[1]));
			}
			InfoDAO.insertAll(a);
		}
	}
}
//	
//	private void selectStock() throws FileNotFoundException, IOException, SQLException {
//		List<StockDTO> a = StockDAO.selectAll();
//		String str = "";
//		int i = 0;
//		for (StockDTO s : a) {
//			i++;
//			str += (InfoDAO.getNameBycmpCode(s.getCmpCode()) + "," + s.toString());
//		}
//		System.out.println(str);
//		System.out.println(i);
//		try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\Finance.csv"))) {
//			System.out.println("-----------------------");
//			out.write(str);
//		}
//	}
//	
//	private void selectFinance() throws FileNotFoundException, IOException, SQLException {
//		List<FinanceDTO> a = FinanceDAO.selectAll();
//		String str = "";
//		for (FinanceDTO s : a) {
//			str += (InfoDAO.getNameBycmpCode(s.getCmpCode()) + "," + s.toString());
//		}
//		str.replaceAll("null", "");
//		try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\Finance.csv"))) {
//			System.out.println("-----------------------");
//			out.write(str);
//		}
//	}
//	
//	private void selectInfo() throws FileNotFoundException, IOException, SQLException {
//		List<InfoDTO> a = InfoDAO.selectAll();
//		String str = "";
//		
//		for (InfoDTO s : a) {
//			str += (s.getCmpName() + "," + s.getBusName() + "\n");
//		}
//		
//		try (BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\Info.csv"))) {
//			out.write(str);
//		}
//	}
//}

/*
 * package controller;
 * 
 * import java.io.BufferedReader; import java.io.BufferedWriter; import
 * java.io.FileReader; import java.io.FileWriter; import java.io.IOException;
 * import java.sql.SQLException; import java.util.ArrayList;
 * 
 * import javax.servlet.ServletException; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import model.dao.FinanceDAO; import
 * model.dao.InfoDAO; import model.dto.FinanceDTO; import model.dto.InfoDTO;
 * 
 * public class ABC extends HttpServlet {
 * 
 * protected void service(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * 
 * try { String str = ""; for (FinanceDTO info : FinanceDAO.selectAll()) { str
 * += (info.toString() + "\n"); }
 * 
 * try (BufferedReader in = new BufferedReader(new
 * FileReader("C:\\Users\\user\\Desktop\\ads\\Finance.csv"))) {
 * ArrayList<FinanceDTO> a = new ArrayList<>(); for(String line = in.readLine();
 * line!=null;line=in.readLine()) { String[] s = line.split(","); int l = 6 -
 * s[16].length(); for(int i =0; i < l; i++) { s[16] = "0" + s[16]; } a.add(new
 * FinanceDTO(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10],
 * s[11], s[12], s[13], s[14], s[15], s[16], s[17])); } FinanceDAO.insertAll(a);
 * } } catch (SQLException e) { e.printStackTrace(); } } }
 


 * package controller;
 * 
 * import java.io.BufferedWriter; import java.io.FileWriter; import
 * java.io.IOException; import java.sql.SQLException;
 * 
 * import javax.servlet.ServletException; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import model.dao.FinanceDAO; import model.dto.FinanceDTO;
 * 
 * public class ABC extends HttpServlet {
 * 
 * protected void service(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { try (BufferedWriter out =
 * new BufferedWriter(new FileWriter("ad"))) {
 * 
 * }
 * 
 * try { String str = ""; for (FinanceDTO info : FinanceDAO.selectAll()) { str
 * += (info.toString() + "\n"); }
 * 
 * try (BufferedWriter out = new BufferedWriter( new
 * FileWriter("C:\\Users\\user\\Desktop\\ads\\finance.csv"))) { out.write(str);
 * } } catch (SQLException e) { e.printStackTrace(); } }
 * 
 * }
 * 
 */

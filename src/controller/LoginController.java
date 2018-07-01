package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;

public class LoginController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		try {
			if(MemberDAO.checkUser(id, password)) {
				response.sendRedirect("searchView.jsp");
			}else {
				response.sendRedirect("loginFailView.html");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

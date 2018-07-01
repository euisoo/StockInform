package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;
import model.dto.MemberDTO;

public class JoinSuccessController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		try {
			MemberDAO.insertUser(new MemberDTO(id, password, name));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("loginView.html").forward(request, response);
	}
}

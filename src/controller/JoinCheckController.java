package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDAO;

public class JoinCheckController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		response.setContentType("text/plane;charset=utf-8");
		try (PrintWriter out = response.getWriter()) {
			if (id != null) {
				out.print(id.length() < 5 ? "아이디는 5자 이상만 사용 가능합니다." : (MemberDAO.checkId(id) ? "이미 존재하는 아이디 입니다." : "t"));
			} else if (pw != null) {
				out.print(pw.length() < 8 ? "비밀번호는 8자 이상만 사용 가능합니다." : "t");
			} else if (name != null) {
				out.print(name.length() < 2 ? "이름은 2자 이상만 사용 가능합니다." : "t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

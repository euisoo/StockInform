package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.InfoDAO;

public class SearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bus = request.getParameter("bus");
		String name = request.getParameter("name");
		try {
			if (bus.equals("전체") && name.equals("")) {
				request.setAttribute("data", InfoDAO.getAll());
			} else if (bus.equals("전체") && !name.equals("")) {
				request.setAttribute("data", InfoDAO.getByName(name));
			} else if (!bus.equals("전체") && !name.equals("")) {
				request.setAttribute("data", InfoDAO.getByNameNBus(name, bus));
			} else if (!bus.equals("전체") && name.equals("")) {
				request.setAttribute("data", InfoDAO.getByBus(bus));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("tableList.jsp").forward(request, response);
	}
}

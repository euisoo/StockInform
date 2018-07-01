package controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String charset =null;
	HashMap<String, Controller> controllers = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		controllers = new HashMap<String, Controller>();
		controllers.put("/joinCheck.do", new JoinCheckController());
		controllers.put("/joinSuccess.do", new JoinSuccessController());
		controllers.put("/login.do", new LoginController());
		controllers.put("/search.do", new SearchController());
		controllers.put("/select.do", new SelectController());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		Controller subController = controllers.get(path);
		subController.execute(request, response);
	}
}

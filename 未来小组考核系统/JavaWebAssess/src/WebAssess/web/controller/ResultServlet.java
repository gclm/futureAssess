package WebAssess.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebAssess.dao.IUserDao;
import WebAssess.dao.impl.UserDaoImpl;
import WebAssess.domain.Results;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IUserDao dao=new UserDaoImpl();
		String username=request.getParameter("username");
		System.out.println(username);
		String NO1=request.getParameter("NO1");
		System.out.println(NO1);
		String NO2=request.getParameter("NO2");
		System.out.println(NO2);
		String NO3=request.getParameter("NO3");
		System.out.println(NO3);
		String NO4=request.getParameter("NO4");
		System.out.println(NO4);
		String NO5=request.getParameter("NO5");
		System.out.println(NO5);
		String NO6=request.getParameter("NO6");
		System.out.println(NO6);
		String NO7=request.getParameter("NO7");
		System.out.println(NO7);
		Results results=new Results(username,NO1,NO2,NO3,NO4,NO5, NO6,NO7);
		dao.add(results);
		String message = String.format(
				"成绩录入成功！！2秒后为你返回考官页面！！<meta http-equiv='refresh' content='2;url=%s'",
				request.getContextPath() + "/IdentityUIServlet2");
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

}

package WebAssess.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebAssess.dao.IUserDao;
import WebAssess.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class IdentityUIServlet
 */
@WebServlet("/IdentityUIServlet1")
public class IdentityUIServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdentityUIServlet1() {
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
		List list=dao.Infoall();
		request.setAttribute("List", list);
		request.getRequestDispatcher("/WEB-INF/examinee/examinee.jsp").forward(request, response);
	}

}

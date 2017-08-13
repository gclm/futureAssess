package WebAssess.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebAssess.dao.IUserDao;
import WebAssess.dao.impl.UserDaoImpl;
import WebAssess.domain.User;
import WebAssess.service.IUserService;
import WebAssess.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取用户填写的登录用户名
		String identity = request.getParameter("identity");
		System.out.println(identity);
		String username = request.getParameter("username");
		// 获取用户填写的登录密码
		String password = request.getParameter("userpass");
		IUserService service = new UserServiceImpl();
		// 用户登录
		User user = service.loginUser(username, password);

		if (user == null) {
			String message = String.format(
					"对不起，用户名或密码有误！！请重新登录！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url=%s'",user.getUsernick(),
					request.getContextPath() + "/LoginUIServlet");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		// 登录成功后，就将用户存储到session中
		request.getSession().setAttribute("user", user);
		String identity1 = user.getUseridentity();
		System.out.println(identity1);
		if(identity1==null){
			String message = String.format(
					"恭喜：%s,登陆成功 !将在3秒后跳到申请授权页面！！<meta http-equiv='refresh' content='3;url=%s'",
					user.getUsernick(), request.getContextPath() + "/IdentityUIServlet5");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}else{
			if (identity.equals(identity1)) {
				if (identity1.equals("考生")) {
					String message = String.format(
							"恭喜：%s,登陆成功！本页将在3秒后跳到考生首页！！<meta http-equiv='refresh' content='3;url=%s'", user.getUsernick(),
							request.getContextPath() + "/IdentityUIServlet1");
					request.setAttribute("message", message);
					request.getRequestDispatcher("/message.jsp").forward(request, response);
				} else if (identity1.equals("考官")) {
					String message = String.format(
							"恭喜：%s,登陆成功！本页将在3秒后跳到考官首页！！<meta http-equiv='refresh' content='3;url=%s'", user.getUsernick(),
							request.getContextPath() + "/IdentityUIServlet2");
					request.setAttribute("message", message);
					request.getRequestDispatcher("/message.jsp").forward(request, response);
				} else if (identity1.equals("管理员")) {
					IUserDao dao=new UserDaoImpl();
					List list=dao.Applyall();
					request.setAttribute("List", list);
					String message = String.format(
							"恭喜：%s,登陆成功！本页将在3秒后跳到管理员首页！！<meta http-equiv='refresh' content='3;url=%s'", user.getUsernick(),
							request.getContextPath() + "/IdentityUIServlet3");
					request.setAttribute("message", message);
					request.getRequestDispatcher("/message.jsp").forward(request, response);
				} else if (identity1.equals("系统维护员")) {
					String message = String.format(
							"恭喜：%s,登陆成功！本页将在3秒后跳到系统维护员首页！！<meta http-equiv='refresh' content='3;url=%s'",
							user.getUsernick(), request.getContextPath() + "/IdentityUIServlet4");
					request.setAttribute("message", message);
					request.getRequestDispatcher("/message.jsp").forward(request, response);
				}

			}else if(identity1.equals("考官")||identity1.equals("考官")||identity1.equals("管理员")||identity1.equals("系统维护员")) {
				String message = String.format(
						"提醒：%s,选择身份选择错误 !将在3秒后跳到登录界面！！<meta http-equiv='refresh' content='3;url=%s'",
						user.getUsernick(), request.getContextPath() + "/LoginUIServlet");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
		}
	}
}
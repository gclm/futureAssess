package WebAssess.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import WebAssess.domain.User;
import WebAssess.exception.UserExistException;
import WebAssess.service.IUserService;
import WebAssess.service.impl.UserServiceImpl;
import WebAssess.util.WebUtils;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
				String username=request.getParameter("username1");
				String userpass=request.getParameter("userpass");
				String usernick=request.getParameter("usernick");
				String userid=request.getParameter("useridentity");
				String age=request.getParameter("age");
				String sex=request.getParameter("sex");
				String grade=request.getParameter("grade");
				String dn=request.getParameter("direction");
				String phone=request.getParameter("phone");
				String email=request.getParameter("email");
				User user = new User(username,userpass,usernick,userid,age,sex,grade,dn,phone,email);
				try {
					user.setId(WebUtils.makeId());//设置用户的Id属性
					IUserService service = new UserServiceImpl();
					//调用service层提供的注册用户服务实现用户注册
					service.registerUser(user);
					String message = String.format(
							"注册成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>", 
							request.getContextPath()+"/LoginUIServlet");
					request.setAttribute("message",message);
					request.getRequestDispatcher("/message.jsp").forward(request,response);

				} catch (UserExistException e) {
				    String message = String.format(
						"注册失败，账户已存在！！3秒后为您自动跳到注册页面！！<meta http-equiv='refresh' content='3;url=%s'/>", 
						request.getContextPath()+"/WEB-INF/pages/RegisterUIServlet");
						request.setAttribute("message",message);
						request.getRequestDispatcher("/message.jsp").forward(request,response); 
				    
				} catch (Exception e) {
					e.printStackTrace(); // 在后台记录异常
					request.setAttribute("message", "对不起，注册失败！！");
					request.getRequestDispatcher("/message.jsp").forward(request,response);
				}
	}

}

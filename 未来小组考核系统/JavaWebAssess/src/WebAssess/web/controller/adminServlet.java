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
import WebAssess.domain.Apply;
import WebAssess.domain.Info;
import WebAssess.domain.User;
import WebAssess.util.WebUtils;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("*.user")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminServlet() {
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
		request.setCharacterEncoding("utf-8");
		IUserDao dao=new UserDaoImpl();
		String url=request.getServletPath();
	    if(url.equals("/finduser.user")){
			request.getRequestDispatcher("/WEB-INF/administrator/finduser.jsp").forward(request, response);
		}else if(url.equals("/getfinduser.user")){
			String choose=request.getParameter("Choose");
			String input=request.getParameter("input");
			if(choose.equals("getusertall.user")){
				List list=dao.findAll();
				request.setAttribute("List", list);
				request.getRequestDispatcher("/WEB-INF/administrator/userall.jsp").forward(request, response);	
			}else if(choose.equals("getuser.user")){
				User user=dao.find(input);
				request.setAttribute("User", user);
				request.getRequestDispatcher("/WEB-INF/administrator/user.jsp").forward(request, response);
			}else if(choose.equals("getdirectionfind.user")){
				List list=dao.find1(input);
				request.setAttribute("List", list);
				request.getRequestDispatcher("/WEB-INF/administrator/userall.jsp").forward(request, response);
			}else if(choose.equals("getidentityfind.user")){
				List list=dao.find2(input);
				request.setAttribute("List", list);
				request.getRequestDispatcher("/WEB-INF/administrator/userall.jsp").forward(request, response);
			}	
		}else if(url.equals("/setpassword.user")){
			request.getRequestDispatcher("/WEB-INF/administrator/setpassword.jsp").forward(request, response);
		}else if(url.equals("/getpassword.user")){
			String username=request.getParameter("username");
			String userpass=request.getParameter("userpass");
			dao.update2(username, userpass);
			String message = String.format(
					"恭喜：修改密码成功！本页将在3秒后跳到管理员首页！！<meta http-equiv='refresh' content='3;url=%s'",
					request.getContextPath() + "/IdentityUIServlet3");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}else if(url.equals("/updateexaminee.user")){
			request.getRequestDispatcher("/WEB-INF/administrator/updateexaminee.jsp").forward(request, response);
		}else if(url.equals("/getupdateexaminee.user")){
			String username=request.getParameter("username");
			dao.find(username);
			User user=dao.find(username);
            request.setAttribute("User", user);
			request.getRequestDispatcher("/WEB-INF/administrator/setinfo.jsp").forward(request, response);
		}else if(url.equals("/setupdateexaminee.user")){
			String username=request.getParameter("username");
			String usernick=request.getParameter("usernick");
			String age=request.getParameter("age");
			String sex=request.getParameter("sex");
			String grade=request.getParameter("grade");
			String direction=request.getParameter("direction");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			dao.update(username, usernick, age, sex, grade, direction, phone, email);
			String message = String.format(
					"修改密码成功！本页将在3秒后跳到管理员首页！！<meta http-equiv='refresh' content='3;url=%s'",
					request.getContextPath() + "/IdentityUIServlet3");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}else if(url.equals("/setidentity.user")){
			 request.getRequestDispatcher("/WEB-INF/administrator/setidentity.jsp").forward(request, response);
		}else if(url.equals("/applyidentity.user")){
            String useridentity=request.getParameter("useridentity");
            String username=request.getParameter("username");
            Apply apply=new Apply(username,useridentity);
            apply.setId(WebUtils.makeId());//设置用户的Id属性
            dao.add(apply);
			String message = String.format(
					"申请授权已发出！！！本页将在3秒后跳到申请授权首页！！<meta http-equiv='refresh' content='3;url=%s'",
					request.getContextPath() + "/IdentityUIServlet5");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);			 
		}else if(url.equals("/setinformation.user")){
			request.getRequestDispatcher("/WEB-INF/administrator/setinformation.jsp").forward(request, response);
		}else if(url.equals("/getinformation.user")){
			String information=request.getParameter("information");
            Info info=new Info(information);
            info.setId(WebUtils.makeId());//设置用户的Id属性
            dao.add(info);
			String message = String.format(
					"通知已发出！！！本页将在3秒后跳到管理员首页！！<meta http-equiv='refresh' content='3;url=%s'",
					request.getContextPath() + "/IdentityUIServlet3");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}else if(url.equals("/getidentity.user")){
            String username=request.getParameter("username1");
            String useridentity=request.getParameter("identity");         
            dao.update1(username, useridentity);
            User user=dao.find(username);
            request.setAttribute("User", user);
			request.getRequestDispatcher("/WEB-INF/administrator/user.jsp").forward(request, response);
		} 
	}
}

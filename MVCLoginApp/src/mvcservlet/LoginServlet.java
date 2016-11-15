package mvcservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessservice.LoginService;
import dto.UserDetails;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId , password ;
		response.setContentType("text/html");
		
		userId = request.getParameter("userId");
		password = request.getParameter("password");
		
		LoginService ls = new LoginService();
		boolean result = ls.authenciate(userId, password);
		
		if(result)
		{
			UserDetails user = ls.getUserDetails(userId);
//			request.getSession().setAttribute("user" , user);
			request.setAttribute("user", user);
//			response.sendRedirect("LoginSuccessful.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("LoginSuccessful.jsp");
			rd.forward( request , response );
			return;
		}
		
		else
		{
			response.sendRedirect("loginpage.jsp");
			return;
		}
	}

}

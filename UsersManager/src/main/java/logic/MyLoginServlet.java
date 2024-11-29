package logic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyLoginServlet
 */
@WebServlet("/LoginServlet")
public class MyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		response.setContentType("text/html");
		String email=request.getParameter("email");
		session.setAttribute("adminemail", email);
		String password=request.getParameter("pass");
		if(email.equals("admin@gmail.com") && password.equals("admin@123")) {
			response.getWriter().print("Login Succes");
			//1.create dispather to webpage response
			RequestDispatcher rd=request.getRequestDispatcher("AdminServlet");
			rd.forward(request, response);
		}
		else if(UserVerification.checkUser(email, password)==true) {
			response.getWriter().print("Login sucess");
			RequestDispatcher rd=request.getRequestDispatcher("UserHome");
			rd.include(request,response);
			
		}
		
		else {
			response.getWriter().print("Login failed");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response);
			
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}

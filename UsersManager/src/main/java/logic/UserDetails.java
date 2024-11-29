package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserDetails
 */
@WebServlet("/UserDetails")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 PrintWriter out = response.getWriter();                                          
         		//UserDAO userdao = new UserDAO(); 
		 out.print("<h1>Welcome</h1>");
		 HttpSession session=request.getSession();
		 String email=(String) session.getAttribute("email");
		 out.print(email);
         		List<User> users = UserVerification.getAllUsers();                               
         		//System.out.println(users);                                                   
         		out.print("<div style='text-align:center;'>");                                 
         		out.print("<table border=1><tr><th>id</th><th>username</th><th>Gmail</th><th>password</th>");
         		for(User u:users) {                                                            
         			out.print("<tr>");                                                            
       	 			out.print("<td>"+u.getUserId()+"</td>");                                          
         			out.print("<td>"+u.getUserName()+"</td>");                                    
         			out.print("<td>"+u.getUserMail()+"</td>");      
         			out.print("<td>"+u.getUserPassword()+"</td>");
         			out.print("</tr>");                                                           
         		}                                                                              
         		out.print("</table>");                                                         
         		out.print("</div>");                                                                                                                                   
                                                                                                                        

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	

}

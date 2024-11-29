package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>Welcome</h1>");
		List<User> users = UserVerification.getAllUsers();                               
 		//System.out.println(users);      
		//table
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
 		//input
 		out.print("<p><b>Delete User</p>");
		out.print("<form action=DeleteUser>");
		out.print("<input placeholder='id' type='number' name='Id'>");
		out.print("</form>");
		
		int userId=Integer.parseInt(request.getParameter("Id"));
		UserVerification.deleteUserByUsingId(userId);
		//table
		List<User> user = UserVerification.getAllUsers();                               
 		//System.out.println(users);                                                   
 		out.print("<div style='text-align:center;'>");                                 
 		out.print("<table border=1><tr><th>id</th><th>username</th><th>Gmail</th><th>password</th>");
 		for(User u:user) {                                                            
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}

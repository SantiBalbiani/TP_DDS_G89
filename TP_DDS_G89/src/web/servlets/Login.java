package web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import usuario.Usuario;

/**
 * Servlet implementation class LogIn
 */


@WebServlet(name="Login", urlPatterns="/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{	    

		     //UserBean user = new UserBean();
			String usuario = request.getParameter("usuario");
			String contrasenia = request.getParameter("contrasenia");

			   		    
			if(usuario.equals("admin") && contrasenia.equals("admin")){
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",usuario); 
		          response.sendRedirect("welcome.jsp");     		
		     }    
		     else 
		    	 response.sendRedirect("login.jsp");
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
 
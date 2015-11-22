package web.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.RequestDispatcher;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


@WebServlet("/Recibe")
public class ServletRecibe extends HttpServlet { // Hereda de
	private static final long serialVersionUID = 1L;
       

    public ServletRecibe() {
        super();
        
    }

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 PrintWriter out = response.getWriter();
		    ResourceBundle rb = ResourceBundle.getBundle("LocalStrings", request.getLocale());
		      // To test other locales.
		      //ResourceBundle rb = ResourceBundle.getBundle("LocalStrings", new Locale("fr"));
		 
		      // Write the response message, in an HTML document.
		      try {
		         out.println("<!DOCTYPE html>");  // HTML 5
		         out.println("<html><head>");
		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		         String title = rb.getString("helloworld.title");
		         out.println("<title>" + title + "</title></head>");
		         out.println("<body>");
		         out.println("<h1>" + title + "</h1>");  // Prints "Hello, world!"
		         // Set a hyperlink image to refresh this page
		         out.println("<a href='" + request.getRequestURI() + "'><img src='images/return.gif'></a>");
		         out.println("</body></html>");
		      } finally {
		         out.close();  // Always close the output writer
		      }
		 
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String nombre = request.getParameter("nombreBienvenida"); //nombreBienvenida es la variable del textbox de la pag web
		
		String msg;
		

		
		if ( (nombre==null) || (nombre.trim().length() == 0)){
			msg = "ingrese Nombre";
		}else{
			msg = "Bienvenido " + nombre;
		}
		request.setAttribute("mensaje", msg); // Cargar una variable (el string) de la pagina web
		RequestDispatcher dispatcher = request.getRequestDispatcher("mensaje.jsp");
		dispatcher.forward(request, response);
		
	}

}

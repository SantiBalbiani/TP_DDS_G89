package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import receta.Receta;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class Buscar
 */
@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nombreReceta;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		nombreReceta = request.getParameter("nombreReceta");
		
		Receta recetaBuscada = new Receta();
		
		recetaBuscada = recetaBuscada.buscarRecetaPorNombre(nombreReceta);
		

	     // response.setContentType("text/html");

	
//	      PrintWriter out = response.getWriter();
//	      out.println("<h1>" + recetaBuscada.getNombreReceta() + "</h1>");
		if (recetaBuscada.getNombreReceta()== nombreReceta){
			response.sendRedirect("nuevaReceta.jsp?receta=" + recetaBuscada + "&datos=0");
		}
		
		
	}

}

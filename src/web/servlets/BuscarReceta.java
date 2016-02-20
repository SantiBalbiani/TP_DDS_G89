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
@WebServlet("/BuscarReceta")
public class BuscarReceta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nombreReceta;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarReceta() {
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

		HttpSession session = request.getSession(true);
		
		
		nombreReceta = request.getParameter("buscar_nombreReceta");
		Receta recetaBuscada = new Receta();
		
		try{
			recetaBuscada = recetaBuscada.buscarRecetaPorNombre(nombreReceta);
		
			if (recetaBuscada!=null) {
			session.setAttribute("recetaEncontrada", recetaBuscada);
		
			response.sendRedirect("verReceta.jsp");
			}
			else
			{
				session.setAttribute("errorBusqueda", "yes");
				response.sendRedirect("welcome.jsp");
			}
		}catch(Throwable Exception){
			System.out.println(Exception);
		}
		
	}

}

package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import usuario.DataInsertion;

import usuario.Usuario;

/**
 * Servlet implementation class Registro
 */
@WebServlet(name="RegistrarServlet", urlPatterns="/register")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
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
		String usuario = request.getParameter("nombre");
		String contrasenia1 = request.getParameter("pass");
		//String contrasenia2 = request.getParameter("contrasenia2");
		String fechaNac = request.getParameter("fechaNacimiento");
		//String alturaTexto = request.getParameter("altura");
		//String sexoTexto = request.getParameter("sexo");
		String complexion = request.getParameter("complexion");
		//char sexo;
		//Double altura = Double.parseDouble(alturaTexto);
		
		//sexo = (char)sexoTexto.charAt(0);
		
		
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.altaUsuario(usuario, 'M', fechaNac, complexion, 0.00, " ", " ", " ", " ",contrasenia1);
		
		
		
		nuevoUsuario.guardarUsuario(nuevoUsuario);
		
		
		
		
		response.sendRedirect("welcome.jsp");
	}

}

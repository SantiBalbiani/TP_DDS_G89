package web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import usuario.Usuario;

/**
 * Servlet implementation class Registro
 */
@WebServlet("/register")
public class Registrarse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrarse() {
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

		Usuario usuario = new Usuario();
		String nombreUsuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String fechaNac = request.getParameter("fechaNacimiento");
		String altura = request.getParameter("altura");
		String sexo = request.getParameter("sexo");
		String complexion = request.getParameter("complexion");		
		
		//TODO: falta agregar: String preferencias_alimenticias, Set<Integer> condPreexistentes,String dieta, String rutina, String password
		//ejemplo de prueba compilar
		Set<Integer> condPreexis;
		condPreexis = new HashSet<Integer>();
		condPreexis.add(1); //generico
		//TODO: si el sexo es hombre que sea 'M' y 'H'
		//TODO: la altura hay que castearla a double....
		
		//usuario.altaUsuario(nombreUsuario, 'H', "20150313", complexion, 1.70 , " ", condPreexis, " ", " ", password);
		usuario.altaUsuario("admin", 'H', "20150313", "media", (double)1.70 , " ", condPreexis, " ", " ", "123");
		
		usuario.guardarUsuario(usuario);
		
		response.sendRedirect("welcome.jsp?usuario=" + nombreUsuario + "&datos=0");
	}

}
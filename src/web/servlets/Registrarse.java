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


		String nombreUsuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String fechaNac = request.getParameter("fechaNacimiento");
		String altura = request.getParameter("altura");
		String sexo = request.getParameter("optionSexo");
		String complexion = request.getParameter("complexion");		
		
		//TODO: falta agregar: String preferencias_alimenticias, Set<Integer> condPreexistentes,String dieta, String rutina, String password
		//ejemplo de prueba compilar
		//Set<Integer> condPreexis;
		//condPreexis = new HashSet<Integer>();
		//condPreexis.add(1); //generico


		//TODO: arreglar alta de usuario
		//usuario.altaUsuario(nombreUsuario, 'H', "20150313", complexion, 1.70 , " ", condPreexis, " ", " ", password);
		//usuario.altaUsuario("admin", 'H', "20150313", "media", (double)1.70 , " ", condPreexis, " ", " ", "123");
		
		
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombreUsuario(nombreUsuario);
		nuevoUsuario.setPassword(password);
		//TODO: que guarde la password en md5!! (capaz la tendria que mandar desde el cliente asi)
		//por el momento implica muchos cambios..
		nuevoUsuario.setFecha_nacimiento(fechaNac);
		nuevoUsuario.setComplexion(complexion);
		
		//TODO: hay que agregar preferencias alimenticias
		//nuevoUsuario.setPreferencias_alimenticias("algo");
		//TODO: hay que agregar la dieta
		//nuevoUsuario.setDieta("ovolactovegetariana");
		//TODO: hay que agregar la rutina
		//nuevoUsuario.setRutina("vago");
		
		//se dio de baja el campo edad...
		//nuevoUsuario.setEdad((int)15);
		
		//si el sexo es hombre que sea 'M' (Masculino) y 'F' (Femenino)
		char c = sexo.charAt(0);
		c = ((c=='M')|| (c=='F')) ? c : 'e';
		nuevoUsuario.setSexo(c);
		//el char e es de error...
		
		
		//String text = "192"; // example String.... recordar que es en centimetros
		double doubleAltura = Double.parseDouble(altura);
		nuevoUsuario.setAltura(doubleAltura);

		
		
		
		nuevoUsuario.guardarUsuario(nuevoUsuario);
		
		//response.sendRedirect("welcome.jsp?usuario=" + nombreUsuario + "&datos=0");
		response.sendRedirect("login.jsp");
	}

}
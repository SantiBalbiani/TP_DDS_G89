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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String usuario = request.getParameter("nombre");
		//TODO:  Bajar MD5 y llamarlo en el cliente
		String contrasenia1 = request.getParameter("pass");
		//String contrasenia2 = request.getParameter("contrasenia2");
		String fechaNac = request.getParameter("fechaNacimiento");
		//String alturaTexto = request.getParameter("altura");
		//String sexoTexto = request.getParameter("sexo");
		String complexion = request.getParameter("complexion");
		//char sexo;
		//Double altura = Double.parseDouble(alturaTexto);
		
		//sexo = (char)sexoTexto.charAt(0);
		
        out.println("<html>");
        out.println("<head></head>");         
        out.println("<body>");

        out.println("Usuario:");
        out.println(usuario);
        out.println("</br>");
        out.println("Password:");         
        out.println(contrasenia1);
        out.println("</body>");
        out.println("</html>");  
		
		
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.altaUsuario(usuario, 'M', fechaNac, complexion, 0.00, " ", " ", " ", " ",contrasenia1);
		
		
		
		nuevoUsuario.guardarUsuario(nuevoUsuario);
		
		
		
		
		response.sendRedirect("welcome.jsp");
	}

}
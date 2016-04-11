package cams.org.httpsession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cams.org.cson.Cson;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Cson cson = new Cson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    //==========================================
	//Debes tener CSON.jar para poder trabajar//
    //==========================================
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cson.clear();
		cson.add("status", 200)
			.add("response", "You must to use POST method");
		response.setContentType("application/json");
		response.getWriter().print(cson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		
		HttpSession session = request.getSession();
		
		cson.clear();
		
		if (session.isNew()) {
			User user = new User(name, lastname);			
			cson.add("status", 200)
				.add("response", "You are logged");
			session.setAttribute("user_info", user);			
		} else {			
			cson.add("status", 300)
				.add("response", "You are already logged");
		}
		
		response.setContentType("application/json");
		response.getWriter().print(cson);
	}

}

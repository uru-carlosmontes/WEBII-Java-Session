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
 * Servlet implementation class Consult
 */
@WebServlet("/consult")
public class Consult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Cson cson = new Cson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		cson.clear();
		
		if (session.isNew()) {
			cson.add("status", 400)
				.add("response", "You Must to login first"); 
			session.invalidate();
		} else {
			User user = (User) session.getAttribute("user_info");
			
			Cson user_info = new Cson();
			user_info.add("name", user.getName())
				.add("lastname", user.getLastname());
			
			cson.add("status", 200)
				.add("user", user_info);		
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println(cson);
		response.getWriter().print(cson);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package customerwork;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/find_password")
public class Findpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService userService = new CustomerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Findpassword() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String password = null;
		try {
			password = this.userService.findPassword(name, question, answer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(password == null) {
			request.setAttribute("errorMsg", "–≈œ¢¥ÌŒÛ!");
			request.getRequestDispatcher("password/findpassword_fail.jsp").forward(request, response);
		} else{
			request.setAttribute("password", password);
			request.getRequestDispatcher("password/findpassword_success.jsp").forward(request, response);
		}
	}

	
}

package customerwork;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Customer;
import service.CustomerService;

/**
 * Servlet implementation class Resetpwd
 */
@WebServlet("/Resetpwd")

public class Resetpwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerrService = new CustomerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resetpwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String real_name = request.getParameter("real_name");
		String email = request.getParameter("email");
		try {

            this.customerrService.update(password,real_name,email);
            request.getRequestDispatcher("password/reset_success.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("password/reset_success.jsp").forward(request, response);
        }

    }

}

            
            
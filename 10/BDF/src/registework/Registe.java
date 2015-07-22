package registework;
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
 * Servlet implementation class register
 */
@WebServlet("/register")
public class Registe extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerService customerrService = new CustomerService();

    /**
     * @see HttpServlet#HttpServlet()
     */

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String realName = request.getParameter("realName");
        String email = request.getParameter("email");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");

        try {

            Customer customer = new Customer();
            customer.setName(username);
            customer.setPassword(password);
            customer.setRealName(realName);
            customer.setEmail(email);
            customer.setQuestion(question);
            customer.setAnswer(answer);
            this.customerrService.save(customer);
            request.getRequestDispatcher("/WEB-INF/view/regist/regist_success.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/view/regist/regist_fail.jsp").forward(request, response);
        }

    }

}

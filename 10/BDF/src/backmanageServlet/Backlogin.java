package backmanageServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Admin;
import service.AdminService;

/**
 * ��̨��½����
 */
@WebServlet(value={"/backend/login", "/backend/main"})
public class Backlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Backlogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //û��½�ķ��ʶ��������������ˣ���������ǵ�½״̬�ģ����Է���mainҳ��
	    request.getRequestDispatcher("view/backend/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Admin admin = null;
        try {
            admin = this.adminService.findByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		if(admin != null && admin.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("adminName", admin.getRealName());
			request.getRequestDispatcher("view/backend/main.jsp").forward(request, response);
		
		} else{
			request.setAttribute("loginError", "�û������������");
			request.getRequestDispatcher("/backend/login.jsp").forward(request, response);
		}
	}

}

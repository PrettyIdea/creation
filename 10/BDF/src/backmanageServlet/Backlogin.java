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
 * 后台登陆处理
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
	    //没登陆的访问都被过滤器拦截了，到这里就是登陆状态的，可以访问main页面
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
			request.setAttribute("loginError", "用户名或密码错误");
			request.getRequestDispatcher("/backend/login.jsp").forward(request, response);
		}
	}

}

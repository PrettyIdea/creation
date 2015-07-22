package customerwork;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LonginServlet
 */
@WebServlet("/logout")
public class Timeout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Timeout() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		//删除登陆信息的cookie
		Cookie nameCookie = new Cookie("name", "");
        nameCookie.setMaxAge(0); //让cookie立刻失效
        Cookie passwordCookie = new Cookie("password", "");
        passwordCookie.setMaxAge(0);
        response.addCookie(nameCookie);
        response.addCookie(passwordCookie);
		response.sendRedirect("view/index.jsp");
	}
}

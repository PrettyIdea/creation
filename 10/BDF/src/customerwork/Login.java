package customerwork;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService = new CustomerService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean result = this.customerService.check(name, password);
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
	         ServletContext application = request.getSession().getServletContext();
	         AtomicInteger counter = (AtomicInteger)application.getAttribute("counter");
	         counter.incrementAndGet();
			 //如果登陆成功了，而且需要记住用户，则记录cookie
	         String remenberMe = request.getParameter("remenberMe");
	         if (remenberMe != null) {
	             //用户名如果有中文，放入cookie会出错，这样处理就不出错，密码同理
	            String encodeName = URLEncoder.encode(name, "UTF-8"); 
                Cookie nameCookie = new Cookie("name", encodeName);
                int aWeek = 3600 * 24 * 7;
                nameCookie.setMaxAge(aWeek); //一周才过期
                String encodePssword = URLEncoder.encode(password, "UTF-8");
                Cookie passwordCookie = new Cookie("password", encodePssword);
                passwordCookie.setMaxAge(aWeek);
                response.addCookie(nameCookie);
                response.addCookie(passwordCookie);
            } else {
                //没勾选记住单选框，则清除cookie中的登陆信息
                Cookie nameCookie = new Cookie("name", "");
                nameCookie.setMaxAge(0); 
                Cookie passwordCookie = new Cookie("password", "");
                passwordCookie.setMaxAge(0);
                response.addCookie(nameCookie);
                response.addCookie(passwordCookie);
            } response.getWriter().print(true);
		} else{
			 response.getWriter().print(false);
		}
		
	}

}


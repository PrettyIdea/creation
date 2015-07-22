package backmanageServlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;
import surpport.PageBean;

/**
 * Servlet implementation class ProductCategroyServlet
 */
@WebServlet("/backend/product_list")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService  = new ProductService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();
		PageBean<Product> pageBean = new PageBean<>(map);
		pageBean = this.productService.list(pageBean);
		request.setAttribute("page", pageBean);
		request.getRequestDispatcher("/WEB-INF/view/backend/product_list.jsp").forward(request, response);
	}

}

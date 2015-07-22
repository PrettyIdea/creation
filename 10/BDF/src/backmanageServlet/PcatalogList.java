package backmanageServlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ProductCategory;
import service.ProductCategroyService;
import surpport.PageBean;

/**
 * Servlet implementation class ProductCategroyServlet
 */
@WebServlet("/backend/product_category_list")
public class PcatalogList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductCategroyService productCategroyService  = new ProductCategroyService();

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
		PageBean<ProductCategory> pageBean = new PageBean<>(map);
		pageBean = this.productCategroyService.list(pageBean);
		request.setAttribute("page", pageBean);
		request.getRequestDispatcher("/WEB-INF/view/backend/product_category_list.jsp").forward(request, response);
	}

}

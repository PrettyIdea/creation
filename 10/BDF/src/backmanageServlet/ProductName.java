package backmanageServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;

/**
 * 验证分类名是否占用
 */
@WebServlet("/backend/product_name")
public class ProductName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService  = new ProductService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String oldValue = request.getParameter("oldValue");
	    String name = request.getParameter("name");
	    boolean result = true;
	    if(!oldValue.equals(name) && !name.isEmpty()){
	        Product product = this.productService.findByName(name);
	        result = (product == null);
	    }
	    response.getWriter().print(result);
	}
}

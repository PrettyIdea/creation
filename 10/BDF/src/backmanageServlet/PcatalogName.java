package backmanageServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ProductCategory;
import service.ProductCategroyService;

/**
 * 验证分类名是否占用
 */
@WebServlet("/backend/product_category_name")
public class PcatalogName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductCategroyService productCategroyService  = new ProductCategroyService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String oldValue = request.getParameter("oldValue");
	    String name = request.getParameter("name");
	    boolean result = true;
	    if(!oldValue.equals(name) && !name.isEmpty()){
	        ProductCategory productCategory = this.productCategroyService.findByName(name);
	        result = (productCategory == null);
	    }
	    response.getWriter().print(result);
	}
}

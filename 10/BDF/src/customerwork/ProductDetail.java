package customerwork;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/productdetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService  = new ProductService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String idStr = request.getParameter("id");
	    Long id = Long.valueOf(idStr);
	    Product product = this.productService.findById(id);
	    request.setAttribute("bean", product);
	    request.getRequestDispatcher("maotai/maotai.jsp").forward(request, response);
	}

}


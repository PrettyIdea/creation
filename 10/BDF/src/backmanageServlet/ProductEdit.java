package backmanageServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import entity.ProductCategory;
import service.ProductCategroyService;
import service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/backend/product_edit")
public class ProductEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService  = new ProductService();
	private ProductCategroyService productCategoryService  = new ProductCategroyService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idStr = request.getParameter("id");
	    if(idStr != null) {
	        Long id = Long.valueOf(idStr);
	        Product product  = this.productService.findById(id);
	        request.setAttribute("bean", product);
	    }
	    List<ProductCategory> threeLevels = this.productCategoryService.findThreeLevel(); 
	    request.setAttribute("threeLevels", threeLevels);
	    request.getRequestDispatcher("/WEB-INF/view/backend/product_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String success = "{\"statusCode\":200,\"message\":\"操作成功\",\"callbackType\":\"closeCurrent\",\"navTabId\":\"product_list\"}";
        String fail = "{\"statusCode\":300, \"message\":\"本操作失败\"}";
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String description = request.getParameter("description");
        String categoryIdStr = request.getParameter("categoryId");
        Long id = idStr.isEmpty() ? null : Long.valueOf(idStr);
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(Float.valueOf(price));
        product.setQuantity(Long.valueOf(quantity));
        product.setDescription(description);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(Long.valueOf(categoryIdStr));
        product.setProductCategory(productCategory);
        PrintWriter writer = response.getWriter();
        try{
            this.productService.saveOrUpdate(product);
            writer.print(success);
        } catch(Exception e){
            e.printStackTrace();
            writer.print(fail);
        }
	}

}

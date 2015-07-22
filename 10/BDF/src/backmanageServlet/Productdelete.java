package backmanageServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;

/**
 * 删除分类
 */
@WebServlet("/backend/product_delete")
public class Productdelete extends HttpServlet {
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
	    String success = "{\"statusCode\":200,\"message\":\"操作成功\",\"navTabId\":\"product_list\"}";
	    String fail = "{\"statusCode\":300, \"message\":\"本操作失败\"}";
	    String idStr = request.getParameter("id");
	    Long id = idStr.isEmpty() ? null : Long.valueOf(idStr);
	    PrintWriter writer = response.getWriter();
	    try{
	        this.productService.delete(id);
	        writer.print(success);
	    } catch(Exception e){
	        e.printStackTrace();
	        writer.print(fail);
	    }
	}

}

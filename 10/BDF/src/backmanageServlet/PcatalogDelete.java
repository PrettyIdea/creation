package backmanageServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductCategroyService;

/**
 * 删除分类
 */
@WebServlet("/backend/product_category_delete")
public class PcatalogDelete extends HttpServlet {
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
	    String success = "{\"statusCode\":200,\"message\":\"操作成功\",\"navTabId\":\"product_category_list\"}";
	    String fail = "{\"statusCode\":300, \"message\":\"本操作失败\"}";
	    Long id =  Long.valueOf(request.getParameter("id"));
	    PrintWriter writer = response.getWriter();
	    try{
	        this.productCategroyService.delete(id);
	        writer.print(success);
	    } catch(Exception e){
	        e.printStackTrace();
	        writer.print(fail);
	    }
	}

}

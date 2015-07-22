package backmanageServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ProductCategory;
import service.ProductCategroyService;

/**
 * Servlet implementation class ProductCategroyServlet
 */
@WebServlet("/backend/product_category_edit")
public class PcatalogEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductCategroyService productCategroyService  = new ProductCategroyService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idStr = request.getParameter("id");
	    if(idStr != null) {
	        Long id = Long.valueOf(idStr);
	        ProductCategory category = this.productCategroyService.findById(id);
	        request.setAttribute("bean", category);
	    }
	    Map<Long, String> allCategory = this.productCategroyService.findAll();
	    request.setAttribute("allCategory", allCategory);
	    request.getRequestDispatcher("/WEB-INF/view/backend/product_category_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String success = "{\"statusCode\":200,\"message\":\"操作成功\",\"callbackType\":\"closeCurrent\",\"navTabId\":\"product_category_list\"}";
        String fail = "{\"statusCode\":300, \"message\":\"本操作失败\"}";
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String levelStr = request.getParameter("level");
        String superIdStr = request.getParameter("productCategoryId");
        Long id = idStr.isEmpty() ? null : Long.valueOf(idStr);
        Integer level = Integer.valueOf(levelStr);
        Long superId = superIdStr.isEmpty() ? null : Long.valueOf(superIdStr);
        PrintWriter writer = response.getWriter();
        try{
            this.productCategroyService.saveOrUpdate(id, name, level, superId);
            writer.print(success);
        } catch(Exception e){
            e.printStackTrace();
            writer.print(fail);
        }
	}

}

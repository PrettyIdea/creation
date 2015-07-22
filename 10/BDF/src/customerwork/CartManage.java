package customerwork;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 清空购物车，或者支付
 */
@WebServlet(value={"/cart/clear", "/cart/pay"})
public class CartManage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * 清空购物车
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("cart");
        response.getWriter().write("清空购物车成功！");
    }

    /**
     * 支付
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("cart");
        //TODO 添加订单逻辑
        response.getWriter().write("支付成功！");
    }

}

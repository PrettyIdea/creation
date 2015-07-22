package customerwork;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��չ��ﳵ������֧��
 */
@WebServlet(value={"/cart/clear", "/cart/pay"})
public class CartManage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * ��չ��ﳵ
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("cart");
        response.getWriter().write("��չ��ﳵ�ɹ���");
    }

    /**
     * ֧��
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("cart");
        //TODO ��Ӷ����߼�
        response.getWriter().write("֧���ɹ���");
    }

}

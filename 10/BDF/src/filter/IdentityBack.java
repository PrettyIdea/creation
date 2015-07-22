package filter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��̨��½״̬��֤�Ĺ�����
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/backend/*" })
public class IdentityBack implements Filter {
    /**
     * ���ô����url��һ����Щurl�����Ժ��Ե�½״̬
     */
    private List<String> ignoreUrl = Arrays.asList(
            "/backend/login",
            "/backend/login.jsp",
            "/backend/logout"
            );

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() { }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		String uri = request.getRequestURI(); //��ǰ���ʵ�url
		Object name = request.getSession().getAttribute("adminName");//�����Ϊnull˵����½״̬��pass
		if(name != null) {
		    chain.doFilter(request, response);
		    return;
		}
		//������˵����û��½�������������Ҫ��½���ܿ���ҳ��
		for (String ignore : ignoreUrl) {
            if(uri.contains(ignore)) {
                chain.doFilter(request, response); //���������ֱ��ͨ����url��pass
                return;
            }
        }
		//������˵��û��½�������������Ƶ�����
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}
}

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
 * 后台登陆状态验证的过滤器
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/backend/*" })
public class IdentityBack implements Filter {
    /**
     * 不用处理的url，一下这些url都可以忽略登陆状态
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
		String uri = request.getRequestURI(); //当前访问的url
		Object name = request.getSession().getAttribute("adminName");//如果不为null说明登陆状态，pass
		if(name != null) {
		    chain.doFilter(request, response);
		    return;
		}
		//到这里说明是没登陆，而其访问了需要登陆才能看的页面
		for (String ignore : ignoreUrl) {
            if(uri.contains(ignore)) {
                chain.doFilter(request, response); //如果是允许直接通过的url，pass
                return;
            }
        }
		//到这里说明没登陆，还访问受限制的链接
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}
}

package project.filter;

import org.apache.commons.lang.StringUtils;
import project.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ForeServletFilter")
public class ForeServletFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String contextPath=request.getServletContext().getContextPath();
        request.getServletContext().setAttribute("contextPath", contextPath);


        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri, contextPath);
        if(uri.startsWith("/fore") && !uri.startsWith("/foreServlet")){
            String method = StringUtils.substringAfterLast(uri,"/fore" );
            request.setAttribute("method", method);
            req.getRequestDispatcher("/foreServlet").forward(request, response);
            return;
        }

        chain.doFilter(req, res);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

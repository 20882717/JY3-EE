package filtle;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "FilterDome",urlPatterns = "*.jsp")
public class FilterDome implements Filter {
    String allFilterPage;
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String requestURI = request.getRequestURI();
        if ("Login2".equals(requestURI))
        {
            chain.doFilter(request,response);
            return;
        }
        List<String> list = Arrays.asList(allFilterPage.split(","));
        if (list.contains(requestURI))
        {
            Object username = request.getSession().getAttribute("username");
            if (null != username)
            {
                chain.doFilter(request,response);
            }else
            {
                request.getRequestDispatcher("Longin2.jsp").forward(request,response);
            }

        }
    }

    public void init(FilterConfig config) throws ServletException {
        allFilterPage = config.getServletContext().getInitParameter("allFilterPage");


    }

}

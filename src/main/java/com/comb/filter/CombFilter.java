package com.comb.filter;


import com.comb.model.Envirment;
import com.comb.util.XmlUtil;
import org.dom4j.DocumentException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = "/*", filterName = "combFilter")
public class CombFilter implements Filter {

    private static List<Envirment> envirments =new ArrayList<>();

    public static final String ENVIR_ATTRIBUTE ="envirments";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            envirments = XmlUtil.readApplicationXml();
            filterConfig.getServletContext().setAttribute(ENVIR_ATTRIBUTE,envirments);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

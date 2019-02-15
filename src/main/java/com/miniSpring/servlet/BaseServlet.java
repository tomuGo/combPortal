package com.miniSpring.servlet;

import com.comb.config.TemplateEngineUtil;
import com.comb.filter.CombFilter;
import com.miniSpring.model.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext((HttpServletRequest) req, (HttpServletResponse) res, req.getServletContext());
        context.setVariable("recipient", "World");
        //Object o=req.getServletContext().getAttribute(CombFilter.ENVIR_ATTRIBUTE);
        ModelAndView modelAndView=new ModelAndView("123","123");
        context.setVariable("envir",modelAndView.getModel());
        engine.process(modelAndView.getView(), context, res.getWriter());
    }
}

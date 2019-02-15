package com.comb.web;

import com.comb.config.TemplateEngineUtil;
import com.comb.filter.CombFilter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        context.setVariable("recipient", "World");
        Object o=request.getServletContext().getAttribute(CombFilter.ENVIR_ATTRIBUTE);
        context.setVariable("envir",o);
        engine.process("index", context, response.getWriter());
    }
}

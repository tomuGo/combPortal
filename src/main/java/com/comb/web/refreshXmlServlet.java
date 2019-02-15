package com.comb.web;

import com.comb.config.TemplateEngineUtil;
import com.comb.filter.CombFilter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/refreshXml")
public class refreshXmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        request.getServletContext().setAttribute(CombFilter.ENVIR_ATTRIBUTE,"1234");
        //context.setVariable("envir",o);
        //envirments = XmlUtil.readApplicationXml();
        engine.process("index", context, response.getWriter());
    }

}

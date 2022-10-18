package fii.jt.lab2.webfilter;

import fii.jt.lab2.wrapper.ResponseWrapper;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Custom Filter that uses a Wrapper over a Response and adds a Prelude and a Coda
 * Both ar <br> tags for sake of simplicity
 *
 * @author Amarandei Matei Alexandru
 */
@WebFilter(filterName = "WebFilter", urlPatterns = {"/*"})
public class ResponseFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ResponseWrapper wrapper = new ResponseWrapper((HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, wrapper);
        String content = wrapper.toString();
        PrintWriter out = servletResponse.getWriter();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie cookie = request.getCookies()[0];
        out.write("<h5>" + cookie.getValue() + "</h5><br>" + content + "<br>");
    }
}

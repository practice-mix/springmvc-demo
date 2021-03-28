package com.practice.springmvc.demo.filter;

import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Luo Bao Ding
 * @since 2018/12/12
 */
//@Component
public class ExtractKeyServletFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("ExtractKeyServletFilter: name = " + name);
        Assert.hasText(name, "the name should not be empty");
        String file = request.getParameter("file");
        Assert.isNull(file, "the file should not be a string");
        request.setAttribute("nameExtracted", name);
        filterChain.doFilter(request, response);
    }
}

package com.cs.ms.baseapp.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MessageFilter
 */
@WebFilter(urlPatterns={"/*"})
public class MessageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MessageFilter() {
      
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	 
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
		System.out.println("My Web Filter...");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException { 
	}

}

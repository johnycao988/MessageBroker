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
@WebFilter(urlPatterns = { "/*" })
public class MessageFilter implements Filter {

	Filter filter = null;

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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Start to do Web Filter...");

		if (this.filter != null)
			this.filter.doFilter(request, response, chain);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		filter = this.getFilter();
	}

	private Filter getFilter() {

		String fn = "WEB_FILTER_COMP_NAME";
		String name = System.getenv().get(fn);
		if (name == null)
			name = System.getProperty(fn);

		System.out.println("WEB_FILTER_COMP_NAME is " + name);

		try {
			return (Filter) Class.forName(name).newInstance();
		} catch (Exception e) {
			return null;
		}

	}
}

package dev.sgp.filtre;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;

public class FrequentationFilter implements Filter {

	private FilterConfig config = null;
	@Inject private VisiteWebService visiteService;
	
	
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("TimerFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		long before = System.currentTimeMillis();
		String path = ((HttpServletRequest) req).getRequestURI();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		config.getServletContext().log(path + " : " + (after - before));
		
		visiteService.sauvegarderVisiteWeb(new VisiteWeb(path, (int)(after - before)));

	}

	@Override
	public void destroy() { }

}
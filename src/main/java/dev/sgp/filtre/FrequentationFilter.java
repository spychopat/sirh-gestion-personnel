package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.util.Constantes;

public class FrequentationFilter implements Filter {

	private FilterConfig config = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("TimerFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		String path = ((HttpServletRequest) req).getRequestURI();
		config.getServletContext().log(path + " : " + (after - before));
		
		Constantes.VISITE_SERVICE.sauvegarderVisiteWeb(new VisiteWeb(path, (int)(after - before)));

	}

	@Override
	public void destroy() { }

}
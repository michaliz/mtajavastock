package com.mta.javacourse.michal.izraitel.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.michal.izraitel.model.Portfolio;
import com.mta.javacourse.michal.izraitel.model.Stock;
import com.mta.javacourse.michal.izraitel.service.PortfolioService;

/**
 * An instance of this class sends data to front end, the html side.
 * @author Michal Izraitel
 * @since 04/12/2014
 *
 */

public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio = portfolioService.getPortfolio();
						
		resp.setContentType("text/html");
		
		resp.getWriter().println (portfolio.getHtmlString());
	}
}
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
		Portfolio portfolio1 = portfolioService.getPortfolio();
		Portfolio portfolio2 = new Portfolio(portfolio1);
						
		resp.setContentType("text/html");
		
		portfolio2.setTitle (" Potfolio #2 ");
		resp.getWriter().println (portfolio1.getHtmlString());
		resp.getWriter().println (portfolio2.getHtmlString());
		portfolio1.deleteStock(0);
		resp.getWriter().println (" <h1><b> The portfolio after a deleted Stock: </h1></b> ");
		resp.getWriter().println (portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		portfolio2.getStocks()[2].setBid((float)55.55);
		resp.getWriter().println(" <h1><b> The portfolio after the change of the bid </h1></b> ");
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		}
}
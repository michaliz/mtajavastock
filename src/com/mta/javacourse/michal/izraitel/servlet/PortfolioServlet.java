package com.mta.javacourse.michal.izraitel.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.michal.izraitel.exception.BalanceException;
import com.mta.javacourse.michal.izraitel.exception.PortfolioFullException;
import com.mta.javacourse.michal.izraitel.exception.QuantityException;
import com.mta.javacourse.michal.izraitel.exception.StockAlreadyExistsException;
import com.mta.javacourse.michal.izraitel.exception.StockNotExistException;
import com.mta.javacourse.michal.izraitel.model.Portfolio;
import com.mta.javacourse.michal.izraitel.service.PortfolioService;

/**
 * An instance of this class sends data to front end, the html side.
 * @author Michal Izraitel
 * @since 04/12/2014
 *
 */

public class PortfolioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio;
		try {
			portfolio = portfolioService.getPortfolio();
			resp.getWriter().println(portfolio.getHtmlString());
		} catch (PortfolioFullException e) {
			resp.getWriter().println(e.getMessage());
		} catch (StockAlreadyExistsException e) {
			resp.getWriter().println(e.getMessage());
		} catch (StockNotExistException e) {
			resp.getWriter().println(e.getMessage());
		} catch (BalanceException e) {
			resp.getWriter().println(e.getMessage());
		} catch (QuantityException e) {
			resp.getWriter().println(e.getMessage());
		}
						
		resp.setContentType("text/html");
	}
}
package com.mta.javacourse.michal.izraitel.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.michal.izraitel.model.Portfolio;
import com.mta.javacourse.michal.izraitel.model.Stock;
import com.mta.javacourse.michal.izraitel.model.Portfolio.StockStatus;


/**
 * An instance of this class creates a new portfolio. It receives the values and descriptions of
 * 3 stocks and adds it to the array of stocks.
 * @author Michal Izraitel
 * @since 04/12/2014
 *
 */

public class PortfolioService {
	
	private final static int MAX_PORTFOLIO_SIZE = 5;
	Portfolio myPortfolio;
	
	public PortfolioService() {
		myPortfolio = new Portfolio ("NEW PORTFOLIO", new Stock[MAX_PORTFOLIO_SIZE], new StockStatus[MAX_PORTFOLIO_SIZE], 0);
	}
	
	/**
	 * 3 new stocks are created and values are put in them. Afterwards, the stock is added
	 * to the array of stocks.
	 * @return the full updated portfolio containing all the new stock's information.
	 */
	
	public Portfolio getPortfolio() {
		
		Calendar c = Calendar.getInstance();
		c.set(2014, 10, 15, 00, 00);
		Date mydate = c.getTime();
		
		Stock stock1;
		stock1 = new Stock("PIH", (float) 12.4, (float) 13.1, mydate);
		myPortfolio.addStock(stock1);
			
		Stock stock2;
		stock2 = new Stock("AAL", (float) 5.5, (float) 5.78, mydate);
		myPortfolio.addStock(stock2);
		
		Stock stock3;
		stock3 = new Stock("CAAS", (float) 31.5, (float) 31.2, mydate);
		myPortfolio.addStock(stock3);
		
		return myPortfolio;
		
	}
}
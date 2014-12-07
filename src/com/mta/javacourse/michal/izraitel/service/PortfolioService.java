package com.mta.javacourse.michal.izraitel.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.michal.izraitel.Stock;
import com.mta.javacourse.michal.izraitel.model.Portfolio;


/**
 * An instance of this class creates a new portfolio. It receives the values and descriptions of
 * 3 stocks and adds it to the array of stocks.
 * @author Michal Izraitel
 * @since 04/12/2014
 *
 */

public class PortfolioService {
	
	/**
	 * 3 new stocks are created and values are put in them. Afterwards, the stock is added
	 * to the array of stocks.
	 * @return the full updated portfolio containing all the new stock's information.
	 */
	
	public Portfolio getPortfolio() {
		
		Calendar c = Calendar.getInstance();
		c.set(2014, 10, 15, 00, 00);
		Date mydate = c.getTime();
		
		Portfolio myPortfolio = new Portfolio();
		
		Stock stock1;
		stock1 = new Stock();
		stock1.setSymbol("PIH");
		stock1.setAsk((float) 12.4);
		stock1.setBid((float) 13.1);
		stock1.setDate(mydate);
			
		myPortfolio.addStock(stock1);
			
		Stock stock2;
		stock2 = new Stock();
		stock2.setSymbol("AAL");
		stock2.setAsk((float) 5.5);
		stock2.setBid((float) 5.78);
		stock2.setDate(mydate);	
			
		myPortfolio.addStock(stock2);
		
		Stock stock3;
		stock3 = new Stock();
		stock3.setSymbol("CAAS");
		stock3.setAsk((float) 31.5);
		stock3.setBid((float) 31.2);
		stock3.setDate(mydate);
			
		myPortfolio.addStock(stock3);
		
		return myPortfolio;
		
	}
}



package com.mta.javacourse.michal.izraitel.model;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.michal.izraitel.Stock;

/**
 *  An instance of this class represents a portfolio of stocks.
 * @author Michal Izraitel
 * @since 04/12/2014
 */

public class Portfolio {
	
 	/**
 	 * The portfolio's title/name.
 	 */
	private String title;
	
	/**
	 * The maximum size for the array that contains the stocks.
	 */
	private final static int MAX_PORTFOLIO_SIZE = 5;
	
	/**
	 * An array of stocks, in each place in the array is a stock with full details.
	 */
	private Stock[]stocks;
	
	/**
	 * An array of information about the stocks status.
	 */
	private StockStatus[]stocksStatus;
	
	/**
	 * Represents a counter that holds the amount of "filled" places in the array.
	 */
	private int portfolioSize = 0;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public StockStatus[] getStocksStatus() {
		return stocksStatus;
	}

	public void setStocksStatus(StockStatus[] stocksStatus) {
		this.stocksStatus = stocksStatus;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	public static int getMaxPortfolioSize() {
		return MAX_PORTFOLIO_SIZE;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}

	public Portfolio() {
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		stocksStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
	}
	
	
	/**
	 * Receives a stock and adds it to the array containing the stocks. After this action, 
	 * the portfolio size is updated so that the next added stock will be in the next empty place. 
	 * @param stock - The stock to be added to the array of stocks.
	 */
	public void addStock (Stock stock) {
		stocks[portfolioSize] = stock;
				portfolioSize++;
	}
	

	/**
	 * Gets the array of stocks to use in other classes.
	 * @return the array of stocks.
	 */
	public Stock[] getStocks () {
		return stocks;
	}
	
	
	/**
	 * A method that concats all the html descriptions of the stocks in the array.
	 * The loop goes over the array, according to it's size, and adds the description in a string.
	 * @return the portfolio's title and adds to it the html code with the stock's details
	 */
	
	public String getHtmlString () {
		String htmlTitle = " <h1> Portfolio Title: </h1>";
		String htmlCodeString = " ";
		for (int i = 0; i < portfolioSize; i++)
			htmlCodeString += stocks[i].getHtmlDescription() + "<br>"; 
		return htmlTitle + htmlCodeString;
		}
		
	public class StockStatus {
		private String symbol;
		private float currentBid, currentAsk;
		private Date date;
		private int recommendation, stockQuantity;
		private final static int DO_NOTHING = 0, BUY = 1, SELL = 2;

		
	}
}
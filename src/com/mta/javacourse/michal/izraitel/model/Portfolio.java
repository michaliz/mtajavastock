package com.mta.javacourse.michal.izraitel.model;

import java.util.Date;

/**
 *  An instance of this class represents a portfolio of stocks. It holds the portfolio's name
 *  (title), maximum size, current amount of stocks in it and their status.
 * @author Michal Izraitel
 * @since 04/12/2014
 */

public class Portfolio {

	private String title;
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[]stocks;
	private StockStatus[]stocksStatus;
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
	

	/**
	 * A method that creates a new Portfolio and inputs values in it's fields.
	 * @param titleS - the portfolio's name/title.
	 * @param stocksS - an array of stocks.
	 * @param stockStatusS - an array of statuses for each stock.
	 * @param portfolioSizeS - the amount of stocks in the portfolio.
	 */
	
	public Portfolio(String titleS, Stock[]stocksS, StockStatus[]stocksStatusS, int portfolioSizeS) {
		title = titleS;
		stocks = stocksS;
		stocksStatus = stocksStatusS;
		portfolioSize = portfolioSizeS;
	}
	
	/**
	 * A copy constructor that makes a new, copied Portfolio.
	 * @param portfolio
	 */
	
	public Portfolio (Portfolio portfolio) {
		this("NEW PORTFOLIO", new Stock[MAX_PORTFOLIO_SIZE], new StockStatus[MAX_PORTFOLIO_SIZE], 0);
		
		for(int i = 0; i < portfolio.portfolioSize ; i++) {
			stocks[i] = new Stock(portfolio.stocks[i]);
			stocksStatus[i] = new StockStatus(portfolio.stocksStatus[i]);
		}
		
		this.setTitle(portfolio.getTitle());
		this.portfolioSize = portfolio.portfolioSize;
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
		
		String htmlCodeString = " <br><b><h1> " + this.getTitle() + ": </h1></b><br><br> ";
		for(int i = 0; i < portfolioSize; i++)
			htmlCodeString += stocks[i].getHtmlDescription() + "<br>";
		return htmlCodeString;
	}
		
	public class StockStatus {
		private String symbol;
		private float currentBid, currentAsk;
		private Date date;
		private int recommendation, stockQuantity;
		private final static int DO_NOTHING = 0, BUY = 1, SELL = 2;
		
		/**
		 * A method that creates a new array that contains the current status of each stock
		 * in the portfolio.
		 * @param symbolStatus - the stock's name/symbol.
		 * @param cBidStatus - the stock's bidding price.
		 * @param cAskStatus - the stock's asking price.
		 * @param dateStatus - the stock's date.
		 * @param recommStatus - a recommendation for what to do with the stock.
		 * @param stockQuaStatus - the quantity of the stock.
		 */
		
		public StockStatus(String symbolStatus, float cBidStatus, float cAskStatus, Date dateStatus, int recommStatus, int stockQuaStatus) {
			
			symbol = symbolStatus;
			currentBid = cBidStatus;
			currentAsk = cAskStatus;
			date = dateStatus;
			recommendation = recommStatus;
			stockQuantity = stockQuaStatus;
		}
	
	
		/**
		 * A copy constructor that makes a new, copied array of StockStatus.
		 * @param stocksStatus - an array that contains the current status of each stock
		 * in the portfolio.
		 */
		
		public StockStatus(StockStatus stocksStatus) {
			
			if(this.symbol != null) {
				this.symbol = stocksStatus.symbol;
				this.currentAsk = stocksStatus.currentBid;
				this.currentAsk = stocksStatus.currentAsk;
				this.date = stocksStatus.date;
				this.recommendation = stocksStatus.recommendation;
				this.stockQuantity = stocksStatus.stockQuantity;
			}
		}
	}
		
	/**
	 * 	A method that deletes one of the stocks in the portfolio.
	 * @param deleteLocation - the stock that is to be deleted.
	 */
	
	public void deleteStock(int deleteLocation) {
			if(deleteLocation == portfolioSize) {
				this.portfolioSize--;
				}
			else {
				this.portfolioSize--;
				for(int i = deleteLocation; i <= portfolioSize - 1; i++) {
					this.stocks[i] = this.stocks[i + 1];
					}
				}
		}
	}

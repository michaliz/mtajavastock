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
	private enum ALGO_RECOMMENDATION {DO_NOTHING, BUY, SELL};
	private float balance;

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

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
	 * Same with StockStock array. 
	 * @param newStock - The stock to be added to the array of stocks.
	 * @param newStocksStatus - The information about the stock that is being added and also
	 * being added to the StockStatus array.
	 */
	
	public void addStock (Stock newStock) {
		boolean flag = false;
		if (portfolioSize == MAX_PORTFOLIO_SIZE) {
			System.out.println("Can’t add new stock, portfolio can only have " +MAX_PORTFOLIO_SIZE+ " stocks.");
			flag = true;
		}
		for (int i = 0; i < portfolioSize && (!flag); i++) {
			if (newStock.getSymbol() == stocks[i].getSymbol()) {
				System.out.println("Can’t add new stock because it already exists in the array. You can buy stock instead.");
				flag = true;
			}
		}
		if(!flag) {
			stocks[portfolioSize] = newStock;
			stocksStatus[portfolioSize] = new StockStatus (newStock.getSymbol(), newStock.getAsk(), newStock.getBid(), new Date(newStock.getDate().getTime()),ALGO_RECOMMENDATION.DO_NOTHING, 0);
			portfolioSize++;
			System.out.println("The stock " +newStock.getSymbol()+ " was successfully added to the array in place: " +portfolioSize);
			}
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
		
		String htmlCodeString = " <b><h1> " + this.getTitle() + ": </h1></b><br> ";
		for(int i = 0; i < portfolioSize; i++) 
			htmlCodeString += stocks[i].getHtmlDescription() + stocksStatus[i].getStockQuantity() + "<br>";
		htmlCodeString += ("<br><b> The total portfolio value is: </b> " + this.getTotalValue()+ " $.<br><b> The total stock value is: </b> " + this.getStocksValue()+ " $.<br><b> The current balance is: </b> " + this.getBalance() + "$.<br>");
		return htmlCodeString;
	}
	
	/**
	 * An instance of this class represents an array that contains information about each stock.
	 * @author Michal Izraitel
	 * @since 15/12/2014
	 */
	
	public class StockStatus {
		private String symbol;
		private float currentBid, currentAsk;
		private Date date;
		private int stockQuantity;
		private ALGO_RECOMMENDATION recommendation;
		
		public String getSymbol() {
			return symbol;
		}


		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}


		public float getCurrentBid() {
			return currentBid;
		}


		public void setCurrentBid(float currentBid) {
			this.currentBid = currentBid;
		}


		public float getCurrentAsk() {
			return currentAsk;
		}


		public void setCurrentAsk(float currentAsk) {
			this.currentAsk = currentAsk;
		}


		public Date getDate() {
			return date;
		}


		public void setDate(Date date) {
			this.date = date;
		}


		public int getStockQuantity() {
			return stockQuantity;
		}


		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}


		public ALGO_RECOMMENDATION getRecommendation() {
			return recommendation;
		}


		public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
			this.recommendation = recommendation;
		}


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
		
		public StockStatus(String symbolStatus, float cAskStatus, float cBidStatus, Date dateStatus, ALGO_RECOMMENDATION recommStatus, int stockQuaStatus) {
			
			symbol = symbolStatus;
			currentAsk = cAskStatus;
			currentBid = cBidStatus;
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
				this.currentAsk = stocksStatus.currentAsk;
				this.currentBid = stocksStatus.currentBid;
				this.date = stocksStatus.date;
				this.recommendation = stocksStatus.recommendation;
				this.stockQuantity = stocksStatus.stockQuantity;
			}
		}
	}
		
	/**
	 * A method that updates the current balance in the portfolio. 
	 * @param amount - the sum that is added/subtracted to the balance.
	 */
	
	public void updateBalance (float amount) {
		balance += amount;
	}
	
	/**
	 * A method that deletes a stock from the portfolio (both from the array of stocks and the
	 * array of status). It checks if the stock exists in the portfolio and uses sellStock 
	 * method to sell this stock (if possible).
	 * @param symbol - the symbol of the stock the user wants to remove.
	 * @return a true/false answer if the stock was successfully removed or not.
	 */
	
	public boolean removeStock (String symbol) {
		for (int i = 0; i < portfolioSize; i++) {
			if (symbol == stocks[i].getSymbol()) {
				sellStock(symbol, -1);
				stocks[i] = stocks[portfolioSize - 1];
				stocksStatus[i] = stocksStatus[portfolioSize - 1];
				portfolioSize--;
				System.out.println("The stock " +symbol+ " was removed from your portfolio.");
				return true;
			}
		}
		
		System.out.println("The stock " +symbol+ " doesn't exist in your portfolio so it cannot be removed.");
		return false;
	}
	
	/**
	 * This method sells stocks and updates stock's quantity and the current balance. It checks
	 * if the amount of stocks the user wishes to sell even exists in his portfolio. 
	 * @param symbol - the symbol of the stock you wish to sell.
	 * @param quantity - the quantity of stocks with this symbol you wish to sell.
	 * @return an answer if it is possible to sell the stock (if it exists in the portfolio or 
	 * if the quantity is possible to sell).
	 */
	
	public boolean sellStock (String symbol, int quantity) {
		for (int i = 0; i < portfolioSize; i++) {
				if (symbol == stocks[i].getSymbol()) {
					if(quantity == -1) {
						updateBalance (stocks[i].getBid() * stocksStatus[i].getStockQuantity());
						stocksStatus[i].setStockQuantity(0);
						System.out.println("All " +symbol+ " stocks you own were sold from your portfolio. Your current balance is: " +balance );
					}
					else {
						if (stocksStatus[i].getStockQuantity() - quantity > 0) {
							stocksStatus[i].setStockQuantity(stocksStatus[i].getStockQuantity() - quantity);
							updateBalance (stocks[i].getBid() * quantity);
							System.out.println( quantity + symbol + " stocks were sold from your portfolio. Your current balance is: " +balance );
					}
						else {
							System.out.println("The quantity you want to sell is higher than the amount of stocks you own.");
							return false;
						}
					}
					return true;
				}
		}
		System.out.println("The stock " +symbol+ " doesn't exist in your portfolio so it cannot be sold.");
		return false;
	}
	
	/**
	 * A method that buys a stock and updates stock's quantity and balance. It checks if the 
	 * balance allows the purchase of the wanted quantity to buy or if it even exists in the portfolio.
	 * @param symbol -  the symbol of the stock you wish to buy.
	 * @param quantity - the quantity of stocks with this symbol you wish to buy.
	 * @return an answer if it is possible to buy the stock (if it exists in the portfolio or 
	 * if the quantity is possible to buy with the current balance).
	 */
	
	public boolean buyStock (String symbol, int quantity) {
		for (int i = 0; i < portfolioSize; i++) {
			if (symbol == stocks[i].getSymbol()) {
				if(quantity == -1) {
					int quan = (int)(balance / stocksStatus[i].getCurrentAsk());
					stocksStatus[i].setStockQuantity(stocksStatus[i].getStockQuantity() + quan);
					updateBalance (-(quan * stocksStatus[i].getCurrentAsk()));
					System.out.println( quan+ " stock/s of symbol " +symbol+ " were bought. Your current balance is: " +balance );
				}
				else {
					if ((stocksStatus[i].currentAsk * quantity) > balance) {
						System.out.println("Your balance is NOT high enough to complete the purchase.");
						return false;
					}
					else {
							stocksStatus[i].setStockQuantity(stocksStatus[i].getStockQuantity() + quantity);
							updateBalance (-(quantity * stocksStatus[i].getCurrentAsk()));
							System.out.println( quantity+ " stock/s of symbol " +symbol+ " were bought. Your current balance is: " +balance );
					}
				}
				return true;
			}
		}
		System.out.println("The stock " +symbol+ " you wish to buy doesn't exist in your portfolio.");
		return false;
	}
	
	/**
	 * A method that counts the value of all the stocks in the portfolio. It multiplies the bid
	 * of the stock by the quantity of stocks of the same kind.
	 * @return - the value of the portfolio (bid*quantity).
	 */
	
	public float getStocksValue() {
		float value = 0;
		for (int i = 0; i < portfolioSize; i++) {
			value += (stocksStatus[i].getCurrentBid() * stocksStatus[i].getStockQuantity());
		}
		return value;
	}
	
	/**
	 * A method that counts the total value of the portfolio. The value of the stocks I own
	 * and the amount of my balance.
	 * @return The total value of all the portfolio.
	 */
	
	public float getTotalValue() {
		return (getStocksValue() + getBalance());
	}
}
	

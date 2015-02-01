package com.mta.javacourse.michal.izraitel.model;


import java.util.List;

import com.mta.javacourse.michal.izraitel.exception.BalanceException;
import com.mta.javacourse.michal.izraitel.exception.IllegalQuantityException;
import com.mta.javacourse.michal.izraitel.exception.PortfolioFullException;
import com.mta.javacourse.michal.izraitel.exception.StockAlreadyExistsException;
import com.mta.javacourse.michal.izraitel.exception.StockNotExistException;

/**
 *  An instance of this class represents a portfolio of stocks. It holds the portfolio's name
 *  (title), maximum size, current amount of stocks in it and their status.
 * @author Michal Izraitel
 * @since 04/12/2014
 */

public class Portfolio {

	public final static int SIZE = 5;
	private String title;
	private StockStatus[] stocksStatus;
	public enum ALGO_RECOMMENDATION {DO_NOTHING, BUY, SELL}
	private int portfolioSize = 0;
	private float balance;
	
	/**
	 * A constructor that creates a new Portfolio and inputs values in it's fields.
	 */
	
	public Portfolio() {
		this.title = " ";
		this.stocksStatus = new StockStatus[SIZE];
		this.balance = 0;
		this.portfolioSize = 0;
	}
	
	public Portfolio(List<StockStatus> stockStatuses) {
		this();
		for (int i = 0; i < stockStatuses.size(); i++)
			this.stocksStatus[i] = stockStatuses.get(i);
		
	}
	
	/**
	 * A copy constructor that makes a new, copied Portfolio.
	 * @param portfolio
	 */
	
	public Portfolio(Portfolio p) {
		this.title = p.title;
		this.stocksStatus = new StockStatus[SIZE];
		for(int i = 0;i < SIZE; i++){
			if (p.stocksStatus[i] != null) {
				this.stocksStatus[i] = new StockStatus(p.stocksStatus[i]);	
			}
		}	
		this.balance = p.balance;
		this.portfolioSize = p.portfolioSize;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public static int getSize() {
		return SIZE;
	}
	
	public StockStatus[] getStocks(){
		return this.stocksStatus;
	}
 	

	/**
	 * A method that receives a stock and adds it to the array containing the stocks. After this action, 
	 * the portfolio size is updated so that the next added stock will be in the next empty place.
	 * Same with StockStock array. 
	 * @param newStock - The stock to be added to the array of stocks.
	 * @throws PortfolioFullException 
	 * @throws StockAlreadyExistsException 
	 */
	
	public void addStock (Stock newStock) throws PortfolioFullException, StockAlreadyExistsException {

		if (portfolioSize == SIZE) {
			System.out.println("Can’t add new stock, portfolio can only have " +SIZE+ " stocks.");
			throw new PortfolioFullException();
		}
		for (int i = 0; i < portfolioSize; i++) {
			if (newStock.getSymbol().equals(stocksStatus[i].getSymbol())) {
				System.out.println("Can’t add new stock because it already exists in the array.");
				throw new StockAlreadyExistsException(newStock.symbol);
			}
		}
		
		stocksStatus[portfolioSize] = new StockStatus (newStock);
		portfolioSize++;	
		System.out.println("The stock " +newStock.getSymbol()+ " was successfully added to the array");
	}


	/**
	 * A method that concats all the html descriptions of the stocks in the array.
	 * The loop goes over the array, according to it's size, and adds the description in a string.
	 * @return the portfolio's title and adds to it the html code with the stock's details
	 */
	
	public String getHtmlString () {
		
		String htmlCodeString = " <b><h1> " + this.getTitle() + ": </h1></b><br> ";
		for(int i = 0; i < portfolioSize; i++) 
			htmlCodeString += stocksStatus[i].getHtmlDescription() + stocksStatus[i].getStockQuantity() + "<br>";
		htmlCodeString += ("<br><b> The total portfolio value is: </b> " + this.getTotalValue()+ " $.<br><b> The total stock value is: </b> " + this.getStocksValue()+ " $.<br><b> The current balance is: </b> " + this.getBalance() + "$.<br>");
		return htmlCodeString;
	}
	
	/**
	 * A method that updates the current balance in the portfolio. 
	 * @param amount - the sum that is added/subtracted to the balance.
	 */
	
	public void updateBalance (float amount) throws BalanceException {
		if (this.balance + amount >= 0){
			this.balance += amount;
		}
		else
			throw new BalanceException();
	}
	
	public boolean StocksExists (String symbol) {
		int count = 0;
		for (int i = 0; i < portfolioSize; i++) {
			if (symbol.equals(stocksStatus[i].getSymbol())) 
				count++;
		}
		return (count != 0 );
	}
	
	/**
	 * A method that deletes a stock from the portfolio (both from the array of stocks and the
	 * array of status). It checks if the stock exists in the portfolio and uses sellStock 
	 * method to sell this stock (if possible).
	 * @param symbol - the symbol of the stock the user wants to remove.
	 * @return a true/false answer if the stock was successfully removed or not.
	 * @throws StockNotExistException 
	 * @throws BalanceException 
	 * @throws QuantityException 
	 */
	
	public void removeStock (String symbol) throws StockNotExistException, IllegalQuantityException, BalanceException {
		boolean exists = StocksExists (symbol);
		
		if (!exists) {
			System.out.println("The stock " +symbol+ " doesn't exist in your portfolio so it cannot be removed.");
			throw new StockNotExistException(symbol);
		}
		
		for (int i = 0; i < portfolioSize; i++) {
			if (symbol.equals(stocksStatus[i].getSymbol())) {
				sellStock(symbol, -1);
				stocksStatus[i] = stocksStatus[portfolioSize - 1];
				stocksStatus[i] = stocksStatus[portfolioSize - 1];
				portfolioSize--;
				System.out.println("The stock " +symbol+ " was removed from your portfolio.");
			}
		}
	}
	
	/**
	 * This method sells stocks and updates stock's quantity and the current balance. It checks
	 * if the amount of stocks the user wishes to sell even exists in his portfolio. 
	 * @param symbol - the symbol of the stock you wish to sell.
	 * @param quantity - the quantity of stocks with this symbol you wish to sell.
	 * @return an answer if it is possible to sell the stock (if it exists in the portfolio or 
	 * if the quantity is possible to sell).
	 * @throws BalanceException 
	 * @throws QuantityException 
	 */
	
	public void sellStock (String symbol, int quantity) throws StockNotExistException, IllegalQuantityException, BalanceException {
		boolean exists = StocksExists (symbol);
		
		if (!exists) {
			System.out.println("The stock " +symbol+ " doesn't exist in your portfolio so it cannot be sold.");
			throw new StockNotExistException(symbol);
		}
		
		for (int i = 0; i < portfolioSize; i++) {
				if (symbol.equals(stocksStatus[i].getSymbol())) {
					if(quantity == -1) {
						updateBalance (stocksStatus[i].getBid() * stocksStatus[i].getStockQuantity());
						stocksStatus[i].setStockQuantity(0);
						System.out.println("All " +symbol+ " stocks you own were sold from your portfolio. Your current balance is: " +balance );
					}
					else {
						if (stocksStatus[i].getStockQuantity() - quantity > 0) {
							stocksStatus[i].setStockQuantity(stocksStatus[i].getStockQuantity() - quantity);
							updateBalance (stocksStatus[i].getBid() * quantity);
							System.out.println( quantity + symbol + " stocks were sold from your portfolio. Your current balance is: " +balance );
					}
						else {
							System.out.println("The quantity you want to sell is higher than the amount of stocks you own.");
							throw new IllegalQuantityException(symbol);
						}
					}
				}
		}
	}
	
	/**
	 * A method that buys a stock and updates stock's quantity and balance. It checks if the 
	 * balance allows the purchase of the wanted quantity to buy or if it even exists in the portfolio.
	 * @param symbol -  the symbol of the stock you wish to buy.
	 * @param quantity - the quantity of stocks with this symbol you wish to buy.
	 * @return an answer if it is possible to buy the stock (if it exists in the portfolio or 
	 * if the quantity is possible to buy with the current balance).
	 * @throws StockNotExistException 
	 * @throws BalanceException 
	 */
	
	public void buyStock (String symbol, int quantity) throws StockNotExistException, BalanceException {
		boolean exists = StocksExists (symbol);
		
		if (!exists) {
			System.out.println("The stock " +symbol+ " you wish to buy doesn't exist in your portfolio.");
			throw new StockNotExistException(symbol);
		}
		
		for (int i = 0; i < portfolioSize; i++) {
			if (symbol.equals(stocksStatus[i].getSymbol())) {
				if(quantity == -1) {
					int quan = (int)(balance / stocksStatus[i].getAsk());
					stocksStatus[i].setStockQuantity(stocksStatus[i].getStockQuantity() + quan);
					updateBalance (-(quan * stocksStatus[i].getAsk()));
					System.out.println( quan+ " stock/s of symbol " +symbol+ " were bought. Your current balance is: " +balance );
				}
				else {
					if ((stocksStatus[i].ask * quantity) > balance) {
						System.out.println("Your balance is NOT high enough to complete the purchase.");
						throw new BalanceException();
					}
					else {
							stocksStatus[i].setStockQuantity(stocksStatus[i].getStockQuantity() + quantity);
							updateBalance (-(quantity * stocksStatus[i].getAsk()));
							System.out.println (quantity+ " stock/s of symbol " +symbol+ " were bought. Your current balance is: " +balance );
					}
				}
			}
		}
	}
	
	public StockStatus findBySymbol(String symbol) {
		for (int i = 0; i < SIZE ; i++) {
			if(this.stocksStatus[i] != null && symbol.equals(stocksStatus[i].getSymbol())) {
				return stocksStatus[i];
			}
		}
		return null;
	}
	
	/**
	 * A method that counts the value of all the stocks in the portfolio. It multiplies the bid
	 * of the stock by the quantity of stocks of the same kind.
	 * @return - the value of the portfolio (bid*quantity).
	 */
	
	public float getStocksValue() {
		float value = 0;
		for (int i = 0; i < portfolioSize; i++) {
			value += (stocksStatus[i].getBid() * stocksStatus[i].getStockQuantity());
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
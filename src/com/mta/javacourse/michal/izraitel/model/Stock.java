package com.mta.javacourse.michal.izraitel.model;

import java.util.Date;

/**
 * An instance of this class represents a stock. It's characteristics are: symbol, ask, bid
 * and date.
 * @author Michal Izraitel
 * @since 09/12/2014
 */
public class Stock {
	
	protected String symbol;
	protected float ask, bid;
	protected java.util.Date date;
	
	
	/**
	 * Constructors that create new Stock and inputs values in it's fields.
	 * @param symbolS - the stock's name/symbol.
	 * @param askS - the stock's asking price.
	 * @param bidS - the stock's bidding price.
	 * @param dateS - the stock's date.
	 */
	
	public Stock () {
		this("",0,0,new Date(0));
	}
	
	public Stock (String symbolS, float askS, float bidS, Date dateS) {
		symbol = symbolS;
		ask = askS;
		bid = bidS;
		date = dateS;
	}
	
	
	/**
	 * A copy constructor that makes a new, copied Stock.
	 * @param stock - the stock we wish to copy.
	 */
	
	public Stock (Stock stock){
		this(stock.getSymbol(), stock.getAsk(), stock.getBid(), new Date(stock.getDate().getTime()));
	}
	
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public float getAsk() {
		return ask;
	}

	public void setAsk(float ask) {
		this.ask = ask;
	}

	public float getBid() {
		return bid;
	}

	public void setBid(float bid) {
		this.bid = bid;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = new Date (date.getTime());
	}
	
	public void setStock(String symbol, float ask, float bid, Date d) {
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = new Date (d.getTime());
	}
	
	public boolean sameString (String symbol){
		return (this.symbol.equals(symbol));
	}
	
	
	/**
	 * Gets the stock's information (symbol, ask, bid and date) and turns it into one string.
	 * @return the new string containing all the stock's information.
	 */
	
	public String getHtmlDescription() {
		String stockHtmlDetailsString = new String (" <b>  Stock symbol:</b>  " + getSymbol() + " <b>  Bid:</b>  " + getBid() + " <b>  Ask:</b>  "  + getAsk() + " <b>  Date:</b>  " + getDate() + " <b>  Quantity of these stocks:</b>  ");
		return stockHtmlDetailsString;
		}
	
}
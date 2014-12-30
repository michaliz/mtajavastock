package com.mta.javacourse.michal.izraitel.model;

import java.util.Date;

import com.mta.javacourse.michal.izraitel.model.Portfolio.ALGO_RECOMMENDATION;

/**
 * An instance of this class represents an array that contains information about each stock.
 * @author Michal Izraitel
 * @since 15/12/2014
 */

public class StockStatus extends Stock {
	
	private int stockQuantity;
	private ALGO_RECOMMENDATION recommendation;
	
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
	 * A constructor that creates a new array that contains the current status of each stock
	 * in the portfolio.
	 * @param symbolStatus - the stock's name/symbol.
	 * @param cBidStatus - the stock's bidding price.
	 * @param cAskStatus - the stock's asking price.
	 * @param dateStatus - the stock's date.
	 * @param recommStatus - a recommendation for what to do with the stock.
	 * @param stockQuaStatus - the quantity of the stock.
	 */
	
	public StockStatus(String symbol, float ask, float bid, Date date, ALGO_RECOMMENDATION recomm, int stockQuan) {
		super (symbol, ask, bid, date);
		this.recommendation = recomm;
		this.stockQuantity = stockQuan;
	}
	
	
	public StockStatus (StockStatus stocksStatus) {
		super (stocksStatus.getSymbol(), stocksStatus.getAsk(), stocksStatus.getBid(), new Date(stocksStatus.getDate().getTime()));
		this.recommendation = stocksStatus.getRecommendation();
		this.stockQuantity = stocksStatus.getStockQuantity();
	}
}

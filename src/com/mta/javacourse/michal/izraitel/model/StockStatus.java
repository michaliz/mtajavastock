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
	

	/**
	 * Constructors that create new StockStatus and inputs values in it's fields.
	 * @param symbol - the stock's name/symbol.
	 * @param ask - the stock's asking price.
	 * @param bid - the stock's bidding price.
	 * @param date - the stock's date.
	 */
	
	public StockStatus(){
		super ();
		this.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		stockQuantity = 0;
	}

	public StockStatus(String symbol, float ask, float bid, Date date) {
		super (symbol, ask, bid, date);
		this.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		this.stockQuantity = 0;
	}
	
	public StockStatus(Stock stock){
		super(stock);
		this.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		stockQuantity = 0;
	}
	
	/**
	 * A copy constructor.
	 * @param stocksStatus - an array that contains the status for each stock.
	 */
	
	public StockStatus (StockStatus stocksStatus) {
		super ((Stock)stocksStatus);
		this.recommendation = stocksStatus.getRecommendation();
		this.stockQuantity = stocksStatus.getStockQuantity();
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
}

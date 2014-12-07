package com.mta.javacourse.michal.izraitel;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Stock {
	
	private String symbol;
	private float ask, bid;
	private Date date;
	
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
		this.date = date;
	}
	
	public String getHtmlDescription() {
		String stockHtmlDetailsString = " <b>  Stock symbol</b>:  " + getSymbol() + " <b>  Bid</b>:  " + getBid() + " <b>  Ask</b>:  "  + getAsk() + " <b>  Date</b>:  " + getDate();
		return stockHtmlDetailsString;
		}
}
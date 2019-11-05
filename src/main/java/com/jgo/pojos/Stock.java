package com.jgo.pojos;

import com.jgo.annotations.DismissField;
import com.jgo.annotations.OneToOne;

/**
 * Model class for Stock
 */
public class Stock implements java.io.Serializable {
	
	
	
	@DismissField
	private static final long serialVersionUID = 1L;
	private Integer stockPId;
	private String stockCode;
	
	private String stockName;
	
	@OneToOne
	Category category;
	


	public Stock() {
	}

	public Stock(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Integer getStockPId() {
		return this.stockPId;
	}

	public void setStockPId(Integer stockPId) {
		this.stockPId = stockPId;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

}


package com.boot.demo;

public class ProductData {
	
	private String code;
	
	private String name;
	
	private String desc;
	
	private StockAndPriceData stockAndPrice;
	
	public ProductData() {}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public StockAndPriceData getStockAndPrice() {
		return stockAndPrice;
	}

	public void setStockAndPrice(StockAndPriceData stockAndPrice) {
		this.stockAndPrice = stockAndPrice;
	}		
}



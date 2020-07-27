package com.boot.demo;

public class StockAndPriceData {
	
	private int offlineStock;	

	private int onlineStock;
	
	private double unitPrice;
	
	private String uom;

	public int getOfflineStock() {
		return offlineStock;
	}

	public void setOfflineStock(int offlineStock) {
		this.offlineStock = offlineStock;
	}

	public int getOnlineStock() {
		return onlineStock;
	}

	public void setOnlineStock(int onlineStock) {
		this.onlineStock = onlineStock;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

}

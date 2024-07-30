package com.keyin.stock;

import com.keyin.stockmarket.StockMarket;

import java.util.List;

public class StockRequest {
    private String stockName;
    private List<StockMarket> stockMarkets;
    private double stockPrice;

    // Getters and Setters

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public List<StockMarket> getStockMarkets() {
        return stockMarkets;
    }

    public void setStockMarkets(List<StockMarket> stockMarkets) {
        this.stockMarkets = stockMarkets;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }
}

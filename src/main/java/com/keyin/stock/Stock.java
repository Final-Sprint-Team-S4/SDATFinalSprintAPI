package com.keyin.stock;

import com.keyin.stockmarket.StockMarket;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Stock {
//    id StockName StockMarket StockPrice


    @Id
    @SequenceGenerator(name = "stock_sequence", sequenceName = "stock_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "stock_sequence")
    private long stockId;

    private String stockName;

    @OneToMany
    private List<StockMarket> stockMarkets;

    private double stockPrice;

    public Stock() {
    }

    public Stock(long stockId, String stockName, List<StockMarket> stockMarket, double stockPrice) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockMarkets = stockMarket;
        this.stockPrice = stockPrice;
    }

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

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

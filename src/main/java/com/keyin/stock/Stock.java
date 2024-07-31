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

    @ManyToOne
    @JoinColumn(name = "stock_market_id")
    private StockMarket stockMarket;

    private double stockPrice;

    public Stock() {
    }

    public Stock(long stockId, String stockName, StockMarket stockMarket, double stockPrice) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.stockMarket = stockMarket;
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

    public StockMarket getStockMarket() {
        return stockMarket;
    }

    public void setStockMarket(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }
}

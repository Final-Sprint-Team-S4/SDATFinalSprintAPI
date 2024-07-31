//Mohamed
package com.keyin.stockmarket;

import com.keyin.stock.Stock;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class StockMarket {

    @Id
    @SequenceGenerator(name = "stockMarket_sequence", sequenceName = "stockMarket_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "stockMarket_sequence")
    private long stockMarketId;

    private String name;

    @OneToMany
    private List<Stock> stocks = new ArrayList<>();

    public StockMarket(String name) {
        this.name = name;
    }

    public  StockMarket(){
    }

    public long getStockMarketId() {
        return stockMarketId;
    }

    public void setStockMarketId(long stockMarketId) {
        this.stockMarketId = stockMarketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
        stock.setStockMarket(this);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
        stock.setStockMarket(null);
    }
}

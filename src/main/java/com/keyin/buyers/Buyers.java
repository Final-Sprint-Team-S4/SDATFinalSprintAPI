package com.keyin.buyers;

import jakarta.persistence.*;
import com.keyin.stock.Stock;
import com.keyin.stockmarket.StockMarket;

@Entity
public class Buyers {
    @Id
    @SequenceGenerator(name = "buyers_sequence", sequenceName = "buyers_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buyers_sequence")
    private Long id;
    private String name;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "stock_market_id")
    private StockMarket stockMarket;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public StockMarket getStockMarket() {
        return stockMarket;
    }

    public void setStockMarket(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
    }
}
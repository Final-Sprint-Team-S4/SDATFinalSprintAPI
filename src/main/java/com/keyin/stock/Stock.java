package com.keyin.stock;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.keyin.buyer.Buyer;
import com.keyin.stockmarket.StockMarket;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "company")
    private String company;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "stock_market_id")
    @JsonBackReference ////////TAKE THIS OUT IF NOT WORKINGGGG
    private StockMarket stockMarket;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "stock_buyer",
            joinColumns = @JoinColumn(name = "stock_id"),
            inverseJoinColumns = @JoinColumn(name = "buyer_id")
    )
    private List<Buyer> buyers;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public StockMarket getStockMarket() {
        return stockMarket;
    }

    public void setStockMarket(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }
}

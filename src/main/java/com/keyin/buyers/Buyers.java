package com.keyin.buyers;

import javax.persistence.*;

@Entity
public class Buyers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
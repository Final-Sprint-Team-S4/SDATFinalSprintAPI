//Mohamed
package com.keyin.stockmarket;

import com.keyin.stock.Stock;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class StockMarket {

    @Id
    @SequenceGenerator(name = "stockMarket_sequence", sequenceName = "stockMarket_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "stockMarket_sequence")
    private long stockMarketId;

    public void setStock(Stock stock) {
    }
}

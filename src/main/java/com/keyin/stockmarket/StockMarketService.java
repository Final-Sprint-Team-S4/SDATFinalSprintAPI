package com.keyin.stockmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockMarketService {

    @Autowired
    private StockMarketRepository stockMarketRepository;

    public Iterable<StockMarket> getAllStockMarkets() {
        return stockMarketRepository.findAll();
    }

    public Optional<StockMarket> getStockMarketById(Long id) {
        return stockMarketRepository.findById(id);
    }

    public StockMarket createStockMarket(StockMarket stockMarket) {
        return stockMarketRepository.save(stockMarket);
    }

    public StockMarket updateStockMarket(Long id, StockMarket stockMarket) {
        stockMarket.setId(id);
        return stockMarketRepository.save(stockMarket);
    }

    public void deleteStockMarket(Long id) {
        stockMarketRepository.deleteById(id);
    }
}

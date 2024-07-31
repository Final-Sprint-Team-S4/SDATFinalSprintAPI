package com.keyin.stockmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockMarketService {
    @Autowired
    private StockMarketRepository stockMarketRepository;

    public StockMarket createStockMarket(StockMarket stockMarket) {
        return stockMarketRepository.save(stockMarket);
    }

    public Optional<StockMarket> getStockMarketById(Long id) {
        return stockMarketRepository.findById(id);
    }

    public Iterable<StockMarket> getAllStockMarkets() {
        return stockMarketRepository.findAll();
    }

    public StockMarket updateStockMarket(Long id, StockMarket updatedStockMarket) {
        if (stockMarketRepository.existsById(id)) {
            updatedStockMarket.setStockMarketId(id);
            return stockMarketRepository.save(updatedStockMarket);
        } else {
            return null;
        }
    }

    public boolean deleteStockMarket(Long id) {
        if (stockMarketRepository.existsById(id)) {
            stockMarketRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

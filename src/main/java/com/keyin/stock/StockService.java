package com.keyin.stock;

import com.keyin.stockmarket.StockMarket;
import com.keyin.stockmarket.StockMarketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockMarketRepository stockMarketRepository;

    public List<Stock> getAllStocks() {
        return (List<Stock>) stockRepository.findAll();
    }

    public Stock getStockById(long id) {
        Optional<Stock> stockMarketOptional = stockRepository.findById(id);
        return stockMarketOptional.orElse(null);
    }

    public void deleteStockById(long id) {
        stockRepository.deleteById(id);
    }

    public Stock createStock(Stock newStock) {
        return stockRepository.save(newStock);
    }

    public Stock updateStock(long id, Stock updatedStock) {
        Optional<Stock> stockToUpdateOptional = stockRepository.findById(id);

        if (stockToUpdateOptional.isPresent()) {
            Stock stockToUpdate = stockToUpdateOptional.get();

            stockToUpdate.setStockName(updatedStock.getStockName());
            stockToUpdate.setStockPrice(updatedStock.getStockPrice());
            stockToUpdate.setStockMarket(updatedStock.getStockMarket());

            return stockRepository.save(stockToUpdate);
        }
        return null; //need to handle null case
    }
}

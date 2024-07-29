package com.keyin.stock;

import com.keyin.stockmarket.StockMarket;
import com.keyin.stockmarket.StockMarketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockMarketRepository stockMarketRepository;

    @Transactional
    public Stock createStock(String stockName, List<StockMarket> stockMarkets, double stockPrice) {
        Stock stock = new Stock();
        stock.setStockName(stockName);
        stock.setStockMarkets(stockMarkets);
        stock.setStockPrice(stockPrice);

        // Save the stock to generate the stockId
        stock = stockRepository.save(stock);

        // Save the stock markets and associate them with the stock
        for (StockMarket stockMarket : stockMarkets) {
            stockMarket.setStock(stock);
            stockMarketRepository.save(stockMarket);
        }

        return stock;
    }
}

package com.keyin.stock;

import com.keyin.buyer.Buyer;
import com.keyin.buyer.BuyerRepository;
import com.keyin.stockmarket.StockMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Transactional
    public Stock saveStock(Stock stock) {
        for (Buyer buyer : stock.getBuyers()) {
            if (buyer.getId() != null) {
                Buyer existingBuyer = buyerRepository.findById(buyer.getId()).orElse(null);
                if (existingBuyer != null) {
                    stock.getBuyers().remove(buyer);
                    stock.getBuyers().add(existingBuyer);
                }
            }
        }
        return stockRepository.save(stock);
    }

    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }

    public List<Stock> findAll() {
        Iterable<Stock> stockIterable = stockRepository.findAll();
        List<Stock> stockList = new ArrayList<>();
        stockIterable.forEach(stockList::add);
        return stockList;
    }

    @Transactional
    public void deleteById(Long id) {
        stockRepository.deleteById(id);
    }
}
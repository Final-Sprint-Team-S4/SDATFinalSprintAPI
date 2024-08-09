package com.keyin.buyer;

import com.keyin.stock.Stock;
import com.keyin.stock.StockRepository;
import com.keyin.stockmarket.StockMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockMarketRepository stockMarketRepository;

    public Iterable<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Optional<Buyer> getBuyerById(Long id) {
        return buyerRepository.findById(id);
    }


    public Buyer createBuyer(Buyer newBuyer) {
        if(newBuyer.getStocks() == null){
            Stock defaultStock = stockRepository.findBySymbol("Default");
            if(defaultStock == null){
                defaultStock = new Stock();
                defaultStock.setSymbol("DEFAULT");
                defaultStock.setCompany("Default Company");
                defaultStock.setPrice(0.00);
                stockRepository.save(defaultStock);
                stockRepository.save(defaultStock);
            }

            ArrayList<Stock> stockList = new ArrayList<Stock>();
            stockList.add(defaultStock);

            newBuyer.setStocks(stockList);
        } else {
            for(Stock stock: newBuyer.getStocks()){
                Stock stockInDb = stockRepository.findBySymbol(stock.getSymbol());
                if (stockInDb == null){
                    stock = stockRepository.save(stock);
                }

            }
        }


        return buyerRepository.save(newBuyer);
    }

    public Buyer findById(Long id) {
        return buyerRepository.findById(id).orElseThrow(() -> new RuntimeException("Buyer not found"));
    }

    public List<Buyer> findAll() {
        return (List<Buyer>) buyerRepository.findAll();
    }

    @Transactional
    public Buyer updateBuyer(Long id, String buyerName, List<Long> stockIds) {
        Buyer buyer = buyerRepository.findById(id).orElseThrow(() -> new RuntimeException("Buyer not found"));
        buyer.setName(buyerName);

        List<Stock> stocks = new ArrayList<>();

        for (Long stockId : stockIds) {
            Stock stock = stockRepository.findById(stockId).orElse(null);
            if (stock == null) {
                throw new RuntimeException("Stock with id " + stockId + " not found");
            }
            stocks.add(stock);
        }

        buyer.setStocks(stocks);
        return buyerRepository.save(buyer);
    }

    @Transactional
    public void deleteById(Long id) {
        buyerRepository.deleteById(id);
    }

    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);
    }

    @Transactional
    public Buyer saveBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public List<Buyer>  getBuyerByStockSymbol (String stockSymbol) {
       return buyerRepository.findBuyerByStocks_Symbol(stockSymbol);
    }
}
package com.keyin.stockmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stockmarkets")
public class StockMarketController {

    @Autowired
    private StockMarketService stockMarketService;

    @GetMapping
    public Iterable<StockMarket> getAllStockMarkets() {
        return stockMarketService.getAllStockMarkets();
    }

    @GetMapping("/{id}")
    public StockMarket getStockMarketById(@PathVariable Long id) {
        return stockMarketService.getStockMarketById(id).orElse(null);
    }

    @PostMapping
    public StockMarket createStockMarket(@RequestBody StockMarket stockMarket) {
        return stockMarketService.createStockMarket(stockMarket);
    }

    @PutMapping("/{id}")
    public StockMarket updateStockMarket(@PathVariable Long id, @RequestBody StockMarket stockMarket) {
        return stockMarketService.updateStockMarket(id, stockMarket);
    }

    @DeleteMapping("/{id}")
    public void deleteStockMarket(@PathVariable Long id) {
        stockMarketService.deleteStockMarket(id);
    }
}

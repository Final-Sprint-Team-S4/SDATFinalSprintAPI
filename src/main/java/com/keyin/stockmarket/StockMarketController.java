package com.keyin.stockmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/stockmarket")
public class StockMarketController {

    @Autowired
    private StockMarketService stockMarketService;

    @PostMapping
    public ResponseEntity<StockMarket> createStockMarket(@RequestBody StockMarket stockMarket) throws URISyntaxException {
        StockMarket savedStockMarket = stockMarketService.createStockMarket(stockMarket);
        return ResponseEntity.created(new URI("/stockmarket/" + savedStockMarket.getStockMarketId())).body(savedStockMarket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockMarket> getStockMarketById(@PathVariable Long id) {
        Optional<StockMarket> stockMarket = stockMarketService.getStockMarketById(id);
        return stockMarket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public Iterable<StockMarket> getAllStockMarkets() {
        return stockMarketService.getAllStockMarkets();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockMarket> updateStockMarket(@PathVariable Long id, @RequestBody StockMarket stockMarket) {
        StockMarket updatedStockMarket = stockMarketService.updateStockMarket(id, stockMarket);
        return updatedStockMarket != null ? ResponseEntity.ok(updatedStockMarket) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStockMarket(@PathVariable Long id) {
        boolean deleted = stockMarketService.deleteStockMarket(id);
        return deleted ? ResponseEntity.ok("Stock Market Was Deleted") : ResponseEntity.notFound().build();
    }
}

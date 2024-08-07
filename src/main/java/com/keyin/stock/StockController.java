package com.keyin.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        Stock savedStock = stockService.saveStock(stock);
        return ResponseEntity.ok(savedStock);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Optional<Stock> stock = stockService.findById(id);
        return stock.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.findAll();
        return ResponseEntity.ok(stocks);
    }

    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        return stockService.updateStock(id, stock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockById(@PathVariable Long id) {
        stockService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
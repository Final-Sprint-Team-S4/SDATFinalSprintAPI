package com.keyin.stock;

import com.keyin.stockmarket.StockMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable long id) {
        Stock stock = stockService.getStockById(id);
        if (stock != null) {
            return ResponseEntity.ok(stock);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock newStock) {
        Stock createdStock = stockService.createStock(newStock);
        return ResponseEntity.ok(createdStock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable long id, @RequestBody Stock updatedStock) {
        Stock stock = stockService.updateStock(id, updatedStock);
        if (stock != null) {
            return ResponseEntity.ok(stock);
        } else {
            // If the stock was not found, create a new stock
            updatedStock.setStockId(id);
            Stock createdStock = stockService.createStock(updatedStock);
            return ResponseEntity.ok(createdStock);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable long id) {
        stockService.deleteStockById(id);
        return ResponseEntity.noContent().build();
    }
}

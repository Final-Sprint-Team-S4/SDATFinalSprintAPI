//Mohamed
package com.keyin.stock;

import com.keyin.stockmarket.StockMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/create")
    public ResponseEntity<Stock> createStock(
            @RequestParam String stockName,
            @RequestParam List<StockMarket> stockMarkets,
            @RequestParam double stockPrice) {

        Stock stock = stockService.createStock(stockName, stockMarkets, stockPrice);
        return new ResponseEntity<>(stock, HttpStatus.CREATED);
    }

}

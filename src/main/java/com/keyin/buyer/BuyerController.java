package com.keyin.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/buyers")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @GetMapping
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        List<Buyer> buyers = buyerService.findAll();
        return ResponseEntity.ok(buyers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable Long id) {
        Buyer buyer = buyerService.findById(id);
        return ResponseEntity.ok(buyer);
    }
    @PostMapping
    public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer newBuyer) {
        Buyer savedBuyer = buyerService.createBuyer(newBuyer);
        return ResponseEntity.ok(savedBuyer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buyer> updateBuyer(
            @PathVariable Long id,
            @RequestParam String buyerName,
            @RequestParam List<Long> stockIds) {
        Buyer updatedBuyer = buyerService.updateBuyer(id, buyerName, stockIds);
        return ResponseEntity.ok(updatedBuyer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyerById(@PathVariable Long id) {
        buyerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
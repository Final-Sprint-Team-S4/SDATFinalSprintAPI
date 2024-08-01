package com.keyin.buyers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/buyers")
public class BuyersController {

    @Autowired
    BuyersService buyersService;

    @GetMapping public List<Buyers> getAllBuyers() {
        return buyersService.getAllBuyers();
    }

    @GetMapping("/{id}")public ResponseEntity<Buyers> getBuyerById(@PathVariable Long id) {
        Buyers buyer= buyersService.getBuyerById(id);
        if (buyer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buyer);
    }

    @PostMapping
    public Buyers createBuyer(@RequestBody Buyers newBuyer) {
        return buyersService.addBuyer(newBuyer);
    }

    @PutMapping("/{id}")public ResponseEntity<Buyers> updateBuyer(@PathVariable Long id, @RequestBody Buyers buyerDetails) {
        Buyers updatedBuyer= buyersService.updateBuyer(id, buyerDetails);
        if (updatedBuyer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBuyer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBuyer(@PathVariable Long id) {
        buyersService.deleteBuyer(id);
        return ResponseEntity.ok("Buyer Has Been Deleted");
    }
}
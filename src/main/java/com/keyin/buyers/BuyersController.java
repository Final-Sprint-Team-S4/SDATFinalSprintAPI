package com.keyin.buyers;

import com.keyin.buyers.Buyers;
import com.keyin.buyers.BuyersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/buyers") public class BuyersController {
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

    @PostMapping public Buyers createBuyer(@RequestBody Buyers buyer) {
        return buyersService.addBuyer(buyer);
    }

    @PutMapping("/{id}")public ResponseEntity<Buyers> updateBuyer(@PathVariable Long id, @RequestBody Buyers buyerDetails) {
        Buyers updatedBuyer= buyersService.updateBuyer(id, buyerDetails);
        if (updatedBuyer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBuyer);
    }

    @DeleteMapping("/{id}")public ResponseEntity<Void> deleteBuyer(@PathVariable Long id) {
        buyersService.deleteBuyer(id);
        return ResponseEntity.noContent().build();
    }
}
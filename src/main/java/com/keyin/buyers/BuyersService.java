package com.keyin.buyers;

import com.keyin.buyers.models.Buyers;
import com.keyin.buyers.repositories.BuyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@ServicepublicclassBuyersService {
    @Autowiredprivate BuyersRepository buyersRepository;

    public List<Buyers> getAllBuyers() {
        return buyersRepository.findAll();
    }
    public Buyers getBuyerById(Long id) {
        return buyersRepository.findById(id).orElse(null);
    }
    public Buyers addBuyer(Buyers buyer) {
        return buyersRepository.save(buyer);
    }
    public Buyers updateBuyer(Long id, Buyers buyerDetails) {
        Buyersbuyer= buyersRepository.findById(id).orElse(null);
        if (buyer != null) {

            buyer.setName(buyerDetails.getName());
            buyer.setEmail(buyerDetails.getEmail());
            buyer.setPhone(buyerDetails.getPhone());
            buyer.setStock(buyerDetails.getStock());
            buyer.setStockMarket(buyerDetails.getStockMarket());
            return buyersRepository.save(buyer);
        }
        returnnull;
    }
    publicvoiddeleteBuyer(Long id) {
        buyersRepository.deleteById(id);
    }
}

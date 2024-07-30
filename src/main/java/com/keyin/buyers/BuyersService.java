package com.keyin.buyers;

import com.keyin.buyers.Buyers;
import com.keyin.buyers.BuyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service public class BuyersService {
    @Autowired private BuyersRepository buyersRepository;

    public List<Buyers> getAllBuyers() {
        return (List<Buyers>) buyersRepository.findAll();
    }
    public Buyers getBuyerById(Long id) {
        return buyersRepository.findById(id).orElse(null);
    }
    public Buyers addBuyer(Buyers buyer) {
        return buyersRepository.save(buyer);
    }
    public Buyers updateBuyer(Long id, Buyers buyerDetails) {
        Buyers buyer= buyersRepository.findById(id).orElse(null);
        if (buyer != null) {

            buyer.setName(buyerDetails.getName());
            buyer.setEmail(buyerDetails.getEmail());
            buyer.setPhone(buyerDetails.getPhone());
            buyer.setStock(buyerDetails.getStock());
            buyer.setStockMarket(buyerDetails.getStockMarket());
            return buyersRepository.save(buyer);
        }
        return null;
    }
    public void deleteBuyer(Long id) {
        buyersRepository.deleteById(id);
    }
}

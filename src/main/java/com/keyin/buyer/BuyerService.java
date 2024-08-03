package com.keyin.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public Iterable<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Optional<Buyer> getBuyerById(Long id) {
        return buyerRepository.findById(id);
    }

    public Buyer createBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public Buyer updateBuyer(Long id, Buyer buyer) {
        buyer.setId(id);
        return buyerRepository.save(buyer);
    }

    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);
    }

    @Transactional
    public Buyer saveBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }
}
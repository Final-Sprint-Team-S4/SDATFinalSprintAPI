package com.keyin.buyer;

import com.keyin.stock.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer, Long> {
    List<Buyer> findBuyerByStocks_Symbol(String stockSymbol);

}
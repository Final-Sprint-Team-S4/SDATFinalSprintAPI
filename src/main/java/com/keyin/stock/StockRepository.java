package com.keyin.stock;

import com.keyin.buyer.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<Stock,Long > {
    Stock findBySymbol(String symbol);

}

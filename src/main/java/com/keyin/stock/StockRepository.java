package com.keyin.stock;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock,Long > {
    Stock findBySymbol(String symbol);
}

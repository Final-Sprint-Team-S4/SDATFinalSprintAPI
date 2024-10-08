package com.keyin.stockmarket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMarketRepository extends CrudRepository<StockMarket, Long> {
}

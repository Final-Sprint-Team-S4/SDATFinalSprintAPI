package com.keyin.stockmarket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StockMarketRepository extends CrudRepository<StockMarket, Long> {
}

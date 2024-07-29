//.
package com.keyin.stock;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StockRepository extends CrudRepository<Stock,Long > {
}

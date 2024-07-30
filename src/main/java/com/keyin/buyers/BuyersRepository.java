package com.keyin.buyers;

import com.keyin.buyers.Buyers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyersRepository extends CrudRepository<Buyers, Long> {
}
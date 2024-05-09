package com.elevengroup.watch.repository;

import com.elevengroup.watch.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends CrudRepository<Customer, Integer> {
    @Query(value = "SELECT * FROM customer WHERE user_name = ?1", nativeQuery = true)
    public Customer findByUserName(String username);
}

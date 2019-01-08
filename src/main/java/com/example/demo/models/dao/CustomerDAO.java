package com.example.demo.models.dao;

import com.example.demo.models.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer, Integer> {
}

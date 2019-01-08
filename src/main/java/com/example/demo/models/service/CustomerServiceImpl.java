package com.example.demo.models.service;

import com.example.demo.models.dao.CustomerDAO;
import com.example.demo.models.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDao;

    @Override
    @Transactional(readOnly=true)
    public List<Customer> getCustomers() {
        return (List<Customer>) customerDao.findAll();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    @Transactional(readOnly=true)
    public Customer getCustomer(Integer id) {
        return customerDao.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteCustomer(Integer id) {
        customerDao.deleteById(id);
    }
}

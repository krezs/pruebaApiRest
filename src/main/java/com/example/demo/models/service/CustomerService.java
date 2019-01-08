package com.example.demo.models.service;

import com.example.demo.models.entity.Customer;

import java.util.List;

public interface CustomerService {

    //Listar
    public List<Customer> getCustomers();
    //Guardar
    public void saveCustomer(Customer customer);
    //Obtener
    public Customer getCustomer(Integer id);
    //Eliminar
    public void deleteCustomer(Integer id);

}

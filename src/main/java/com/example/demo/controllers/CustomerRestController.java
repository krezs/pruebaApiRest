package com.example.demo.controllers;

import com.example.demo.models.entity.Customer;
import com.example.demo.models.service.CustomerService;
import com.example.demo.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/customers", method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> getCustomers(){
        //return customerService.getCustomers();
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setData(customerService.getCustomers());
        return new ResponseEntity<>(jsonResponse,HttpStatus.OK);
    }

    @RequestMapping(value="/customers/{id}" , method = RequestMethod.GET)
    public ResponseEntity<JsonResponse> getCustomer(@PathVariable int id){
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(customerService.getCustomer(id));
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setData(customers);
        return new ResponseEntity<>(jsonResponse,HttpStatus.OK);
    }

    @RequestMapping(value="/customers", method =RequestMethod.POST)
    public ResponseEntity<JsonResponse> addCustomer(@RequestBody Customer customer){

        JsonResponse jsonResponse = new JsonResponse();
        List<Customer> customers=new ArrayList<>();

        String msg= customer.getId()!=null ? "Customer Updated." : "Customer Created.";

        customerService.saveCustomer(customer);
        customers.add(customer);
        jsonResponse.setData(customers);
        jsonResponse.setMsg(msg);
        return new ResponseEntity<>(jsonResponse,HttpStatus.OK);
    }

    @RequestMapping(value="/customers/{id}", method =RequestMethod.POST)
    public ResponseEntity<JsonResponse> deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setMsg("Customer Deleted.");
        return new ResponseEntity<>(jsonResponse,HttpStatus.OK);
    }



}

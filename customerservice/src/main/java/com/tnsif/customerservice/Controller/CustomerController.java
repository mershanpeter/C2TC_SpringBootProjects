package com.tnsif.customerservice.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.customerservice.entity.Customer;
import com.tnsif.customerservice.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService c;

    // Get all customers
    @GetMapping("/customerservice")
    public List<Customer> list() {
        return c.listAll();
    }

    // Add new customer
    @PostMapping("/customerservice")
    public void add(@RequestBody Customer cl) {
        c.save(cl);
    }

    // Get customer by ID
    @GetMapping("/customerservice/{id}")
    public ResponseEntity<Customer> get(@PathVariable Integer id) {
        Customer c2 = c.get(id);
        if (c2 != null)
            return new ResponseEntity<>(c2, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete customer by ID
    @DeleteMapping("/customerservice/{id}")
    public void delete(@PathVariable Integer id) {
        c.delete(id);
    }

    // Update customer
    @PutMapping("/customerservice/{id}")
    public ResponseEntity<Customer> update(@PathVariable Integer id, @RequestBody Customer update_c) {
        Customer exist_c = c.get(id);
        if (exist_c != null) {
            exist_c.setC_name(update_c.getC_name());
            exist_c.setAddress(update_c.getAddress());
            c.update(exist_c);
            return new ResponseEntity<>(exist_c, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

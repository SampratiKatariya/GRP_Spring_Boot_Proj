package com.example.GRP_Spring_Proj.controller;

import com.example.GRP_Spring_Proj.DTO.CustomerDTO;
import com.example.GRP_Spring_Proj.Exception.HnDBankException;
import com.example.GRP_Spring_Proj.entity.Customer;
import com.example.GRP_Spring_Proj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mystore")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private Environment environment;
    @GetMapping(value = "/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() throws HnDBankException {
        List<CustomerDTO> customerList = customerService.findAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
    @GetMapping(value = "/customers/{customerId}")
    public CustomerDTO getCustomer(@PathVariable Integer customerId) throws HnDBankException {
        CustomerDTO customer = customerService.getCustomer(customerId);
        return customer;
    }
    @GetMapping(value = "/customer")
    public ResponseEntity<CustomerDTO> getCustomerParam(@RequestParam Integer customerId) throws HnDBankException {
        CustomerDTO customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @PostMapping(value = "/customers")
    public ResponseEntity<String> addCustomer(@RequestBody  CustomerDTO customer) throws HnDBankException {
        Integer customerId = customerService.addCustomer(customer);
        String successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
    @PutMapping(value = "/customers/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDTO customer)
            throws HnDBankException {
        customerService.updateCustomer(customerId,customer);
        String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
    @DeleteMapping(value = "/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws HnDBankException {
        customerService.deleteCustomer(customerId);
        String successMessage = environment.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
}

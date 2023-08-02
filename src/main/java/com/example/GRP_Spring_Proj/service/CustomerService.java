package com.example.GRP_Spring_Proj.service;

import com.example.GRP_Spring_Proj.DTO.CustomerDTO;
import com.example.GRP_Spring_Proj.Exception.HnDBankException;
import com.example.GRP_Spring_Proj.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerService{
    public int addCustomer(CustomerDTO customer) throws HnDBankException;
    public CustomerDTO getCustomer(Integer customerId) throws HnDBankException;
    public List<CustomerDTO> findAll() throws HnDBankException;
    public void updateCustomer(Integer customerId, CustomerDTO customerDTO) throws HnDBankException;
    public void deleteCustomer(Integer customerId) throws HnDBankException;

}

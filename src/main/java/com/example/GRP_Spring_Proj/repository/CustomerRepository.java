package com.example.GRP_Spring_Proj.repository;

import com.example.GRP_Spring_Proj.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByEmailId(String emailId);

    @Query("SELECT c.name FROM Customer c WHERE c.emailId = :emailId")
    List<String> findNameByEmailId(@Param("emailId") String emailId);

    @Query("UPDATE Customer c SET c.emailId = ?1 WHERE c.customerId = ?2")
    @Modifying
    @Transactional
    Integer updateCustomerEmailId(String updateCustomerByEmailId, Integer customerId);
}

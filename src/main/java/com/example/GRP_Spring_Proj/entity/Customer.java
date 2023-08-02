package com.example.GRP_Spring_Proj.entity;

import com.example.GRP_Spring_Proj.enums.CustomerType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Customer {
    @Id
    private int customerId;
    private String name;
    private String emailId;
    private LocalDate dateOfBirth;
    @Enumerated(value= EnumType.STRING)
    private CustomerType customerType;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", customerType=" + customerType +
                '}';
    }
}

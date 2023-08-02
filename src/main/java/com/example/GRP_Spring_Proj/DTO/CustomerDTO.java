package com.example.GRP_Spring_Proj.DTO;

import com.example.GRP_Spring_Proj.enums.CustomerType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
public class CustomerDTO {
    private int customerId;
    private String name;
    private String emailId;
    private LocalDate dateOfBirth;
    @Enumerated(value= EnumType.STRING)
    private CustomerType customerType;

}

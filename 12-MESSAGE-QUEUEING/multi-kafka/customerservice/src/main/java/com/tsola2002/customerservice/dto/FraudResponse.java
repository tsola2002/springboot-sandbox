package com.tsola2002.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudResponse {

    private String customerId;
    private boolean fraudulent;
}

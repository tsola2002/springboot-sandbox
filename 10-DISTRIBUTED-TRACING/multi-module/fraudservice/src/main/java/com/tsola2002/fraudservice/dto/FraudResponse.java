package com.tsola2002.fraudservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudResponse {
    private String customerId;
    private boolean fraudulent;
}

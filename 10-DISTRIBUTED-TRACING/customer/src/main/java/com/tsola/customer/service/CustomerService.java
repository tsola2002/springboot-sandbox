package com.tsola.customer.service;

import com.tsola.customer.dto.CustomerRegistrationRequest;
import com.tsola.customer.dto.FraudCheckResponse;
import com.tsola.customer.entity.Customer;
import com.tsola.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        //log.info("Registering Customer");
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId());
        // log.info("Customer Registered");


        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

//        NotificationRequest notificationRequest = new NotificationRequest(
//                customer.getId(),
//                customer.getEmail(),
//                String.format("Hi %s, welcome to Amigoscode...",
//                        customer.getFirstName())
//        );

//        rabbitMQMessageProducer.publish(
//                notificationRequest,
//                "internal.exchange",
//                "internal.notification.routing-key"
//        );

    }
}

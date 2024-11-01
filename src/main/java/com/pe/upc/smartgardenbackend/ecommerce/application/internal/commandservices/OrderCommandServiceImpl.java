package com.pe.upc.smartgardenbackend.ecommerce.application.internal.commandservices;

import com.pe.upc.smartgardenbackend.ecommerce.domain.services.OrderCommandService;
import com.pe.upc.smartgardenbackend.ecommerce.infrastucture.persistence.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {
    private final OrderRepository orderRepository;



}

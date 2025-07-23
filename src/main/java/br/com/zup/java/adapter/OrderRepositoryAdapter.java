package br.com.zup.java.adapter;

import br.com.zup.java.entity.Order;
import br.com.zup.java.port.OrderRepositoryPort;
import br.com.zup.java.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderRepositoryAdapter implements OrderRepositoryPort {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }


    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
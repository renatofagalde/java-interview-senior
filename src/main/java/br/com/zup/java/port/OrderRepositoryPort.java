package br.com.zup.java.port;

import br.com.zup.java.entity.Order;

import java.util.List;

public interface OrderRepositoryPort {
    Order save(Order order);
    List<Order> findAll();
}
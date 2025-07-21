package br.com.zup.java.port;

import br.com.zup.java.entity.Order;
import java.util.List;
import java.util.Optional;

public interface OrderRepositoryPort {
    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
    void deleteById(Long id);
    List<Order> findByCustomerEmail(String email);
    List<Order> findByStatus(String status);
}
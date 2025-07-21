package br.com.zup.java.repository;

import br.com.zup.java.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerEmail(String email);  // PROBLEMA: Query N+1 problem

    @Query(value = "SELECT * FROM orders WHERE status = ?1", nativeQuery = true)
    List<Order> findOrdersByStatus(String status);

    Order findByIdAndCustomerEmail(Long id, String customerEmail);
}
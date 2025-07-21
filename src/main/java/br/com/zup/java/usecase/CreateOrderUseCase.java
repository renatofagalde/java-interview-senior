package br.com.zup.java.usecase;

import br.com.zup.java.entity.Order;
import br.com.zup.java.entity.OrderItem;
import br.com.zup.java.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class CreateOrderUseCase {

    @Autowired
    private OrderRepository orderRepository;

    public Order execute(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus("PENDING");

        BigDecimal total = BigDecimal.ZERO;
        if (order.getItems() != null) {
            for (OrderItem item : order.getItems()) {
                if (item.getPrice() != null && item.getQuantity() != null) {
                    total = total.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
                    item.setOrder(order);
                }
            }
        }
        order.setTotal(total);

        return orderRepository.save(order);
    }
}
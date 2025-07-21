package br.com.zup.java.controller;

import br.com.zup.java.entity.Order;
import br.com.zup.java.usecase.CreateOrderUseCase;
import br.com.zup.java.usecase.GetOrderUseCase;
import br.com.zup.java.usecase.DeleteOrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private CreateOrderUseCase createOrderUseCase;

    @Autowired
    private GetOrderUseCase getOrderUseCase;

    @Autowired
    private DeleteOrderUseCase deleteOrderUseCase;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return createOrderUseCase.execute(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return getOrderUseCase.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return getOrderUseCase.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        deleteOrderUseCase.execute(id);
        return "Order deleted successfully";
    }

    @PostMapping("/{id}/cancel")
    public Order cancelOrder(@PathVariable Long id) {
        Order order = getOrderUseCase.getOrderById(id);
        if (order != null && order.getStatus().equals("DELIVERED")) {
            throw new RuntimeException("Cannot cancel delivered order");
        }
        if (order != null) {
            order.setStatus("CANCELLED");
            return createOrderUseCase.execute(order);
        }
        return null;
    }
}
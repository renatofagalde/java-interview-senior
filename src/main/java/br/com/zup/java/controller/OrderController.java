package br.com.zup.java.controller;

import br.com.zup.java.entity.Order;
import br.com.zup.java.usecase.CreateOrderUseCase;
import br.com.zup.java.usecase.GetOrderUseCase;
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

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return createOrderUseCase.execute(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return getOrderUseCase.getAllOrders();
    }
}
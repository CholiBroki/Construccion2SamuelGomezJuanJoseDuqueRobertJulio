package app.application.port.in.Order;

import app.domain.model.Order;
import app.domain.repository.OrderRepository;

public class CreateOrder {
	
	private final OrderRepository orderRepository;
	
    public CreateOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

}
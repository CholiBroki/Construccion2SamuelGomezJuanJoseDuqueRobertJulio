package app.application.port.in.Order;

import java.util.List;

import app.domain.model.Order;
import app.domain.repository.OrderRepository;

public class DeleteOrder {
	
	private final OrderRepository orderRepository;
	
    public DeleteOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
	
	public List<Order>DeleteOrder(Order deleteOrder){
		System.out.println("Orden eliminada");
		return null;
	}

}
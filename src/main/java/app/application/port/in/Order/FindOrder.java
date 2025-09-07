package app.application.port.in.Order;

import app.domain.model.Order;
import app.domain.repository.OrderRepository;
import app.domain.valueobject.Id;
import java.util.List;

public class FindOrder {
    private final OrderRepository orderRepository;

    public FindOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrdersByPatient(Id patientId) {
        return orderRepository.findByPatientId(patientId);
    }
}
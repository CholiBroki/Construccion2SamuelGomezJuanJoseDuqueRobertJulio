package app.domain.repository;

import app.domain.model.Order;
import app.domain.valueobject.Id;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    void delete(Id orderId);
    Optional<Order> findById(Id orderId);
    List<Order> findByPatientId(Id patientId);
    public void createOrder(Order order);
	void deleteOrder(Id orderId);
	void saveOrder(Order order);
}
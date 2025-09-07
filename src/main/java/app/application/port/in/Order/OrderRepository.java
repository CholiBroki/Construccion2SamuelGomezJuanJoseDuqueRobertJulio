package app.application.port.in.Order;
import java.util.List;

import app.domain.valueobject.Id;

public interface OrderRepository {
	public void createOrder(Order order);
	void save(Order order);
	public List<Order>DeleteOrder(Order deleteOrder);
	public List<Order> findByPatientId(Id patientId);
	

}

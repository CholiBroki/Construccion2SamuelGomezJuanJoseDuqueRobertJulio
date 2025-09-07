package app.adapter.out;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.port.in.Order.Order;
import app.domain.repository.OrderRepository;
import app.domain.valueobject.Id;

@Service
public class OrderAdapter implements OrderRepository{

	@Override
	public void createOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> DeleteOrder(Order deleteOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByPatientId(Id patientId) {
		// TODO Auto-generated method stub
		return null;
	}

}
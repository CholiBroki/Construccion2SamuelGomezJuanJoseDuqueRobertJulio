package app.adapter.out;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.domain.model.Order;
import app.domain.repository.OrderRepository;
import app.domain.valueobject.Id;

@Service
public class OrderAdapter implements OrderRepository{

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(Id orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Order> findById(Id orderId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Order> findByPatientId(Id patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Id orderId) {
		// TODO Auto-generated method stub
		
	}



}
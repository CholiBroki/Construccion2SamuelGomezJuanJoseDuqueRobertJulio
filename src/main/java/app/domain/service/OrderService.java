package app.domain.service;

import app.domain.model.Order;
import app.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        System.out.println("📝 Creando orden médica");
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByPatient(Long patientId) {
        return orderRepository.findByPatientId(patientId);
    }

    public List<Order> getOrdersByDoctor(Long doctorId) {
        return orderRepository.findByDoctorId(doctorId);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public Order updateOrder(Long id, Order updated) {
        Optional<Order> existing = orderRepository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Orden no encontrada");
        }
        
        Order order = existing.get();
        if (updated.getStatus() != null) order.setStatus(updated.getStatus());
        if (updated.getDescription() != null) order.setDescription(updated.getDescription());
        if (updated.getInstructions() != null) order.setInstructions(updated.getInstructions());
        if (updated.getCost() != null) order.setCost(updated.getCost());
        
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
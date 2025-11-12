package app.adapter.out;

import app.domain.model.Order;
import app.domain.valueobject.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderAdapter {

    // Implementación temporal en memoria
    // TODO: Crear OrderJpaRepository cuando lo necesites
    
    public void save(Order order) {
        // Implementación temporal
    }

    public void delete(Id orderId) {
        // Implementación temporal
    }

    public Optional<Order> findById(Id orderId) {
        return Optional.empty();
    }

    public List<Order> findByPatientId(Id patientId) {
        return new ArrayList<>();
    }

    public void createOrder(Order order) {
        save(order);
    }
}
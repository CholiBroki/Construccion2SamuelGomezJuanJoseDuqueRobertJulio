package app.domain.repository;

import app.domain.model.Order;
import app.domain.valueobject.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByPatientId(Long patientId);
    List<Order> findByDoctorId(Long doctorId);
    List<Order> findByStatus(String status);
    List<Order> findByOrderType(String orderType);
	List<Order> findByPatientId(Id patientId);
}
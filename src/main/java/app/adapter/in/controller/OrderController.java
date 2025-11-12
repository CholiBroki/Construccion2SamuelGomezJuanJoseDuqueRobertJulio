package app.adapter.in.controller;

import app.domain.model.Order;
import app.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER')")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        try {
            Order created = orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(createSuccessResponse("Orden creada exitosamente", created));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(createSuccessResponse("Órdenes obtenidas", orders));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE', 'PATIENT')")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
            .map(order -> ResponseEntity.ok(createSuccessResponse("Orden encontrada", order)))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patient/{patientId}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE', 'PATIENT')")
    public ResponseEntity<?> getOrdersByPatient(@PathVariable Long patientId) {
        List<Order> orders = orderService.getOrdersByPatient(patientId);
        return ResponseEntity.ok(createSuccessResponse("Órdenes del paciente", orders));
    }

    @GetMapping("/doctor/{doctorId}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER')")
    public ResponseEntity<?> getOrdersByDoctor(@PathVariable Long doctorId) {
        List<Order> orders = orderService.getOrdersByDoctor(doctorId);
        return ResponseEntity.ok(createSuccessResponse("Órdenes del doctor", orders));
    }

    @GetMapping("/status/{status}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER', 'NURSE')")
    public ResponseEntity<?> getOrdersByStatus(@PathVariable String status) {
        List<Order> orders = orderService.getOrdersByStatus(status);
        return ResponseEntity.ok(createSuccessResponse("Órdenes con estado: " + status, orders));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN', 'OWNER')")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        try {
            Order updated = orderService.updateOrder(id, order);
            return ResponseEntity.ok(createSuccessResponse("Orden actualizada", updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.ok(createSuccessResponse("Orden eliminada", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(createErrorResponse(e.getMessage()));
        }
    }

    private Map<String, Object> createSuccessResponse(String message, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "✅ " + message);
        response.put("data", data);
        return response;
    }

    private Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", "❌ " + message);
        return response;
    }
}
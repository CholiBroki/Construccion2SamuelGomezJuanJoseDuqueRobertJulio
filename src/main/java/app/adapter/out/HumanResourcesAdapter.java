package app.adapter.out;

import app.domain.model.HumanResources;
import app.domain.valueobject.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HumanResourcesAdapter {

    // Implementación temporal en memoria
    // TODO: Crear HumanResourcesJpaRepository cuando lo necesites

    public List<HumanResources> updateEmployee(HumanResources updateEmployee) {
        return new ArrayList<>();
    }

    public void createEmployee(HumanResources createEmployee) {
        // Implementación temporal
    }

    public void deleteEmployee(Id deleteEmployee) {
        // Implementación temporal
    }

    public Optional<HumanResources> findById(Long hrId) {
        return Optional.empty();
    }

    public void save(HumanResources member) {
        // Implementación temporal
    }
}
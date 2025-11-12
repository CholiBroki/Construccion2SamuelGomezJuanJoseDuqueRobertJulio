package app.domain.repository;

import app.domain.model.HumanResources;
import app.domain.valueobject.Id;

import java.util.Optional;
import java.util.List;

public interface HumanResourcesRepository {
    
    List<HumanResources> updateEmployee(HumanResources updateEmployee);
    
    void createEmployee(HumanResources createEmployee);
    
    void deleteEmployee(Id deleteEmployee);
    
    Optional<HumanResources> findById(Long hrId);
    
    HumanResources save(HumanResources member);
}